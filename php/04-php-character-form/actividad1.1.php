<?php
// Iniciamos la sesión para guardar el estado del parking
session_start();

// Comprobamos si ya existe el estado del parking en la sesión
if (!isset($_SESSION['parking_pequeno'])) {
    // Creamos 10 plazas para coches pequeños, todas libres al principio
    $_SESSION['parking_pequeno'] = array_fill(0, 10, 0);
    // Creamos 14 plazas para coches grandes, todas libres al principio
    $_SESSION['parking_grande'] = array_fill(0, 14, 0);
}

// Creamos la función que permite aparcar un coche según su tipo (pequeño o grande)
function aparcarCoche($tipo) {
    // Accedemos a las plazas del parking que ya hemos guardado
    global $_SESSION;

    if ($tipo === 'pequeno') {
        // Buscamos una plaza libre en la zona de coches pequeños
        foreach ($_SESSION['parking_pequeno'] as $key => $estado) {
            if ($estado === 0) { // Si encontramos una plaza libre
                $_SESSION['parking_pequeno'][$key] = 1; // Marcamos la plaza como ocupada
                return "Coche pequeño aparcado en la plaza pequeña número $key."; 
            }
        }
        // Si no hay plazas pequeñas libres, buscamos en la zona de coches grandes
        foreach ($_SESSION['parking_grande'] as $key => $estado) {
            if ($estado === 0) { // Si encontramos una plaza grande libre
                $_SESSION['parking_grande'][$key] = 1; // Marcamos la plaza como ocupada
                return "Coche pequeño aparcado en la plaza grande número $key."; 
            }
        }
    } elseif ($tipo === 'grande') {
        // Buscamos una plaza libre en la zona de coches grandes
        foreach ($_SESSION['parking_grande'] as $key => $estado) {
            if ($estado === 0) { // Si encontramos una plaza libre
                $_SESSION['parking_grande'][$key] = 1; // Marcamos la plaza como ocupada
                return "Coche grande aparcado en la plaza grande número $key."; 
            }
        }
    }

    // Mostramos un mensaje si no hay plazas disponibles
    return "No hay plazas disponibles para este tipo de coche."; 
}

// Creamos la función para retirar un coche de una plaza
function retirarCoche($zona, $plaza) {
    // Usamos las plazas que ya están guardadas en la sesión
    global $_SESSION;

    if ($zona === 'pequeno' && isset($_SESSION['parking_pequeno'][$plaza])) {
        // Comprobamos si la plaza pequeña está ocupada
        if ($_SESSION['parking_pequeno'][$plaza] === 1) {
            $_SESSION['parking_pequeno'][$plaza] = 0; // Liberamos la plaza
            return "El coche ha sido retirado de la plaza pequeña número $plaza."; 
        }
        // Si ya estaba libre
        return "La plaza pequeña número $plaza ya estaba libre."; 
    } elseif ($zona === 'grande' && isset($_SESSION['parking_grande'][$plaza])) {
        // Comprobamos si la plaza grande está ocupada
        if ($_SESSION['parking_grande'][$plaza] === 1) {
            $_SESSION['parking_grande'][$plaza] = 0; // Liberamos la plaza
            return "El coche ha sido retirado de la plaza grande número $plaza."; 
        }
        // Si ya estaba libre
        return "La plaza grande número $plaza ya estaba libre."; 
    }
    // Mensaje si la plaza no es correcta
    return "La plaza especificada no existe o no es válida."; 
}

// Creamos la función para mostrar cómo están las plazas del parking
function mostrarEstado() {
    // Accedemos a las plazas que hemos guardado
    global $_SESSION;

    // Convertimos las plazas en texto para mostrarlas
    $estadoPequeno = implode(', ', $_SESSION['parking_pequeno']);
    $estadoGrande = implode(', ', $_SESSION['parking_grande']);

    // Devolvemos el estado de las plazas en ambas zonas
    return "<h3>Estado de las plazas pequeñas: [$estadoPequeno]</h3>
            <h3>Estado de las plazas grandes: [$estadoGrande]</h3>";
}

// Procesamos el formulario enviado
$mensaje = ""; 
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Recogemos la operación que el usuario seleccionó
    $operacion = $_POST['operacion'] ?? ''; 

    if ($operacion === 'aparcar') {
        // Recogemos el tipo de coche (pequeño o grande)
        $tipo = $_POST['tipo'] ?? ''; 
        $mensaje = aparcarCoche($tipo); // Aparcamos el coche según el tipo
    } elseif ($operacion === 'retirar') {
        // Recogemos la zona del parking (pequeño o grande)
        $zona = $_POST['zona'] ?? ''; 
        // Recogemos el número de plaza que se quiere liberar
        $plaza = $_POST['plaza'] ?? ''; 
        $mensaje = retirarCoche($zona, $plaza); // Retiramos el coche de la plaza
    } elseif ($operacion === 'estado') {
        $mensaje = mostrarEstado(); // Mostramos el estado actual del parking
    }
}
?>

<!-- Creamos la estructura HTML de la página para gestionar las operaciones del parking, 
     incluyendo el formulario principal y las secciones de las acciones -->
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tema 4: Actividad 1.1 - Gestión de Parking</title>
    <link rel="stylesheet" href="styles.css">
    <script>
        // Usamos JAVASCRIPT para mostrar u ocultar los formularios adicionales según la operación seleccionada
        function mostrarFormulario() {
            const operacion = document.querySelector('input[name="operacion"]:checked')?.value;
            document.getElementById('form-aparcar').style.display = operacion === 'aparcar' ? 'block' : 'none';
            document.getElementById('form-retirar').style.display = operacion === 'retirar' ? 'block' : 'none';
            document.getElementById('form-estado').style.display = operacion === 'estado' ? 'block' : 'none';
        }
    </script>
</head>
<body>
    <header>
        <h1>Tema 4: Actividad 1.1 - Gestión de Parking</h1>
    </header>
    <main>
        <form method="post">
            <h2>Seleccione una operación:</h2>
            <label>
                <input type="radio" name="operacion" value="aparcar" onclick="mostrarFormulario()"> Aparcar coche
            </label><br>
            <label>
                <input type="radio" name="operacion" value="retirar" onclick="mostrarFormulario()"> Retirar coche
            </label><br>
            <label>
                <input type="radio" name="operacion" value="estado" onclick="mostrarFormulario()"> Visualizar estado del parking
            </label><br><br>

            <div id="form-aparcar" style="display: none;">
                <h3>Aparcar coche</h3>
                <label>
                    <input type="radio" name="tipo" value="pequeno"> Coche pequeño
                </label>
                <label>
                    <input type="radio" name="tipo" value="grande"> Coche grande
                </label>
            </div>

            <div id="form-retirar" style="display: none;">
                <h3>Retirar coche</h3>
                <label>Zona:
                    <select name="zona">
                        <option value="pequeno">Zona pequeña</option>
                        <option value="grande">Zona grande</option>
                    </select>
                </label><br>
                <label>Número de plaza:
                    <input type="number" name="plaza" min="0" placeholder="Nº de plaza">
                </label>
            </div>

            <div id="form-estado" style="display: none;">
                <h3>Visualizar estado del parking</h3>
                <p>Presione "Ejecutar" para ver el estado actual del parking.</p>
            </div>

            <br><button type="submit">Ejecutar</button>
        </form>

        <?php if ($mensaje): ?>
            <section class="resultado">
                <h2>Resultado:</h2>
                <p><?= $mensaje ?></p>
            </section>
        <?php endif; ?>
    </main>
</body>
</html>