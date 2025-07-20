/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_11_tienda_libros;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class Libro {
    private String titulo; // Atributo para almacenar el título del libro
    private int stock;     // Atributo para almacenar el stock del libro

    // Constructor para inicializar los atributos
    public Libro(String titulo, int stock) {
        this.titulo = titulo;
        this.stock = stock;
    }

    // Getter para obtener el título del libro
    public String getTitulo() {
        return titulo;
    }

    // Setter para establecer el título del libro
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter para obtener el stock del libro
    public int getStock() {
        return stock;
    }

    // Setter para modificar el stock del libro
    public void setStock(int stock) {
        this.stock = stock;
    }
}
