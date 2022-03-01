package z_EXAMENES.ExGrupoJueves;

import IntroducirDatos.IntroducirDatos;

import javax.swing.*;
import java.io.*;

public class AlumnoAleatoria {
    private static final int TAMANHOREGISTRO = 88;

    private static final int LONGMAX = 30; // // longitud m�xima de los String

    private static int codigo;
    private static String nombre;
    private static int notAcc;
    private static int notInt;
    private static int notMul;
    private static int notSer;
    private static int notSis;
    private static int notEmp;

    private static int[] notas = new int[6];

    static RandomAccessFile raf = null;


    public static void main(String[] args) {

        File f = new File("Alumnos.dat");

        int opcion = 0;

        do {

            System.out.println();
            System.out.println("1.- Insertar alumnos");
            System.out.println("2.- Listado de los alumnos y nota media");
            System.out.println("3.- Modificar alumnos");
            System.out.println("4.- Salir");

            opcion = Integer.parseInt(IntroducirDatos.introducirDatos("Introduce una opción: "));
            switch (opcion) {
                case 1:
                    altasAlumnos(f);
                    break;
                case 2:
                    listadoAlumnos(f);
                    break;
                case 3:
                    modificarAlumnos(f);
                    break;
                case 4:
                    System.exit(0);
            }
        } while (opcion != 4);
    }

    private static void listadoAlumnos(File f) {
        int numRegistros = 0;
        int suma = 0;
        try {
            raf = new RandomAccessFile(f, "r");

            numRegistros = (int) (raf.length() / TAMANHOREGISTRO);

            for (int i = 0; i <= numRegistros; i++) {
                raf.seek(i * TAMANHOREGISTRO);
                codigo = raf.readInt();
                if (codigo != 0) {
                    nombre = raf.readUTF();
                    for (int n = 0; n < notas.length; n++) {
                        notas[n] = raf.readInt();
                    }
                    System.out.print(codigo + "\t" + nombre + "\t");
                    suma = 0;
                    for (int n = 0; n < notas.length; n++) {
                        suma += notas[n];
                        System.out.print(notas[n] + "\t");
                    }
                    System.out.println(suma / 6);

                }
            }
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

    private static void modificarAlumnos(File f) {
        int codigo = 0;

        String respuesta = "";


        try {
            // abriendo archivo, capturando datos
            raf = new RandomAccessFile(f, "rw");

            codigo = Integer.parseInt(insertarDatos("Introducir la clave "
                    + "a modificar. < 0 para Finalizar>: "));
            while (codigo != 0) {
                //colocamos el puntero seg�n la clave para leer el registro
                raf.seek((codigo - 1) * TAMANHOREGISTRO);

                //leemos los campos del registro
                codigo = raf.readInt();
                if (codigo != 0) {
                    nombre = raf.readUTF();

                    for (int n = 0; n < notas.length; n++) {
                        notas[n] = raf.readInt();
                        System.out.print(notas[n] + "\t");
                    }
                }

                respuesta = insertarDatos(("Desea modificar el registro. S/N"));
                if (respuesta.equalsIgnoreCase("s")) {
                    nombre = comprobarLongitud(insertarDatos("Nombre: "), LONGMAX);

                    for (int i = 0; i < notas.length; i++) {
                        do {
                            notas[i] = Integer.parseInt(insertarDatos("Nota "));
                        } while (notas[i] < 0 || notas[i] > 10);

                    }

                    // colocamos el puntero
                    raf.seek((codigo - 1) * TAMANHOREGISTRO);
                    //escribimos los valores
                    raf.writeInt(codigo);
                    raf.writeUTF(nombre);
                    for (int i = 0; i < notas.length; i++) {
                        raf.writeInt(notas[i]);
                    }
                }


                codigo = Integer.parseInt(insertarDatos("Introducir la clave. < 0 para Finalizar>: "));
            }// fin while

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

    private static void altasAlumnos(File f) {
        try {
            raf = new RandomAccessFile(f, "rw");

            String respuesta = null;

            do {
                codigo = Integer.parseInt(insertarDatos("C�digo: "));
                nombre = comprobarLongitud(insertarDatos("Nombre: "), LONGMAX);

                for (int i = 0; i < notas.length; i++) {
                    do {
                        notas[i] = Integer.parseInt(insertarDatos("Nota "));
                    } while (notas[i] < 0 || notas[i] > 10);

                }

                // colocamos el puntero
                raf.seek((codigo - 1) * TAMANHOREGISTRO);
                //escribimos los valores
                raf.writeInt(codigo);
                raf.writeUTF(nombre);
                for (int i = 0; i < notas.length; i++) {
                    raf.writeInt(notas[i]);
                }

                respuesta = JOptionPane.showInputDialog("Desea continuar S/N");

            } while (respuesta.equalsIgnoreCase("s"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            raf.close();
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

    private static String insertarDatos(String string) {
        return JOptionPane.showInputDialog(string);
    }
}


