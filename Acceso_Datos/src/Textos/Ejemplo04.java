package Textos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo04 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("Ejemplo02.txt");
            BufferedReader br = new BufferedReader(fr);
            String nombre;

            while ((nombre = br.readLine()) != null) {
                System.out.println(nombre);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
