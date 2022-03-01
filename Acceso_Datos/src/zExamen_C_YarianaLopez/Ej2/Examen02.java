package zExamen_C_YarianaLopez.Ej2;


import java.io.*;
import java.util.Objects;

public class Examen02 {
    public static void main(String[] args) {

        File f = new File("Animales.dat");
        int opcion = 0;

        do {
            System.out.println("1.- Insertar Animal");
            System.out.println("2.- Listado Completo");
            System.out.println("3.- Listado animales Zoo determinado");
            System.out.println("4.- Salir");

            try {
                opcion = Integer.parseInt(introducirDatos("Elegir opcion: "));
                switch (opcion) {
                    case 1:
                        comprobarExistenciaFichero(f);
                        break;
                    case 2:
                        listadoCompleto(f);
                    case 3:
                        listadoZoo(f);
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Opcion erronea");
                }// fin switch
            } catch (NumberFormatException e) {
                System.out.println("La opcion tiene que ser un numero");
            }

        } while (opcion != 4);

    }// fin Main

    private static void listadoZoo(File f) {
        String m = introducirDatos("Introduce el zoo que quiere listar: ");

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (true) {
                Animal animal;
                animal = (Animal) ois.readObject();
                if (Objects.equals(animal.getNbZoo(), m))
                    System.out.println(animal);
            }

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();

        } catch (
                IOException e) {
            System.out.println("Fin de la lectura");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void comprobarExistenciaFichero(File f) {

        if (f.exists())
            existeFichero(f);
        else
            nuevoFichero(f);
    }

    private static void listadoCompleto(File f) {
        System.out.println("\t\tListado Animales");
        System.out.println("CODIGO\t\tESPECIE\t\tSEXO\t\tANHO NACIMIENTO\t\tPAIS ORIGEN\t\tNB ZOO");

        Animal animal = new Animal();
        animal.listadoCompleto(f);

    }

    private static void existeFichero(File f) {
        FileOutputStream fos = null;
        MiObjectOutputStream salida = null;

        int codigo;
        boolean respuesta = false;
        try {

            fos = new FileOutputStream(f, true);
            salida = new MiObjectOutputStream(fos);

            Animal animal = new Animal();
            codigo = Integer.parseInt(introducirDatos("Introducir el codigo del articulo <0> para fin:"));

            while (codigo != 0) {
                respuesta = animal.buscarAnimal(codigo, f);

                if (respuesta)
                    System.out.println(codigo + " Existente");
                else {
                    animal = introducirAnimal(codigo);
                    salida.writeObject(animal);
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
    }

    public static void nuevoFichero(File f) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        int codigo;

        boolean respuesta = false;

        try {
            fos = new FileOutputStream(f);
            salida = new ObjectOutputStream(fos);

            Animal animal = new Animal();
            codigo = Integer.parseInt(introducirDatos("Introducir el codigo del articulo <0> para fin:"));

            while (codigo != 0) {
                respuesta = animal.buscarAnimal(codigo, f);
                if (respuesta)
                    System.out.println(codigo + " Existente");
                else {
                    animal = introducirAnimal(codigo);
                    salida.writeObject(animal);
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


    private static Animal introducirAnimal(int codigo) {

        Animal animal = new Animal();
        String especie = introducirDatos("Especie: ");
        String sexo = introducirDatos("Sexo: ");
        int anhoNac = Integer.parseInt(introducirDatos("Anhho Nacimiento: "));
        String paisOri = introducirDatos("Pais Origen: ");
        String nbZoo = introducirDatos("Nb Zoo: ");

        animal.setCodigo(codigo);
        animal.setEspecie(especie);
        animal.setSexo(sexo);
        animal.setAnhoNacimiento(anhoNac);
        animal.setPaisOrigen(paisOri);
        animal.setNbZoo(nbZoo);

        return animal;
    }

    //IntroducirDatos
    public static String introducirDatos(String s) {
        try {
            System.out.print(s);
            return (new BufferedReader(new InputStreamReader(System.in))).readLine();
        } catch (IOException ioe) {
            System.out.println("\nError interno en sistema de entrada/salida\n");
        }
        return "";

    }// fin introducirDatos


}
