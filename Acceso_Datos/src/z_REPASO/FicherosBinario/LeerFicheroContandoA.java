package z_REPASO.FicherosBinario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerFicheroContandoA {
    // Cantidad de "a" en un fichero de cualquier tipo
    public static void main(String[] args) {

        System.out.println("Contando\"a\"...");
        int contador = 0;

        try {
            FileInputStream ficheroEntrada = new FileInputStream(new File("fichero01.txt"));
            int dato;

            while ((dato = ficheroEntrada.read()) != -1) {
                if (dato == 97)
                    contador++;
            }
            System.out.println("Cantidad de \"a\"..."+contador);
            ficheroEntrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
