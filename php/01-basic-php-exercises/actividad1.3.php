<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>actividad 1.3</title>
</head>
<body>
<div class="container"> <!-- Se utiliza la clase container para la estructura de la página -->
        <h1>Solución de Ecuación de Segundo Grado</h1>
        <?php
        // Se definen los coeficientes de la ecuación ax^2 + bx + c = 0
        $a = 1; // Coeficiente a
        $b = -3; // Coeficiente b
        $c = 2; // Coeficiente c

        // Se calcula el discriminante (b^2 - 4ac) para ver cuántas soluciones hay
        $discriminante = ($b ** 2) - (4 * $a * $c);

        // Se comprueba el discriminante para determinar las soluciones
        if ($discriminante > 0) {
            // Se calculan las dos soluciones reales y distintas
            $solucion1 = (-$b + sqrt($discriminante)) / (2 * $a); // Se usa sqrt() para la raíz cuadrada
            $solucion2 = (-$b - sqrt($discriminante)) / (2 * $a); // Se usa sqrt() para la raíz cuadrada
            echo "<p>Las soluciones son: $solucion1 y $solucion2.</p>";
        } elseif ($discriminante == 0) {
            // Se calcula la única solución real
            $solucion = -$b / (2 * $a);
            echo "<p>La solución es: $solucion.</p>";
        } else {
            // No hay soluciones reales
            echo "<p>No hay soluciones reales.</p>";
        }
        ?>
    </div>
</body>
</html>