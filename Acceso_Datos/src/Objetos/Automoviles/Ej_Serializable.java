package Objetos.Automoviles;

import IntroducirDatos.IntroducirDatos;

import java.io.*;

/*Añadir datos al fichero (no se sobrescriben) cada vez que ejecutamos la
aplicación.*/

public class Ej_Serializable {
    public static void main(String[] args) {
        File f = new File("Coche.dat");

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
            fos = new FileOutputStream(f, true);
            moos = new MiObjectOutputStream(fos);

            for (int i = 0; i < 2; i++) {
                Coches coche = new Coches(IntroducirDatos.introducirDatos("Matricula: "),
                        IntroducirDatos.introducirDatos("Marca: "),
                        IntroducirDatos.introducirDatos("Modelo: "),
                        Integer.parseInt(IntroducirDatos.introducirDatos("Tamaño del depósito: ")),
                        Integer.parseInt(IntroducirDatos.introducirDatos("Precio: ")));

                moos.writeObject(coche);

            }
            fos.close();

            System.out.println("Información agregada!");

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
                Coches coche = new Coches(IntroducirDatos.introducirDatos("Matricula: "),
                        IntroducirDatos.introducirDatos("Marca: "),
                        IntroducirDatos.introducirDatos("Modelo: "),
                        Integer.parseInt(IntroducirDatos.introducirDatos("Tamaño del depósito: ")),
                        Integer.parseInt(IntroducirDatos.introducirDatos("Precio: ")));
                oos.writeObject(coche);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

