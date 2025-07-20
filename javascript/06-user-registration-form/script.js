// Creamos la función para validar el formulario de registro
function validarFormulario(event) {
    // Prevenimos que el formulario se envíe si hay errores
    event.preventDefault();

    // Obtenemos los valores de los campos
    const nombre = document.getElementById("nombre").value.trim();
    const apellido = document.getElementById("apellido").value.trim();
    const email = document.getElementById("correo").value.trim();
    const password = document.getElementById("contraseña").value.trim();
    const confirmPassword = document.getElementById("confirmar_contraseña").value.trim();

    let hayErrores = false; // Inicializamos una variable para verificar errores

    // Validamos que el nombre tenga al menos 2 caracteres
    if (nombre.length < 2) {
        alert("El nombre debe tener al menos 2 caracteres.");
        hayErrores = true;
    }

    // Validamos que el apellido tenga al menos 2 caracteres
    if (apellido.length < 2) {
        alert("El apellido debe tener al menos 2 caracteres.");
        hayErrores = true;
    }

    // Validamos que el correo tenga un formato válido
    const regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!regexEmail.test(email)) {
        alert("Por favor, introduce un correo electrónico válido.");
        hayErrores = true;
    }

    // Validamos que la contraseña tenga al menos 6 caracteres
    if (password.length < 6) {
        alert("La contraseña debe tener al menos 6 caracteres.");
        hayErrores = true;
    }

    // Validamos que las contraseñas coincidan
    if (password !== confirmPassword) {
        alert("Las contraseñas no coinciden.");
        hayErrores = true;
    }

    // Si no hay errores, permitimos el envío
    if (!hayErrores) {
        document.getElementById("formulario-registro").submit();
    }
}

// Asociamos la validación al evento "submit" del formulario
document.getElementById("formulario-registro").addEventListener("submit", validarFormulario);

