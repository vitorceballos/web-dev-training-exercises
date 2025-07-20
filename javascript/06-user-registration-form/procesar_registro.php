<?php
// Iniciamos la sesión
session_start();

// Inicializamos un array para almacenar los errores
$errores = [];

// Validamos los datos enviados desde el formulario
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = trim($_POST['nombre']);
    $apellido = trim($_POST['apellido']);
    $correo = trim($_POST['correo']);
    $contraseña = trim($_POST['contraseña']);
    $confirmarContraseña = trim($_POST['confirmar_contraseña']);

    // Validamos que el nombre tenga al menos 2 caracteres
    if (strlen($nombre) < 2) {
        $errores[] = "El nombre debe tener al menos 2 caracteres.";
    }

    // Validamos que el apellido tenga al menos 2 caracteres
    if (strlen($apellido) < 2) {
        $errores[] = "El apellido debe tener al menos 2 caracteres.";
    }

    // Validamos el formato del correo electrónico
    if (!filter_var($correo, FILTER_VALIDATE_EMAIL)) {
        $errores[] = "El correo electrónico no tiene un formato válido.";
    }

    // Validamos que la contraseña tenga al menos 6 caracteres
    if (strlen($contraseña) < 6) {
        $errores[] = "La contraseña debe tener al menos 6 caracteres.";
    }

    // Validamos que las contraseñas coincidan
    if ($contraseña !== $confirmarContraseña) {
        $errores[] = "Las contraseñas no coinciden.";
    }

    // Si hay errores, los guardamos en la sesión y redirigimos al formulario
    if (!empty($errores)) {
        $_SESSION['errores'] = $errores;
        header('Location: registro.html');
        exit();
    }

    // Si todo es válido, guardamos los datos en la sesión
    $_SESSION['usuario'] = [
        'nombre' => $nombre,
        'apellido' => $apellido,
        'correo' => $correo
    ];

    // Redirigimos a la página de registro exitoso
    header('Location: registro_exitoso.php');
    exit();
}
?>
