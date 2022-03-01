package z_REPASO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class b_EscribirArrayCaracterLinea {
    public static void main(String[] args) {
        File f = new File("fichero.txt");

        String cadena = "hola que tal";
        char[] cad = cadena.toCharArray();

        try {
            FileWriter fw = new FileWriter(f);

            if (!f.exists()) {
                f.createNewFile();
            } else {
                fw.write("si");
            }

            for (int i = 0; i < cad.length; i++) {
                fw.write(cad[i]);
                fw.write("\n");
            }

            fw.append('*');
            fw.write(cadena);
            fw.append('*');
            fw.write(cad);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
