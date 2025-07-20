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
        
        <h1 class="titulo">Tema 2: Actividad 1.3 - Calculadora</h1>

        <!-- Formulario para introducir dos números y seleccionar la operación -->
        <form method="post" action="Tema2_Actividad1.3_resultado.php" class="form-calculadora"> <!-- Enlaza con Tema2_Actividad1.3_resultado.php -->
            <label for="numero1">Número 1:</label>
            <input type="number" id="numero1" name="numero1" required class="input-numero">
            
            <label for="numero2">Número 2:</label>
            <input type="number" id="numero2" name="numero2" required class="input-numero">

            <fieldset class="fieldset-operacion">
                <legend>Selecciona una operación:</legend>
                <label><input type="radio" name="operacion" value="suma" required> Suma</label>
                <label><input type="radio" name="operacion" value="resta"> Resta</label>
                <label><input type="radio" name="operacion" value="multiplicacion"> Multiplicación</label>
                <label><input type="radio" name="operacion" value="division"> División</label>
            </fieldset>
            
            <input type="submit" value="Calcular" class="boton-calcular">
        </form>
    </div>
</body>
</html>