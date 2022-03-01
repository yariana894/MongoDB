package z_REPASO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirCaracteres {
    public static void main(String[] args) {
        try {
            File f = new File("fichero01.txt");
            FileWriter fw = new FileWriter(f);
            String cadena = "Esto es una prueba de FIlewriter método";

            char[] cad = cadena.toCharArray();

            fw.write("hola");

            for (int i = 0; i < cad.length; i++){
                fw.write(cad[i]);
                fw.write("\n");
            }
            fw.append('*');
            fw.write(cadena);
            fw.append('*');
            fw.write(cad);
            fw.close();
            System.out.println("Programa finalizado");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
