<?php
// Iniciamos la sesión para guardar el usuario
session_start();

// Procesamos el formulario de login
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = $_POST['nombre'];
    $password = $_POST['password'];

    // Hacemos la conexión con la base de datos
    $conn = new mysqli("localhost", "root", "root", "padel");
    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error); // Mostramos un mensaje si falla la conexión
    }

    // Preparamos la consulta para buscar el usuario con el nombre y contraseña
    $sql = "SELECT * FROM USUARIO WHERE nombre = ? AND pass = ?";
    $stmt = $conn->prepare($sql);
    if (!$stmt) {
        die("Error en la preparación de la consulta: " . $conn->error);
    }
    $stmt->bind_param("ss", $nombre, $password); // Asignamos los valores a la consulta
    $stmt->execute();
    $resultado = $stmt->get_result();
    
    // Verificamos si se encontró un usuario con las credenciales dadas
    if ($resultado->num_rows === 1) {
        // Si el usuario existe, guardamos los datos en la sesión
        $usuario = $resultado->fetch_assoc();
        $_SESSION['usuario'] = $usuario;

        // Redirigimos según el tipo de usuario (0: Administrador, 1: Usuario normal)
        if ($usuario['tipo'] == 0) {
            header("Location: admin.php"); // Redirigimos a la página de administrador
        } else {
            header("Location: user.php"); // Redirigimos a la página de usuario
        }
        exit;
    } else {
        $mensaje = "Usuario o contraseña incorrectos."; // Mostramos un mensaje si el usuario o la contraseña no coinciden
    }
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tema 5 - Utilización de técnicas de acceso a datos - Vitor Mendes Ceballos - Página Principal</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Club de Pádel - Iniciar Sesión</h1>
    </header>
    <main>
        <!-- Creamos el formulario para que el usuario se identifique -->
        <form method="POST">
            <h2>Inicia Sesión</h2>
            <!-- Mostramos mensaje de error si hay uno -->
            <?php if (isset($mensaje)): ?>
                <p class="mensaje error"><?= $mensaje ?></p>
            <?php endif; ?>
            <label>Nombre de Usuario:</label>
            <input type="text" name="nombre" required>
            <label>Contraseña:</label>
            <input type="password" name="password" required>
            <button type="submit">Entrar</button>
        </form>
    </main>
</body>
</html>