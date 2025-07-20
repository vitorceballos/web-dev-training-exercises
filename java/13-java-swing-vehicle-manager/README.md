# 13-java-swing-vehicle-manager

This folder contains a Java graphical user interface (GUI) application developed as part of the "Programming" module (M03) during my Higher Technical Education in Web Application Development (EQF Level 5).

## Description

This activity consists of building a vehicle management system using Swing. The interface allows the user to add, view, and remove vehicles (cars and motorbikes) from a catalog stored in a `HashMap`. The identification of each vehicle is done using a unique license plate. The application uses modal dialogs to interact with the user and implements logic for handling vehicles based on their type.

## Features

- Java Swing interface (`JFrame`, `JOptionPane`)
- Object-oriented class `Vehiculo` with attributes and methods
- Vehicle identification by license plate
- `HashMap<String, Vehiculo>` as a data store
- GUI buttons:
  - Add vehicle
  - Remove vehicle
  - Show cars
  - Show motorbikes
  - Exit application
- Overriding of `equals()` and `hashCode()` based on the license plate

## Files

- `GestionVehiculos.java`: Main Swing interface with vehicle management logic.
- `GestionVehiculos.form`: Form layout file used with NetBeans.
- `M03_ACT_13_Concesionario.java`: Entry point to launch the GUI.
- `Vehiculo.java`: Class that defines vehicle attributes and behavior.

## Technologies Used

- Java
- Java Swing (GUI)
- HashMap
- NetBeans GUI Builder

---

This activity helped me gain experience in building user interfaces with Swing and managing structured data using Java collections and object-oriented programming.
