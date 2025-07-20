<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>actividad 1.1</title>
</head>
<body>
<div class="container"> <!-- Se crea la clase container para la estructura de la página -->
        <h1>Verificación de Edad Laboral</h1>
        <?php
            // Se definen las constantes para la edad mínima y máxima para trabajar
            define("EDAD_MINIMA", 16); // Edad mínima para trabajar
            define("EDAD_MAXIMA", 65);  // Edad máxima para trabajar

            // Se define la edad de la persona
            $edad_persona = 28; // Valor donde se utiliza para probar el programa.

            // Se verifica si la persona está en edad de trabajar
            if ($edad_persona >= EDAD_MINIMA && $edad_persona <= EDAD_MAXIMA) {
                echo "La persona tiene edad para trabajar. ";

                // Se calcula los años que faltan para la jubilación
                $años_para_jubilacion = EDAD_MAXIMA - $edad_persona; // Se calcula los años faltantes para jubilarse
                echo "Faltan " . $años_para_jubilacion . " años para la jubilación.";
            } else {
                echo "La persona no tiene edad para trabajar.";
            }
        ?>
    </div>
</body>
</html>