package Enunciado;

import IntroducirDatos.IntroducirDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio4 {

    private static final int tamanhoRegistro = 80;

    public static void main(String[] args) {
        File f = new File("Alumnos.dat");
        int opcion = 0;

        do {
            System.out.println("1.- Insertar nuevo alumno");
            System.out.println("2.- Listado alumnos");
            System.out.println("3.- Modificar alumnos");
            System.out.println("4.- Consultar alumno determinado");

            opcion = Integer.parseInt(IntroducirDatos.introducirDatos("Elegir opción: "));

            switch (opcion) {
                case 1:
                    insertarRegistros(f);
                    break;
                case 2:
                    listarRegistros(f);
            }
        } while (opcion != 4);
    }

    public static void listarRegistros(File f) {
        RandomAccessFile raf = null;

        int codigo = 0;
        String nombre;
        int notaAccesoDatos, notaInterfaces, notaMultimedia, notaServicios, notaSistemas, notaEmpresa;

        try {
            raf = new RandomAccessFile(f, "r");
            long numRegistros = f.length() / tamanhoRegistro;

            for (int i = 0; i <= numRegistros; i++) {
                raf.seek(i * tamanhoRegistro);
                codigo = raf.readInt();
                nombre = raf.readUTF();
                notaAccesoDatos = raf.readInt();
                notaMultimedia = raf.readInt();
                notaEmpresa = raf.readInt();
                notaInterfaces = raf.readInt();
                notaSistemas = raf.readInt();
                notaServicios = raf.readInt();

                if (codigo != 0)
                    System.out.println(codigo + "\t" + nombre + "\t" + notaAccesoDatos
                            + "\t" + notaMultimedia + "\t" + notaEmpresa + "\t" + notaInterfaces
                            + "\t" + notaSistemas + "\t" + notaServicios);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertarRegistros(File f) {

        RandomAccessFile raf = null;

        int codigo = 0;
        String nombre;
        int notaAccesoDatos, notaInterfaces, notaMultimedia, notaServicios, notaSistemas, notaEmpresa;
        String respuesta = "s";

        try {
            do {
                codigo = Integer.parseInt(IntroducirDatos.introducirDatos("Código alumno: "));
                nombre = IntroducirDatos.introducirDatos("Nombre alumno: ");

                do {
                    notaAccesoDatos = Integer.parseInt(IntroducirDatos.introducirDatos("Nota Acceso Datos:"));
                } while (notaAccesoDatos < 0 || notaAccesoDatos > 10);

                do {
                    notaInterfaces = Integer.parseInt(IntroducirDatos.introducirDatos("Nota Interfaces:"));
                } while (notaInterfaces < 0 || notaInterfaces > 10);

                do {
                    notaMultimedia = Integer.parseInt(IntroducirDatos.introducirDatos("Nota Multimedia:"));
                } while (notaMultimedia < 0 || notaMultimedia > 10);

                do {
                    notaServicios = Integer.parseInt(IntroducirDatos.introducirDatos("Nota Servicios:"));
                } while (notaServicios < 0 || notaServicios > 10);

                do {
                    notaSistemas = Integer.parseInt(IntroducirDatos.introducirDatos("Nota Sistemas:"));
                } while (notaSistemas < 0 || notaSistemas > 10);

                do {
                    notaEmpresa = Integer.parseInt(IntroducirDatos.introducirDatos("Nota Empresa:"));
                } while (notaEmpresa < 0 || notaEmpresa > 10);


                raf.seek((codigo - 1) * tamanhoRegistro);
                raf.writeInt(codigo);
                raf.writeUTF(nombre);
                raf.writeInt(notaAccesoDatos);
                raf.writeInt(notaMultimedia);
                raf.writeInt(notaEmpresa);
                raf.writeInt(notaSistemas);
                raf.writeInt(notaInterfaces);
                raf.writeInt(notaServicios);

                respuesta = IntroducirDatos.introducirDatos("Desea continuar: s/n");

            } while (respuesta.equalsIgnoreCase("s"));
            raf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
