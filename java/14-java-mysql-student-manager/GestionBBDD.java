/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03_act_14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Vitor Mendes Ceballos
 */

// Clase que se encarga de gestionar la conexión con la base de datos MySQL
public class GestionBBDD {

    // Creamos un atributo de tipo Connection para usar en toda la clase
    private Connection conexion;

    // Método para conectarse a la base de datos
    public void conectar() {
        try {
            // Configuramos la URL, usuario y contraseña para conectarnos
            String url = "jdbc:mysql://localhost:3306/bd_alumnos"; 
            String usuario = "root";
            String contrasena = "root"; 

            // Establecemos la conexión
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión establecida correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    // Método para cerrar la conexión
    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // Getter para obtener la conexión desde fuera
    public Connection getConexion() {
        return conexion;
    }

    // Método para crear la tabla 'alumnos' si no existe
    public void crearTablaAlumnos() {
        // Creamos una sentencia SQL para crear la tabla si no existe
        String sql = """
            CREATE TABLE IF NOT EXISTS alumnos (
                id INT PRIMARY KEY AUTO_INCREMENT,
                nombre VARCHAR(50),
                edad INT,
                curso VARCHAR(50),
                media DOUBLE
            )
        """;

        try {
            // Usamos Statement porque no pasamos parámetros
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            System.out.println("Tabla 'alumnos' creada correctamente (o ya existía).");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla 'alumnos': " + e.getMessage());
        }
    }
    
    // Método para ingresar un nuevo alumno en la base de datos
    public void ingresarAlumno() {
        // Creamos el Scanner para leer datos del usuario
        Scanner sc = new Scanner(System.in);

        // Pedimos los datos
        System.out.println("Introduce el nombre del alumno:");
        String nombre = sc.nextLine();

        System.out.println("Introduce la edad:");
        int edad = sc.nextInt();
        sc.nextLine(); // Limpiar el salto de línea

        System.out.println("Introduce el curso:");
        String curso = sc.nextLine();

        System.out.println("Introduce la media:");
        double media = sc.nextDouble();

        // Creamos el objeto Alumno (el id lo ignora porque es autoincremental)
        Alumno nuevoAlumno = new Alumno(0, nombre, edad, curso, media);

        // Preparamos la sentencia SQL
        String sql = "INSERT INTO alumnos (nombre, edad, curso, media) VALUES (?, ?, ?, ?)";

        try {
            // Usamos PreparedStatement para evitar errores y ataques de SQL
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nuevoAlumno.getNombre());
            ps.setInt(2, nuevoAlumno.getEdad());
            ps.setString(3, nuevoAlumno.getCurso());
            ps.setDouble(4, nuevoAlumno.getMedia());

            // Ejecutamos la inserción
            ps.executeUpdate();

            System.out.println("Alumno insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el alumno: " + e.getMessage());
        }
    }  
    
    // Método para actualizar los datos de un alumno existente
    public void actualizarAlumno() {
        Scanner sc = new Scanner(System.in);

        // Pedimos el ID del alumno que queremos actualizar
        System.out.println("Introduce el ID del alumno a actualizar:");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiamos salto de línea

        // Pedimos los nuevos datos
        System.out.println("Introduce el nuevo nombre:");
        String nombre = sc.nextLine();

        System.out.println("Introduce la nueva edad:");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduce el nuevo curso:");
        String curso = sc.nextLine();

        System.out.println("Introduce la nueva media:");
        double media = sc.nextDouble();

        // Creamos la consulta SQL para actualizar
        String sql = """
            UPDATE alumnos
            SET nombre = ?, edad = ?, curso = ?, media = ?
            WHERE id = ?
        """;

        try {
            // Preparamos la sentencia con los nuevos valores
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setString(3, curso);
            ps.setDouble(4, media);
            ps.setInt(5, id); // usamos el ID para identificar qué fila actualizar

            int filasAfectadas = ps.executeUpdate();

            // Comprobamos si realmente se actualizó algo
            if (filasAfectadas > 0) {
                System.out.println("Alumno actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún alumno con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el alumno: " + e.getMessage());
        }
      }
    
    // Método para borrar un alumno a partir de su ID
    public void borrarAlumno() {
        Scanner sc = new Scanner(System.in);

        // Pedimos el ID del alumno que se quiere eliminar
        System.out.println("Introduce el ID del alumno a borrar:");
        int id = sc.nextInt();

        // Preparamos la consulta SQL para eliminar
        String sql = "DELETE FROM alumnos WHERE id = ?";

        try {
            // Usamos PreparedStatement para asignar el ID de forma segura
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();

            // Comprobamos si se eliminó el alumno
            if (filasAfectadas > 0) {
                System.out.println("Alumno borrado correctamente.");
            } else {
                System.out.println("No se encontró ningún alumno con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error al borrar el alumno: " + e.getMessage());
        }
    }
    
    // Método para listar todos los alumnos registrados en la base de datos
    public void listarAlumnos() {
        // Creamos la consulta para obtener todos los registros de la tabla alumnos
        String sql = "SELECT * FROM alumnos";

        try {
            // Usamos Statement porque no hay parámetros
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Lista de alumnos:");

            // Recorremos cada fila del resultado
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String curso = rs.getString("curso");
                double media = rs.getDouble("media");

                // Mostramos los datos de cada alumno por consola
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Edad: " + edad);
                System.out.println("Curso: " + curso);
                System.out.println("Media: " + media);
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error al listar alumnos: " + e.getMessage());
        }
    }
}
