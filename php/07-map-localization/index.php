<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actividades_Tema_7 - Desarrollo de Aplicaciones Web Híbridas - Vitor Mendes Ceballos</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Buscador de Locales</h1>

<!-- Formulario para seleccionar tipo de local y población -->
<form action="mapa.php" method="GET">
    <label for="tipo">Tipo de Local:</label>
    <select id="tipo" name="tipo" required>
        <option value="Restaurante">Restaurante</option>
        <option value="Bar">Bar</option>
        <option value="Discoteca">Discoteca</option>
    </select>

    <label for="poblacion">Población:</label>
    <select id="poblacion" name="poblacion" required>
        <option value="Madrid">Madrid</option>
    </select>

    <button type="submit">Buscar</button>
</form>
</body>
</html>
