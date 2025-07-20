<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tema 2: Actividad 1.3</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container"> 
        
        <h1 class="titulo">Tema 2: Actividad 1.3 - Resultado de la Calculadora</h1>

        <?php
        // Se verifica si se ha enviado el formulario desde Tema2_Actividad1.3.php
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            // Se recogen los números y la operación seleccionada
            $numero1 = $_POST["numero1"];
            $numero2 = $_POST["numero2"];
            $operacion = $_POST["operacion"];
            
            // Se inicializa la variable resultado
            $resultado = 0;

            // Se realizan las operaciones según lo seleccionado
            switch ($operacion) {
                case "suma":
                    $resultado = $numero1 + $numero2;
                    break;
                case "resta":
                    $resultado = $numero1 - $numero2;
                    break;
                case "multiplicacion":
                    $resultado = $numero1 * $numero2;
                    break;
                case "division":
                    // Se verifica si el segundo número es distinto de cero para evitar división por cero
                    if ($numero2 != 0) {
                        $resultado = $numero1 / $numero2;
                    } else {
                        echo "<p>No se puede dividir entre cero.</p>";
                        exit; // Termina la ejecución si hay error
                    }
                    break;
            }
            
            // Se muestra el resultado de la operación
            echo "<p>El resultado de la $operacion es: $resultado</p>";
        } else {
                /// Si el formulario no ha sido enviado, se muestra un mensaje que indica que no se han recibido datos y se ofrece un enlace para volver al formulario para que el usuario pueda intentarlo de nuevo.
            echo "<p>No se han enviado datos. Por favor, vuelve a <a href='Tema2_Actividad1.3.php'>intentar</a>.</p>";
        }
        ?>
    </div>
</body>
</html>