/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_15;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Vitor Mendes Ceballos
 */

@Entity // Indicamos que esta clase será una tabla en la base de datos
public class Cliente {

    @Id // Este campo será la clave primaria
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    
    @OneToMany // Un cliente puede tener muchas facturas
    private List<Factura> facturas;


    // Constructor con todos los atributos
    public Cliente(int id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    Cliente() {
    }
    
    // Getters y setters (incluimos también la lista de facturas)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public List<Factura> getFacturas() { return facturas; }
    public void setFacturas(List<Factura> facturas) { this.facturas = facturas; }
}

