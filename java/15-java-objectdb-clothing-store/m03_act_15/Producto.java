/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_15;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Vitor Mendes Ceballos
 */
// Esta clase representa un producto que se vende en la tienda
@Entity
public class Producto {

    @Id // Indicamos que 'id' será la clave primaria
    private int id;
    private String nombre;
    private double precio;
    private String categoria;

    // Constructor para crear objetos Producto con sus atributos
    public Producto(int id, String nombre, double precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    Producto() {
    }

    // Getters y setters para acceder y modificar los atributos del producto
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}