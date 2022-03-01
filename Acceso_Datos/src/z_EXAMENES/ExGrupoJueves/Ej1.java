package z_EXAMENES.ExGrupoJueves;

/*º) Crear una aplicación que pida la ruta de dos ficheros de texto y una ruta de destino, en ésta
última no indicaremos el nombre del fichero, solo la ruta.
El programa deberá unir los dos ficheros en uno de destino cuyo nombre será el nombre de los
dos ficheros separados por un guion bajo. Se deberá comprobar si el fichero de destino existe,
en cuyo caso nos mostrará un mensaje informándonos de si queremos sobreescribir el fichero.
Por ejemplo, si tenemos un fichero Uno.txt cuyo contenido es “Hola” y otro fichero Dos.txt con
“Adios” y una ruta de destino D:\, el resultado será un fichero llamado Uno_Dos.txt en la ruta
D:\ con el contenido “Hola Adios”.
El programa deberá estar estructurado y controlar las excepciones que puedan aparecer.*/

import java.io.*;

import IntroducirDatos.IntroducirDatos;

public class Ej1 {

    public static File f1;
    public static File f2;
    public static File destino;

    public static FileWriter fw;
    public static BufferedWriter bw;
    public static FileReader fr;
    public static BufferedReader br;
    public static FileReader fr2;
    public static BufferedReader br2;

    public static void main(String[] args) {

        ficheros();

        juntar();
    }

    public static void ficheros() {
        f1 = new File((IntroducirDatos.introducirDatos("Introduce la ruta del primer archivo: ")));
        f2 = new File((IntroducirDatos.introducirDatos("Introduce la ruta del segundo archivo: ")));
        destino = new File(IntroducirDatos.introducirDatos("Introduce la ruta de destino (sin el nombre del archivo): ") + "/" + nombre());
    }

    public static String nombre() {
        String name1 = f1.getName();
        String name2 = f2.getName();

        return ((name1).substring(0, name1.length()-4) + "_" + name2);
    }

    public static void juntar() {

        try {

            fr = new FileReader(f1);
            br = new BufferedReader(fr);

            if (addFile()) {
                fw = new FileWriter(destino, true);
            } else {
                fw = new FileWriter(destino);
            }
            bw = new BufferedWriter(fw);

            copy(bw, br);

            br.close();

            fr2 = new FileReader(f2);
            br2 = new BufferedReader(fr2);

            copy(bw, br2);
            bw.close();
            br2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                fw.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static boolean addFile() {
        if (destino.exists()) {
            String val = IntroducirDatos.introducirDatos("El fichero existe, pulsa a para anhadir al fichero existente: ");
            if (val.equalsIgnoreCase("a")) {
                return true;
            } else {
                return false;
            }
        } else
            return false;
    }

    private static void copy(BufferedWriter bw, BufferedReader br) throws IOException{
        String linea;
        while ((linea = br.readLine()) != null) {
            bw.write(linea);
            bw.write("\n");
        }


    }
}