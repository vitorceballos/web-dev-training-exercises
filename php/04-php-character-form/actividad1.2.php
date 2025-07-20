<?php
// Clase base para los personajes del juego de rol
class Personaje {
    protected $nombre; 
    protected $especie; 
    protected $experiencia; 

    // Creamos el constructor para inicializar los atributos comunes del personaje
    public function __construct($nombre, $especie, $experiencia) {
        $this->nombre = $nombre; // Guardamos el nombre del personaje
        $this->especie = $especie; // Guardamos la especie del personaje
        $this->experiencia = $experiencia; // Guardamos los puntos de experiencia
    }

    // Creamos un método para mostrar la información general del personaje
    public function mostrarInformacion() {
        return "Nombre: {$this->nombre}, Especie: {$this->especie}, Experiencia: {$this->experiencia}";
    }

    // Método para obtener el tipo genérico del personaje
    public function obtenerTipo() {
        return "Personaje";
    }
}

// Clase Guerrero que hereda de Personaje
class Guerrero extends Personaje {
    private $enemigosAbatidos; // Enemigos derrotados por el guerrero
    private $danioSufrido; // Daño recibido en combate

    // Creamos el constructor para incluir atributos específicos del guerrero
    public function __construct($nombre, $especie, $experiencia, $enemigosAbatidos, $danioSufrido) {
        parent::__construct($nombre, $especie, $experiencia); // Usamos el constructor de la clase base
        $this->enemigosAbatidos = $enemigosAbatidos; // Guardamos la cantidad de enemigos abatidos
        $this->danioSufrido = $danioSufrido; // Guardamos el daño sufrido
    }

    // Creamos una función para calcular los puntos del guerrero según su desempeño
    public function calcularPuntos() {
        return ($this->enemigosAbatidos * 10) + ($this->danioSufrido * 5);
    }

    // Mostramos la información específica del guerrero junto con sus puntos
    public function mostrarInformacion() {
        return parent::mostrarInformacion() . ", Enemigos Abatidos: {$this->enemigosAbatidos}, Daño Sufrido: {$this->danioSufrido}, Puntos: " . $this->calcularPuntos();
    }

    // Indicamos el tipo de personaje que es (Guerrero)
    public function obtenerTipo() {
        return "GUERRERO";
    }
}

// Clase Mago que hereda de Personaje
class Mago extends Personaje {
    private $secretosDescubiertos; // Secretos encontrados por el mago
    private $hechizosLanzados; // Cantidad de hechizos que lanzó

    // Creamos el constructor para incluir atributos específicos del mago
    public function __construct($nombre, $especie, $experiencia, $secretosDescubiertos, $hechizosLanzados) {
        parent::__construct($nombre, $especie, $experiencia); // Usamos el constructor de la clase base
        $this->secretosDescubiertos = $secretosDescubiertos; // Guardamos los secretos descubiertos
        $this->hechizosLanzados = $hechizosLanzados; // Guardamos los hechizos lanzados
    }

    // Creamos una función para calcular los puntos del mago según su desempeño
    public function calcularPuntos() {
        return ($this->secretosDescubiertos * 5) + ($this->hechizosLanzados * 10);
    }

    // Mostramos la información específica del mago junto con sus puntos
    public function mostrarInformacion() {
        return parent::mostrarInformacion() . ", Secretos Descubiertos: {$this->secretosDescubiertos}, Hechizos Lanzados: {$this->hechizosLanzados}, Puntos: " . $this->calcularPuntos();
    }

    // Indicamos el tipo de personaje que es (Mago)
    public function obtenerTipo() {
        return "MAGO";
    }
}

// Clase Explorador que hereda de Personaje
class Explorador extends Personaje {
    private $objetivosDescubiertos; // Objetivos encontrados por el explorador
    private $vecesSinSerDescubierto; // Veces que no fue detectado

    // Creamos el constructor para incluir atributos específicos del explorador
    public function __construct($nombre, $especie, $experiencia, $objetivosDescubiertos, $vecesSinSerDescubierto) {
        parent::__construct($nombre, $especie, $experiencia); // Usamos el constructor de la clase base
        $this->objetivosDescubiertos = $objetivosDescubiertos; // Guardamos los objetivos descubiertos
        $this->vecesSinSerDescubierto = $vecesSinSerDescubierto; // Guardamos las veces que no fue descubierto
    }

    // Creamos una función para calcular los puntos del explorador según su desempeño
    public function calcularPuntos() {
        return ($this->objetivosDescubiertos * 10) + ($this->vecesSinSerDescubierto * 5);
    }

    // Mostramos la información específica del explorador junto con sus puntos
    public function mostrarInformacion() {
        return parent::mostrarInformacion() . ", Objetivos Descubiertos: {$this->objetivosDescubiertos}, Veces Sin Ser Descubierto: {$this->vecesSinSerDescubierto}, Puntos: " . $this->calcularPuntos();
    }

    // Indicamos el tipo de personaje que es (Explorador)
    public function obtenerTipo() {
        return "EXPLORADOR";
    }
}

// Creamos un array con personajes
$personajes = [];
$personajes[] = new Guerrero("Jon Snow", "Humano", 1500, 20, 8);
$personajes[] = new Mago("Melisandre", "Bruja Roja", 1800, 12, 30);
$personajes[] = new Explorador("Arya Stark", "Humana", 1600, 25, 18);
?>
<!-- Creamos la estructura HTML de la página -->
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tema 4: Actividad 1.2 - Personajes Juego</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Tema 4: Actividad 1.2 - Personajes Juego</h1>
    </header>
    <main>
        <h2>Listado de Personajes</h2>
        <!-- Mostramos la información de cada personaje con su tipo -->
        <?php foreach ($personajes as $personaje): ?>
            <div class="personaje">
                <h3><?= $personaje->obtenerTipo(); ?></h3>
                <p><?= $personaje->mostrarInformacion(); ?></p>
            </div>
        <?php endforeach; ?>
    </main>
</body>
</html>
