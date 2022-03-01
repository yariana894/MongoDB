package Objetos.ej04;

import IntroducirDatos.IntroducirDatos;

import java.io.*;

public class ej04 {

    public static FileOutputStream fos;
    public static ObjectOutputStream oos;
    public static FileInputStream fis = null;
    public static ObjectInputStream ois = null;

    public static String fichero = "Coches.dat";
    public static File f = new File(fichero);

    public static void main(String[] args) throws IOException {

        addEntry();
        readData();
        readMarca();
        listado();

    }

    public static void addEntry() {
        if (f.exists()) {
            appendData();
        } else {
            addData();
        }
    }

    public static void addData() {

        try {
            fos = new FileOutputStream(f, true);
            oos = new ObjectOutputStream(fos);

            coches c = createCar();

            oos.writeObject(c);

            fos.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void appendData() {

        try {
            fos = new FileOutputStream(f, true);
            Overwrite ow = new Overwrite(fos);

            coches c = createCar();

            ow.writeObject(c);

            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static coches createCar() {
        coches cAdd = new coches(IntroducirDatos.introducirDatos("Introduce la matricula: "),
                IntroducirDatos.introducirDatos("Introduce la marca: "),
                IntroducirDatos.introducirDatos("Modelo: "),
                Integer.parseInt(IntroducirDatos.introducirDatos("Introduce el tamaño del deposito: ")),
                Integer.parseInt(IntroducirDatos.introducirDatos("Introduce el precio: ")));
        return cAdd;
    }


    public static void readData() throws IOException {
        try {
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);

            while (true) {
                coches c;
                c = (coches) ois.readObject();
                System.out.println(c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Fin de la lectura");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readMarca() {

        String marca = IntroducirDatos.introducirDatos("Introduce la marca: ");

        try {
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);

            while (true) {
                coches c;
                c = (coches) ois.readObject();
                if (c.getMarca().equals(marca)) {
                    System.out.println(c);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Fin de la lectura");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void listado() {

        try {
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);

            while (true) {
                coches c;
                c = (coches) ois.readObject();
                String result = c.toString();
                System.out.println((result.substring(0, result.length() - 1) + addPrice(c)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Fin de la lectura");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String addPrice(coches c) {
        double precio = c.getPrecio();
        double iva = 0.21;
        double ivaCoche = precio * iva;
        double precioConIva = precio + ivaCoche;

        return (", ivaCoche=" + ivaCoche + ", precioConIva=" + precioConIva + "}");
    }
}