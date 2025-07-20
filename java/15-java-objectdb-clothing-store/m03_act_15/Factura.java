/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m03_act_15;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vitor Mendes Ceballos
 */

// Esta clase representa una factura generada por una compra
@Entity
public class Factura {

    @Id // Clave primaria de la factura
    private int id;

    // Fecha en que se emitió la factura
    private Date fecha;

    // Total de la factura
    private double total;

    // Relación 1 a N: una factura puede tener varios detalles
    @OneToMany
    private List<DetalleFactura> detalles;

    // Constructor para inicializar una factura
    public Factura(int id, Date fecha, double total) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
    }

    // Getters y setters de todos los atributos
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public List<DetalleFactura> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleFactura> detalles) { this.detalles = detalles; }
}
