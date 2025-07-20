/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_12 {

    public static void main(String[] args) {
        // Creamos el objeto Libro
        Libro libroOriginal = new Libro("George Orwell", "1984", 1949, 49.99);

        // Realizamos la serialización del libro
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("libros.dat"))) {
            out.writeObject(libroOriginal);  // Serializamos el objeto
            System.out.println("El objeto se ha serializado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al serializar el objeto: " + e.getMessage());
        }
        // Deserialización del libro
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("libros.dat"))) {
            Libro libroDeserializado = (Libro) in.readObject();  // Deserializamos el objeto
            System.out.println("El objeto se ha deserializado correctamente.");

            // Mostramos la información del libro deserializado
            System.out.println("Título: " + libroDeserializado.getTitulo());
            System.out.println("Autor: " + libroDeserializado.getAutor()); // Este será null debido a 'transient'
            System.out.println("Año: " + libroDeserializado.getAnyo()); // Año deserializado
            // El precio no se serializa, por lo tanto no lo mostramos
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar el libro: " + e.getMessage());
        }
    }
}