// Creamos la función para validar el formulario de reserva
function validarFormulario(event) {
    // Evitamos que el formulario se envíe por defecto
    event.preventDefault();

    // Obtenemos los valores de los campos del formulario usando sus IDs
    const nombreCliente = document.getElementById("nombre_cliente").value.trim();
    const tipoClase = document.getElementById("tipo_clase").value;
    const fechaReserva = document.getElementById("fecha_reserva").value;

    // Creamos una expresión regular para validar que el nombre solo tenga letras y espacios
    const regexNombre = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/;

    // Validamos el nombre del cliente para asegurarnos de que cumple con la expresión regular
    if (!regexNombre.test(nombreCliente)) {
        alert("El nombre debe contener solo letras y espacios.");
        return; // Salimos de la función si el nombre no es válido
    }

    // Verificamos que se haya seleccionado un tipo de clase
    if (!tipoClase) {
        alert("Por favor, selecciona un tipo de clase.");
        return; // Salimos de la función si no hay tipo de clase seleccionado
    }

    // Verificamos que la fecha no esté vacía
    if (!fechaReserva) {
        alert("Por favor, selecciona una fecha válida.");
        return; // Salimos de la función si no hay fecha seleccionada
    }

    // Verificamos que la fecha de reserva no sea anterior a la fecha actual
    const hoy = new Date();
    const fechaReservaObj = new Date(fechaReserva);
    hoy.setHours(0, 0, 0, 0); // Hora inicial del día 

    if (fechaReservaObj < hoy) {
        alert("No puedes reservar una fecha anterior a la fecha actual.");
        return; // Salimos de la función si la fecha es anterior
    }

    // Si todo es válido, mostramos un mensaje al usuario
    alert("¡Reserva realizada correctamente!");

    // Llamamos a la función guardar cookies
    guardarReservaEnCookie(nombreCliente, tipoClase, fechaReserva);

    // Reiniciamos el formulario para que quede vacío después de enviarse
    document.getElementById("formulario-reserva").reset();
}

// Asociamos la función de validación al evento "submit" del formulario
document.getElementById("formulario-reserva").addEventListener("submit", function(event) {
    // Llamamos a la función de validación y verificamos si hay errores
    if (!validarFormulario(event)) {
        // Si hay errores, evitamos que el formulario se envíe
        event.preventDefault();
    }
});


// Creamos la función para mostrar una reserva en la lista de reservas
function agregarReservaALista(nombre, clase, fecha) {
    const listaReservas = document.getElementById("reservas-list");
    const nuevaReserva = document.createElement("li");
    nuevaReserva.textContent = `Nombre: ${nombre}, Clase: ${clase}, Fecha: ${fecha}`;
    nuevaReserva.setAttribute("class", "reserva-item");
    listaReservas.appendChild(nuevaReserva);
}

// Creamos la función Guardar Rerserva en Cookie 
function guardarReservaEnCookie() {
    // Obtenemos los valores de los campos del formulario
    const nombreCliente = document.getElementById("nombre_cliente").value.trim();
    const tipoClase = document.getElementById("tipo_clase").value;
    const fechaReserva = document.getElementById("fecha_reserva").value;

    // Creamos la cadena de datos para la cookie
    const datosReserva = `nombre=${nombreCliente}&clase=${tipoClase}&fecha=${fechaReserva}`;

    // Establecemos la duración de la cookie (1 día)
    const fechaExpiracion = new Date();
    fechaExpiracion.setDate(fechaExpiracion.getDate() + 1);

    // Guardamos la cookie
    document.cookie = `${datosReserva};expires=${fechaExpiracion.toUTCString()};path=/`;

     // Agregamos la reserva a la lista en la página
     agregarReservaALista(nombreCliente, tipoClase, fechaReserva);

    alert("¡Reserva guardada en cookies!");
}

// Creamos la función para Leer Rerseva de Cookie
function leerReservaDeCookie() {
    // Obtenemos todas las cookies disponibles
    const cookies = document.cookie;

    if (!cookies) {
        alert("No hay reservas almacenadas en cookies.");
        return;
    }

    // Buscamos y procesamos la cookie relacionada con la reserva
    const reservas = cookies.split("; ").find(row => row.startsWith("nombre="));
    if (reservas) {
        const [nombre, clase, fecha] = reservas.split("&").map(item => item.split("=")[1]);
        alert(`Reserva guardada:\nNombre: ${nombre}\nClase: ${clase}\nFecha: ${fecha}`);
    } else {
        alert("No se encontró ninguna reserva guardada.");
    }
}

// Creamos la función para eliminar una reserva del DOM y las cookies
function eliminarReserva() {
    // Seleccionamos el formulario de reserva
    const formulario = document.getElementById("formulario-reserva");

    // Verificamos si existe una cookie llamada "reserva"
    const cookies = document.cookie.split("; ").find(cookie => cookie.startsWith("nombre="));
    
    if (!cookies) {
        alert("No hay reservas guardadas que eliminar.");
        return;
    }

    // Verificamos si el formulario existe en el DOM
    if (formulario) {
        // Reiniciamos el formulario para vaciar los campos
        formulario.reset();

        // Eliminamos la cookie configurando una fecha de expiración pasada
        document.cookie = "nombre=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
        
        // Mostramos un mensaje al usuario indicando que la reserva ha sido eliminada
        alert("La reserva ha sido eliminada correctamente.");

        // Limpiamos la lista de reservas
        const listaReservas = document.getElementById("reservas-list");
        listaReservas.innerHTML = "";
        
    } else {
        // Si no se encuentra el formulario, informamos al usuario
        alert("No hay reservas que eliminar.");
    }
}

// Añadimos un botón para eliminar la reserva directamente en el archivo HTML usando JavaScript
document.querySelector("main").insertAdjacentHTML(
    "beforeend",
    `<button id="btnEliminarReserva" style="margin-top: 20px;">Eliminar Reserva</button>`
);

// Asociamos la función "eliminarReserva" al evento click del botón
document.getElementById("btnEliminarReserva").addEventListener("click", eliminarReserva);





















