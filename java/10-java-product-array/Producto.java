package m03_act_10;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Objects;
    
/**
 *
 * @author Vitor Mendes Ceballos 
 */
public class Producto {
    // Creamos los atributos de la clase Producto
    private String nombre;
    private ArrayList<String> materiales;
    private double precio;
    private int cantidad;

    // Constructor de la clase Producto para inicializar los atributos
    public Producto(String nombre, ArrayList<String> materiales, double precio, int cantidad) {
        this.nombre = nombre;
        this.materiales = materiales;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Métodos getters y setters para los atributos
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<String> getMateriales() {
        return materiales;
    }
    
    public void setMateriales(ArrayList<String> materiales) {
        this.materiales = materiales;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    // Sobrescribimos el método toString() para que nos muestre la información del producto
    @Override
    public String toString() {
        return "Producto{nombre=" + nombre + ", materiales=" + materiales + ", precio=" + precio + ", cantidad=" + cantidad + "}";
    }

    // Sobreescribimos equals() y hashCode() para comparar los productos por su nombre
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return nombre.equals(producto.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}









