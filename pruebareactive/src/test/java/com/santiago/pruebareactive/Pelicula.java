package com.santiago.pruebareactive;

import java.time.LocalTime;

public class Pelicula {
    private String nombre;
    private String genero;
    private double calificacion;
    private LocalTime duracion;

    public Pelicula(String nombre, String genero, double calificacion, LocalTime duracion) {
        this.nombre = nombre;
        this.genero = genero;
        this.calificacion = calificacion;
        this.duracion = duracion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", calificacion=" + calificacion +
                ", duracion='" + duracion + '\'' +
                '}';
    }
}
