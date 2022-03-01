package Textos;

import java.io.*;

public class Ejemplo06 {
    public static void main(String[] args) {
        File f;
        FileReader fr = null;
        int caracter;

        try {
            f = new File("Ejemplo01.txt");
            if (f.exists()) {
                fr = new FileReader(f);
                //leemos un caracter y sino es el final lo escribimos el final del fichero -1

                while ((caracter = fr.read()) != -1) {
                    System.out.println((char) caracter);

                }
            } else
                System.out.println("El fichero no existe");
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) {
            System.out.println("Error de L/E");
        } finally {
            try {
                fr.close();
            } catch (IOException ioe) {


            }
        }
    }
}
