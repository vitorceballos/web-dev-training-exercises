// Ejercicio 1 - B
//Función para crear una cookie con nombre, valor y duración
function crearCookie(nombre, valor, dias) {
    let fecha = new Date();
    fecha.setTime(fecha.getTime() + (dias * 24 * 60 * 60 * 1000)); // Calculamos la fecha de expiración
    let expiracion = "expires=" + fecha.toUTCString(); // Establecemos la fecha de expiración
    document.cookie = nombre + "=" + valor + ";" + expiracion + ";path=/"; // Creamos la cookie
}

// Ejercicio 1 - C
// Se crea una cookie 'nombre' con el valor 'Juan' que dura 7 días
crearCookie('nombre', 'Juan', 7);

// Ejercicio 1 - D
// Función para abrir una nueva ventana
function abrirNuevaVentana(url, nombreVentana) {
    window.open(url, nombreVentana); // Abrimos una nueva ventana con la URL y el nombre dados
}

// Ejercicio 1 - E
document.addEventListener('DOMContentLoaded', function() {
    // Seleccionamos el botón y se le asigna un evento click
    document.getElementById('abrir-google').addEventListener('click', function() {
        abrirNuevaVentana('https://www.google.com', 'Ventana de Google'); // Se abre Google
    });
});

// Ejercicio 1 - F
// Función para obtener los parámetros de la URL actual y mostrarlos en la consola
function obtenerParametrosUrl() {
    let parametros = window.location.search; // Obtener los parámetros de la URL
    console.log("Parámetros de la URL: " + parametros); // Mostrar los parámetros
    
    // Comprobamos si existen parámetros
    if (parametros) {
        console.log("Se encontraron parámetros en la URL.");
        
        // Se crea un objeto URLSearchParams
        const urlParams = new URLSearchParams(parametros);
        
        // Para mostras los parámetros usamos:  
        urlParams.forEach((value, key) => {
            console.log(`${key}: ${value}`); // Mostrar el nombre y valor de cada parámetro
        });
    } else {
        console.log("No se encontraron parámetros en la URL.");
    }
}

obtenerParametrosUrl();

// Ejercicio 1 - G
// Función para cambiar el color de fondo del documento al azar
function cambiarColorDeFondo() {
    // Definimos una lista de colores posibles
    let colores = ["#FF5733", "#33FF57", "#3357FF", "#F333FF", "#FFFF33"];
    
    // Seleccionamos un color aleatorio de la lista
    let colorAleatorio = colores[Math.floor(Math.random() * colores.length)];
    
    // Cambiamos el color de fondo del documento
    document.body.style.backgroundColor = colorAleatorio;
    
    // Mostramos en consola el color que se ha seleccionado
    console.log("Color de fondo cambiado a: " + colorAleatorio);
}

// Asignamos la función cambiarColorDeFondo al evento 'click' del botón con id 'cambiar-color'
document.getElementById('cambiar-color').addEventListener('click', cambiarColorDeFondo);

