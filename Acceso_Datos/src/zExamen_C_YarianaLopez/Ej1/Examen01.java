package zExamenUD01102021.Ej1;

import java.io.*;

public class Examen01 {

    private static final int TAMANHOREGISTRO = 200;

    private static final int LONGMAX = 30;

    private static int codigo;
    private static String descripcion;
    private static String destinatario;
    private static String direccion;
    private static int precio;
    private static int nbCamionero;
    private static boolean entregado = true;


    static RandomAccessFile raf = null;


    public static void main(final String[] args) {


        File f = new File("C:\\Users\\DAM2\\Desktop\\YARI\\Acceso_Datos\\Paquetes.dat");


        String opcion;

        do {
            System.out.println();
            System.out.println("1.- Introducir nuevo paquete");
            System.out.println("2.- Listado Completo");
            System.out.println("3.- Listado paquetes entregados");
            System.out.println("4.- Modificar un paquete");
            System.out.println("5.- Salir");

            opcion = introduccionDatos("Introduce una opcion: ");
            try {
                switch (Integer.parseInt(opcion)) {
                    case 1:
                        insertarPaquete(f);
                        break;
                    case 2:
                        listadoCompleto(f);
                        break;
                    case 3:
                        listadoEntregados(f);
                        break;
                    case 4:
                        modificarPaquetes(f);
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Opcion erronea");
                }
            } catch (NumberFormatException e) {
                System.out.println("La opcion tiene que ser un numero");
            }
        } while (!opcion.equals("5"));
    }// fin main


    private static void modificarPaquetes(File f) {
        // TODO Auto-generated method stub
        String respuesta = "";
        try {
            raf = new RandomAccessFile(f, "rw");

            codigo = Integer.parseInt(introduccionDatos("Introducir el codigo "
                    + "a modificar. < 0 para Finalizar>: "));
            while (codigo != 0) {
                raf.seek((codigo - 1) * TAMANHOREGISTRO);

                codigo = raf.readInt();
                if (codigo != 0) {
                    descripcion = raf.readUTF();
                    destinatario = raf.readUTF();
                    direccion = raf.readUTF();
                    precio = raf.readInt();
                    nbCamionero = raf.readInt();
                    entregado = raf.readBoolean();

                    System.out.println(codigo + "\t" + descripcion + "\t" + destinatario + "\t" + direccion
                            + "\t" + precio + "\t" + nbCamionero + "\t" + entregado);
                }

                respuesta = introduccionDatos(("Desea modificar el registro. S/N"));
                if (respuesta.equalsIgnoreCase("s")) {
                    descripcion = comprobarLongitud(introduccionDatos("Descripcion: "), LONGMAX);
                    destinatario = comprobarLongitud(introduccionDatos("Destinatario: "), LONGMAX);
                    direccion = comprobarLongitud(introduccionDatos("Direccion: "), LONGMAX);
                    precio = Integer.parseInt(introduccionDatos("Precio: "));

                    do {
                        nbCamionero = Integer.parseInt(introduccionDatos("NbCamionero: "));
                    } while (nbCamionero < 0 || nbCamionero > 10);

                    entregado = Boolean.parseBoolean(introduccionDatos("Entregado <true entregado, false no entregado>: "));


                    raf.seek((codigo - 1) * TAMANHOREGISTRO);
                    raf.writeInt(codigo);
                    raf.writeUTF(descripcion);
                    raf.writeUTF(destinatario);
                    raf.writeUTF(direccion);
                    raf.writeInt(precio);
                    raf.writeInt(nbCamionero);
                    raf.writeBoolean(entregado);

                }
                codigo = Integer.parseInt(introduccionDatos("Introducir el codigo. < 0 para Finalizar>: "));
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error al introducir los datos");
        } catch (IOException ioe) {
            System.out.println("Error de posicionamiento o lectura");
            System.out.println(ioe.getMessage());
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void listadoEntregados(File f) {
        // TODO Auto-generated method stub

        int numRegistros = 0;
        try {
            raf = new RandomAccessFile(f, "r");

            numRegistros = (int) (raf.length() / TAMANHOREGISTRO);

            for (int i = 0; i <= numRegistros; i++) {
                raf.seek(i * TAMANHOREGISTRO);
                codigo = raf.readInt();
                if (codigo != 0) {
                    descripcion = raf.readUTF();
                    destinatario = raf.readUTF();
                    direccion = raf.readUTF();
                    precio = raf.readInt();
                    nbCamionero = raf.readInt();
                    entregado = raf.readBoolean();
                    if (entregado == true)
                        System.out.println(codigo + "\t" + descripcion + "\t" + destinatario + "\t"
                                + direccion + "\t" + precio + "\t" + nbCamionero + "\t" + entregado);
                }
            }
            raf.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            raf.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void insertarPaquete(File f) {
        // TODO Auto-generated method stub

        try {
            raf = new RandomAccessFile(f, "rw");

            String respuesta = null;
            do {
                codigo = Integer.parseInt(introduccionDatos("Codigo: "));
                descripcion = comprobarLongitud(introduccionDatos("Descripcion: "), LONGMAX);
                destinatario = comprobarLongitud(introduccionDatos("Destinatario: "), LONGMAX);
                direccion = comprobarLongitud(introduccionDatos("Direccion: "), LONGMAX);
                precio = Integer.parseInt(introduccionDatos("Precio: "));


                do {
                    nbCamionero = Integer.parseInt(introduccionDatos("NbCamionero: "));
                } while (nbCamionero < 0 || nbCamionero > 10);

                entregado = Boolean.parseBoolean(introduccionDatos("Entregado <true entregado, false no entregado>: "));


                raf.seek((codigo - 1) * TAMANHOREGISTRO);
                raf.writeInt(codigo);
                raf.writeUTF(descripcion);
                raf.writeUTF(destinatario);
                raf.writeUTF(direccion);
                raf.writeInt(precio);
                raf.writeInt(nbCamionero);
                raf.writeBoolean(entregado);

                respuesta = introduccionDatos("Desea continuar S/N ");

            } while (respuesta.equalsIgnoreCase("s"));
            raf.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static String comprobarLongitud(String nombre, int longmax) {

        if (nombre.length() > longmax)
            nombre = nombre.substring(0, longmax);
        else {
            for (int i = nombre.length(); i < longmax; i++)
                nombre = nombre + " ";
        }

        return nombre;
    }


    private static void listadoCompleto(File f) {

        int numRegistros = 0;

        try {
            raf = new RandomAccessFile(f, "r");

            numRegistros = (int) (raf.length() / TAMANHOREGISTRO);

            for (int i = 0; i <= numRegistros; i++) {
                raf.seek(i * TAMANHOREGISTRO);
                codigo = raf.readInt();
                if (codigo != 0) {
                    descripcion = raf.readUTF();
                    destinatario = raf.readUTF();
                    direccion = raf.readUTF();
                    precio = raf.readInt();
                    nbCamionero = raf.readInt();
                    entregado = raf.readBoolean();

                    System.out.println(codigo + "\t" + descripcion + "\t" + destinatario + "\t"
                            + direccion + "\t" + precio + "\t" + nbCamionero + "\t" + entregado);
                }
            }
            raf.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }// fin listadoCompleto


    /*---------------------------------------------------------------
     * metodo para introducir los datos desde el teclado
     */
    public static String introduccionDatos(final String s) {
        try {
            System.out.println("--------------------------------------------------------");
            System.out.print(s);
            return (new BufferedReader(new InputStreamReader(System.in))).readLine();
        } catch (IOException ioe) {
            System.out.println("\nError interno en sistema de entrada/salida\n");
        }
        return "";
    }// fin metodo introduccionDatos()
}
