/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M03_ACT_07_Gimnasio;

import java.util.ArrayList;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class Entrenador {
    
    // Creamos los atributos del entrenador
    private String nombre;
    private String codigoEntrenador;
    private int edad;
    private String telefono;
    private String email;
    private String especialidad;
    private int aniosDeExperiencia;
    
    // Creamos un ArrayList para guardar los clientes asignados a este entrenador
    private ArrayList<Cliente> clientesAsignados;

    // Creamos el constructor para inicializar todos los atributos del entrenador
    public Entrenador(String nombre, String codigoEntrenador, int edad, String telefono, String email,
                      String especialidad, int aniosDeExperiencia) {
        this.nombre = nombre;
        this.codigoEntrenador = codigoEntrenador;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.especialidad = especialidad;
        this.aniosDeExperiencia = aniosDeExperiencia;
        this.clientesAsignados = new ArrayList<>(); // Inicializamos la lista de clientes asignados
    }

    // Creamos los métodos getter para poder acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public String getCodigoEntrenador() {
        return codigoEntrenador;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public int getAniosDeExperiencia() {
        return aniosDeExperiencia;
    }

    // Creamos un método para asignar un cliente al entrenador
    public void asignarCliente(Cliente cliente) {
        // Añadimos el cliente a la lista de clientes asignados
        clientesAsignados.add(cliente);
    }
    
    // Creamos el método para mostrar la información del entrenador
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Código del Entrenador: " + codigoEntrenador);
        System.out.println("Edad: " + edad);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Años de experiencia: " + aniosDeExperiencia);
        System.out.println("---------------------------");
    }
}
    














