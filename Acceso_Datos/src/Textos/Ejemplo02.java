package Textos;

import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo02 {
    public static void main(String[] args) {

        String cadena = "Hola, estamos en clase de Acceso a Datos";
        char[] cad = cadena.toCharArray();
        FileWriter fw = null;

        try {
            fw = new FileWriter("Ejemplo02.txt");
            for (int i = 0; i < cadena.length(); i++) {
                fw.write(cad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
