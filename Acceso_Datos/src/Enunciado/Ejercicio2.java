package Enunciado;

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        File f = new File("1.txt");


        try {
            FileReader fr = new FileReader("1.txt");
            FileWriter fw = new FileWriter("2.txt");
            int c = fr.read();
            while (c != -1) {
                fw.write(c);
            }
            fr.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
