<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tema 2: Actividad 1.4</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">

        <h1 class="titulo">Tema 2: Actividad 1.4 - Simulador de Interruptores</h1>

        <!-- Formulario para que el usuario introduzca la secuencia de interruptores -->
        <form method="post" action="">
            <label for="secuencia">Introduce la secuencia de interruptores (0-7), separados por comas:</label>
            <input type="text" id="secuencia" name="secuencia" required>
            <input type="submit" value="Enviar">
        </form>

        <?php
        // Se inicializa un array de luces con 8 posiciones, todas con el valor 'false' inicialmente
        $luces = array_fill(0, 8, false);
        $mensajeError = ""; // Variable para almacenar mensajes de error
        
        // Se verifica si se ha enviado el formulario
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            // Se recoge la secuencia de interruptores introducida por el usuario
            $secuencia = $_POST["secuencia"];
            
            // Se convierte la secuencia de texto en un array de números
            $interruptores = explode(",", $secuencia);
            
            // Se recorren los interruptores pulsados por el usuario
            foreach ($interruptores as $interruptor) {
                
                // Se eliminan los espacios en blanco del interruptor
                $interruptor = trim($interruptor); 

                // Se verifica si el interruptor es numérico y dentro del rango permitido
                if (is_numeric($interruptor) && $interruptor >= 0 && $interruptor < 8) {
                    // Se alterna el estado de la luz correspondiente
                    $luces[$interruptor] = !$luces[$interruptor];
                } else {
                    // Si el valor no es válido, se guarda un mensaje de error
                    $mensajeError = "Error: El valor '$interruptor' no es válido. Debe estar entre 0 y 7.";
                }
            }

            // Se convierte el estado de las luces a formato numérico (0 para apagada, 1 para encendida)
            $estadoLuces = array_map(function($luz) {
                return $luz ? 1 : 0; // Convierte 'true' en 1 y 'false' en 0
            }, $luces);
            
            // Se muestra el estado final de las luces
            echo "<p>Estado de las luces: " . implode(", ", $estadoLuces) . "</p>";
        }

        // Se muestra el mensaje de error si existe
        if ($mensajeError) {
            echo "<p style='color: red;'>$mensajeError</p>";
        }
        ?>
    </div>
</body>
</html>