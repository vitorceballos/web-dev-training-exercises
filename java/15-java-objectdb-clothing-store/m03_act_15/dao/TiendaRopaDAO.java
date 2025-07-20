package m03_act_15.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import m03_act_15.Cliente;
import m03_act_15.DetalleFactura;
import m03_act_15.Factura;
import m03_act_15.Producto;

/**
 *
 * @author Vitor Mendes Ceballos
 */
public class TiendaRopaDAO {
    
    // Creamos el gestor de persistencia para ObjectDB
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tienda.odb");

    // -------------------------------
    // MÉTODO 1: Insertar un cliente
    // -------------------------------
    public void insertarCliente(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Guardamos el cliente en la base de datos
        em.persist(cliente);

        em.getTransaction().commit();
        em.close();

        System.out.println("Cliente insertado correctamente.");
    }

    // -------------------------------
    // MÉTODO 2: Insertar un producto
    // -------------------------------
    public void insertarProducto(Producto producto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Guardamos el producto
        em.persist(producto);

        em.getTransaction().commit();
        em.close();

        System.out.println(" Producto insertado correctamente.");
    }

    // ----------------------------------------------------
    // MÉTODO 3: Insertar una factura con detalles (compra)
    // ----------------------------------------------------
    public void insertarFactura(Factura factura, List<DetalleFactura> detalles) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Primero guardamos la factura
        em.persist(factura);

        // Luego guardamos cada detalle asociado a la factura
        for (DetalleFactura detalle : detalles) {
            em.persist(detalle);
        }

        em.getTransaction().commit();
        em.close();

        System.out.println("Compra realizada correctamente.");
    }

    // -----------------------------------
    // MÉTODO 4: Mostrar todos los clientes
    // -----------------------------------
    public void mostrarClientes() {
        EntityManager em = emf.createEntityManager();

        // Consulta para obtener todos los clientes
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();

        System.out.println("\n Lista de clientes:");
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() +
                               ", Nombre: " + c.getNombre() +
                               ", Dirección: " + c.getDireccion() +
                               ", Teléfono: " + c.getTelefono());
        }

        em.close();
    }

    // -----------------------------------
    // MÉTODO 5: Mostrar todos los productos
    // -----------------------------------
    public void mostrarProductos() {
        EntityManager em = emf.createEntityManager();

        // Consulta para obtener todos los productos
        List<Producto> productos = em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();

        System.out.println("\n Lista de productos:");
        for (Producto p : productos) {
            System.out.println("ID: " + p.getId() +
                               ", Nombre: " + p.getNombre() +
                               ", Precio: " + p.getPrecio() +
                               ", Categoría: " + p.getCategoria());
        }

        em.close();
    }

    // --------------------------------------------------------
    // MÉTODO 6: Mostrar todas las facturas con sus detalles
    // --------------------------------------------------------
    public void mostrarFacturas() {
        EntityManager em = emf.createEntityManager();

        // Consulta para obtener todas las facturas
        List<Factura> facturas = em.createQuery("SELECT f FROM Factura f", Factura.class).getResultList();

        System.out.println("\n Lista de facturas:");
        for (Factura f : facturas) {
            System.out.println("ID: " + f.getId() +
                               ", Fecha: " + f.getFecha() +
                               ", Total: " + f.getTotal());

            // Mostramos los detalles si existen
            if (f.getDetalles() != null) {
                for (DetalleFactura d : f.getDetalles()) {
                    System.out.println("   ↳ Producto: " + d.getProducto().getNombre() +
                                       " | Cantidad: " + d.getCantidad() +
                                       " | Precio: " + d.getPrecio());
                }
            }

            System.out.println("----------------------------------");
        }

        em.close();
    }
}