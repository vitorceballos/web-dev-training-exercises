package m03_act_15;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.persistence.*;

/**
 *
 * @author Vitor Mendes Ceballos
 */

// Esta clase representa los detalles de una compra concreta
@Entity
public class DetalleFactura {

    @Id // Clave primaria del detalle
    private int id;

    // Cantidad de unidades del producto
    private int cantidad;

    // Precio aplicado al producto en esta factura
    private double precio;

    // Relación N a 1: muchos detalles pueden referirse a un mismo producto
    @ManyToOne
    private Producto producto;

    // Relación N a 1: muchos detalles pueden pertenecer a una misma factura
    @ManyToOne
    private Factura factura;

    // Constructor para crear objetos DetalleFactura
    public DetalleFactura(int id, int cantidad, double precio, Producto producto, Factura factura) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
        this.factura = factura;
    }

    // Getters y setters de todos los campos
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public Factura getFactura() { return factura; }
    public void setFactura(Factura factura) { this.factura = factura; }
}