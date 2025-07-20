/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        
        //Ejercicio 2.1
        
        // Tipo de dato entero (int)
        int variableEntera = 10;
        System.out.println("Variable tipo int muestra datos enteros de 32 bits. Ejemplo: " + variableEntera);

        // Tipo de dato pequeño (byte)
        byte variableByte = 100;
        System.out.println("Variable tipo byte muestra datos enteros de 8 bits. Ejemplo: " + variableByte);

        // Tipo de dato entero (short)
        short variableShort = 20000;
        System.out.println("Variable tipo short muestra datos enteros de 16 bits. Ejemplo: " + variableShort);

        // Tipo de dato entero grande (long)
        long variableLong = 1234567890L;
        System.out.println("Variable tipo long muestra datos enteros de 64 bits. Ejemplo: " + variableLong);

        // Tipo de dato con decimales (float)
        float variableFloat = 3.14f;
        System.out.println("Variable tipo float muestra datos con decimales de 32 bits. Ejemplo: " + variableFloat);

        // Tipo de dato con decimales (double)
        double variableDouble = 3.14159265358979;
        System.out.println("Variable tipo double muestra datos con decimales de 64 bits. Ejemplo: " + variableDouble);

        // Tipo de dato carácter (char)
        char variableChar = 'A';
        System.out.println("Variable tipo char muestra un solo carácter de 16 bits. Ejemplo: " + variableChar);

        // Tipo de dato lógico (boolean)
        boolean variableBoolean = true;
        System.out.println("Variable tipo boolean muestra valores lógicos. Ejemplo: " + variableBoolean);
        
        //Ejercicio 2.2
        
        // Operadores Lógicos
        System.out.println("--Operadores lógicos--");
        System.out.println("El resultado de true && false es: " + (true && false)); // AND lógico
        System.out.println("El resultado de true || false es: " + (true || false)); // OR lógico
        System.out.println("El resultado de !true es: " + (!true)); // NOT lógico

        // Operadores Relacionales
        System.out.println("--Operadores relacionales--");
        System.out.println("El resultado de 5 == 5 es: " + (5 == 5));  // Igual a
        System.out.println("El resultado de 5 != 3 es: " + (5 != 3));  // Diferente de
        System.out.println("El resultado de 7 > 3 es: " + (7 > 3));    // Mayor que
        System.out.println("El resultado de 4 < 6 es: " + (4 < 6));    // Menor que
        System.out.println("El resultado de 5 >= 5 es: " + (5 >= 5));  // Mayor o igual que
        System.out.println("El resultado de 3 <= 4 es: " + (3 <= 4));  // Menor o igual que
    }
}
