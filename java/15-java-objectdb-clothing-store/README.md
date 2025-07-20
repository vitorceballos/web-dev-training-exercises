# 15-java-objectdb-clothing-store

This folder contains a Java application using ObjectDB for object persistence, developed as part of the "Programming" module (M03) during my Higher Technical Education in Web Application Development (EQF Level 5).

## Description

This activity implements a clothing store management system where customers, products, invoices, and purchase details are modeled as Java objects and stored in a database using ObjectDB. It applies object-oriented principles, entity relationships, and persistence annotations to handle the full workflow from inserting data to displaying complete invoices.

## Features

- Entity classes with annotations for persistence:
  - `Cliente`: personal data of clients
  - `Producto`: information about clothing products
  - `Factura`: purchase records
  - `DetalleFactura`: intermediate class for invoice-product relationship
- ObjectDB configuration with `persistence.xml`
- Data operations using JPA and `EntityManager`
- Console menu with options to:
  - Add clients
  - Add products
  - Register purchases (with invoice and product details)
  - Show all clients
  - Show all products
  - Show all invoices (with line items)
  - Exit

## Files

- `Cliente.java`: Defines a customer entity with personal information.
- `Producto.java`: Represents a clothing product.
- `Factura.java`: Contains purchase date and total amount, linked to clients.
- `DetalleFactura.java`: Holds quantity and price of each product in an invoice.
- `TiendaRopaDAO.java`: Data access object handling all ObjectDB interactions.
- `M03_ACT_15.java`: Main application with the menu interface.
- `persistence.xml`: Persistence configuration file for ObjectDB setup.

## Technologies Used

- Java
- JPA (Java Persistence API)
- ObjectDB
- EntityManager

---

This final activity helped me apply advanced concepts in Java persistence, object modeling, and multi-entity relationships in a realistic business scenario.