package Objetos.Alumnos;

import IntroducirDatos.IntroducirDatos;
import Objetos.Alumnos.Alumno;

import java.io.*;

public class Escritura02 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("Alumnos.dat", true);
            oos = new ObjectOutputStream(fos);


            for (int i = 0; i < 3; i++) {
                //Los objetosd los tenemos que instanciar SIEMPRE dentro del bucle
                Alumno al = new Alumno();
                al.setDni(IntroducirDatos.introducirDatos("DNI: "));
                al.setNombre(IntroducirDatos.introducirDatos("Nombre: "));
                al.setNota(Integer.parseInt(IntroducirDatos.introducirDatos("Nota: ")));
                oos.writeObject(al);

            }
            oos.close();

        } catch (
                FileNotFoundException e) {
            System.out.println("Fin del programa");

        } catch (
                IOException e) {
            System.out.println("Fin de la lectura");

        }
    }
}

