/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m03_act_15;

import m03_act_15.dao.TiendaRopaDAO;
import java.util.*;
import java.util.Date;


/**
 *
 * @author Vitor Mendes Ceballos
 */
public class M03_ACT_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TiendaRopaDAO dao = new TiendaRopaDAO();
        String opcion;

        do {
            System.out.println("\n----- MENÚ -----");
            System.out.println("a) Ingresar cliente");
            System.out.println("b) Ingresar producto");
            System.out.println("c) Realizar compra");
            System.out.println("d) Mostrar clientes");
            System.out.println("e) Mostrar productos");
            System.out.println("f) Mostrar facturas");
            System.out.println("g) Salir");

            System.out.print("Ingrese una opción: ");
            opcion = sc.nextLine().toLowerCase();

            switch (opcion) {
                case "a":
                    System.out.println("Ingresar cliente");
                    System.out.print("ID: ");
                    int idCliente = Integer.parseInt(sc.nextLine());
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    Cliente cliente = new Cliente(idCliente, nombre, direccion, telefono);
                    dao.insertarCliente(cliente);
                    break;

                case "b":
                    System.out.println("Ingresar producto");
                    System.out.print("ID: ");
                    int idProducto = Integer.parseInt(sc.nextLine());
                    System.out.print("Nombre: ");
                    String nombreP = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(sc.nextLine());
                    System.out.print("Categoría: ");
                    String categoria = sc.nextLine();

                    Producto producto = new Producto(idProducto, nombreP, precio, categoria);
                    dao.insertarProducto(producto);
                    break;

                case "c":
                    System.out.println("Realizar compra");

                    System.out.print("ID de cliente: ");
                    int idC = Integer.parseInt(sc.nextLine());
                    System.out.print("ID de producto: ");
                    int idP = Integer.parseInt(sc.nextLine());
                    System.out.print("Cantidad: ");
                    int cantidad = Integer.parseInt(sc.nextLine());

                    // Creamos entidades para simular la compra
                    Cliente c = new Cliente(); c.setId(idC); // solo asignamos ID
                    Producto p = new Producto(); p.setId(idP); // solo ID

                    // Creamos la factura
                    int idFactura = new Random().nextInt(10000); // generar ID aleatorio
                    double subtotal = cantidad * p.getPrecio(); // solo referencia
                    Factura factura = new Factura(idFactura, new Date(), subtotal);

                    // Creamos el detalle de la compra
                    DetalleFactura detalle = new DetalleFactura(0, cantidad, subtotal, p, factura);
                    factura.setDetalles(Arrays.asList(detalle));

                    dao.insertarFactura(factura, Arrays.asList(detalle));
                    break;

                case "d":
                    dao.mostrarClientes();
                    break;

                case "e":
                    dao.mostrarProductos();
                    break;

                case "f":
                    dao.mostrarFacturas();
                    break;

                case "g":
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

            System.out.println("------------------------------");

        } while (!opcion.equals("g"));
    }
}




