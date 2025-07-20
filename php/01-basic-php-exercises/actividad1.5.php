<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Actividad 1.5</title>
</head>
<body>
<div class="container"> <!-- Se utiliza la clase container para la estructura de la página -->
        <h1>Verificación de Alquiler</h1>
        <?php
            // Se definen las constantes para las horas y días de trabajo
            define("HORAS_DIARIAS", 7);
            define("DIAS_SEMANALES", 5);
            define("SEMANAS_MES", 4);

            // Se definen las variables de ingreso y gastos
            $salario_hora = 10; // Cantidad que la persona gana por hora trabajada
            $precio_alquiler = 1000; // Precio mensual del alquiler
            $gastos_mensuales = 200; // Otros gastos mensuales aproximados

            // Se calcula el salario mensual total
            $salario_mensual = HORAS_DIARIAS * DIAS_SEMANALES * SEMANAS_MES * $salario_hora;

            // Se comprueba si puede pagar el alquiler
            if ($salario_mensual >= ($precio_alquiler + $gastos_mensuales)) {
                echo "<p>La persona puede pagar el alquiler.</p>";
            } else {
                echo "<p>La persona no puede pagar el alquiler.</p>";
            }
        ?>
</body>
</html>