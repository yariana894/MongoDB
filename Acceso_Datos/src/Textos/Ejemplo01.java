package Textos;

import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo01 {
    public static void main(String[] args) {
        String nombres[] = {"Ana", "Juan", "Marta", "Bea"};
        FileWriter fw = null;

        try {
            fw = new FileWriter("Ejemplo01.txt");

            for (int i = 0; i < nombres.length; i++) {
                fw.write(nombres[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try{
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
