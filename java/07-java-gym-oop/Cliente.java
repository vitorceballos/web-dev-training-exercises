/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M03_ACT_07_Gimnasio;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class Cliente {
    
// Creamos los atributos del cliente
    private String nombre;
    private String dni;
    private int edad;
    private String telefono;
    private String email;
    private int membresia; // 1 = Básica, 2 = Premium
    private Entrenador entrenador; // Relación con la clase Entrenador

    // Creamos el constructor para inicializar todos los atributos cuando creamos un cliente
    public Cliente(String nombre, String dni, int edad, String telefono, String email, int membresia) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.membresia = membresia;
        this.entrenador = null; // Al principio, el cliente no tiene entrenador asignado
    }

    // Creamos los métodos getter para poder acceder a los atributos desde fuera de la clase
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getMembresia() {
        return membresia;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
    this.entrenador = entrenador; // Asignamos el entrenador al cliente
 } 
    // Creamos el método para mostrar la información del cliente
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Edad: " + edad);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Membresía: " + (membresia == 1 ? "Básica" : "Premium"));
        if (entrenador != null) {
            System.out.println("Entrenador asignado: " + entrenador.getNombre());
        } else {
            System.out.println("Entrenador asignado: Ninguno");
        }
        System.out.println("---------------------------");
    }
}