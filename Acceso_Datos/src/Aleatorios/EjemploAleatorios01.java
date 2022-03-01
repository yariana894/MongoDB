package Aleatorios;

import IntroducirDatos.IntroducirDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EjemploAleatorios01 {

    private static final int tamanhoRegistro = 80;
    static File f = new File ("Alumnos.dat");

    public static void main(String[] args) {

        int opcion = 0;

        do {
            System.out.println("1.- Nuevo Alumno (Insertar registros)");
            System.out.println("2.- Listado (Lista todos los registros. Secuencial)");
            System.out.println("3.- Consulta Alumno (Muestra el Alumno seleccionado)");
            System.out.println("4.- Modificar Alumnos (Modifica los datos del Alumno seleccionado)");
            System.out.println("5.- Salir");

            opcion = Integer.parseInt(IntroducirDatos.introducirDatos
                    ("Elegir opción: "));

            switch(opcion) {
                case 1:
                    insertarRegistros(f);
                    break;
                case 2:
                    listarFichero(f);
                    break;
                case 3:
                    //consultarRegistros(f);
                    consultarRegistros01(f);
                    break;
                case 4:
                    modificarRegistros(f);
                    break;
                case 5:
                    System.exit(0);
            }

        }while(opcion != 5);
    }

    private static void modificarRegistros(File f) {
        RandomAccessFile raf = null;
        int clave, nota, codigo;
        String nombre;

        try {
            raf = new RandomAccessFile(f, "rw");
            long numRegistros = f.length()/tamanhoRegistro;

            do {
                codigo = Integer.parseInt(IntroducirDatos.introducirDatos
                        ("Código: "));
                if(codigo > 0 && codigo < numRegistros + 1) {

                    raf.seek((codigo-1)*tamanhoRegistro);

                    clave = raf.readInt();
                    nombre = raf.readUTF();
                    nota = raf.readInt();

                    System.out.println(clave+"\t"+nombre+"\t"+nota);
                    String respuesta =
                            IntroducirDatos.introducirDatos("Modificar S/N: " );
                    if(respuesta.equalsIgnoreCase("S")) {

                        nombre = IntroducirDatos.introducirDatos("Nuevo nombre: ");
                        if(nombre.length() > 30)
                            nombre = nombre.substring(0, 30);
                        else
                            for(int i= nombre.length(); i < 30; i++)
                                nombre += " ";
                        nota = Integer.parseInt(IntroducirDatos.introducirDatos("Nota: "));

                        //recolar el puntero
                        raf.seek((codigo-1)* tamanhoRegistro);
                        //reesccribir los datos
                        raf.writeInt(codigo);
                        raf.writeUTF(nombre);
                        raf.writeInt(nota);
                    }
                }else
                    System.out.println("Código inexistente");
            }while(codigo != 0);
            raf.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }



    }

    private static void consultarRegistros01(File f) {
        RandomAccessFile raf = null;

        int clave = 0;
        String nombre;
        int nota;
        int codigo;

        try {
            raf = new RandomAccessFile(f, "r");
            long numRegistros = f.length()/tamanhoRegistro;

            do {
                codigo = Integer.parseInt(IntroducirDatos.introducirDatos
                        ("Código. <0 Fin>: "));
                if(codigo > 0 && codigo <= numRegistros+1) {
                    raf.seek((codigo-1)*tamanhoRegistro);
                    clave = raf.readInt();
                    nombre = raf.readUTF();
                    nota = raf.readInt();
                    if(clave != 0)
                        System.out.println(clave+"\t"+nombre+"\t"+nota);
                    else
                        System.out.println("Codigo inexistente");
                }else
                if(codigo != 0)
                    System.out.println("Código inexistente");

            }while(codigo != 0);
            raf.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }

    }

    private static void consultarRegistros(File f) {
        // TODO Auto-generated method stub
        RandomAccessFile raf = null;

        int clave = 0;
        String nombre;
        int nota;
        int codigo;

        try {
            raf = new RandomAccessFile(f, "r");
            long numRegistros = f.length()/tamanhoRegistro;

            do {
                codigo = Integer.parseInt(IntroducirDatos.introducirDatos
                        ("Código. <0 Fin>: "));

                if((codigo-1) > numRegistros) {
                    System.out.println("Código inexistente");
                }else {
                    if(codigo != 0) {

                        raf.seek((codigo-1)*tamanhoRegistro);
                        clave = raf.readInt();
                        nombre = raf.readUTF();
                        nota = raf.readInt();
                        if(clave != 0)
                            System.out.println(clave+"\t"+nombre+"\t"+nota);
                        else
                            System.out.println("Codigo inexistente");
                    }
                }

            }while(codigo != 0);
            raf.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }

    }

    private static void listarFichero(File f) {
        // vamos a tratarb el fichero de forma secuencial
        // vamos a leer todos los registros

        RandomAccessFile raf = null;

        int clave = 0;
        String nombre;
        int nota;

        try {
            raf = new RandomAccessFile(f, "r");

            long numRegistros = f.length() / tamanhoRegistro;

            for(int i=0; i<= numRegistros; i++) {
                raf.seek(i * tamanhoRegistro);
                clave = raf.readInt();
                nombre = raf.readUTF();
                nota = raf.readInt();
                if(clave != 0)
                    System.out.println(clave+"\t"+nombre+"\t"+nota);

            }
            raf.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch(IOException io) {
            io.printStackTrace();
        }
    }

    private static void insertarRegistros(File f) {
        RandomAccessFile raf = null;

        int clave = 0;
        String nombre;
        int nota;
        String respuesta = "s";

        try {
            raf = new RandomAccessFile(f, "rw");
            do {


                clave = Integer.parseInt(IntroducirDatos.introducirDatos
                        ("Código Alumno: "));
                nombre = IntroducirDatos.introducirDatos("Nombre: ");

                do {
                    nota = Integer.parseInt(IntroducirDatos.introducirDatos
                            ("Nota: "));
                }while (nota < 0 || nota > 10);

                //colocar el puntero en la posición donde vamos a escribir

                raf.seek((clave-1) * tamanhoRegistro);
                raf.writeInt(clave);
                if(nombre.length() >=30) {
                    nombre = nombre.substring(0, 30);
                }else {
                    for(int i = nombre.length(); i<= 30; i++) {
                        nombre +=" ";
                    }
                }
                raf.writeUTF(nombre);
                raf.writeInt(nota);
                respuesta = IntroducirDatos.introducirDatos("Desea continuar S/N ");

            }while(respuesta.equalsIgnoreCase("s"));
            raf.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}


