/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_08;

import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_08 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // Creamos un Scanner para leer los datos del usuario
        Scanner scanner = new Scanner(System.in);

        // Creamos los arrays para almacenar las comidas y bebidas
        Comida[] comidas = new Comida[10];
        Bebida[] bebidas = new Bebida[10];

        // Creamos las variables para llevar el conteo de comidas y bebidas
        int comidaCount = 0;
        int bebidaCount = 0;

        // Empezamos un bucle infinito para mostrar el menú y gestionar las opciones
        while (true) {
            // Mostramos el menú de opciones
            System.out.println("------ MENU ------");
            System.out.println("1. Ingresar comida");
            System.out.println("2. Ingresar bebida");
            System.out.println("3. Mostrar stock");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            
            // Leemos la opción seleccionada por el usuario
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiamos el buffer

            // Procesamos según la opción seleccionada
            switch (opcion) {
                case 1: // Ingresar comida
                    // Si hay espacio en el array de comidas
                    if (comidaCount < 10) {
                        // Solicitamos los datos de la comida
                        System.out.println("Ingrese el nombre de la comida:");
                        String nombreComida = scanner.nextLine();
                        System.out.println("Ingrese el precio de la comida:");
                        double precioComida = scanner.nextDouble();
                        System.out.println("Ingrese la cantidad de la comida:");
                        int cantidadComida = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        System.out.println("Ingrese la fecha de caducidad de la comida:");
                        String fechaCaducidad = scanner.nextLine();
                        System.out.println("Ingrese el tipo de cocción (1-Microondas, 2-Sartén, 3-Horno):");
                        int tipoCoccion = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer

                        // Solicitamos el tipo de comida (Ejemplo: Tubérculo, Carne, etc.)
                        System.out.println("Ingrese el tipo de la comida:");
                        String tipo = scanner.nextLine();

                        // Creamos el objeto Comida con los datos proporcionados
                        Comida comida = new Comida(nombreComida, precioComida, cantidadComida, fechaCaducidad, tipo, tipoCoccion);
                        // Añadimos la comida al array de comidas
                        comidas[comidaCount++] = comida;
                        // Confirmamos que la comida fue agregada correctamente
                        System.out.println("Comida agregada correctamente.");
                    } else {
                        // Si no hay espacio en el array, mostramos un mensaje
                        System.out.println("No se puede agregar más comida, aforo completo.");
                    }
                    break;

                case 2: // Ingresar bebida
                    // Si hay espacio en el array de bebidas
                    if (bebidaCount < 10) {
                        // Solicitamos los datos de la bebida
                        System.out.println("Ingrese el nombre de la bebida:");
                        String nombreBebida = scanner.nextLine();
                        System.out.println("Ingrese el precio de la bebida:");
                        double precioBebida = scanner.nextDouble();
                        System.out.println("Ingrese la cantidad de la bebida:");
                        int cantidadBebida = scanner.nextInt();
                        System.out.println("Ingrese el volumen por unidad de la bebida (en litros):");
                        double volumenUnidad = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar buffer
                        System.out.println("Ingrese el sabor de la bebida:");
                        String sabor = scanner.nextLine();

                        // Creamos el objeto Bebida con los datos proporcionados
                        Bebida bebida = new Bebida(nombreBebida, precioBebida, cantidadBebida, volumenUnidad, sabor);
                        // Añadimos la bebida al array de bebidas
                        bebidas[bebidaCount++] = bebida;
                        // Confirmamos que la bebida fue agregada correctamente
                        System.out.println("Bebida agregada correctamente.");
                    } else {
                        // Si no hay espacio en el array, mostramos un mensaje
                        System.out.println("No se puede agregar más bebida, aforo completo.");
                    }
                    break;

                case 3: // Mostrar stock
                    // Mostramos todos los productos del stock
                    System.out.println("------ STOCK ------");
                    System.out.println("Comidas:");
                    for (int i = 0; i < comidaCount; i++) {
                        // Mostramos el nombre de cada comida y su precio total
                        System.out.println("Comida " + (i + 1) + ": " + comidas[i].getNombre() + " - Precio total: $" + comidas[i].obtenerPrecioTotal());
                    }
                    System.out.println("Bebidas:");
                    for (int i = 0; i < bebidaCount; i++) {
                        // Mostramos el nombre de cada bebida y su precio total
                        System.out.println("Bebida " + (i + 1) + ": " + bebidas[i].getNombre() + " - Precio total: $" + bebidas[i].obtenerPrecioTotal());
                    }
                    break;

                case 4: // Salir
                    // Salimos del programa
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    // Si el usuario ingresa una opción inválida, mostramos un mensaje
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}