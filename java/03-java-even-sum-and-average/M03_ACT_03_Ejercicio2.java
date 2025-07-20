/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_03_ejercicio2;

import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_03_Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 2.1. Escribe un programa que cree una matriz bidimensional de tamaño 3x3.
        // Se define una matriz de 3x3 para almacenar valores enteros.
        int[][] matriz = new int[3][3];

        // Se crea un objeto Scanner para recibir datos del usuario desde la consola.
        Scanner sc = new Scanner(System.in);

        // Variables para almacenar el valor máximo y el mínimo de la matriz.
        int maximo = Integer.MIN_VALUE; // Se inicializa con el valor más bajo posible.
        int minimo = Integer.MAX_VALUE; // Se inicializa con el valor más alto posible.
        
        // Se solicita al usuario que ingrese valores para la matriz.
        System.out.println("Introduce los valores de la matriz 3x3:");
        for (int i = 0; i < 3; i++) { // Recorremos las filas
            for (int j = 0; j < 3; j++) { // Recorremos las columnas
                System.out.print("Introduce el valor para la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt(); // Guardamos el valor ingresado en la matriz

                // Comprobamos si el número ingresado es el nuevo máximo
                if (matriz[i][j] > maximo) {
                    maximo = matriz[i][j];
                }

                // Comprobamos si el número ingresado es el nuevo mínimo
                if (matriz[i][j] < minimo) {
                    minimo = matriz[i][j];
                }
            }
        }
        // Se muestra la matriz en pantalla.
        System.out.println("\nMatriz ingresada:");
        for (int i = 0; i < 3; i++) { // Recorremos las filas
            for (int j = 0; j < 3; j++) { // Recorremos las columnas
                System.out.print(matriz[i][j] + "\t"); // Mostramos el valor con tabulación
            }
            System.out.println(); // Salto de línea después de cada fila
        }

        // Se muestran los valores máximo y mínimo encontrados en la matriz.
        System.out.println("\nEl valor máximo en la matriz es: " + maximo);
        System.out.println("El valor mínimo en la matriz es: " + minimo);
    }
}
