package Objetos.Automoviles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;
import java.util.Scanner;

/*Se listarán los coches de una determinada marca que introducimos por teclado.*/

public class ListaMarcaCoches {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la marca que quiere listar: ");
        String m = sc.nextLine();

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
                if (Objects.equals(coche.marca, m))
                    System.out.println(coche);
            }

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();

        } catch (
                IOException e) {
            System.out.println("Fin de la lectura");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
