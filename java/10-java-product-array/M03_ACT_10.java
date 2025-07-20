/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_10 {
    
    public static void main(String[] args) {
        // Creamos el HashMap donde la clave es el código del producto (String) y el valor es un objeto Producto.
        HashMap<String, Producto> listaProductos = new HashMap<>();
        
 // Creamos un Scanner para leer los datos del usuario
        Scanner scanner = new Scanner(System.in);

        // Iniciamos el ciclo para mostrar el menú y gestionar las opciones
        while (true) {
            System.out.println("====== MENÚ ======");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1: // Agregar producto
                    System.out.println("====== AGREGAR PRODUCTO ======");
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    double precioProducto = scanner.nextDouble();
                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidadProducto = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    System.out.println("Ingrese los materiales del producto (ingrese 'fin' para terminar): ");
                    ArrayList<String> materiales = new ArrayList<>();
                    String material;
                    while (true) {
                        material = scanner.nextLine();
                        if (material.equalsIgnoreCase("fin")) {
                            break;
                        }
                        materiales.add(material);
                    }

                    // Verificamos si el producto ya existe en la lista usando equals()
                    Producto productoNuevo = new Producto(nombreProducto, materiales, precioProducto, cantidadProducto);
                    if (listaProductos.containsValue(productoNuevo)) {
                        System.out.println("El producto ya existe.");
                    } else {
                        // Si no existe, lo agregamos al HashMap
                        String codigoProducto = "P" + (listaProductos.size() + 1); // Generamos un código para el producto
                        listaProductos.put(codigoProducto, productoNuevo);
                        System.out.println("Producto agregado exitosamente.");
                    }
                    break;

                case 2: // Actualizar producto
                    System.out.println("====== ACTUALIZAR PRODUCTO ======");
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    String nombreActualizar = scanner.nextLine();

                    // Buscamos el producto por su nombre
                    boolean productoEncontrado = false;
                    for (String codigo : listaProductos.keySet()) {
                        Producto p = listaProductos.get(codigo);
                        if (p.getNombre().equals(nombreActualizar)) {
                            productoEncontrado = true;
                            System.out.print("Ingrese el nuevo precio del producto: ");
                            p.setPrecio(scanner.nextDouble());
                            System.out.print("Ingrese la nueva cantidad del producto: ");
                            p.setCantidad(scanner.nextInt());
                            System.out.println("Producto actualizado exitosamente.");
                            break;
                        }
                    }
                    if (!productoEncontrado) {
                        System.out.println("El producto no existe.");
                    }
                    break;

                case 3: // Eliminar producto
                    System.out.println("====== ELIMINAR PRODUCTO ======");
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();

                    // Buscamos y eliminamos el producto
                    boolean productoEliminado = false;
                    for (String codigo : listaProductos.keySet()) {
                        Producto p = listaProductos.get(codigo);
                        if (p.getNombre().equals(nombreEliminar)) {
                            listaProductos.remove(codigo);
                            productoEliminado = true;
                            System.out.println("Producto eliminado exitosamente.");
                            break;
                        }
                    }
                    if (!productoEliminado) {
                        System.out.println("El producto no existe.");
                    }
                    break;

                case 4: // Salir
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return; // Termina la ejecución del programa

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            // Mostrar lista de productos después de cada acción
            System.out.println("====== LISTA DE PRODUCTOS ======");
            for (String codigo : listaProductos.keySet()) {
                Producto p = listaProductos.get(codigo);
                System.out.println(p); // Mostramos el producto
            }
        }
    }
}


























