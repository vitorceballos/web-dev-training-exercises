/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_11_tienda_libros;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_11_Tienda_Libros {

    // Creamos un HashMap para almacenar los libros, donde la clave es el título y el valor es un objeto de tipo Libro.
    private HashMap<String, Libro> inventario;

    // Constructor de la tienda
    public M03_ACT_11_Tienda_Libros() {
        inventario = new HashMap<>();  // Inicializamos el HashMap
    }

    // Método para agregar un libro al inventario
    public void agregarLibro(String titulo, int stock) {
        if (!inventario.containsKey(titulo)) {
            // Si el libro no existe, lo agregamos
            Libro nuevoLibro = new Libro(titulo, stock);
            inventario.put(titulo, nuevoLibro);
            System.out.println("Libro agregado correctamente: " + titulo);
        } else {
            System.out.println("El libro ya existe en el inventario.");
        }
    }

    // Método para vender un libro
    public void venderLibro(String titulo) throws ExcepcionLibroNoEncontrado, ExcepcionStockAgotado {
        // Verificamos si el libro existe
        Libro libro = buscarLibro(titulo); // Llamamos al método de búsqueda
        if (libro != null) {
            if (libro.getStock() > 0) {
                libro.setStock(libro.getStock() - 1); // Reducimos el stock
                System.out.println("Libro vendido: " + titulo);
            } else {
                throw new ExcepcionStockAgotado("No hay stock suficiente para " + titulo);
            }
        }
    }

    // Método para buscar un libro
    public Libro buscarLibro(String titulo) throws ExcepcionLibroNoEncontrado {
        if (inventario.containsKey(titulo)) {
            return inventario.get(titulo);
        } else {
            throw new ExcepcionLibroNoEncontrado("El libro " + titulo + " no se encuentra en el inventario.");
        }
    }

    // Método para mostrar los libros disponibles
    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("No hay libros en el inventario.");
        } else {
            for (String titulo : inventario.keySet()) {
                System.out.println(titulo + ": Stock = " + inventario.get(titulo).getStock());
            }
        }
    }

    public static void main(String[] args) {
        M03_ACT_11_Tienda_Libros tienda = new M03_ACT_11_Tienda_Libros(); // Creamos una instancia de la tienda
        Scanner scanner = new Scanner(System.in);

        // Bucle de menú
        while (true) {
            // Mostramos el menú
            System.out.println("========== MENÚ TIENDA DE LIBROS ==========");
            System.out.println("1. Agregar libro");
            System.out.println("2. Vender libro");
            System.out.println("3. Buscar libro");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiamos el buffer

            try {
                switch (opcion) {
                    case 1:
                        // Agregar libro
                        System.out.print("Ingrese el titulo del libro: ");
                        String tituloAgregar = scanner.nextLine();
                        System.out.print("Ingrese el stock del libro: ");
                        int stockAgregar = scanner.nextInt();
                        tienda.agregarLibro(tituloAgregar, stockAgregar);
                        break;

                    case 2:
                        // Vender libro
                        System.out.print("Ingrese el titulo del libro a vender: ");
                        String tituloVender = scanner.nextLine();
                        tienda.venderLibro(tituloVender);
                        break;

                    case 3:
                        // Buscar libro
                        System.out.print("Ingrese el titulo del libro a buscar: ");
                        String tituloBuscar = scanner.nextLine();
                        Libro libroBuscado = tienda.buscarLibro(tituloBuscar);
                        System.out.println("Libro encontrado: " + libroBuscado.getTitulo() + ", Stock: " + libroBuscado.getStock());
                        break;

                    case 4:
                        // Salir
                        System.out.println("¡Hasta luego!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
                }
            } catch (ExcepcionLibroNoEncontrado e) {
                System.out.println(e.getMessage());  // Capturamos la excepción de libro no encontrado
            } catch (ExcepcionStockAgotado e) {
                System.out.println(e.getMessage());  // Capturamos la excepción de stock agotado
            }
        }
    }
}














