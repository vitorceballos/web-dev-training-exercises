/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package M03_ACT_07_Gimnasio;

import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_07_Gimnasio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos el gimnasio, el cual contiene los arrays de clientes y entrenadores
        Gimnasio gimnasio = new Gimnasio();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostramos el menú de opciones para que el usuario elija qué hacer
            System.out.println("\n---- Sistema de Gestión de Gimnasio ----");
            System.out.println("1. Agregar clientes al gimnasio");
            System.out.println("2. Agregar entrenadores al gimnasio");
            System.out.println("3. Asignar entrenador a cliente");
            System.out.println("4. Mostrar información de los clientes");
            System.out.println("5. Mostrar información de los entrenadores");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opción deseada: ");

            // Validamos la entrada del usuario
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // Limpiamos la entrada incorrecta
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiamos el buffer

            // Ejecutamos la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    // Agregar un cliente al gimnasio
                    if (gimnasio.getNumClientes() < 100) {
                        System.out.println("Ingrese los datos del cliente:");
                        System.out.print("Nombre: ");
                        String nombreCliente = scanner.nextLine();
                        System.out.print("DNI: ");
                        String dniCliente = scanner.nextLine();
                        System.out.print("Edad: ");
                        int edadCliente = scanner.nextInt();
                        scanner.nextLine(); // Limpiamos el buffer
                        System.out.print("Teléfono: ");
                        String telefonoCliente = scanner.nextLine();
                        System.out.print("Email: ");
                        String emailCliente = scanner.nextLine();
                        System.out.print("Membresía (1. Básica / 2. Premium): ");
                        int membresiaCliente = scanner.nextInt();
                        scanner.nextLine(); // Limpiamos el buffer

                        // Creamos el cliente y lo agregamos al gimnasio
                        Cliente cliente = new Cliente(nombreCliente, dniCliente, edadCliente, telefonoCliente, emailCliente, membresiaCliente);
                        gimnasio.agregarCliente(cliente);
                    } else {
                        System.out.println("No se puede agregar más clientes. El aforo está completo.");
                    }
                    break;
                case 2:
                    // Agregar un entrenador al gimnasio
                    if (gimnasio.getNumEntrenadores() < 10) {
                        System.out.println("Ingrese los datos del entrenador:");
                        System.out.print("Nombre: ");
                        String nombreEntrenador = scanner.nextLine();
                        System.out.print("Código de entrenador: ");
                        String codigoEntrenador = scanner.nextLine();
                        System.out.print("Edad: ");
                        int edadEntrenador = scanner.nextInt();
                        scanner.nextLine(); // Limpiamos el buffer
                        System.out.print("Teléfono: ");
                        String telefonoEntrenador = scanner.nextLine();
                        System.out.print("Email: ");
                        String emailEntrenador = scanner.nextLine();
                        System.out.print("Especialidad: ");
                        String especialidadEntrenador = scanner.nextLine();
                        System.out.print("Años de experiencia: ");
                        int aniosExperiencia = scanner.nextInt();
                        scanner.nextLine(); // Limpiamos el buffer

                        // Creamos el entrenador y lo agregamos al gimnasio
                        Entrenador entrenador = new Entrenador(nombreEntrenador, codigoEntrenador, edadEntrenador, telefonoEntrenador, emailEntrenador, especialidadEntrenador, aniosExperiencia);
                        gimnasio.agregarEntrenador(entrenador);
                    } else {
                        System.out.println("No se puede agregar más entrenadores. El gimnasio ya tiene suficientes entrenadores.");
                    }
                    break;
                case 3:
                    // Asignar un entrenador a un cliente
                    if (gimnasio.getNumClientes() == 0) {
                        System.out.println("Primero debe agregar clientes antes de asignar entrenadores.");
                    } else {
                        System.out.print("Ingrese el DNI del cliente: ");
                        String dniClienteAsignar = scanner.nextLine();
                        System.out.print("Ingrese el código del entrenador: ");
                        String codigoEntrenadorAsignar = scanner.nextLine();

                        // Asignamos el entrenador al cliente
                        gimnasio.asignarEntrenador(dniClienteAsignar, codigoEntrenadorAsignar);
                    }
                    break;
                case 4:
                    // Mostrar la información de los clientes
                    gimnasio.mostrarInfoClientes();
                    break;
                case 5:
                    // Mostrar la información de los entrenadores
                    gimnasio.mostrarInfoEntrenadores();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 6); // El bucle continuará hasta que el usuario elija salir

        scanner.close(); // Cerramos el scanner para evitar fugas de memoria
    }
}