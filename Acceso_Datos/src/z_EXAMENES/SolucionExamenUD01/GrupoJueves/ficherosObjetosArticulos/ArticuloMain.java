package z_EXAMENES.SolucionExamenUD01.GrupoJueves.ficherosObjetosArticulos;

import java.io.*;

public class ArticuloMain {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        File f = new File("Articulos.dat");
        int opcion;

        try {
            do {
                System.out.println("1.- Nuevo Articulo.");
                System.out.println("2.- Listar Articulos.");
                System.out.println("3.- Articulos bajo minimo.");
                System.out.println("4.- Salir.");
                System.out.println("Elegir opcion: ");
                opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1:
                        comprobarExistenciaFichero(f);
                        break;
                    case 2:
                        listadoCompleto(f);
                        break;
                    case 3:
                        listadoMinimo(f);
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error en la opcion");
                }

            } while (opcion != 4);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }// fin main

    private static void listadoMinimo(File f) {
        // imprimimos la cabecera
        System.out.println("\t\tListado Articulos bajo minimo");
        System.out.println("CODIGO\t\tDESCRIPCION\t\tPVP\t\tSTOCKPVP\t\tSTOCK MINIMO");

        //creamos el listado
        Articulo articulo = new Articulo();
        articulo.articulosMinimo(f);
    }

    private static void listadoCompleto(File f) {

        //escribimos la cabecera
        System.out.println("\t\tListado Articulos");
        System.out.println("CODIGO\t\tDESCRIPCION\t\tSTOCK\t\tPVP\t\tTOTAL");

        //creamos el listado
        Articulo articulo = new Articulo();
        articulo.listadoCompleto(f);


    }// fin metodo listadoCompleto

    public static void comprobarExistenciaFichero(File f) {

        if (f.exists())
            existeFichero(f);
        else
            nuevoFichero(f);
    } // fin metodo comprobarExistenciaFichero

    private static void existeFichero(File f) {
        FileOutputStream fos = null;
        // Se usa un ObjectOutputStream que no escriba una cabecera en el stream.
        MiObjectOutputStream salida = null;

        //variables auxiliares para introducir los datos
        String desc;
        double precio;
        int codigo, stock, stockMinimo;
        boolean respuesta = false; // no existe el articulo

        try {

            fos = new FileOutputStream(f, true);
            salida = new MiObjectOutputStream(fos);

            Articulo articulo = new Articulo();
            codigo = Integer.parseInt(introducirDatos("Introducir el codigo del articulo <0> para fin:"));

            while (codigo != 0) {
                respuesta = articulo.buscarArticulo(codigo, f);

                if (respuesta) // articulo ya existe
                    System.out.println(codigo + " Existente");
                else {
                    //metodo para insertar los datos de los articulos
                    articulo = introducirArticulo(codigo);
                    //escribimos el articulo en el fichero
                    salida.writeObject(articulo);
                }
                codigo = Integer.parseInt(introducirDatos("Introducir el codigo del articulo <0> para fin:"));
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                salida.close();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }// fin metodo existeFichero

    private static Articulo introducirArticulo(int codigo) {

        Articulo articulo = new Articulo();
        try {
            String desc = introducirDatos("Articulo:");

            double precio = Double.parseDouble(introducirDatos("Precio:"));
            int stock = Integer.parseInt(introducirDatos("Stock: "));
            int stockMinimo = Integer.parseInt(introducirDatos("Stock minimo: "));

            // le pasamos los valores al objeto
            articulo.setCodigo(codigo);
            articulo.setDescripcion(desc);
            articulo.setPvp(precio);
            articulo.setStock(stock);
            articulo.setStockMinimo(stockMinimo);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return articulo;
    }

    public static void nuevoFichero(File f) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        String desc;
        double precio;
        int codigo, stock, stockMinimo;

        boolean respuesta = false; // no existe el art�culo

        try {
            fos = new FileOutputStream(f);
            salida = new ObjectOutputStream(fos);

            Articulo articulo = new Articulo();
            codigo = Integer.parseInt(introducirDatos("Introducir el codigo del articulo <0> para fin:"));

            while (codigo != 0) {
                respuesta = articulo.buscarArticulo(codigo, f);
                if (respuesta) // articulo ya existe
                    System.out.println(codigo + " Existente");
                else {
                    //metodo para insertar los datos de los articulos
                    articulo = introducirArticulo(codigo);
                    //escribimos el articulo en el fichero
                    salida.writeObject(articulo);
                }
                codigo = Integer.parseInt(introducirDatos("Introducir el codigo del articulo <0> para fin:"));
            }

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                salida.close();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }// fin metodo nuevoFichero

    public static String introducirDatos(String mensaje) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(mensaje);
        return br.readLine();
    } // fin metodo introducirDatos
} // fin de la clase

