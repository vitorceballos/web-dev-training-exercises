// Definimos la clase Plato para representar los platos del restaurante
class Plato {
    constructor(nombre, descripcion, precio) {
        this.nombre = nombre; 
        this.descripcion = descripcion; 
        this.precio = precio; 
    }

    // Retornamos el HTML que representa al plato en formato de tarjeta
    getHTML() {
        return '<div class="plato"><h3>' + this.nombre + '</h3><p>' + this.descripcion + '</p><span class="precio">' + this.precio + '€</span></div>';
    }
}

// Validamos la clase Plato creando una instancia y mostrando el HTML generado

// Creamos una instancia de la clase Plato con un plato
const plato1 = new Plato("Hamburguesa", "Deliciosa hamburguesa con carne jugosa y queso derretido", 10);

// Mostramos en la consola el HTML del plato usando el método getHTML()
console.log(plato1.getHTML());

// Definimos la clase Menu
class Menu {
    constructor(nombre) {
        this.nombre = nombre; 
        this.platos = []; 
    }

    // Función para añadir un plato al menú
    agregarPlato(plato) {
        this.platos.push(plato); // Añadimos el plato al array de platos
    }

    // Función para retornar el HTML que representa el menú y sus platos asociados
    getHTML() {
        // Iniciamos el HTML con el nombre del menú
        let html = `<div class="menu">
                        <h2>${this.nombre}</h2>
                        <div class="platos">`; // Agregamos el contenedor de platos

        // Recorremos la lista de platos y generamos el HTML de cada uno
        this.platos.forEach(plato => {
            html += plato.getHTML(); // Usamos la función getHTML() de la clase Plato
        });

        // Cerramos el contenedor de platos y el contenedor del menú
        html += `</div></div>`;
        return html; 
    }
}

// Creamos una instancia de la clase Menu
const menu1 = new Menu("Menú del día");

// Añadimos plato1 al menú
menu1.agregarPlato(plato1);

// Mostramos en la consola el HTML del menú con su plato
console.log(menu1.getHTML());

// Creación de un array global para almacenar todos los platos disponibles
const platosDisponibles = [];

// Añadimos el plato existente (plato1) al array
platosDisponibles.push(plato1);

// Creamos un nuevo plato llamado "Pizza"
const plato2 = new Plato("Pizza", "Sabrosa pizza con una variedad de ingredientes frescos", 12.5);

// Añadimos el nuevo plato al array
platosDisponibles.push(plato2);

// Mostramos los platos disponibles en la consola
console.log(platosDisponibles);

// Función para mostrar todos los platos disponibles en el HTML
function mostrarPlatos() {
    // Seleccionamos el contenedor de platos disponibles en el HTML
    const contenedorPlatos = document.getElementById('platosDisponibles');

    // Limpiamos el contenido del contenedor
    contenedorPlatos.innerHTML = '<h2>Platos Disponibles</h2>';

    // Recorremos el array de platos disponibles y añadimos cada uno al contenedor
    platosDisponibles.forEach(plato => {
        contenedorPlatos.innerHTML += plato.getHTML(); // Usamos el método getHTML() de la clase Plato
    });
}

// Llamamos a la función mostrarPlatos 
window.onload = mostrarPlatos;

// Array asociativo global para almacenar todos los menús disponibles
const menusDisponibles = {};

// Añadimos el menú existente (menu1) al array asociativo usando su nombre como clave
menusDisponibles[menu1.nombre] = menu1;

// Mostramos los menús disponibles en la consola para verificar
console.log(menusDisponibles);

// Función para mostrar todos los menús disponibles en el HTML
function mostrarMenus() {
    // Seleccionamos el contenedor de menús disponibles en el HTML
    const contenedorMenus = document.getElementById('menusDisponibles');
    
    // Limpiamos el contenido del contenedor
    contenedorMenus.innerHTML = '<h2>Menús Disponibles</h2>';

    // Recorremos el array asociativo de menús disponibles y añadimos cada menú al contenedor
    for (const nombreMenu in menusDisponibles) {
        if (menusDisponibles.hasOwnProperty(nombreMenu)) {
            contenedorMenus.innerHTML += menusDisponibles[nombreMenu].getHTML(); // Usamos el método getHTML() de la clase Menu
        }
    }

    // Actualizamos el select de menús para "Añadir Plato a Menú"
    const selectMenus = document.getElementById('selectMenus');
    selectMenus.innerHTML = '<option value="">Seleccione un menú</option>'; // Resetear las opciones

    for (const nombreMenu in menusDisponibles) {
        const option = document.createElement('option');
        option.value = nombreMenu;
        option.textContent = nombreMenu;
        selectMenus.appendChild(option);
    }
}

// Llamamos a la función mostrarMenus una vez cargada la página
window.onload = function() {
    mostrarPlatos();
    mostrarMenus();
};

// Función para manejar el evento del botón "AÑADIR PLATO"
document.getElementById('btnAgregarPlato').addEventListener('click', function() {
    // Obtenemos los valores del formulario
    const nombre = document.getElementById('nombre').value;
    const descripcion = document.getElementById('descripcion').value;
    const precio = parseFloat(document.getElementById('precio').value);

    // Verificamos que los campos no estén vacíos y el precio sea válido
    if (nombre && descripcion && !isNaN(precio)) {
        // Creamos un nuevo plato con los valores ingresados
        const nuevoPlato = new Plato(nombre, descripcion, precio);

        // Añadimos el nuevo plato al array global de platos disponibles
        platosDisponibles.push(nuevoPlato);

        // Actualizamos la lista de platos visibles
        mostrarPlatos();

        // Limpiamos los campos del formulario
        document.getElementById('nombre').value = '';
        document.getElementById('descripcion').value = '';
        document.getElementById('precio').value = '';
    } else {
        alert('Por favor, complete todos los campos correctamente.');
    }
});

// Función para manejar el evento del botón "ELIMINAR"
document.getElementById('btnEliminar').addEventListener('click', function() {
    // Obtenemos el índice del plato seleccionado
    const select = document.getElementById('selectPlatosEliminar');
    const indice = select.selectedIndex - 1; // Restamos 1 porque la primera opción es "Seleccione un plato"

    // Verificamos que se haya seleccionado un plato válido
    if (indice >= 0) {
        // Eliminamos el plato seleccionado del array
        platosDisponibles.splice(indice, 1);

        // Actualizamos la lista de platos visibles
        mostrarPlatos();

        // Actualizamos las opciones del select
        actualizarSelectPlatos();
    } else {
        alert('Por favor, seleccione un plato para eliminar.');
    }
});

// Función para actualizar las opciones del select con los platos disponibles
function actualizarSelectPlatos() {
    const select = document.getElementById('selectPlatos');
    select.innerHTML = '<option value="">Seleccione un plato</option>'; // Reseteamos las opciones

    // Recorremos los platos disponibles y añadimos cada uno como opción
    platosDisponibles.forEach((plato, index) => {
        const option = document.createElement('option');
        option.value = index;
        option.textContent = plato.nombre;
        select.appendChild(option);
    });
}

// Actualizamos el select al cargar la página
window.onload = function() {
    mostrarPlatos();
    mostrarMenus();
    actualizarSelectPlatos();
};

document.getElementById('btnAgregarMenu').addEventListener('click', function() {
    // Obtenemos el valor del nombre del menú
    const nombreMenu = document.getElementById('nombreMenu').value.trim();

    // Verificamos que el nombre no esté vacío
    if (nombreMenu) {
        // Creamos un nuevo menú
        const nuevoMenu = new Menu(nombreMenu);

        // Añadimos el nuevo menú al array asociativo de menús disponibles
        menusDisponibles[nombreMenu] = nuevoMenu;

        // Actualizamos la lista de menús visibles
        mostrarMenus();

        // Limpiamos el campo de entrada
        document.getElementById('nombreMenu').value = '';
    } else {
        alert('Por favor, ingrese un nombre para el menú.');
    }
});


// Modificación de la función mostrarPlatos para actualizar el select
function mostrarPlatos() {
    // Seleccionamos el contenedor de platos disponibles en el HTML
    const contenedorPlatos = document.getElementById('platosDisponibles');

    // Limpiamos el contenido del contenedor
    contenedorPlatos.innerHTML = '<h2>Platos Disponibles</h2>';

    // Recorremos el array de platos disponibles y añadimos cada uno al contenedor
    platosDisponibles.forEach(plato => {
        contenedorPlatos.innerHTML += plato.getHTML(); // Usamos el método getHTML() de la clase Plato
    });


    // Actualizamos el select de platos para eliminar
    const selectPlatosEliminar = document.getElementById('selectPlatosEliminar');
    selectPlatosEliminar.innerHTML = '<option value="">Seleccione un plato</option>'; // Resetear las opciones
    platosDisponibles.forEach((plato, index) => {
        const option = document.createElement('option');
        option.value = index;
        option.textContent = plato.nombre;
        selectPlatosEliminar.appendChild(option);
    });
}

// Modificación de la función mostrarPlatos para actualizar el select
function mostrarPlatos() {
    // Seleccionamos el contenedor de platos disponibles en el HTML
    const contenedorPlatos = document.getElementById('platosDisponibles');
    
    // Limpiamos el contenido del contenedor
    contenedorPlatos.innerHTML = '<h2>Platos Disponibles</h2>';

    // Recorremos el array de platos disponibles y añadimos cada uno al contenedor
    platosDisponibles.forEach(plato => {
        contenedorPlatos.innerHTML += plato.getHTML(); // Usamos el método getHTML() de la clase Plato
    });

    // Actualizamos el select de platos para eliminar y para añadir a menú
    const selectPlatosEliminar = document.getElementById('selectPlatosEliminar');
    const selectPlatosMenu = document.getElementById('selectPlatosMenu');
    
    // Limpiamos las opciones de ambos selects
    selectPlatosEliminar.innerHTML = '<option value="">Seleccione un plato</option>';
    selectPlatosMenu.innerHTML = '<option value="">Seleccione un plato</option>';

    // Añadimos cada plato como opción en ambos selects
    platosDisponibles.forEach((plato, index) => {
        const optionEliminar = document.createElement('option');
        optionEliminar.value = index;
        optionEliminar.textContent = plato.nombre;
        selectPlatosEliminar.appendChild(optionEliminar);

        const optionMenu = document.createElement('option');
        optionMenu.value = index;
        optionMenu.textContent = plato.nombre;
        selectPlatosMenu.appendChild(optionMenu);
    });
}

// Aseguramos que estas funciones se llaman al cargar la página
window.onload = function() {
    mostrarPlatos();
    mostrarMenus();
};

// Función para manejar el evento del botón "AÑADIR PLATO AL MENÚ"
document.getElementById('btnAgregarPlatoMenu').addEventListener('click', function() {
    // Obtenemos el índice del plato seleccionado y el nombre del menú seleccionado
    const selectPlatosMenu = document.getElementById('selectPlatosMenu');
    const selectMenus = document.getElementById('selectMenus');
    const indicePlato = selectPlatosMenu.selectedIndex - 1; // Restamos 1 porque la primera opción es "Seleccione un plato"
    const nombreMenu = selectMenus.value;

    // Verificamos que se haya seleccionado un plato y un menú válidos
    if (indicePlato >= 0 && nombreMenu) {
        // Obtenemos el plato y el menú seleccionados
        const platoSeleccionado = platosDisponibles[indicePlato];
        const menuSeleccionado = menusDisponibles[nombreMenu];

        // Añadimos el plato al menú
        menuSeleccionado.agregarPlato(platoSeleccionado);

        // Actualizamos la lista de menús visibles
        mostrarMenus();
    } else {
        alert('Por favor, seleccione un plato y un menú válidos.');
    }
});
