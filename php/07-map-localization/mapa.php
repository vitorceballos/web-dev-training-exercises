<?php
// Obtenemos los datos enviados desde index.php
$tipo = $_GET['tipo'] ?? null;
$poblacion = $_GET['poblacion'] ?? null;

// Validación de datos
if (!$tipo || !$poblacion) {
    die("Error: Faltan parámetros. Seleccione un tipo de local y una población.");
}

// Conectamos a la base de datos
$conn = new mysqli('localhost', 'root', 'root', 'M07_DWES_T07');
if ($conn->connect_error) {
    die("Error: No se pudo conectar a la base de datos");
}

// Consultamos a la base de datos para obtener los locales
$sql = $conn->prepare('SELECT nombre, coordenadas FROM locales WHERE tipo = ? AND poblacion = ?');
$sql->bind_param('ss', $tipo, $poblacion);
$sql->execute();
$result = $sql->get_result();

// Convertimos los resultados en un array para pasarlos a JavaScript
$locales = [];
while ($row = $result->fetch_assoc()) {
    $locales[] = $row;
}
$conn->close();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Actividades_Tema_7 - Desarrollo de Aplicaciones Web Híbridas - Vitor Mendes Ceballos</title>
    <link rel="stylesheet" href="styles.css">
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDGBGNSIjsRjPUWZOU-T40kxMUPEt7dZOQ&libraries=maps,marker&v=beta" defer></script>
    <script>
        function initMap() {
            // Inicializamos el mapa
            const map = new google.maps.Map(document.getElementById("map"), {
                center: { lat: 40.416775, lng: -3.70379 },
                zoom: 12,
            });

            // Obtenemos los locales desde PHP
            const locales = <?php echo json_encode($locales); ?>;

            // Añadimos los marcadores al mapa
            locales.forEach(local => {
                const [lat, lng] = local.coordenadas.split(',');
                new google.maps.Marker({
                    position: { lat: parseFloat(lat), lng: parseFloat(lng) },
                    map: map,
                    title: local.nombre,
                });
            });
        }
    </script>
</head>
<body onload="initMap()">
    <h1>Mapa de Locales en <?php echo htmlspecialchars($poblacion); ?></h1>

    <!-- Formulario para realizar una nueva búsqueda -->
    <form action="mapa.php" method="GET">
        <label for="tipo">Tipo de Local:</label>
        <select id="tipo" name="tipo" required>
            <option value="Restaurante" <?php echo $tipo === 'Restaurante' ? 'selected' : ''; ?>>Restaurante</option>
            <option value="Bar" <?php echo $tipo === 'Bar' ? 'selected' : ''; ?>>Bar</option>
            <option value="Discoteca" <?php echo $tipo === 'Discoteca' ? 'selected' : ''; ?>>Discoteca</option>
        </select>

        <label for="poblacion">Población:</label>
        <select id="poblacion" name="poblacion" required>
            <option value="Madrid" <?php echo $poblacion === 'Madrid' ? 'selected' : ''; ?>>Madrid</option>
        </select>

        <button type="submit">Buscar</button>
    </form>

    <div id="map" style="height: 500px; width: 100%; margin-top: 20px;"></div>
</body>
</html>
