package Objetos.Alumnos;

import IntroducirDatos.IntroducirDatos;
import Objetos.Automoviles.MiObjectOutputStream;

import java.io.*;

public class Escritura04 {
    public static void main(String[] args) {
        File f = new File("Alumnos2.dat");

        //comprueba si el fichero existe o no
        if (!f.exists()) {//no existe
            escribirNuevoFichero(f);
        } else {
            System.out.println("Fichero existe");
            escribirExisteFichero(f);
        }
    }

    public static void escribirExisteFichero(File f) {

        FileOutputStream fos = null;
        MiObjectOutputStream moos = null;

        try {
            //cuando quiero añadir datos tengo que añadir el true
            fos = new FileOutputStream(f, true);
            moos = new MiObjectOutputStream(fos);

            for (int i = 0; i < 2; i++) {
                Alumno al = new Alumno(IntroducirDatos.introducirDatos("DNI:"),
                        IntroducirDatos.introducirDatos("Nombre: "),
                        Integer.parseInt(IntroducirDatos.introducirDatos("Nota: ")));
                moos.writeObject(al);

            }
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Fin del programa");
    }

    public static void escribirNuevoFichero(File f) {

        FileOutputStream fos = null;
        //como el fichero no existe tenemos que poner la siguiente clase
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);

            for (int i = 0; i < 3; i++) {
                Alumno alum = new Alumno(IntroducirDatos.introducirDatos("DNI:"),
                        IntroducirDatos.introducirDatos("Nombre: "),
                        Integer.parseInt(IntroducirDatos.introducirDatos("Nota: ")));
                oos.writeObject(alum);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
