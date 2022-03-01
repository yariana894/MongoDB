package Objetos.Automoviles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


/*Se listarán todos los coches del fichero.*/

public class LecturaCoches {
    public static void main(String[] args) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("Coche.dat");
            ois = new ObjectInputStream(fis);

            //como se repite la cabecera dá un error
            //escribimos el método escribir la cabecera
            while (true) {
                Coches coche;
                coche = (Coches) ois.readObject();
                System.out.println(coche);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Fin de la lectura");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
