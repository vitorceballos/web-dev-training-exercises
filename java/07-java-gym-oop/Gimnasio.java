/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M03_ACT_07_Gimnasio;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class Gimnasio {
    
    // Creamos los arrays para almacenar los clientes y los entrenadores
    private Cliente[] clientes;
    private Entrenador[] entrenadores;

    // Creamos las variables para llevar el conteo de clientes y entrenadores
    private int numClientes;
    private int numEntrenadores;

    // Creamos el constructor de la clase Gimnasio
    public Gimnasio() {
        // Inicializamos los arrays con un tamaño máximo de 100 clientes y 10 entrenadores
        clientes = new Cliente[100];  // Creamos un array para almacenar hasta 100 clientes
        entrenadores = new Entrenador[10];  // Creamos un array para almacenar hasta 10 entrenadores
        numClientes = 0;  // Inicializamos el número de clientes a 0
        numEntrenadores = 0;  // Inicializamos el número de entrenadores a 0
    }
    
    // Creamos los métodos para acceder a los valores de numClientes y numEntrenadores
    public int getNumClientes() {
        return numClientes;
    }

    public int getNumEntrenadores() {
        return numEntrenadores;
    }
    
    // Creamos un método para agregar un cliente al gimnasio
    public void agregarCliente(Cliente cliente) {
        // Comprobamos si hay espacio en el array de clientes
        if (numClientes < 100) {
            clientes[numClientes] = cliente; // Añadimos el cliente al array en la posición actual
            numClientes++; // Aumentamos el número de clientes
            System.out.println("Cliente agregado: " + cliente.getNombre()); // Confirmamos la adición del cliente
        } else {
            System.out.println("No se puede agregar más clientes. El aforo está completo.");
        }
    }

    // Creamos un método para agregar un entrenador al gimnasio
    public void agregarEntrenador(Entrenador entrenador) {
        // Comprobamos si hay espacio en el array de entrenadores
        if (numEntrenadores < 10) {
            entrenadores[numEntrenadores] = entrenador; // Añadimos el entrenador al array en la posición actual
            numEntrenadores++; // Aumentamos el número de entrenadores
            System.out.println("Entrenador agregado: " + entrenador.getNombre()); // Confirmamos la adición del entrenador
        } else {
            System.out.println("No se puede agregar más entrenadores. El gimnasio ya tiene suficientes entrenadores.");
        }
    }

    // Creamos un método para asignar un entrenador a un cliente
    public void asignarEntrenador(String dniCliente, String codigoEntrenador) {
        Cliente cliente = null;
        Entrenador entrenador = null;

        // Buscamos al cliente por su DNI
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getDni().equals(dniCliente)) {
                cliente = clientes[i]; // Si encontramos al cliente, lo asignamos a la variable
                break;
            }
        }

        // Buscamos al entrenador por su código
        for (int i = 0; i < numEntrenadores; i++) {
            if (entrenadores[i].getCodigoEntrenador().equals(codigoEntrenador)) {
                entrenador = entrenadores[i]; // Si encontramos al entrenador, lo asignamos a la variable
                break;
            }
        }

        // Si encontramos tanto al cliente como al entrenador, asignamos el entrenador al cliente
        if (cliente != null && entrenador != null) {
            cliente.setEntrenador(entrenador); // Asignamos el entrenador al cliente
            System.out.println("Entrenador asignado a " + cliente.getNombre()); // Confirmamos la asignación
        } else {
            System.out.println("Cliente o entrenador no encontrado.");
        }
    }

    // Creamos un método para mostrar la información de todos los clientes
    public void mostrarInfoClientes() {
        System.out.println("\n--- Información de los Clientes ---");
        if (numClientes == 0) {
            System.out.println("No hay clientes en el gimnasio.");
        } else {
            // Recorremos todos los clientes y mostramos su información
            for (int i = 0; i < numClientes; i++) {
                clientes[i].mostrarInfo(); // Llamamos al método que muestra la información del cliente
            }
        }
    }

    // Creamos un método para mostrar la información de todos los entrenadores
    public void mostrarInfoEntrenadores() {
        System.out.println("\n--- Información de los Entrenadores ---");
        if (numEntrenadores == 0) {
            System.out.println("No hay entrenadores en el gimnasio.");
        } else {
            // Recorremos todos los entrenadores y mostramos su información
            for (int i = 0; i < numEntrenadores; i++) {
                entrenadores[i].mostrarInfo(); // Llamamos al método que muestra la información del entrenador
            }
        }
    }
}
