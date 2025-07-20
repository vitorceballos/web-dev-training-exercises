/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_09;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos las instancias de Programacion y BaseDatos
        Programacion programacion = new Programacion("Programación en Java", 6, "Java", "Intermedio");
        BaseDatos baseDatos = new BaseDatos("Base de Datos", 6, "MySQL", "Avanzado");

        // Almacenamos las instancias en el array de asignaturas
        Asignatura[] asignaturas = new Asignatura[5];
        asignaturas[0] = programacion;
        asignaturas[1] = baseDatos;
        
        // Recorremos el array y mostramos la información y el precio total
        for (Asignatura asignatura : asignaturas) {
            if (asignatura != null) {
                asignatura.mostrarInformacion(); // Mostramos la información de la asignatura
                System.out.println("Precio total: €" + asignatura.calcularPrecioTotal()); // Mostramos el precio total
            }
        }
    }
}
