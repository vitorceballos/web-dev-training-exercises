<?php
// Comprobamos si el usuario ha iniciado sesión y es un usuario normal
session_start();
if (!isset($_SESSION['usuario']) || $_SESSION['usuario']['tipo'] != 1) {
    header("Location: index.php"); // Si no es un usuario normal, lo redirigimos al login
    exit;
}

// Hacemos la conexión a la base de datos
$conn = new mysqli("localhost", "root", "root", "padel");
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error); // Mostramos un mensaje si falla la conexión
}

// Guardamos el ID del usuario actual para usarlo en las consultas
$id_usuario = $_SESSION['usuario']['id_usuario'];

// Procesamos la creación de una nueva reserva
if (isset($_POST['accion']) && $_POST['accion'] === 'crear_reserva') {
    $id_pista = $_POST['id_pista']; // Capturamos la pista seleccionada
    $turno = $_POST['turno']; // Capturamos el turno ingresado

    // Verificamos si ya existe una reserva en la misma pista y turno
    $sql = "SELECT * FROM RESERVA WHERE pista = ? AND turno = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ii", $id_pista, $turno); // Usamos los valores para verificar
    $stmt->execute(); 
    $resultado = $stmt->get_result();

    if ($resultado->num_rows > 0) {
        // Si ya hay una reserva, mostramos un mensaje de error
        $mensaje = "La pista ya está reservada en ese turno.";
    } else {
        // Si no hay reservas, creamos una nueva
        $sql = "INSERT INTO RESERVA (usuario, pista, turno) VALUES (?, ?, ?)";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("iii", $id_usuario, $id_pista, $turno);
        $stmt->execute();
        $mensaje = "Reserva creada.";
    }
}

// Procesamos la eliminación de una reserva
if (isset($_POST['accion']) && $_POST['accion'] === 'borrar_reserva') {
    $id_reserva = $_POST['id_reserva']; // Capturamos el ID de la reserva a eliminar
    $sql = "DELETE FROM RESERVA WHERE id_reserva = ? AND usuario = ?"; // Solo eliminamos reservas del usuario actual
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ii", $id_reserva, $id_usuario); // Usamos el ID del usuario para filtrar sus reservas
    $stmt->execute();
    $mensaje = "Reserva eliminada correctamente.";
}

// Obtenemos todas las reservas del usuario actual
$sql = "SELECT R.id_reserva, P.nombre AS pista, R.turno 
        FROM RESERVA R 
        INNER JOIN PISTA P ON R.pista = P.id_pista 
        WHERE R.usuario = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $id_usuario); // Usamos el ID del usuario para filtrar sus reservas
$stmt->execute();
$reservas = $stmt->get_result();

// Obtenemos todas las pistas para que el usuario pueda seleccionarlas en el formulario
$pistas = $conn->query("SELECT * FROM PISTA");
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tema 5 - Utilización de técnicas de acceso a datos - Vitor Mendes Ceballos - Página Usuario</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Club de Pádel - Bienvenido, <?= $_SESSION['usuario']['nombre'] ?></h1>
        <a href="logout.php">Cerrar sesión</a>
    </header>
    <main>
        <h2>Mis Reservas</h2>
        <!-- Mostramos un mensaje si hay algún aviso o error -->
        <?php if (isset($mensaje)): ?>
            <p class="mensaje"><?= $mensaje ?></p>
        <?php endif; ?>
        <table>
            <thead>
                <tr>
                    <th>Pista</th>
                    <th>Turno</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <!-- Recorremos y mostramos las reservas del usuario -->
                <?php while ($reserva = $reservas->fetch_assoc()): ?>
                    <tr>
                        <td><?= $reserva['pista'] ?></td>
                        <td><?= $reserva['turno'] ?></td>
                        <td>
                            <!-- Formulario para eliminar una reserva -->
                            <form method="POST" style="display: inline;">
                                <input type="hidden" name="accion" value="borrar_reserva">
                                <input type="hidden" name="id_reserva" value="<?= $reserva['id_reserva'] ?>">
                                <button type="submit">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                <?php endwhile; ?>
            </tbody>
        </table>

        <h2>Hacer una Reserva</h2>
        <!-- Formulario para crear una nueva reserva -->
        <form method="POST">
            <input type="hidden" name="accion" value="crear_reserva">
            <label>Pista:</label>
            <select name="id_pista" required>
                <?php while ($pista = $pistas->fetch_assoc()): ?>
                    <option value="<?= $pista['id_pista'] ?>"><?= $pista['nombre'] ?></option>
                <?php endwhile; ?>
            </select>
            <label>Turno:</label>
            <input type="number" name="turno" min="1" max="10" placeholder="Turno (1-10)" required>
            <button type="submit">Reservar</button>
        </form>
    </main>
</body>
</html>
