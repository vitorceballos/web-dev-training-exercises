# 06-soap-music-service

This activity simulates a SOAP-based web service for managing musical groups and genres using PHP and a MySQL database.

It was developed as part of the "Web Development in Server Environment" module during my Higher Technical Education in Web Application Development (EQF Level 5).

## Description

This activity demonstrates the creation and use of a SOAP service in PHP to expose and consume methods related to musical data. It includes:

- SOAP server to provide musical genre and group information
- SOAP client that consumes and displays server data
- SQL script to create and populate the database with sample genres and groups
- Structured folder with the NuSOAP library included
- Basic user interface with a table displaying the retrieved data

## Features

- SOAP web service using the NuSOAP PHP library
- Secure communication between client and server endpoints
- Database with foreign key relationships for genres and groups
- Clean tabular display of music group data
- Admin user creation with full privileges in MySQL

## Files

- `cliente.php`: SOAP client to connect and fetch data from the server
- `servidor.php`: SOAP server with defined service methods
- `script.sql`: SQL script to create and populate the 'musica' database
- `styles.css`: Visual styling for the web interface
- `/lib/`: Folder containing the NuSOAP library used for SOAP functionality

## Technologies Used

- HTML
- CSS
- PHP (with NuSOAP library)
- MySQL
- SOAP Protocol

---

This activity helped me understand how to implement and consume SOAP services in PHP using external libraries like NuSOAP, and how to structure a web service that interacts with a relational database.