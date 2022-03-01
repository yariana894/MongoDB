package z_REPASO;

import java.io.*;

public class g_LeerFIchero {
    public static void main(String[] args) {
        try {
            File f = new File("hola.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {

                System.out.println(linea);

                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
