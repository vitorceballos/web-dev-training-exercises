/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_01_gestiontienda;

import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_01_GestionTienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Definimos las cantidades disponibles en la tienda
        int cantidadMelones = 10; 
        int cantidadPeras = 20;   
        int cantidadManzanas = 15; 
        
        // Definimos los precios de los productos
        double precioMelon = 1.55;  
        double precioPera = 0.75;   
        double precioManzana = 0.88; 

        // Creamos el objeto Scanner para recibir datos del usuario
        Scanner sc = new Scanner(System.in);

        // Solicitamos la cantidad de productos que quiere comprar
        System.out.println("¿Cuántos melones quieres comprar?");
        int comprarMelones = sc.nextInt();
        cantidadMelones -= comprarMelones; // Restamos la cantidad de melones disponibles

        System.out.println("¿Cuántas peras quieres comprar?");
        int comprarPeras = sc.nextInt();
        cantidadPeras -= comprarPeras; // Restamos la cantidad de peras disponibles

        System.out.println("¿Cuántas manzanas quieres comprar?");
        int comprarManzanas = sc.nextInt();
        cantidadManzanas -= comprarManzanas; // Restamos la cantidad de manzanas disponibles
        
        // Mostramos la cantidad de ítems que quedan en la tienda
        System.out.println("Quedan " + cantidadMelones + " melones en la tienda.");
        System.out.println("Quedan " + cantidadPeras + " peras en la tienda.");
        System.out.println("Quedan " + cantidadManzanas + " manzanas en la tienda.");
    }
}
