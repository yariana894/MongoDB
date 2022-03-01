package Objetos.Alumnos;

import Objetos.Alumnos.Alumno;

import java.io.*;

public class Escritura01 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("Alumnos.dat");
            oos = new ObjectOutputStream(fos);

            //primera forma
            Alumno alum1 = new Alumno("1234", "Maria", 8);
            oos.writeObject(alum1);
            //segunda forma
            oos.writeObject(new Alumno("345", "Jorge", 7));

            //tercera forma
            Alumno alum2 = new Alumno();
            alum2.setDni("234");
            alum2.setNombre("Yari");
            alum2.setNota(8);

            oos.writeObject(alum2);

            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Fin de programa");
    }
}
