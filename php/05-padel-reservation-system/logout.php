<?php
// Cerramos la sesión y redirigimos al login
session_start();
session_destroy();
header("Location: index.php");
exit;
?>
