/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_11_tienda_libros;

/**
 *
 * @author Usuario
 */
public class ExcepcionStockAgotado extends Exception {
    
    // Constructor que recibe el mensaje de la excepción
        public ExcepcionStockAgotado(String mensaje) {
            super(mensaje); // Llamamos al constructor de la clase Exception con el mensaje
        }
    }