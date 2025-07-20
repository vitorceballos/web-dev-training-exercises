<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>actividad 1.4</title>
</head>
<body>
<div class="container"> <!-- Se utiliza la clase container para la estructura de la página -->
        <h1>Comparación de Áreas de Pizzas</h1>
        <?php
            // Se definen las dimensiones de las pizzas
            $radio_redonda = 7; // Radio de la pizza redonda en cm
            $ancho_rectangular = 8; // Ancho de la pizza rectangular en cm
            $alto_rectangular = 10; // Alto de la pizza rectangular en cm

            // Se calcula el área de la pizza redonda (A = π * r^2)
            $area_redonda = pi() * pow($radio_redonda, 2);

            // Se calcula el área de la pizza rectangular (A = ancho * alto)
            $area_rectangular = $ancho_rectangular * $alto_rectangular;

            // Se comparan las áreas y se muestra el resultado
            if ($area_redonda > $area_rectangular) {
                echo "<p>La pizza redonda es más grande que la rectangular.</p>";
            } elseif ($area_redonda < $area_rectangular) {
                echo "<p>La pizza rectangular es más grande que la redonda.</p>";
            } else {
                echo "<p>Las dos pizzas tienen el mismo tamaño.</p>";
            }
        ?>
    </div>
</body>
</html>