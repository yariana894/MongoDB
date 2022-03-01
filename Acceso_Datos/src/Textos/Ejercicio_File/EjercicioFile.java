package Textos.Ejercicio_File;/*===================EJERCICIO FILE=================*/

/*Enunciados Clase File

1o) Realizar un programa Java que pida el nombre de un directorio.
El programa deberá listar sus ficheros y después eliminar el directorio
y los ficheros contenidos en él.*/

import java.io.File;
import java.util.Scanner;

public class EjercicioFile {

    static Scanner ns = new Scanner(System.in);
    public static String ruta;

    public static void main(String[] args) {
        System.out.print("Introduce la ruta de un directorio: ");
        ruta = ns.nextLine();
        listarArchivos();
        borrarArchivos();
    }

    public static void listarArchivos() {
        File f = new File(ruta);
        String[] archivos = f.list();
        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i]);
        }
    }

    public static void borrarArchivos() {
        File folder = new File(ruta);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    borrarArchivos();
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}
