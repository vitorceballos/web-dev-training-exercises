<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>actividad 1.2</title>
</head>
<body>
<div class="container"> <!-- Se utiliza la clase container para la estructura de la página -->
        <h1>Cálculo de Pupitres</h1>
        <?php
            // Se definen las cantidades de alumnos en cada clase
            $alumnos_clase1 = 37;
            $alumnos_clase2 = 18;
            $alumnos_clase3 = 26;

            // Se calcula el número total de pupitres necesarios
            $total_alumnos = $alumnos_clase1 + $alumnos_clase2 + $alumnos_clase3; // Suma total de alumnos
            $pupitres_necesarios = ceil($total_alumnos / 2); // Se calcula cuántos pupitres se necesitan (2 alumnos por pupitre)

            // Se muestra el resultado en pantalla
            echo "<p>El número total de pupitres necesarios es $pupitres_necesarios.</p>";
        ?>
    </div>
</body>
</html>