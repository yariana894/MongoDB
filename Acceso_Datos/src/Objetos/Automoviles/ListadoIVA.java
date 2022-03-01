package Objetos.Automoviles;

/*Se generará un listado que mostrará los datos del coche, calculará el IVA,
suponemos el 21% y el Total (precio + IVA).*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ListadoIVA {
    public static void main(String[] args) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("Coche.dat");
            ois = new ObjectInputStream(fis);

            while (true) {
                Coches coche;
                coche = (Coches) ois.readObject();
                System.out.println(coche);

                double iva = coche.precio * 0.21;
                System.out.println("Precio IVA: " + iva);

                double total = coche.precio * 0.21 + coche.precio;
                System.out.println("Total Precio + IVA: " + total+" \n");
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
