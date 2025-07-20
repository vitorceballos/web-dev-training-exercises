# 12-java-object-serialization

This folder contains a Java activity developed as part of the "Programming" module (M03) during my Higher Technical Education in Web Application Development (EQF Level 5).

## Description

This activity demonstrates how to serialize and deserialize Java objects using the `Serializable` interface. The program creates an instance of the class `Libro`, saves it to a binary file using `ObjectOutputStream`, and then reads it back using `ObjectInputStream`. Certain attributes are marked as `transient` to exclude them from the serialization process.

## Features

- Implementation of the `Serializable` interface
- Writing Java objects to binary files (`libros.dat`)
- Reading and reconstructing objects from files
- Use of `transient` to exclude attributes from serialization
- Exception handling for file I/O operations

## Files

- `Libro.java`: Class representing a book, with fields for title, author, year, and price. Implements `Serializable` and uses `transient` for non-persistent attributes.
- `M03_ACT_12.java`: Main class responsible for serializing and deserializing a `Libro` object.

## Technologies Used

- Java

---

This activity helped me understand object persistence in Java using serialization, and how to control what data gets stored and retrieved.
