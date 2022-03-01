package Enunciado;

import IntroducirDatos.IntroducirDatos;
import Objetos.Automoviles.MiObjectOutputStream;

import java.io.*;

public class Ejercicio3 {

    static File f = new File("Articulos.dat");

    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println();
            System.out.println("1.- Nuevo artículos (Insertar registros)");
            System.out.println("2.- Listado (Lista todos los registros. Secuencial)");
            System.out.println("3.- Consulta registro por código (Muestra el Libro seleccionado)");
            System.out.println("4.- Busca libros de un autor determinado");
            System.out.println("5.- Modificar Libros (Modifica los datos del Libro seleccionado)");
            System.out.println("6.- Salir");

            opcion = Integer.parseInt(IntroducirDatos.introducirDatos("Introduce una opción: "));
            switch (opcion) {
                case 1:
                    if (!f.exists()) {//no existe
                        escribirNuevoFichero(f);
                    } else {
                        System.out.println("Fichero existe");
                        escribirExisteFichero(f);
                    }
                    break;
                case 2:
                    listarFichero(f);
                    break;
                case 3:
                    //  consultarRegistrosCodigo(f);
                    break;
                case 4:
                    // consultarRegistrosAutor(f);
                    break;
                case 5:
                    // modificarRegistros(f);
                    break;
            }
        } while (opcion != 6);
    }


    public static void escribirExisteFichero(File f) {

        FileOutputStream fos = null;
        MiObjectOutputStream moos = null;

        try {
            //cuando quiero añadir datos tengo que añadir el true
            fos = new FileOutputStream(f, true);
            moos = new MiObjectOutputStream(fos);

            for (int i = 0; i < 2; i++) {
                Articulo ar = new Articulo(Integer.parseInt(IntroducirDatos.introducirDatos("Código: ")),
                        IntroducirDatos.introducirDatos("Descripción: "),
                        Double.parseDouble(IntroducirDatos.introducirDatos("PVP: ")),
                        Integer.parseInt(IntroducirDatos.introducirDatos("Stock: ")),
                        Integer.parseInt(IntroducirDatos.introducirDatos("Stock mínimo: ")));
                moos.writeObject(ar);

            }
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Fin del programa");
    }

    public static void escribirNuevoFichero(File f) {

        FileOutputStream fos = null;
        //como el fichero no existe tenemos que poner la siguiente clase
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);

            for (int i = 0; i < 3; i++) {
                Articulo ar = new Articulo(Integer.parseInt(IntroducirDatos.introducirDatos("Código: ")),
                        IntroducirDatos.introducirDatos("Descripción: "),
                        Double.parseDouble(IntroducirDatos.introducirDatos("PVP: ")),
                        Integer.parseInt(IntroducirDatos.introducirDatos("Stock: ")),
                        Integer.parseInt(IntroducirDatos.introducirDatos("Stock mínimo: ")));
                oos.writeObject(ar);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void listarFichero(File f) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            System.out.println("Código" + "   "
                    + "Descripción" + "   "
                    + "Stock" + "   "
                    + "PVP" + "   "
                    + "IVA" + "   "
                    + "TOTAL");

            while (true) {
                Articulo articulo;
                articulo = (Articulo) ois.readObject();

                System.out.print(articulo.codigo + "     "
                        + articulo.descripcion + "     "
                        + articulo.stock + "     "
                        + articulo.pvp);

                double iva = articulo.pvp * 0.21;
                System.out.print("     " + iva);

                double total = articulo.stock * articulo.pvp;
                System.out.println("     " + total);
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

