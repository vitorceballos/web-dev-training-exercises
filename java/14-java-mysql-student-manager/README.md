# 14-java-mysql-student-manager

This folder contains a Java + MySQL CRUD application developed as part of the "Programming" module (M03) during my Higher Technical Education in Web Application Development (EQF Level 5).

## Description

This activity implements a command-line program to manage student data in a MySQL database. The user can add, update, delete and list students using a menu interface. The system uses JDBC for database connectivity and organizes the logic across multiple classes for modularity.

## Features

- Connection to MySQL database using JDBC
- CRUD operations on `alumnos` table:
  - Add student (`ingresarAlumno`)
  - Update student (`actualizarAlumno`)
  - Delete student (`borrarAlumno`)
  - List students (`listarAlumnos`)
- Auto-incremented ID for each student
- Menu-driven interface from the `main()` method

## Files

- `Alumno.java`: Class representing a student entity.
- `GestionBBDD.java`: Handles database connection and SQL operations.
- `M03_ACT_14.java`: Main program with the user menu and interaction logic.
- `script SQL - Actividades Tema 14.sql`: SQL script to create and initialize the `bd_alumnos` database and `alumnos` table.

## Technologies Used

- Java
- MySQL
- JDBC

---

This activity allowed me to practice connecting Java applications to a relational database and performing structured data management using SQL and object-oriented programming.
