/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_06;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_06 {

    public static void main(String[] args) {
        // Creamos un Scanner para leer los datos que ingresa el usuario
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Aseguramos que la carpeta "archivos" existe antes de empezar
        crearCarpetaArchivos();

        // Bucle principal del menú
        do {
            // Mostramos el menú de opciones al usuario
            System.out.println("\n--- MENÚ DE ARCHIVOS ---");
            System.out.println("1. Nuevo Archivo");
            System.out.println("2. Listar Archivos");
            System.out.println("3. Mostrar un Archivo");
            System.out.println("4. Borrar un Archivo");
            System.out.println("5. Renombrar un Archivo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            // Validamos que el usuario introduzca un número correcto
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // Eliminamos la entrada incorrecta
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiamos el buffer del scanner

            // Ejecutamos la función correspondiente según la opción elegida
            switch (opcion) {
                case 1:
                    nuevoArchivo(scanner);
                    break;
                case 2:
                    listarArchivos();
                    break;
                case 3:
                    mostrarArchivo(scanner);
                    break;
                case 4:
                    borrarArchivo(scanner);
                    break;
                case 5:
                    renombrarArchivo(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }

        } while (opcion != 6); // Repetimos el menú hasta que el usuario elija salir

        scanner.close(); // Cerramos el Scanner al finalizar
    }

    /*
    Función para crear la carpeta "archivos" si no existe
    */
            
    public static void crearCarpetaArchivos() {
        // Obtenemos la ruta donde se debe crear la carpeta
        String carpetaPath = System.getProperty("user.dir") + File.separator + "archivos";
        File carpeta = new File(carpetaPath);

        // Verificamos si la carpeta ya existe
        if (!carpeta.exists()) {
            // Intentamos crear la carpeta
            if (carpeta.mkdir()) {
                System.out.println("Carpeta 'archivos' creada correctamente.");
            } else {
                System.out.println("Error al crear la carpeta 'archivos'.");
            }
        }
    }
    
    /*
    Función para crear un nuevo archivo con contenido
    */
    
    public static void nuevoArchivo(Scanner scanner) {
        System.out.print("Introduce el nombre del archivo (ejemplo.txt): ");
        String nombreArchivo = scanner.nextLine();

        // Definimos la ruta del nuevo archivo dentro de la carpeta "archivos"
        String rutaArchivo = System.getProperty("user.dir") + File.separator + "archivos" + File.separator + nombreArchivo;
        File archivo = new File(rutaArchivo);

        try {
            // Intentamos crear el archivo
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + nombreArchivo);
                System.out.print("Introduce el contenido del archivo: ");
                String contenido = scanner.nextLine();
                java.nio.file.Files.write(archivo.toPath(), contenido.getBytes());
                System.out.println("Contenido guardado correctamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
        }
    }

    /*
    Función para listar archivos dentro de la carpeta "archivos"
    */
    
    public static String[] listarArchivos() {
        // Obtenemos la ruta de la carpeta "archivos"
        String carpetaPath = System.getProperty("user.dir") + File.separator + "archivos";
        File carpeta = new File(carpetaPath);
        String[] archivos = carpeta.list(); // Obtenemos la lista de archivos

        // Si no hay archivos, lo indicamos
        if (archivos == null || archivos.length == 0) {
            System.out.println("No hay archivos en la carpeta.");
            return new String[0];
        }

        // Mostramos la lista de archivos disponibles
        System.out.println("\n--- Archivos disponibles ---");
        for (int i = 0; i < archivos.length; i++) {
            System.out.println((i + 1) + ". " + archivos[i]);
        }
        return archivos;
    }

    /*
    Función para mostrar el contenido de un archivo
    */
    public static void mostrarArchivo(Scanner scanner) {
        String[] archivos = listarArchivos();
        if (archivos.length == 0) return;

        System.out.print("Seleccione el número del archivo que desea ver: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiamos el buffer

        if (indice < 1 || indice > archivos.length) {
            System.out.println("Número inválido.");
            return;
        }

        File archivo = new File(System.getProperty("user.dir") + File.separator + "archivos" + File.separator + archivos[indice - 1]);

        try {
            String contenido = new String(java.nio.file.Files.readAllBytes(archivo.toPath()));
            System.out.println("\n--- Contenido del archivo ---");
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    /*
    Función para borrar un archivo
    */
    
    public static void borrarArchivo(Scanner scanner) {
        String[] archivos = listarArchivos();
        if (archivos.length == 0) return;

        System.out.print("Seleccione el número del archivo que desea borrar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiamos el buffer

        if (indice < 1 || indice > archivos.length) {
            System.out.println("Número inválido.");
            return;
        }

        File archivo = new File(System.getProperty("user.dir") + File.separator + "archivos" + File.separator + archivos[indice - 1]);

        if (archivo.delete()) {
            System.out.println("Archivo eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo.");
        }
    }

    /*
    Función para renombrar un archivo
     */
    public static void renombrarArchivo(Scanner scanner) {
        String[] archivos = listarArchivos();
        if (archivos.length == 0) return;

        System.out.print("Seleccione el número del archivo que desea renombrar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiamos el buffer

        if (indice < 1 || indice > archivos.length) {
            System.out.println("Número inválido.");
            return;
        }

        File archivoViejo = new File(System.getProperty("user.dir") + File.separator + "archivos" + File.separator + archivos[indice - 1]);

        System.out.print("Introduce el nuevo nombre del archivo (ejemplo.txt): ");
        String nuevoNombre = scanner.nextLine();
        File archivoNuevo = new File(System.getProperty("user.dir") + File.separator + "archivos" + File.separator + nuevoNombre);

        if (archivoNuevo.exists()) {
            System.out.println("El nombre ya está en uso.");
            return;
        }

        if (archivoViejo.renameTo(archivoNuevo)) {
            System.out.println("Archivo renombrado correctamente.");
        } else {
            System.out.println("Error al renombrar el archivo.");
        }
    }
}
