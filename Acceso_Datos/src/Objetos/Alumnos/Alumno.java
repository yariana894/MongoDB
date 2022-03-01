package Objetos.Alumnos;

import java.io.Serializable;

public class Alumno implements Serializable {
    String dni;
    String nombre;
    int nota;

    public Alumno() {
        super();
    }

    public Alumno(String dni, String nombre, int nota) {
        this.dni = dni;
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }
}
