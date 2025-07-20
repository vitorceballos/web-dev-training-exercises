/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_03_ejercicio1;

import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_03_Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1.1. Crea un array de tamaño 10 para almacenar calificaciones de tipo double.
        // Se declara un array llamado 'calificaciones' con capacidad para almacenar 10 valores de tipo double.
        double[] calificaciones = new double[10];

        // Se crea un objeto Scanner para recibir datos del usuario desde la consola.
        Scanner sc = new Scanner(System.in);
        
        // 1.2. Mediante un bucle for, solicita al usuario que vaya introduciendo sus calificaciones.
        // Se usa un bucle 'for' para recorrer el array e ir pidiendo las calificaciones.
        for (int i = 0; i < calificaciones.length; i++) {
            double nota;
            do {
                // Solicitamos la calificación al usuario
                System.out.print("Introduce la calificación " + (i + 1) + " (entre 0 y 10): ");
                nota = sc.nextDouble();
        
        // 1.3. Validar que la calificación esté entre 0 y 10.
                // Si la nota ingresada no está en el rango, se muestra un mensaje de error y se vuelve a pedir.
                if (nota < 0 || nota > 10) {
                    System.out.println("Error: La calificación debe estar entre 0 y 10. Inténtalo de nuevo.");
                }
            } while (nota < 0 || nota > 10); // Se repite hasta que el usuario ingrese un valor válido.

            // Guardamos la calificación válida en el array.
            calificaciones[i] = nota;
        }     
        
         // 1.4. Muestra todas las calificaciones en líneas diferentes, indicando su leyenda.
        System.out.println("\nCalificaciones con su evaluación:");
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.print("Nota: " + calificaciones[i] + " - ");

            // Se determina la leyenda correspondiente según el valor de la calificación.
            if (calificaciones[i] >= 0 && calificaciones[i] <= 2.99) {
                System.out.println("Deficiente");
            } else if (calificaciones[i] >= 3 && calificaciones[i] <= 4.99) {
                System.out.println("Insuficiente");
            } else if (calificaciones[i] >= 5 && calificaciones[i] <= 7.99) {
                System.out.println("Bien");
            } else if (calificaciones[i] >= 8 && calificaciones[i] <= 9.99) {
                System.out.println("Notable");
            } else {
                System.out.println("Excelente");
            }
        }
    }
}
   