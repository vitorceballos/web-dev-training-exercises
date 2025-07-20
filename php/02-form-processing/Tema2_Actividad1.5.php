<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tema 2: Actividad 1.5</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">

    <h1 class="titulo">Cálculo de la Letra del DNI</h1>

        <!-- Formulario para que el usuario introduzca el número de DNI -->
        <form method="post" action="">
            <label for="dni">Introduce el número de DNI (8 dígitos):</label> 
            <!-- Este campo de entrada solo permite que el usuario introduzca exactamente 8 dígitos (números del 0 al 9). El atributo 'pattern' asegura que solo se acepten cadenas que contengan exactamente 8 dígitos, y 'maxlength' limita la entrada a 8 caracteres. Si el usuario intenta ingresar más de 8 dígitos o cualquier otro carácter, el formulario no se enviará.-->
            <input type="text" id="dni" name="dni" pattern="\d{8}" maxlength="8" required title="Debes introducir exactamente 8 dígitos">
            <input type="submit" value="Calcular Letra">
        </form>

        <?php
        // Se verifica si se ha enviado el formulario
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            // Se recoge el número de DNI introducido por el usuario
            $dni = $_POST["dni"]; // Se recoge como texto
            
            // Se verifica que se han introducido exactamente 8 dígitos
            if (preg_match("/^\d{8}$/", $dni)) {
                // Tabla de letras según el resto de la división por 23
                $letras = "TRWAGMYFPDXBJNZSQVHLCKE"; // Letras correspondientes
                
                // Se calcula el resto de la división del DNI entre 23
                $resto = intval($dni) % 23; // Calcula el resto
                
                // Mostrar el valor del resto para depuración
                // Antes se estaban probando varios DNIs y no todos funcionaban correctamente, ya que daban letras incorrectas. 
                // Se añadió esta línea de depuración para verificar el valor del resto y se ha resulto los problemas.
                echo "<p>Resto: $resto</p>";
                
                // Se obtiene la letra correspondiente de la tabla usando el resto
                $letra = $letras[$resto]; 
                
                // Se muestra el resultado
                echo "<p>El número de DNI $dni tiene como letra: $letra</p>";
            }
        }
        ?>
    </div>
</body>
</html>