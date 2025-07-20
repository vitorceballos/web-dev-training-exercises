/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_08;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class Bebida extends Producto {
    // Creamos los atributos adicionales específicos de la clase Bebida
    private double litroUnidad;
    private String sabor;

    // Creamos el constructor de la clase Bebida que llama al constructor de Producto
    public Bebida(String nombre, double precio, int cantidad, double litroUnidad, String sabor) {
        super(nombre, precio, cantidad);  // Llamamos al constructor de la clase base Producto
        this.litroUnidad = litroUnidad;
        this.sabor = sabor;
    }

    // Getters y setters para los atributos de Bebida
    public double getLitroUnidad() {
        return litroUnidad;
    }

    public void setLitroUnidad(double litroUnidad) {
        this.litroUnidad = litroUnidad;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
}