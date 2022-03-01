package z_REPASO.FicherosTexto;

import java.io.*;

public class LeerFicheroTextoConsola {
    public static void main(String[] args) {

        if (!(new File("hola.txt")).exists()) {
            System.out.println("No he encontrado hola.txt");
        }
        System.out.println("Leyendo fichero de texto....");

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("hola.txt")));

            String linea = null;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
