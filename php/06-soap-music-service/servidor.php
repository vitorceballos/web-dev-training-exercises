<?php
// Incluimos la librería NuSOAP para crear el servidor SOAP
// Esto nos permitirá gestionar servicios web SOAP con PHP.
require_once("lib/nusoap.php");

// Creamos el servidor
// El servidor se encargará de recibir solicitudes de los clientes y devolver respuestas.
$servidor = new soap_server();

// Definimos el namespace que usará nuestro servicio.
// El namespace es necesario para identificar el servicio de manera única.
$namespace = "http://localhost/Actividades_Tema_6/servidor.php"; // Definimos el namespace
$servidor->configureWSDL("ServicioMusica", $namespace);
$servidor->wsdl->schemaTargetNamespace = $namespace;

/**
 * Creamos la función para insertar un grupo en la base de datos.
    * - Recibe: el nombre del grupo y el ID del género.
    * - Devuelve: un mensaje indicando si el grupo fue insertado correctamente.
 */
function insertarGrupo($nombre, $genero) {
    // Conectamos a la base de datos MySQL.
    $conexion = new mysqli("localhost", "root", "root", "musica");
    // Verificamos si hubo un error al conectar.
    if ($conexion->connect_error) {
        return "Error de conexión: " . $conexion->connect_error;
    }
    // Preparamos la consulta para insertar el grupo en la tabla.
    $sql = $conexion->prepare("INSERT INTO GRUPO (nombre, genero) VALUES (?, ?)");
    $sql->bind_param("si", $nombre, $genero);
    $sql->execute();
    // Cerramos la conexión con la base de datos.
    $conexion->close();

    return "Grupo insertado correctamente.";
}

/**
 * Creamos la función para obtener todos los géneros disponibles.
    * - Devuelve: un array con el ID y nombre de todos los géneros en la tabla `GENERO`.
 */
function obtenerGeneros() {
    // Conectamos a la base de datos MySQL.
    $conexion = new mysqli("localhost", "root", "root", "musica");
    // Verificamos si hubo un error al conectar.
    if ($conexion->connect_error) {
        return [];
    }
    // Ejecutamos una consulta para obtener todos los géneros.
    $resultado = $conexion->query("SELECT * FROM GENERO");
    // Creamos un array para almacenar los géneros.
    $generos = [];
    while ($fila = $resultado->fetch_assoc()) {
        $generos[] = $fila;
    }
    // Cerramos la conexión con la base de datos.
    $conexion->close();
    // Retornamos el array con los géneros.
    return $generos;
}

/**
 * Creamos la función para obtener todos los grupos de un género.
    * - Recibe: el ID del género.
    * - Devuelve: un array con los grupos correspondientes.
 */
function obtenerGruposPorGenero($genero) {
    // Conectamos a la base de datos MySQL.
    $conexion = new mysqli("localhost", "root", "root", "musica");
    // Verificamos si hubo un error al conectar.
    if ($conexion->connect_error) {
        return [];
    }
    // Preparamos la consulta para obtener los grupos del género especificado
    $sql = $conexion->prepare("SELECT * FROM GRUPO WHERE genero = ?");
    $sql->bind_param("i", $genero);// Enlazamos el ID del género como parámetro.
    $sql->execute();
    $resultado = $sql->get_result();
    // Creamos un array para almacenar los grupos.
    $grupos = [];
    while ($fila = $resultado->fetch_assoc()) {
        $grupos[] = $fila; // Agregamos cada fila al array
    }
    // Cerramos la conexión con la base de datos.
    $conexion->close();
    // Retornamos el array con los grupos.
    return $grupos;
}

// Registramos las funciones del servidor
// Esto permite que las funciones puedan ser invocadas desde un cliente SOAP.
$servidor->register("insertarGrupo", ['nombre' => 'xsd:string', 'genero' => 'xsd:int'], ['return' => 'xsd:string'], $namespace);
$servidor->register("obtenerGeneros", [], ['return' => 'xsd:Array'], $namespace);
$servidor->register("obtenerGruposPorGenero", ['genero' => 'xsd:int'], ['return' => 'xsd:Array'], $namespace);

// Procesamos las solicitudes del cliente
// file_get_contents("php://input") lee los datos enviados por el cliente.
$servidor->service(file_get_contents("php://input"));
?>
