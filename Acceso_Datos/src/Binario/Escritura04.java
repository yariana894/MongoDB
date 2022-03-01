package Binario;

import java.io.*;

public class Escritura04 {
    public static void main(String[] args) {
        //todos tienen que tener el mismo número de elementos
        int numeros[] = {8, 25, 85, 32, 43, 18};
        String nombres[] = {"Juan", "Ana", "Maria", "Marta", "Andres", "Miguel"};
        double decimales[] = {1.2, 5.23, 8.56, 12.23, 52.14, 78.32};

        FileOutputStream fos;
        DataOutputStream dos;

        try {
            fos = new FileOutputStream("Nombres.dat");
            dos = new DataOutputStream(fos);

            for (int i = 0; i < numeros.length; i++) {

                dos.writeInt(numeros[i]);
                dos.writeUTF(nombres[i]);
                dos.writeDouble(decimales[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
