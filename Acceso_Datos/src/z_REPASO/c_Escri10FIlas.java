package z_REPASO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class c_Escri10FIlas {
    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("fichero.txt");

            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < 11; i++) {
                bw.write("Fila número: " + i);
                bw.newLine();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
