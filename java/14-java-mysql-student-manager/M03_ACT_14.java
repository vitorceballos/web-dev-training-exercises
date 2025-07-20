/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.m03_act_14;

import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_14 {

    public static void main(String[] args) {
        // Creamos el gestor de la base de datos y el Scanner para leer por consola
        GestionBBDD gestor = new GestionBBDD();
        Scanner sc = new Scanner(System.in);
        String opcion;

        // Conectamos con la base de datos
        gestor.conectar();

        // Mostramos el menú hasta que el usuario decida salir
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("a) Ingresar alumno");
            System.out.println("b) Actualizar alumno");
            System.out.println("c) Borrar alumno");
            System.out.println("d) Listar alumnos");
            System.out.println("e) Salir");

            System.out.print("Opción: ");
            opcion = sc.nextLine().toLowerCase(); // Convertimos en minúscula por si acaso

            switch (opcion) {
                case "a":
                    gestor.ingresarAlumno();
                    break;
                case "b":
                    gestor.actualizarAlumno();
                    break;
                case "c":
                    gestor.borrarAlumno();
                    break;
                case "d":
                    gestor.listarAlumnos();
                    break;
                case "e":
                    System.out.println("Saliendo del programa..");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (!opcion.equals("e"));

        // Cerramos la conexión al final del programa
        gestor.desconectar();
    }
}