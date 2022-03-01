package Objetos.Alumnos;

import Objetos.Alumnos.Alumno;

import java.io.*;

public class Lectura01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("Alumnos2.dat");
            ois = new ObjectInputStream(fis);

            //como se repite la cabecera dá un error
            //escribimos el método escribir la cabecera
            while (true) {
                Alumno alumno1;
                alumno1 = (Alumno) ois.readObject();
                System.out.println(alumno1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Fin de la lectura");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
