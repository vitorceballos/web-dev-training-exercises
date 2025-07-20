/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03_act_14;

/**
 *
 * @author Vitor Mendes Ceballos 
 */

// Creamos la clase Alumno para representar a cada alumno de la base de datos
public class Alumno {

    // Atributos privados del alumno
    private int id;
    private String nombre;
    private int edad;
    private String curso;
    private double media;

    // Constructor con todos los atributos. Lo usamos para crear alumnos con datos completos.
    public Alumno(int id, String nombre, int edad, String curso, double media) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
        this.media = media;
    }

    // Getters y setters para acceder y modificar cada atributo de forma controlada

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    // Método toString para mostrar los datos del alumno de forma legible
    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", curso='" + curso + '\'' +
                ", media=" + media +
                '}';
    }
}