package z_EXAMENES.SolucionExamenUD01.GrupoJueves;

import java.io.*;

import javax.swing.JOptionPane;

/*Crear una aplicaci�n que pida la ruta de dos ficheros de texto y una ruta de destino, 
 * en �sta �ltima no indicaremos el nombre del fichero, solo la ruta.
El programa deber� unir los dos ficheros en uno de destino cuyo nombre ser� el nombre de los 
dos ficheros separados por un guion bajo. Se deber� comprobar si el fichero de destino existe, 
en cuyo caso nos mostrar� un mensaje inform�ndonos de si queremos sobreescribir el fichero.
Por ejemplo, si tenemos un fichero Uno.txt cuyo contenido es �Hola� y otro fichero 
Dos.txt con  �Adios� y una ruta de destino D:\, el resultado ser� un fichero llamado Uno_Dos.txt 
en la ruta D:\ con el contenido �Hola Adios�.
El programa deber� estar estructurado y controlar las excepciones que puedan aparecer.*/

public class UnionFicheros {

    public static void main(String[] args) {

        File f1 = null;
        File f2 = null;
        do {
            String ruta1 = introducirRuta("Ruta completa del primer fichero: ");
            //Creamos objetos File
            f1 = new File(ruta1);

        } while (!f1.exists());

        do {
            String ruta2 = introducirRuta("Ruta completa del segundo fichero: ");
            f2 = new File(ruta2);
        } while (!f2.exists());

        String ruta3 = introducirRuta("Ruta del tercer fichero, sin nombre del fichero: ");
        //Quitamos la extension del primer fichero
        String primerFichero = f1.getName().substring(0, f1.getName().length() - 4);

        //Creamos el fichero de salida
        String nbFichero3 = primerFichero + "_" + f2.getName();

        //C:\Users\34655\Documents\EjemplosFicheros\

        //creamos la ruta 3
        ruta3 += nbFichero3;
        System.out.println("ruta " + ruta3);

        File f3 = new File(ruta3);

        unionFicheros(f1, f2, f3);

    }

    private static void unionFicheros(File f1, File f2, File f3) {
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(f1));
            BufferedReader br2 = new BufferedReader(new FileReader(f2));

            int respuesta = 1;
            if (f3.exists()) {
                respuesta = JOptionPane.showConfirmDialog(null, "Fichero existente. �Sobrescribir el fichero?",
                        "Informaci�n", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
            if (respuesta != JOptionPane.CANCEL_OPTION) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f3));
                copia(br1, bw);
                copia(br2, bw);

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void copia(BufferedReader br, BufferedWriter bw) {
        String linea = null;
        try {
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.write("\n");
            }
            br.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private static String introducirRuta(String string) {
        return JOptionPane.showInputDialog(string);
    }

}
