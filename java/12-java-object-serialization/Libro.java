/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_12;

import java.io.Serializable;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class Libro implements Serializable  {
    
    // Atributos de la clase Libro
    private transient String autor; // El campo autor no será serializado
    private String titulo;
    private int anyo;
    private transient double precio; // El campo precio no será serializadoa

    // Constructor de la clase Libro para inicializar los atributos
    public Libro(String autor, String titulo, int anyo, double precio) {
        this.autor = autor;   // Inicializamos el autor
        this.titulo = titulo; // Inicializamos el título
        this.anyo = anyo;     // Inicializamos el año de publicación
        this.precio = precio; // Inicializamos el precio
    }

    // Métodos getters y setters para acceder a los atributos
    public String getAutor() {
        return autor; // Retorna el autor
    }
    public void setAutor(String autor) {
        this.autor = autor; // Establece el autor
    }
    public String getTitulo() {
        return titulo; // Retorna el título
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo; // Establece el título
    }
    public int getAnyo() {
        return anyo; // Retorna el año de publicación
    }
    public void setAnyo(int anyo) {
        this.anyo = anyo; // Establece el año de publicación
    }
    public double getPrecio() {
        return precio; // Retorna el precio
    }
    public void setPrecio(double precio) {
        this.precio = precio; // Establece el precio
    }
}