/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_08;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class Producto {
    // Modificamos el atributo nombre para público para que sea accesible desde otras clases
    public String nombre;
    // Modificamos el atributo precio para protegido, accesible solo desde esta clase y las que hereden de Producto
    protected double precio;
    // Modificamos el atributo cantidad para privado para que solo sea accesible dentro de la clase Producto
    private int cantidad;

    // Creamos el constructor para inicializar los atributos
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y setters para acceder y modificar los atributos
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    // Creamos un método público para obtener el precio total
    public double obtenerPrecioTotal() {
        return precio * cantidad;  // Calculamos el precio total multiplicando el precio por la cantidad
    }
}






















