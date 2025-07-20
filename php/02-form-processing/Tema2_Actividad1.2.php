<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tema 2: Actividad 1.2</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        
        <h1>Tema 2: Actividad 1.2 - Menú Semanal</h1> 
        
        <!-- Formulario para seleccionar un día de la semana -->
        <form method="post" action="">
            <label for="dia">Selecciona un día de la semana:</label>
            <select id="dia" name="dia">
                <option value="lunes">Lunes</option>
                <option value="martes">Martes</option>
                <option value="miércoles">Miércoles</option>
                <option value="jueves">Jueves</option>
                <option value="viernes">Viernes</option>
                <option value="sábado">Sábado</option>
                <option value="domingo">Domingo</option>
            </select>
            <input type="submit" value="Consultar Menú"> 
        </form>

        <?php
        // Se verifica si se ha enviado el formulario
        if (isset($_POST['dia'])) {
            // Se define el menú semanal en un array asociativo
            $menu = [
                "lunes" => "Sopa de verduras",
                "martes" => "Tacos de pollo",
                "miércoles" => "Ensalada César",
                "jueves" => "Cochinillo",
                "viernes" => "Cachopo",
                "sábado" => "Paella",
                "domingo" => "Fabada"
            ];
            $diaSeleccionado = $_POST['dia']; 
            // Se obtiene el día seleccionado y se muestra el menú correspondiente
            echo "<p>El menú del $diaSeleccionado es: " . $menu[$diaSeleccionado] . "</p>";
        }
        ?>
    </div> 
</body>
</html>