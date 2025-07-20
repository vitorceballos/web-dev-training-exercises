<?php
// Iniciamos la sesión
session_start();

// Verificamos que los datos del usuario estén en la sesión
if (!isset($_SESSION['usuario'])) {
    die("Acceso denegado. No hay datos de usuario.");
}

$usuario = $_SESSION['usuario'];
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro Exitoso</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>¡Registro Exitoso!</h1>
    </header>
    <main>
        <p>¡Felicitaciones! Tu registro ha sido exitoso.</p>
        <p>A continuación se muestran los detalles de tu registro:</p>
        <ul>
            <li><strong>Nombre:</strong> <?php echo htmlspecialchars($usuario['nombre']); ?></li>
            <li><strong>Apellido:</strong> <?php echo htmlspecialchars($usuario['apellido']); ?></li>
            <li><strong>Correo Electrónico:</strong> <?php echo htmlspecialchars($usuario['correo']); ?></li>
        </ul>
        <p>Gracias por registrarte. Disfruta de nuestros servicios.</p>
    </main>
    <footer>
        <p>&copy; 2024 Linkia FP - Desarrollo Web en Entorno Cliente</p>
    </footer>
</body>
</html>
