package Binario;

import IntroducirDatos.IntroducirDatos;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Escritura02 {
    public static void main(String[] args) {
        int numeros[] = {8, 25, 85, 32, 43, 18};

        FileOutputStream fos;
        DataOutputStream dos;

        try {
            fos = new FileOutputStream("Enteros.dat");
            dos = new DataOutputStream(fos);
            int num = 0;

            while (num != -1) {
                num = Integer.parseInt(IntroducirDatos.introducirDatos("Introducir un entero" + " < -1 para finalizar>"));
                if (num != -1)
                    dos.writeInt(num);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
