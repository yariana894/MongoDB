package z_EXAMENES.ExRecuperacionUD01;

import IntroducirDatos.IntroducirDatos;

import java.io.*;

public class Examen02 {

    private static final long tamanhoRegistro = 200;
    static File f;
    private static RandomAccessFile raf;

    public static int codigo;
    public static String titulo;
    public static String autor;
    public static int precio;
    public static int cantidad;
    public static double desc = 0;
    public static String respuesta = "s";

    public static void main(String[] args) {
        f = new File("Libreria.dat");
        int opcion = 0;

        do {
            System.out.println();
            System.out.println("1.- Altas datos");
            System.out.println("2.- Modificar libro");
            System.out.println("3.- Listado (Lista todos los registros. Secuencial)");
            System.out.println("4.- Salir");


            opcion = Integer.parseInt(IntroducirDatos.introducirDatos("Introduce una opción: "));
            switch (opcion) {
                case 1:
                    insertarRegistros(f);
                    break;
                case 2:
                    modificarRegistros(f);
                    break;
                case 3:
                    listarFichero(f);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        } while (opcion != 6);


    }

    private static void modificarRegistros(File f) {
    }

    private static void listarFichero(File f) {
        double desc;

        try {
            raf = new RandomAccessFile(f, "r");

            long numRegistros = raf.length() / tamanhoRegistro;

            System.out.println("codigo \t" + "titulo\t" + "autor \t" + "precio \t" + "cantidad \t" + "descuento");
            for (int i = 0; i <= numRegistros; i++) {
                raf.seek(i * tamanhoRegistro);

                codigo = raf.readInt();

                if (codigo != 0) {
                    titulo = raf.readUTF();
                    autor = raf.readUTF();
                    precio = raf.readInt();
                    cantidad = raf.readInt();

                    do {
                        precio = Integer.parseInt(IntroducirDatos.introducirDatos("Precio: "));
                    } while (precio < 0);

                    do {
                        cantidad = Integer.parseInt(IntroducirDatos.introducirDatos("Cantidad: "));
                    } while (cantidad < 0 || cantidad > 10);

                    if (titulo.length() >= 30) {
                        titulo = titulo.substring(0, 30);
                    } else {
                        for (int j = titulo.length(); j <= 30; j++) {
                            titulo += " ";
                        }
                    }

                    if (autor.length() >= 30) {
                        autor = autor.substring(0, 30);
                    } else {
                        for (int k = autor.length(); k <= 30; k++) {
                            autor += " ";
                        }
                    }

                    desc = precio * 0.5;

                    System.out.println(codigo + "\t" + titulo + "\t" + autor + "\t" + precio + "\t" + cantidad + "\t" + desc);
                }

            }

            raf.close();

        } catch (EOFException eof) {
            System.out.println("Final del fichero ");
        } catch (FileNotFoundException fnf) {
            System.out.println("Fichero inexistente");
        } catch (IOException ioe) {
            System.out.println("Error al leer el fichero ");
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                System.out.println(" Error al cerrar el fichero");
            }
        }

    }

    private static void insertarRegistros(File f) {
        try {
            raf = new RandomAccessFile(f, "rw");
            long numRegistros = f.length() / tamanhoRegistro;

            do {
                codigo = Integer.parseInt(IntroducirDatos.introducirDatos("Código libro: "));

                if (codigo > 0 && codigo <= numRegistros + 1) {
                    raf.seek((codigo - 1) * tamanhoRegistro);

                }else {

                }

                titulo = IntroducirDatos.introducirDatos("Título: ");
                autor = IntroducirDatos.introducirDatos("Autor: ");

                do {
                    precio = Integer.parseInt(IntroducirDatos.introducirDatos("Precio: "));
                } while (precio < 0);

                do {
                    cantidad = Integer.parseInt(IntroducirDatos.introducirDatos("Cantidad: "));
                } while (cantidad < 0 || cantidad > 10);

                if (titulo.length() >= 30) {
                    titulo = titulo.substring(0, 30);
                } else {
                    for (int i = titulo.length(); i <= 30; i++) {
                        titulo += " ";
                    }
                }

                if (autor.length() >= 30) {
                    autor = autor.substring(0, 30);
                } else {
                    for (int i = autor.length(); i <= 30; i++) {
                        autor += " ";
                    }
                }

                raf.seek((codigo - 1) * tamanhoRegistro);
                raf.writeInt(codigo);
                raf.writeUTF(titulo);
                raf.writeUTF(autor);
                raf.writeDouble(precio);
                raf.writeInt(cantidad);

                respuesta = IntroducirDatos.introducirDatos("Desea continuar s/n?");

            } while (respuesta.equalsIgnoreCase("s"));
            raf.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                System.out.println(" Error al cerrar el fichero");
            }
        }
    }
}



