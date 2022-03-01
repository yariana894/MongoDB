package Binario;

import java.io.*;

public class Lectura03 {
    public static void main(String[] args) {
        FileInputStream fis;
        DataInputStream dis = null;

        int numero;

        try {
            fis = new FileInputStream("Enteros.dat");
            dis = new DataInputStream(fis);

            while (true) {
                System.out.println(dis.readInt());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
