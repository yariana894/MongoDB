package zExamen_C_YarianaLopez;

import java.io.*;


public class Examen03 {

    static File f1 = new File("archivo1.txt");
    static File f2 = new File("archivo2.txt");


    public static void main(String[] args) {

        int opcion = 0;
        do {
            System.out.println("1.- Crear los  Ficheros.");
            System.out.println("2.- CompararFicheros.");
            System.out.println("3.- Salir.");

            try {
                opcion = Integer.parseInt(introducirDatos("Elegir opcion: "));
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            switch (opcion) {
                case 1:
                    crearFichero();
                    break;
                case 2:
                    compararFichero();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error en la opcion");
            }
        } while (opcion != 3);
    }

    private static void compararFichero() {
        crearFichero();

        try {
            BufferedReader lee1 = new BufferedReader(new FileReader(f1));
            BufferedReader lee2 = new BufferedReader(new FileReader(f2));

            String linea1 = "", linea2 = "";
            System.out.println("Comparando Archivos...");
            int cont1 = 0, cont2 = 0;

            while (linea1 != null || linea2 != null) {
                linea1 = lee1.readLine();
                linea2 = lee2.readLine();
                if (linea1 != null) {
                    cont1++;
                }
                if (linea2 != null) {
                    cont2++;
                }
            }

            System.out.println("Fin de comparacion de los archivos...\n");

            System.out.println("El primer archivo tiene " + cont1 + " Lineas");
            System.out.println("El segundo archivo tiene " + cont2 + " Lineas");

            if (cont1 == cont2) {
                System.out.println("Los archivos comparados son iguales");
            } else {
                System.out.println("Los archivos comparados son diferentes");
            }

            lee1.close();
            lee2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("fin...");
        }
    }

    private static void crearFichero() {
        // TODO Auto-generated method stub
        try {
            if (f1.createNewFile())
                System.out.println("El fichero se ha creado correctamente");
            else
                System.out.println("No ha podido ser creado el fichero");

            if (f2.createNewFile())
                System.out.println("El fichero se ha creado correctamente");
            else
                System.out.println("No ha podido ser creado el fichero");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static String introducirDatos(String mensaje) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(mensaje);
        return br.readLine();
    }
}
