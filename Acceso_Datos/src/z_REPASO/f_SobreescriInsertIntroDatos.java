package z_REPASO;

/*
* Ejemplo que escribe y lee datos binarios en un fichero
* 1o Nos pide el nombre del fichero donde va a escribir o leer
* 2o Nos pide si queremos abrir el fichero en el modo sobreescribir o
insertar
* 3o Introducimos los datos en el fichero (codigo y nombre de
usuario)
*/

import IntroducirDatos.IntroducirDatos;

import java.io.*;

public class f_SobreescriInsertIntroDatos {

    static String nombreFichero;

    public static void main(String[] args) {
        nombreFichero = insertaNombreFichero();

        int opcion = 0;

        do {
            System.out.println("1.- Escribir en el fichero");
            System.out.println("2.- Leer del fichero");
            System.out.println("3.- Salir");

            opcion = Integer.parseInt(IntroducirDatos.introducirDatos("Elegir opción: "));
            switch (opcion) {
                case 1:
                    escribirFichero();
                    break;
                case 2:
                    lecturaFichero();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Error en la opción");
            }
        } while (opcion != 3);
    }

    private static void lecturaFichero() {
        File f = null;
        DataInputStream dis = null;

        try {

            f = new File(nombreFichero);
            dis = new DataInputStream(new FileInputStream(f));

            while (true){
                System.out.println("Código: "+dis.readInt());
                System.out.println("Nombre: "+dis.readUTF());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (dis!=null){
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void escribirFichero() {
        File f = null;
        DataOutputStream dos = null;

        String respuesta = "";

        try {
            f = new File(nombreFichero);

            if (f.exists()) {
                respuesta = IntroducirDatos.introducirDatos("El fichero ya" +
                        "existe, ¿desea sobreescribirlo? s/n");
            }
            if (respuesta.compareToIgnoreCase("s") == 0) {
                dos = new DataOutputStream(new FileOutputStream(nombreFichero));
            } else {
                dos = new DataOutputStream(new FileOutputStream(nombreFichero, true));
            }

            String nombre= IntroducirDatos.introducirDatos("Introduce el nombre del usuario" +
                    " F para finalizar: ");

            while (!nombre.equalsIgnoreCase("F")){
                int codigo = Integer.parseInt(IntroducirDatos.introducirDatos("Introduce" +
                        "el código del usuario: "));

                dos.writeInt(codigo);
                dos.writeUTF(nombre);

                nombre = IntroducirDatos.introducirDatos("Introduce el nombre del " +
                        "usuario. F para finalizar: ");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String insertaNombreFichero() {
        return IntroducirDatos.introducirDatos("Introduce el nombre del fichero: ");
    }


}
