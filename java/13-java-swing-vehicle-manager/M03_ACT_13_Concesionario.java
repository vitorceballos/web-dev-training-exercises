/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_13_concesionario;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_13_Concesionario {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // Ejecutamos la interfaz en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            new GestionVehiculos().setVisible(true);
        });
    }
}
