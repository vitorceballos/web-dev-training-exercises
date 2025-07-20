/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_08;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class Comida extends Producto implements Coccion {
    // Creamos los atributos adicionales específicos de la clase Comida
    private String caducidad;
    private String tipo;
    private int tipoCoccion;

    // Creamos el constructor de la clase Comida que llama al constructor de Producto
    public Comida(String nombre, double precio, int cantidad, String caducidad, String tipo, int tipoCoccion) {
        super(nombre, precio, cantidad);  // Llamamos al constructor de la clase base Producto
        this.caducidad = caducidad;
        this.tipo = tipo;
        this.tipoCoccion = tipoCoccion;
    }
    
     // Implementamos el método tipoCoccion de la interfaz Coccion
    @Override
    public void tipoCoccion(int tipo) {
        switch (tipo) {
            case 0:
                System.out.println("Cocción en Microondas.");
                break;
            case 1:
                System.out.println("Cocción en Sartén.");
                break;
            case 2:
                System.out.println("Cocción en Horno.");
                break;
            default:
                System.out.println("Cocción no válida.");
                break;
        }
    }

    // Getters y setters para los atributos de Comida
    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTipoCoccion() {
        return tipoCoccion;
    }

    public void setTipoCoccion(int tipoCoccion) {
        this.tipoCoccion = tipoCoccion;
    }
}