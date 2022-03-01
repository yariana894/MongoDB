package z_EXAMENES.ExGrupoJueves.Ej2;

import IntroducirDatos.IntroducirDatos;

import java.io.*;

public class Ej2 {

    public static FileOutputStream fos;
    public static ObjectOutputStream oos;
    public static FileInputStream fis = null;
    public static ObjectInputStream ois = null;

    public static String fichero = "Articulos.dat";
    public static File f = new File(fichero);

    public static void main(String[] args) throws IOException {


        int opcion = 0;
        do {
            System.out.println("1-Crear fichero e insertar datos");
            System.out.println("2-Listado artículos completo");
            System.out.println("3-Artículos con stock por debajo de mínimo");
            System.out.println("4-Salir");

            opcion = Integer.parseInt(IntroducirDatos.introducirDatos("Introduce la opción que desea: "));

            switch (opcion) {
                case 1: {
                    comprobarExistenciaFichero(f);
                    break;
                }
                case 2: {
                    listadoCompleto(f);
                    break;
                }
                case 3: {
                    articulosMinimo(f);
                    break;
                }
                case 4: {
                    System.exit(0);
                    break;
                }
            }

        } while (opcion != 3);
    }



    public static void articulosMinimo(File f) {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        try {
            fis = new FileInputStream(f);
            entrada = new ObjectInputStream(fis);
            Articulo articulo = new Articulo();
            System.out.println("\t\tListado Articulos bajo minimo");
            System.out.println("CODIGO\t\tDESCRIPCION\t\tPVP\t\tSTOCKPVP\t\tSTOCK MINIMO");

            while (true) {
                articulo = (Articulo) entrada.readObject();
                //comprobamos el stock
                if (articulo.getStock() < articulo.getStockMinimo()) {
                    // imprimimos los datos recuperados
                    System.out.println(articulo.getCodigo() + "\t" + articulo.getDescripcion()
                            + "\t" + articulo.getPvp() + "\t" + articulo.getStock() + "\t"
                            + articulo.getStockMinimo());
                }

            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (EOFException eof) {

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                entrada.close();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }// fin metodo articulosMinimo

    public static void listadoCompleto(File f) {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        double total = 0;
        try {
            fis = new FileInputStream(f);
            entrada = new ObjectInputStream(fis);
            Articulo articulo = new Articulo();

            System.out.println("\t\tListado Articulos");
            System.out.println("CODIGO\t\tDESCRIPCION\t\tSTOCK\t\tPVP\t\tTOTAL");
            while (true) {
                articulo = (Articulo) entrada.readObject();
                // imprimimos los datos recuperados
                System.out.println(articulo.getCodigo() + "\t" + articulo.getDescripcion()
                        + "\t" + articulo.getStock() + "\t" + articulo.getPvp() + "\t"
                        + articulo.getPvp() * articulo.getStock());
                total += articulo.getPvp() * articulo.getStock();

            }// fin del while

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (EOFException eof) {
            System.out.println("Total: " + total);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                entrada.close();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }

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

}
