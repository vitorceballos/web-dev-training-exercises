/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_09;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public abstract class Asignatura {
    private String nombre;
    private int creditos;

    // Creamos el constructor para inicializar los atributos
    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre; // Inicializamos el nombre de la asignatura
        this.creditos = creditos; // Inicializamos los créditos de la asignatura
    }

    // Creamos los getters y setters para acceder a los atributos
    public String getNombre() {
        return nombre; // Retornamos el nombre de la asignatura
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Asignamos el nombre de la asignatura
    }

    public int getCreditos() {
        return creditos; // Retornamos los créditos de la asignatura
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos; // Asignamos los créditos de la asignatura
    }
    
    // Añadimos el método abstracto que las clases hijas deben implementar
    public abstract double calcularPrecioTotal();
    
    // Añadimos el método abstracto mostrarInformacion() que las clases hijas deben implementar
    public abstract void mostrarInformacion();
    
}
