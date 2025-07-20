/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_09;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class BaseDatos extends Asignatura {
private String sistema;
    private String nivel;

    // Creamos el constructor para inicializar los atributos
    public BaseDatos(String nombre, int creditos, String sistema, String nivel) {
        super(nombre, creditos); // Llamamos al constructor de la clase base Asignatura
        this.sistema = sistema; // Inicializamos el sistema de base de datos
        this.nivel = nivel; // Inicializamos el nivel de la asignatura
    }

    // Creamos los métodos getter y setter para los atributos de BaseDatos
    public String getSistema() {
        return sistema; // Retornamos el sistema de base de datos
    }

    public void setSistema(String sistema) {
        this.sistema = sistema; // Asignamos el sistema de base de datos
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
        return getCreditos() * 100; // Precio ficticio para BaseDatos en los créditos
    }
    
    // Implementamos el método mostrarInformacion para mostrar los datos de la asignatura
    @Override
    public void mostrarInformacion() {
        System.out.println("Asignatura: " + getNombre());
        System.out.println("Créditos: " + getCreditos());
        System.out.println("Sistema: " + sistema);
        System.out.println("Nivel: " + nivel);
    }
}