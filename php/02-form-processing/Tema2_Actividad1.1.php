<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tema 2: Actividad 1.1</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        
        <h1>Tema 2: Actividad 1.1 - Comprobador de Palíndromos</h1>

        <!-- Formulario para que el usuario introduzca un texto -->
        <form method="post" action="">
            <label for="texto">Introduce un texto:</label>
            <input type="text" id="texto" name="texto" required> 
            <input type="submit" value="Comprobar"> 
        </form>

        <?php
        // Se verifica si se ha enviado el formulario
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            // Se recoge el texto enviado por el usuario
            $texto = $_POST["texto"];
            
            // Se eliminan los espacios en blanco y se convierte el texto a minúsculas para normalizarlo
            $textoSinEspacios = strtolower(str_replace(" ", "", $texto));
            
            // Se invierte el texto y se compara con el original sin espacios
            $textoInvertido = strrev($textoSinEspacios);
            
            // Se realiza la comprobación para ver si el texto original es igual al invertido
            if ($textoSinEspacios == $textoInvertido) {
                // Si es igual, se muestra que el texto es un palíndromo
                echo "<p>El texto es un palíndromo.</p>";
            } else {
                // Si no es igual, se indica que el texto no es un palíndromo
                echo "<p>El texto no es un palíndromo.</p>";
            }
        }
        ?>
    </div>
</body>
</html>