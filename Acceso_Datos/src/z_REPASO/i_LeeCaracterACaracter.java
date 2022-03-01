package z_REPASO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class i_LeeCaracterACaracter {

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("hola.txt");

            int linea = fr.read();
            while (linea != -1) {
                if (linea != 32) {
                    System.out.println((char) linea);
                }

                linea = fr.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
