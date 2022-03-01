package XML.serializacionFicherosXML;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CrearFicheroDeObjetosAlumno {
    public static void main(final String[] args) {
        crearFicheroObjetos();
        leerFicheroObjetos();
    }// fin main

    private static void leerFicheroObjetos() {
        System.out.println("DNI\t\tNombre \t\t\t Teléfono");
        FileInputStream fs = null;
        ObjectInputStream os = null;
        try {
            // abrimos el fichero para lectura
            fs = new FileInputStream("Alumnos.Dat");
            os = new ObjectInputStream(fs);

            while (true) { // lectura del fichero mientras haya objetos
                // os debe realizar un castingal tipo original
                Alumno alu = (Alumno) os.readObject();
                System.out.println(alu.getDni() + "\t" + alu.getNombre() + "\t" + alu.getTelefono());
            }
        } catch (ClassNotFoundException cnf) {
            System.out.println("Error la clase");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error en el fichero");
        } catch (EOFException eo) {
            System.out.println("Fin del fichero");
        } catch (IOException ioe) {
            System.out.println("Error");
        }

        try {
            os.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void crearFicheroObjetos() {
        // creamos los objetos que nos permiten escribir
        FileOutputStream fs = null;
        ObjectOutputStream os = null;

        try {
            fs = new FileOutputStream("Alumnos.DAT");
            os = new ObjectOutputStream(fs);
            //declaramos el objeto Alumno usando un constructor y escribimos en el disco
            Alumno a1 = new Alumno("11111A", "Marta Aguirre", 986141414);
            os.writeObject(a1);

            // escribimos pasando la creaci�n del objeto
            os.writeObject(new Alumno("222222B", "Ana S�nchez", 627323232));

            Alumno a2 = new Alumno("333333C", "Pedro Garc�a", 615545454);
            os.writeObject(a2);

            // cerramos el fichero
            os.close();
        } catch (FileNotFoundException fne) {
            System.out.println("Error en el fichero");
        } catch (IOException ioe) {
            System.out.println("Error E/L");
        }
    }
}
