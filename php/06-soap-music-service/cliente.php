<?php
// Incluimos la librería NuSOAP para conectar con el servidor
// Esto nos permitirá hacer llamadas a las funciones registradas en el servidor.
require_once("lib/nusoap.php");

// Creamos el cliente SOAP y definimos la URL del servidor.
$cliente = new nusoap_client("http://localhost/Actividades_Tema_6/servidor.php?wsdl", "wsdl");

// Obtenemos los géneros para el formulario
// Esta llamada utiliza la función `obtenerGeneros` registrada en el servidor.
$generos = $cliente->call("obtenerGeneros");

// Procesamos el formulario para añadir un grupo musical.
// Cuando el usuario envía el formulario, se llama a la función `insertarGrupo`.
if ($_SERVER["REQUEST_METHOD"] === "POST" && isset($_POST["nombre"]) && isset($_POST["genero"])) {
    $nombre = $_POST["nombre"];
    $genero = $_POST["genero"];
    $respuesta = $cliente->call("insertarGrupo", ["nombre" => $nombre, "genero" => $genero]);
}

// Procesamos el formulario para ver los grupos de un género específico.
// Cuando el usuario selecciona un género, se llama a la función `obtenerGruposPorGenero`.
$grupos = [];
if (isset($_POST["genero_seleccionado"])) {
    $grupos = $cliente->call("obtenerGruposPorGenero", ["genero" => $_POST["genero_seleccionado"]]);
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>\Actividades_Tema_6 - Programación de servicios web - Vitor Mendes Ceballos</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Gestión de Grupos Musicales</h1>
    </header>
    <main>
        <!-- Formulario para añadir grupos -->
        <section>
            <h2>Añadir Nuevo Grupo Musical</h2>
            <form method="POST">
                <label>Nombre del Grupo:</label>
                <input type="text" name="nombre" required>
                <label>Género:</label>
                <select name="genero">
                    <?php foreach ($generos as $genero): ?>
                        <option value="<?= $genero['id_genero'] ?>"><?= $genero['nombre'] ?></option>
                    <?php endforeach; ?>
                </select>
                <button type="submit">Añadir</button>
            </form>
        </section>

        <!-- Ver grupos por género -->
        <section>
            <h2>Ver Grupos por Género</h2>
            <form method="POST">
                <label>Seleccionar Género:</label>
                <select name="genero_seleccionado">
                    <?php foreach ($generos as $genero): ?>
                        <option value="<?= $genero['id_genero'] ?>"><?= $genero['nombre'] ?></option>
                    <?php endforeach; ?>
                </select>
                <button type="submit">Ver Grupos</button>
            </form>

            <table>
                <thead>
                    <tr>
                        <th>Grupos</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach ($grupos as $grupo): ?>
                        <tr>
                            <td><?= $grupo['nombre'] ?></td>
                        </tr>
                    <?php endforeach; ?>
                </tbody>
            </table>
        </section>
    </main>
</body>
</html>
