package XML.EjercicioXML.Ejercicio3;

import java.io.*;

public class DATaXMLCoche {

    public static void main(String[] args) {
        try {
            File fichero = new File("Coches.dat");
            FileInputStream lectura = new FileInputStream(fichero);

            ObjectInputStream datos = new ObjectInputStream(lectura);
            System.out.println("Comienza el proceso de creación del fichero XML....");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
