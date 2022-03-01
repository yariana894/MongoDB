package z_REPASO;

import IntroducirDatos.IntroducirDatos;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.Scanner;

public class h_MayusMinus {

    static String nombreFichero;
    static String texto;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int opcion = 0;

        do {
            try {
                System.out.println("1.- Crear un archivo");
                System.out.println("2.- Contenido del fichero");
                System.out.println("3.- Crea fichero y varía mayúsculas y minúsculas");

                opcion = Integer.parseInt(IntroducirDatos.introducirDatos("Introduce una opción: "));

                switch (opcion) {
                    case 1:

                        System.out.println("Introduce el nombre del fichero: ");
                        nombreFichero = sc.nextLine();
                        File f = new File(nombreFichero);
                        creaFichero();
                        break;
                    case 2:
                        muestraContenido();
                        break;
                    case 3:
                        creaYMuestraMayusYMinus();
                        break;
                }
            } catch (NumberFormatException e) {

                System.out.println("Error al introducir la opción");
            }
        } while (opcion != 4);

    }

    private static void muestraContenido() {
        FileReader fr = null;

        try {
            fr = new FileReader(nombreFichero);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void creaYMuestraMayusYMinus() {
    }

    private static void creaFichero() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream(nombreFichero+".txt");
            dos = new DataOutputStream(fos);

            String nombre = IntroducirDatos.introducirDatos("Introduce el nombre: ");
            dos.writeUTF(nombre);
            String apellidos = IntroducirDatos.introducirDatos("Introduce los apellidos: ");
            dos.writeUTF(apellidos);
            String ciudad = IntroducirDatos.introducirDatos("Introduce ciudad nacimiento: ");
            dos.writeUTF(ciudad);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
