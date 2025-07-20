/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estadisticas;
import java.util.Arrays; // Importamos Arrays para ordenar los datos
/**
 *
 * @author Vitor Mendes Ceballos
 */
public class EstadisticasUtils {
    
    // Creamos el método estático para calcular el promedio de un array de números
    public static double calcularPromedio(double[] numeros) {
        double suma = 0;
        for (double num : numeros) {
            suma += num; // Sumamos todos los valores del array
        }
        return suma / numeros.length; // Dividimos la suma por la cantidad de números
    }

    // Creamos el método estático para calcular la mediana de un array de números
    public static double calcularMediana(double[] numeros) {
        Arrays.sort(numeros); // Ordenamos el array para calcular la mediana
        int n = numeros.length;
        if (n % 2 == 0) {
            return (numeros[n / 2 - 1] + numeros[n / 2]) / 2; // Promedio de los dos valores centrales
        } else {
            return numeros[n / 2]; // Valor central si el tamaño del array es impar
        }
    }

    // Creamos el método estático para calcular la desviación estándar de un array de números
    public static double calcularDesviacionEstandar(double[] numeros) {
        double media = calcularPromedio(numeros); // Calculamos el promedio
        double sumaDiferencias = 0;
        for (double num : numeros) {
            sumaDiferencias += Math.pow(num - media, 2); // Calculamos la diferencia al cuadrado
        }
        return Math.sqrt(sumaDiferencias / numeros.length); // Calculamos la raíz cuadrada de la varianza
    }
}
