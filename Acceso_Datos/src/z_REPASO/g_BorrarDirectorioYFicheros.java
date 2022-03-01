package z_REPASO;

import java.io.File;
import java.util.Scanner;

/*1o) Realizar un programa Java que pida el nombre
de un directorio. El programa deberá listar sus ficheros
y después eliminar el directorio y los ficheros contenidos en él.*/

public class g_BorrarDirectorioYFicheros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta = "C:\\Users\\Yari\\Documents\\2o DAM\\1aEv\\Acceso_Datos\\src\\";

        System.out.println("Introduce el directorio: ");
        String dire = sc.nextLine();

        File f = new File(ruta + dire);
        System.out.println(f);

        String[] archivos = f.list();

        System.out.println("Listando ficheros del directorio " + dire + ": ");
        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i]);
        }

        System.out.println();
        System.out.println("Eliminando el directorio... ");
        if (f.delete()) {
            System.out.println("Directorio eliminado");
        } else {
            System.out.println("No se ha eliminado el directorio");
        }
    }
}
