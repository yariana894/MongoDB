package Textos;

import java.io.*;

public class Ejemplo05 {
    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("Ejemplo02.txt");
            BufferedReader br = new BufferedReader(fr);
            String nombre;

            while (true) {
                nombre = br.readLine();
                if (nombre != null)
                    System.out.println(nombre);
                else {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}

