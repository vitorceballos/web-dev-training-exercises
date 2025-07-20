<?php

// Incluimos el archivo functions.php
require './functions.php';

// Creamos la estructura HTML para la página de resultados
echo '<!DOCTYPE html>';
echo '<html lang="es">';
echo '<head>';
echo '    <meta charset="UTF-8">'; 
echo '    <meta name="viewport" content="width=device-width, initial-scale=1.0">'; 
echo '    <title>Ejercicio 1 - Tema 3 -Resultado IMC</title>'; 
echo '    <link rel="stylesheet" href="/Actividades_Tema_3/css/styles.css">';
echo '</head>';
echo '<body>';

// Creamos la cabecera de la página de resultados
echo '<header>';
echo '    <h1>Resultado del IMC</h1>';
echo '</header>';

// Creamos el contenedor principal que incluye el resultado
echo '<main>';
echo '<div class="result-box">';

// Recogemos los datos enviados desde el formulario mediante el método POST
$name = $_POST['name'];
$year = $_POST['year']; 
$weight = $_POST['weight']; 
$height = $_POST['height']; 

// Mostramos el saludo al usuario con su nombre
echo "<h2>Hola, $name</h2>";

// Calculamos la edad y verificamos si el usuario es mayor de edad
$age = mayor_edad($year); 

if ($age < 18) {
    // Mostramos un mensaje si el usuario es menor de edad
    echo "<p>Lo sentimos, esta página es para mayores de edad.</p>";
} else {
    // Mostramos la edad del usuario si es mayor de edad
    echo "<p>Rondas los $age años.</p>";

    // Calculamos el IMC del usuario utilizando su peso y altura llamando a la función calculo_imc 
    $imc = calculo_imc($weight, $height); 

    // Determinamos el estado del IMC llamando a la función imc_status
    $status = imc_status($imc); 

    // Mostramos el resultado del IMC junto con el estado
    echo "<p>Tu IMC es de <strong>$imc</strong>. Según tu IMC, este es tu estado: <strong>$status</strong>.</p>";
}

// Cerramos el contenedor principal de resultados
echo '</div>';
echo '</main>';

// Incluimos el pie de página
include '../includes/footer.html';

// Cerramos la estructura HTML de la página
echo '</body>';
echo '</html>';
?>