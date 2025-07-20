/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_09;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class Programacion extends Asignatura {
private String lenguaje;
    private String nivel;

    // Creamos el constructor para inicializar los atributos
    public Programacion(String nombre, int creditos, String lenguaje, String nivel) {
        super(nombre, creditos); // Llamamos al constructor de la clase base Asignatura
        this.lenguaje = lenguaje; // Inicializamos el lenguaje de programación
        this.nivel = nivel; // Inicializamos el nivel de la asignatura
    }
    

    // Creamos los métodos getter y setter para los atributos de Programacion
    public String getLenguaje() {
        return lenguaje; // Retornamos el lenguaje de programación
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje; // Asignamos el lenguaje de programación
    }

    public String getNivel() {
        return nivel; // Retornamos el nivel de la asignatura
    }

    public void setNivel(String nivel) {
        this.nivel = nivel; // Asignamos el nivel de la asignatura
    }
    
    // Implementamos el método calcularPrecioTotal para calcular el precio total de la asignatura
    @Override
    public double calcularPrecioTotal() {
    // Calculamos el precio total usando los créditos multiplicados por 120
    return getCreditos() * 120; // Precio ficticio para Programacion basado en los créditos
    } 

    // Implementamos el método mostrarInformacion para mostrar los datos de la asignatura
    @Override
    public void mostrarInformacion() {
        System.out.println("Asignatura: " + getNombre());
        System.out.println("Créditos: " + getCreditos());
        System.out.println("Lenguaje: " + lenguaje);
        System.out.println("Nivel: " + nivel);
    }
}
