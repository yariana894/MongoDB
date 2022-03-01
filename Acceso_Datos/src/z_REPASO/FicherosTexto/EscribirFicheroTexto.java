package z_REPASO.FicherosTexto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFicheroTexto {

    public static void main(String[] args) {

        System.out.println("Volcando fichero de texto");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("copia.txt")));

            bw.write("hola");
            bw.write("");
            bw.write("esta es");

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
