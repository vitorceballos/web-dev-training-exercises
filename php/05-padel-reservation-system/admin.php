<?php
// Iniciamos la sesión para comprobar si hay un usuario logueado
session_start();

// Verificamos que el usuario tenga permiso de administrador
if (!isset($_SESSION['usuario']) || $_SESSION['usuario']['tipo'] != 0) {
    header("Location: index.php"); // Si no es administrador, lo redirigimos al login
    exit;
}

// Hacemos la conexión a la base de datos
$conn = new mysqli("localhost", "root", "root", "padel");
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error); // Mostramos un mensaje si falla la conexión
}

// Procesamos las acciones relacionadas con usuarios
if (isset($_POST['accion_usuario'])) {
    if ($_POST['accion_usuario'] === 'crear') {
        // Capturamos los datos del formulario para crear un usuario nuevo
        $nombre = $_POST['nombre'];
        $pass = $_POST['pass'];
        $tipo = $_POST['tipo'];
        // Insertamos el usuario en la base de datos
        $sql = "INSERT INTO USUARIO (nombre, pass, tipo) VALUES (?, ?, ?)";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("ssi", $nombre, $pass, $tipo);
        $stmt->execute();
    } elseif ($_POST['accion_usuario'] === 'borrar') {
        // Capturamos el ID del usuario que queremos borrar
        $id_usuario = $_POST['id_usuario'];
        // Eliminamos el usuario de la base de datos
        $sql = "DELETE FROM USUARIO WHERE id_usuario = ?";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("i", $id_usuario);
        $stmt->execute();
    }
}

// Procesamos las acciones relacionadas con las pistas
if (isset($_POST['accion_pista'])) {
    if ($_POST['accion_pista'] === 'crear') {
        // Capturamos el nombre de la pista para crearla
        $nombre = $_POST['nombre'];
        // Insertamos la nueva pista en la base de datos
        $sql = "INSERT INTO PISTA (nombre) VALUES (?)";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("s", $nombre);
        $stmt->execute();
    } elseif ($_POST['accion_pista'] === 'borrar') {
        // Capturamos el ID de la pista que queremos borrar
        $id_pista = $_POST['id_pista'];
        // Eliminamos la pista de la base de datos
        $sql = "DELETE FROM PISTA WHERE id_pista = ?";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("i", $id_pista);
        $stmt->execute();
    }
}

// Procesamos las acciones relacionadas con las reservas
if (isset($_POST['accion_reserva'])) {
    if ($_POST['accion_reserva'] === 'borrar_todas') {
        // Eliminamos todas las reservas de la base de datos
        $sql = "DELETE FROM RESERVA";
        $conn->query($sql);
    } elseif ($_POST['accion_reserva'] === 'borrar') {
        // Capturamos el ID de la reserva que queremos borrar
        $id_reserva = $_POST['id_reserva'];
        // Eliminamos la reserva de la base de datos
        $sql = "DELETE FROM RESERVA WHERE id_reserva = ?";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("i", $id_reserva);
        $stmt->execute();
    }
}

// Consultamos los datos para mostrarlos en las tablas
$usuarios = $conn->query("SELECT * FROM USUARIO"); // Recuperamos todos los usuarios
$pistas = $conn->query("SELECT * FROM PISTA"); // Recuperamos todas las pistas
$reservas = $conn->query("SELECT * FROM RESERVA");// Recuperamos todas las reservas
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tema 5 - Utilización de técnicas de acceso a datos - Vitor Mendes Ceballos - Página Administrador</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Club de Pádel - Administrador</h1>
    </header>
    <main>
        <h2>Gestión de Usuarios</h2>
        <form method="POST">
            <input type="hidden" name="accion_usuario" value="crear">
            <input type="text" name="nombre" placeholder="Nombre" required>
            <input type="password" name="pass" placeholder="Contraseña" required>
            <select name="tipo">
                <option value="0">Administrador</option>
                <option value="1">Usuario</option>
            </select>
            <button type="submit">Añadir Usuario</button>
        </form>
        <!-- Tabla que muestra los usuarios existentes -->
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Tipo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <?php while ($usuario = $usuarios->fetch_assoc()): ?>
                    <tr>
                        <td><?= $usuario['id_usuario'] ?></td>
                        <td><?= $usuario['nombre'] ?></td>
                        <td><?= $usuario['tipo'] == 0 ? 'Administrador' : 'Usuario' ?></td>
                        <td>
                            <!-- Formulario para eliminar usuarios -->
                            <form method="POST" style="display: inline;">
                                <input type="hidden" name="accion_usuario" value="borrar">
                                <input type="hidden" name="id_usuario" value="<?= $usuario['id_usuario'] ?>">
                                <button type="submit">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                <?php endwhile; ?>
            </tbody>
        </table>

        <h2>Gestión de Pistas</h2>
        <!-- Formulario para añadir una nueva pista -->
        <form method="POST">
            <input type="hidden" name="accion_pista" value="crear">
            <input type="text" name="nombre" placeholder="Nombre de la pista" required>
            <button type="submit">Añadir Pista</button>
        </form>
        <!-- Tabla que muestra las pistas existentes -->
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <?php while ($pista = $pistas->fetch_assoc()): ?>
                    <tr>
                        <td><?= $pista['id_pista'] ?></td>
                        <td><?= $pista['nombre'] ?></td>
                        <td>
                            <!-- Formulario para eliminar pistas -->
                            <form method="POST" style="display: inline;">
                                <input type="hidden" name="accion_pista" value="borrar">
                                <input type="hidden" name="id_pista" value="<?= $pista['id_pista'] ?>">
                                <button type="submit">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                <?php endwhile; ?>
            </tbody>
        </table>

        <h2>Gestión de Reservas</h2>
        <!-- Botón para eliminar todas las reservas -->
        <form method="POST">
            <input type="hidden" name="accion_reserva" value="borrar_todas">
            <button type="submit">Eliminar Todas las Reservas</button>
        </form>
        <!-- Tabla que muestra las reservas existentes -->
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Usuario</th>
                    <th>Pista</th>
                    <th>Turno</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <?php while ($reserva = $reservas->fetch_assoc()): ?>
                    <tr>
                        <td><?= $reserva['id_reserva'] ?></td>
                        <td><?= $reserva['usuario'] ?></td>
                        <td><?= $reserva['pista'] ?></td>
                        <td><?= $reserva['turno'] ?></td>
                        <td>
                            <!-- Formulario para eliminar reservas -->
                            <form method="POST" style="display: inline;">
                                <input type="hidden" name="accion_reserva" value="borrar">
                                <input type="hidden" name="id_reserva" value="<?= $reserva['id_reserva'] ?>">
                                <button type="submit">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                <?php endwhile; ?>
            </tbody>
        </table>
    </main>
</body>
</html>