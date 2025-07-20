/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_04_ejercicio2;

import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_04_Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    
    //Creamos la función para comprobar si un número es primo
    //Un número es primo si solo es divisible entre 1 y él mismo
    public static boolean esPrimo(int n) {
        if (n <= 1) {
            return false; // Si el número es menor o igual a 1, no es primo
        }
        // Comprobamos si el número es divisible entre algún número desde 2 hasta la raíz cuadrada de n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // Si encontramos un divisor, el número no es primo
            }
        }
        return true; // Si no encontramos divisores, entonces el número es primo
    }    
    
    //Creamos la función para calcular la raíz cuadrada de un número
    public static double calcularRaizCuadrada(int n) {
        return Math.sqrt(n); // Usamos Math.sqrt para calcular la raíz cuadrada de n
    }

    //Creamos la función que imprime los números primos dentro de un rango dado.
    public static void imprimirPrimosEnRango(int inicio, int fin) {
        System.out.println("Los números primos en el rango de " + inicio + " a " + fin + " son:");
        // Recorremos todos los números entre inicio y fin
        for (int i = inicio; i <= fin; i++) {
            // Llamamos a la función esPrimo para verificar si el número i es primo
            if (esPrimo(i)) {
                System.out.print(i + " "); // Si es primo, lo imprimimos
            }
        }
        System.out.println(); // Hacemos un salto de línea después de mostrar todos los números primos
    }

    public static void main(String[] args) {
        // Creamos el objeto Scanner para pedir al usuario los números de inicio y fin
        Scanner scanner = new Scanner(System.in);

        // Pedimos al usuario que ingrese los valores de inicio y fin
        System.out.print("Ingresa el valor de inicio: ");
        int inicio = scanner.nextInt();
        System.out.print("Ingresa el valor de fin: ");
        int fin = scanner.nextInt();

        // Llamamos a la función que va a imprimir los números primos en el rango
        imprimirPrimosEnRango(inicio, fin);

        // Cerramos el scanner al final para evitar fugas de memoria
        scanner.close();
    }
}