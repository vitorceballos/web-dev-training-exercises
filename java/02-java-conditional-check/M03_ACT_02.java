/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Ejercicio01
        
        // Declaramos las dos variables de tipo double
        double valor1, valor2;
        
        // Creamos un objeto Scanner para recibir datos del usuario
        Scanner sc = new Scanner(System.in);

        // Solicitamos al usuario que ingrese los dos valores positivos
        do {
            System.out.print("Introduce el primer valor positivo: ");
            valor1 = sc.nextDouble(); // Leemos el primer valor

            if (valor1 <= 0) {
                System.out.println("El valor debe ser positivo. Inténtalo de nuevo.");
            }
        } while (valor1 <= 0); // El bucle continúa hasta que se ingrese un valor positivo

        do {
            System.out.print("Introduce el segundo valor positivo: ");
            valor2 = sc.nextDouble(); // Leemos el segundo valor

            if (valor2 <= 0) {
                System.out.println("El valor debe ser positivo. Inténtalo de nuevo.");
            }
        } while (valor2 <= 0); // El bucle continúa hasta que se ingrese un valor positivo
        
        // Menú para seleccionar la operación
        int opcion;
        do {
            System.out.println("\nElige una operación:");
            System.out.println("1 - Sumar los valores");
            System.out.println("2 - Restar los valores");
            System.out.println("3 - Multiplicar los valores");
            System.out.println("4 - Dividir los valores");
            System.out.println("0 - Salir");
            
         
            //Ejercicio 2.2
            //Manejo de la entrada con try-catch
            try {
            opcion = sc.nextInt(); // Leemos la opción del usuario
            } catch (InputMismatchException e) {
            System.out.println("Error: Debes introducir un número entero. Inténtalo de nuevo.");
            sc.next(); // Limpiamos el buffer del scanner
            opcion = -1; // Establecemos una opción inválida para evitar que el switch se ejecute
            }
            
            switch (opcion) {
                case 1:
                    // Sumar los valores
                    System.out.println("La suma de los valores es: " + (valor1 + valor2));
                    break;
                case 2:
                    // Restar los valores
                    System.out.println("La resta de los valores es: " + (valor1 - valor2));
                    break;
                case 3:
                    // Multiplicar los valores
                    System.out.println("La multiplicación de los valores es: " + (valor1 * valor2));
                    break;
                case 4:
                    // Dividir los valores
                    if (valor2 != 0) {
                        System.out.println("La división de los valores es: " + (valor1 / valor2));
                    } else {
                        System.out.println("No se puede dividir entre cero.");
                    }
                    break;
                case 0:
                    // Salir del programa
                    System.out.println("Gracias por usar el programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 0 y 4.");
            }
        } while (opcion != 0); // El bucle continuará hasta que el usuario elija la opción 0
        
        
        // Ejercicio2. Control de errores.
        
        //2.1
        
        //El programa se detiene cuando el usuario introduce una letra en el menú 
        //porque el Scanner está esperando un número entero (nextInt()), 
        //pero se recibe un tipo incompatible. Esto genera una excepción de tipo InputMismatchException.
        //La InputMismatchException es una excepción en Java que ocurre cuando un programa intenta leer 
        //un tipo de dato que no coincide con el tipo esperado por el método del Scanner.
      
    }
}
