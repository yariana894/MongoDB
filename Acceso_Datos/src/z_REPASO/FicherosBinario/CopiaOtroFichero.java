package z_REPASO.FicherosBinario;

import java.io.*;

public class CopiaOtroFichero {

    public static void main(String[] args) {

        System.out.println("Copiando fichero binario....");


        try {
            InputStream ficheroEntrada = new FileInputStream(new File("hola.txt"));
            OutputStream ficheroSalida = new FileOutputStream(new File("copiaHOla.txt"));

            int cantidadLeida;

            while ((cantidadLeida = ficheroEntrada.read()) != -1) {
                ficheroSalida.write(cantidadLeida);
            }
            ficheroSalida.close();
            ficheroEntrada.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

