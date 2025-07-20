/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_04_ejercicio1;

import java.util.Scanner;


/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_04_Ejercicio1 {

    /**
     * @param args the command line arguments
     */
 
    //Definimos los métodos estáticos para realizar las operaciones matemáticas básicas

    // Método estático para realizar la suma de dos números
    public static double sumar(double num1, double num2) {
        return num1 + num2; // Devuelve la suma de los dos números
    }

    // Método estático para realizar la resta de dos números
    public static double restar(double num1, double num2) {
        return num1 - num2; // Devuelve la resta de los dos números
    }

    // Método estático para realizar la multiplicación de dos números
    public static double multiplicar(double num1, double num2) {
        return num1 * num2; // Devuelve el producto de los dos números
    }

    // Método estático para realizar la división de dos números
    public static double dividir(double num1, double num2) {
        // Comprobamos que el divisor no sea 0 para evitar errores
        if (num2 == 0) {
            System.out.println("Error: No se puede dividir por cero.");
            return 0; // Retorna 0 en caso de división por cero
        } else {
            return num1 / num2; // Devuelve el cociente de la división
        }
    }

    // Método estático para calcular la potencia de un número
    public static double potencia(double num1, double num2) {
        return Math.pow(num1, num2); // Devuelve num1 elevado a la potencia de num2
    }    
    
public static void main(String[] args) {
        // Creamos el objeto Scanner para recibir los datos del usuario
        Scanner scanner = new Scanner(System.in);

        // Mostramos un menú de opciones al usuario
        int opcion;

        do {
            System.out.println("\nSeleccione una operación:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Dividir");
            System.out.println("4. Multiplicar");
            System.out.println("5. Potencia");
            System.out.println("6. Salir");

            // Variable para almacenar la opción seleccionada por el usuario
            opcion = scanner.nextInt();

            // Si el usuario elige una opción entre 1 y 5, pedimos los números
            if (opcion >= 1 && opcion <= 5) {
                System.out.print("Introduce el primer número: ");
                double num1 = scanner.nextDouble();
                System.out.print("Introduce el segundo número: ");
                double num2 = scanner.nextDouble();

                // Dependiendo de la opción seleccionada, realizamos la operación correspondiente
                switch (opcion) {
                    case 1:
                        System.out.println("Resultado de la suma: " + sumar(num1, num2));
                        break;
                    case 2:
                        System.out.println("Resultado de la resta: " + restar(num1, num2));
                        break;
                    case 3:
                        System.out.println("Resultado de la división: " + dividir(num1, num2));
                        break;
                    case 4:
                        System.out.println("Resultado de la multiplicación: " + multiplicar(num1, num2));
                        break;
                    case 5:
                        System.out.println("Resultado de la potencia: " + potencia(num1, num2));
                        break;
                }
            } else if (opcion != 6) {
                // Si el usuario introduce una opción no válida, mostramos un mensaje de error
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        // El bucle se repite hasta que el usuario elija la opción "Salir"
        } while (opcion != 6); 

        // Cerramos el scanner al final para evitar fugas de memoria
        scanner.close();
        System.out.println("¡Hasta luego!");
    }
}