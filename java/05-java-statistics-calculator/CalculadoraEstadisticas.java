/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estadisticas;

import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class CalculadoraEstadisticas {
    
    public static void main(String[] args) {
        // Creamos el objeto Scanner para recibir los datos del usuario
        Scanner scanner = new Scanner(System.in);
        double[] numeros = new double[10]; // Array para almacenar los números ingresados

        // Solicitamos los 10 números al usuario
        System.out.println("Introduce 10 números:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextDouble(); // Guardamos el número en el array
        }

        // Llamamos a los métodos de EstadisticasUtils y mostramos los resultados
        System.out.println("\nResultados estadísticos:");
        System.out.println("Promedio: " + EstadisticasUtils.calcularPromedio(numeros));
        System.out.println("Mediana: " + EstadisticasUtils.calcularMediana(numeros));
        System.out.println("Desviación estándar: " + EstadisticasUtils.calcularDesviacionEstandar(numeros));

        // Cerramos el Scanner para evitar fugas de memoria
        scanner.close();
    }
}