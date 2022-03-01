package Aleatorios.Ejercicio_FicheroAleatorios;

import IntroducirDatos.IntroducirDatos;

import java.io.*;
import java.util.Scanner;

/*1.- Altas.- Añadiremos nuevos libros al fichero
2.- Listado del fichero completo con la valoración total del inventario.
3.- Consultas:
3.1. De un registro determinado (por código)
3.2. Buscar los libros de un autor determinado
4.- Modificaciones. Modificaremos los valores de los registros
5.- Salir*/

public class Ejercicio_Aleatorios {

    private static final long tamanhoRegistro = 200;
    static File f = new File("Libros.dat");

    public static void main(String[] args) {

        int opcion = 0;

        do {
            System.out.println();
            System.out.println("1.- Nuevo Libro (Insertar registros)");
            System.out.println("2.- Listado (Lista todos los registros. Secuencial)");
            System.out.println("3.- Consulta registro por código (Muestra el Libro seleccionado)");
            System.out.println("4.- Busca libros de un autor determinado");
            System.out.println("5.- Modificar Libros (Modifica los datos del Libro seleccionado)");
            System.out.println("6.- Salir");

            opcion = Integer.parseInt(IntroducirDatos.introducirDatos("Introduce una opción: "));
            switch (opcion) {
                case 1:
                    insertarRegistros(f);
                    break;
                case 2:
                    listarFichero(f);
                    break;
                case 3:
                    consultarRegistrosCodigo(f);
                    break;
                case 4:
                    consultarRegistrosAutor(f);
                    break;
                case 5:
                    modificarRegistros(f);
                    break;
            }
        } while (opcion != 6);
    }


    public static void insertarRegistros(File f) {
        RandomAccessFile raf = null;

        int codigo = 0;
        String titulo;
        String autor;
        int precio;
        int cantidad;
        String respuesta = "s";

        try {
            raf = new RandomAccessFile(f, "rw");

            do {
                codigo = Integer.parseInt(IntroducirDatos.introducirDatos("Código libro: "));
                titulo = IntroducirDatos.introducirDatos("Título: ");
                autor = IntroducirDatos.introducirDatos("Autor: ");

                do {
                    precio = Integer.parseInt(IntroducirDatos.introducirDatos("Precio: "));
                } while (precio < 0);

                do {
                    cantidad = Integer.parseInt(IntroducirDatos.introducirDatos("Cantidad: "));
                } while (cantidad < 0 || cantidad > 10);

                //colocar el puntero en la posición dónde vamos a escribir
                //que va a ocupar la posición cero clave -1
                raf.seek((codigo - 1) * tamanhoRegistro);

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

                raf.writeInt(codigo);
                raf.writeUTF(titulo);
                raf.writeUTF(autor);
                raf.writeInt(precio);
                raf.writeInt(cantidad);

                respuesta = IntroducirDatos.introducirDatos("¿Desea continuar s/n?");

            } while (respuesta.equalsIgnoreCase("s"));

            raf.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                System.out.println(" Error al cerrar el fichero");
            }
        }
    }

    public static void listarFichero(File f) {
        //vamos a tratar el fichero de forma secuencial
        //vamos a leer todos los registros

        RandomAccessFile raf = null;

        int codigo = 0;
        String titulo;
        String autor;
        int precio;
        int cantidad;
        int total = 0;

        try {
            raf = new RandomAccessFile(f, "r");

            long numRegistros = f.length() / tamanhoRegistro;

            for (int i = 0; i <= numRegistros; i++) {
                raf.seek(i * tamanhoRegistro);

                codigo = raf.readInt();
                titulo = raf.readUTF();
                autor = raf.readUTF();
                precio = raf.readInt();
                cantidad = raf.readInt();

                total += precio + cantidad;

                if (codigo != 0)
                    System.out.println(codigo + "\t" + titulo + "\t" + autor + "\t" + precio + "\t" + cantidad + "\t" + total);
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

    public static void consultarRegistrosCodigo(File f) {

        //ERROR CUANDO INTRODUZCO UN CODIGO QUE NO INTRODUCÍ
        RandomAccessFile raf = null;

        int clave = 0;
        int codigo;
        String titulo;
        String autor;
        int precio;
        int cantidad;

        try {
            raf = new RandomAccessFile(f, "r");

            long numRegistros = f.length() / tamanhoRegistro;

            do {
                codigo = Integer.parseInt(IntroducirDatos.introducirDatos("Código. <0 Fin>: "));

                if ((codigo - 1) > numRegistros) {
                    System.out.println("Código inexistente");
                } else {
                    if (codigo != 0) {
                        raf.seek((codigo - 1) * tamanhoRegistro);
                        clave = raf.readInt();
                        titulo = raf.readUTF();
                        autor = raf.readUTF();
                        precio = raf.readInt();
                        cantidad = raf.readInt();

                        if (clave != 0)
                            System.out.println(clave + "\t" + titulo + "\t" + autor + "\t" + precio + "\t" + cantidad + "\n");

                        else
                            System.out.println("Código inexistente");
                    }
                }
            } while (codigo != 0);
            raf.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void consultarRegistrosAutor(File f) {
        RandomAccessFile raf = null;

        int codigo;
        String titulo;
        String autor;
        int precio;
        int cantidad;
        String aux = "";

        long numRegistros = f.length() / tamanhoRegistro;

        if (numRegistros > 0) {
            aux = IntroducirDatos.introducirDatos("Introduce el autor: ");

        }

        try {
            raf = new RandomAccessFile(f, "r");

            System.out.println("Código" + "\t" + "Título" + "\t\t\t\t\t\t" +"Autor" + "\t\t\t\t\t\t"
                    + "Precio" + "\t" +"Cantidad");

            for (int i = 0; i <= numRegistros; i++) {
                raf.seek(i * tamanhoRegistro);

                codigo = raf.readInt();
                titulo = raf.readUTF();
                autor = raf.readUTF();
                precio = raf.readInt();
                cantidad = raf.readInt();


                if (aux.equalsIgnoreCase(autor.trim()))

                    System.out.println(codigo + "\t" + titulo + "\t" + autor + "\t" + precio + "\t" + cantidad);
            }
            raf.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error en la entrada/salida de datos");
        }
    }

    private static void modificarRegistros(File f) {
        RandomAccessFile raf = null;
        int clave, precio, cantidad, codigo;
        String titulo, autor;

        try {
            raf = new RandomAccessFile(f, "rw");
            long numRegistros = f.length() / tamanhoRegistro;

            do {

                codigo = Integer.parseInt(IntroducirDatos.introducirDatos("Código: <0 Fin>"));

                if (codigo > 0 && codigo < numRegistros + 1) {

                    raf.seek((codigo - 1) * tamanhoRegistro);

                    clave = raf.readInt();
                    titulo = raf.readUTF();
                    autor = raf.readUTF();
                    precio = raf.readInt();
                    cantidad = raf.readInt();

                    System.out.println(clave + "\t" + codigo + "\t" + titulo + "\t" + autor + "\t" + precio + "\t" + cantidad);

                    String respuesta = IntroducirDatos.introducirDatos("Modificar s/n: ");

                    if (respuesta.equalsIgnoreCase("s")) {

                        titulo = IntroducirDatos.introducirDatos("Nuevo Título: ");
                        if (titulo.length() > 30)
                            titulo = titulo.substring(0, 30);
                        else
                            for (int i = titulo.length(); i < 30; i++)
                                titulo += " ";


                        autor = IntroducirDatos.introducirDatos("Nuevo autor: ");
                        if (autor.length() > 30)
                            autor = autor.substring(0, 30);
                        else
                            for (int i = autor.length(); i < 30; i++)
                                autor += " ";

                        do {
                            precio = Integer.parseInt(IntroducirDatos.introducirDatos("Nuevo precio: "));
                        } while (precio < 0);

                        do {
                            cantidad = Integer.parseInt(IntroducirDatos.introducirDatos("Nueva cantidad: "));
                        } while (cantidad < 0 || cantidad > 10);

                        //ahora tengo que recolocar el puntero

                        raf.seek((codigo - 1) * tamanhoRegistro);
                        //reescribir los datos
                        raf.writeInt(clave);
                        raf.writeUTF(titulo);
                        raf.writeUTF(autor);
                        raf.writeInt(precio);
                        raf.writeInt(cantidad);

                    }

                } else
                    System.out.println("Código inexistente");
            } while (codigo != 0);
            raf.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

