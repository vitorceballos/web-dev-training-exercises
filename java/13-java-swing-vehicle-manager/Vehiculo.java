/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_13_concesionario;

import java.util.ArrayList;

/**
 *
 * @author Vitor Mendes Ceballos 
 */
public class Vehiculo {
    
    // Atributos del vehículo
    private String matricula; // Identificador único del vehículo
    private String marca;
    private String modelo;
    private int cilindrada;
    private ArrayList<String> complementos;
    private double precio;
    private int tipo; // 1 = moto, 2 = coche

    // Creamos el constructor que inicializa todos los atributos
    public Vehiculo(String matricula, String marca, String modelo, int cilindrada, ArrayList<String> complementos, double precio, int tipo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.complementos = complementos;
        this.precio = precio;
        this.tipo = tipo;
    }

    // Métodos getters y setters
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    public ArrayList<String> getComplementos() {
        return complementos;
    }
    public void setComplementos(ArrayList<String> complementos) {
        this.complementos = complementos;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public String getMatricula() {
    return matricula;
    }
    
    @Override
    public boolean equals(Object obj) {
        // Verificamos si es el mismo objeto
        if (this == obj) return true;
        // Verificamos si el objeto es nulo o de distinta clase
        if (obj == null || getClass() != obj.getClass()) return false;
        // Convertimos el objeto a Vehiculo
        Vehiculo otro = (Vehiculo) obj;
        // Comparamos las matrículas (ignorando mayúsculas/minúsculas)
        return this.matricula.equalsIgnoreCase(otro.matricula);
    }

    @Override
    public int hashCode() {
        // Usamos solo la matrícula para calcular el hash
        return matricula.toLowerCase().hashCode();
    }
}
