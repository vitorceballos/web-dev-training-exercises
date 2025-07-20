function agregarAlumno() {
    // Obtenemos los valores de los campos del formulario
    const nombre = document.getElementById("nombre").value;
    const edad = document.getElementById("edad").value;
    const curso = document.getElementById("curso").value;

    // Creamos un nuevo elemento de lista (li)
    const nuevoAlumno = document.createElement("li");

    // Asignamos el contenido al elemento de lista con la información del alumno
    nuevoAlumno.textContent = `Nombre: ${nombre}, Edad: ${edad}, Curso: ${curso}`;

    // Obtenemos el elemento donde se mostrará la lista de alumnos
    const listaAlumnos = document.getElementById("lista-alumnos");

    // Añadimos el nuevo elemento de lista a la lista de alumnos
    listaAlumnos.appendChild(nuevoAlumno);

    // Limpiamos los campos del formulario después de agregar el alumno
    document.getElementById("formulario-alumno").reset();
}

    // Agregamos un evento al formulario para que llame a la función al enviar
document.getElementById("formulario-alumno").addEventListener("submit", function(event) {
    event.preventDefault(); // Evita el envío del formulario y la recarga de la página
    agregarAlumno();
});

// Función eliminar alumnos de la lista
function eliminarAlumno() {
    // Seleccionamos el primer elemento de la lista de alumnos (li)
    const primerAlumno = document.querySelector("#lista-alumnos li");

    // Verificamos si existe un elemento en la lista
    if (primerAlumno) {
        // Eliminamos el primer elemento
        primerAlumno.remove();
    } else {
        alert("No hay alumnos en la lista para eliminar.");
    }
}

// Añadimos un botón "Eliminar Alumno" justo debajo de la lista de alumnos
document.querySelector("#lista-alumnos").insertAdjacentHTML("afterend", `
    <button id="btnEliminarAlumno">Eliminar Alumno</button>
`);

// Agregamos un evento al botón "Eliminar Alumno"
document.getElementById("btnEliminarAlumno").addEventListener("click", eliminarAlumno);

// Variable para almacenar el elemento seleccionado
let elementoSeleccionado = null;

// Función para navegar a través de los elementos
function navegarElementos(direccion) {
    // Si no hay elemento seleccionado, seleccionamos el primer elemento de la lista
    if (!elementoSeleccionado) {
        elementoSeleccionado = document.querySelector("#lista-alumnos li");
        if (elementoSeleccionado) {
            elementoSeleccionado.style.backgroundColor = "#ffeeba"; // Resaltamos el primer elemento
        }
        return;
    }

    // Quitamos el estilo de resaltado del elemento actual
    elementoSeleccionado.style.backgroundColor = "";

    // Dependiendo de la dirección, seleccionamos el siguiente o el anterior
    if (direccion === "siguiente") {
        if (elementoSeleccionado.nextElementSibling) {
            elementoSeleccionado = elementoSeleccionado.nextElementSibling;
        } else {
            alert("No hay más elementos hacia adelante.");
        }
    } else if (direccion === "anterior") {
        if (elementoSeleccionado.previousElementSibling) {
            elementoSeleccionado = elementoSeleccionado.previousElementSibling;
        } else {
            alert("No hay más elementos hacia atrás.");
        }
    }

    // Resaltamos el nuevo elemento seleccionado
    if (elementoSeleccionado) {
        elementoSeleccionado.style.backgroundColor = "#ffeeba";
    }
}

// Añadimos un h3 (texto de instrucción "Seleccione un Alumno" y botones para navegar entre los elementos
// Además añadimos estilo al h3 y a los botones
document.querySelector("#lista-alumnos").insertAdjacentHTML("afterend", `
    <div id="navegacion">
        <h3 style="color: #4882b6; font-size: 1em; font-weight: bold;">Seleccione un Alumno</h3>
        <button id="btnAnterior" style="background-color: #4882b6; color: white; border: none; padding: 5px 10px; border-radius: 3px; cursor: pointer;">Anterior</button>
        <button id="btnSiguiente" style="background-color: #4882b6; color: white; border: none; padding: 5px 10px; border-radius: 3px; cursor: pointer;">Siguiente</button>
    </div>
`);

// Agregamos eventos a los botones de navegación
document.getElementById("btnAnterior").addEventListener("click", () => navegarElementos("anterior"));
document.getElementById("btnSiguiente").addEventListener("click", () => navegarElementos("siguiente"));