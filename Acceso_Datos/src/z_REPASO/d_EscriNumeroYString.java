package z_REPASO;

import java.io.*;

public class d_EscriNumeroYString {
    public static void main(String[] args) {

        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            int[] array = {5, 18, 23, 12, 10, 1, 47};
            String[] nombres = {"Bea", "Ana", "Maria", "Juan",
                    "Pedro", "Teresa", "Marta"};

            fos = new FileOutputStream("EnterosNombres.txt", true);
            dos = new DataOutputStream(fos);

            for (int i = 0; i < array.length; i++) {
                dos.writeInt(array[i]);
                dos.writeUTF(nombres[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                dos.close();
                fos.close();
            } catch (IOException e) {
                System.out.println("No se pudo cerrar el fihcero Enteros.txtg");
            }
        }
    }
}
