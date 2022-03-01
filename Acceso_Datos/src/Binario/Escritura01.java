package Binario;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Escritura01 {
    public static void main(String[] args) {
        int numeros[] ={8,25,85,32,43,18};

        FileOutputStream fos;
        DataOutputStream dos;

        try {
            fos= new FileOutputStream("Enteros.dat");
            dos = new DataOutputStream(fos);

            for(int num:numeros){
                dos.write(num);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
