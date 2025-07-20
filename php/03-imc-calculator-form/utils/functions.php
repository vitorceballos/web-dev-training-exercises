<?php
// Calculamos la edad del usuario
function mayor_edad($year) {
    $currentYear = date('Y'); // Obtenemos el año actual
    return $currentYear - $year; 
}

// Calculamos el IMC
function calculo_imc($weight, $height) {
    $imc = $weight / ($height * $height); 
    return sprintf("%.2f", $imc); // Redondeamos a 2 decimales
}

// Determinamos el estado del IMC
function imc_status($imc) {
    if ($imc < 18.5) {
        return "Peso insuficiente";
    } elseif ($imc >= 18.5 && $imc < 25) {
        return "Peso normal";
    } elseif ($imc >= 25 && $imc < 50) {
        return "Sobrepeso";
    } else {
        return "Obesidad";
    }
}
?>