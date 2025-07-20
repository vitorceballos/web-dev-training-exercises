# 11-java-bookstore-exceptions

This folder contains a Java console application developed as part of the "Programming" module (M03) during my Higher Technical Education in Web Application Development (EQF Level 5).

## Description

This activity simulates the management of a bookstore using object-oriented programming and custom exceptions. The program includes a menu that allows the user to add books, sell them, and search for them in the inventory. It handles exceptional cases, such as a book not being found or stock being unavailable, using custom exception classes.

## Features

- Menu-based console interface for bookstore management
- Inventory stored using a `HashMap` (title → `Libro`)
- Add, sell, and search functionality
- Custom exceptions:
  - `ExcepcionLibroNoEncontrado`
  - `ExcepcionStockAgotado`
- Exception handling with descriptive messages

## Files

- `M03_ACT_11_Tienda_Libros.java`: Main class with menu and logic to interact with the bookstore.
- `Libro.java`: Class that defines book attributes and methods.
- `ExcepcionLibroNoEncontrado.java`: Exception thrown when a book is not found.
- `ExcepcionStockAgotado.java`: Exception thrown when a book is out of stock.

## Technologies Used

- Java

---

This activity helped me reinforce the use of custom exceptions, `HashMap`, and error management in real-world scenarios using Java.
