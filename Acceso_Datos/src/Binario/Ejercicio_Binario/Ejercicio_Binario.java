package Binario.Ejercicio_Binario;

import java.io.*;
import java.util.Scanner;

/*Crea un programa que pida por teclado la ruta de un fichero y la cantidad de números
aleatorios que queremos generar. Los números generados se guardarán en el fichero usando
DataOutputStream, en otro método los leeremos del fichero utilizando DataInputStream y los
mostraremos en pantalla.
El rango de los números aleatorios estará entre 0 y 100, incluyendo el 100.
Cada vez que ejecutemos la aplicación añadiremos números al fichero sin borrar los anteriores,
es decir, si creo el fichero añadiendo 10 números y después añadimos otros 10, al final el
fichero habrá 20 números que se mostrarán por pantalla.*/

public class Ejercicio_Binario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la ruta del fichero: ");
        String ruta = sc.nextLine();

        System.out.println("Introduce la cantidad de números aleatorios que quieres introducir: ");
        int numero = sc.nextInt();

        escribirDatos(ruta, numero);
        leerFichero(ruta);
    }

    public static void escribirDatos(String ruta, int numero) {

        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream(ruta, true);
            dos = new DataOutputStream(fos);

            for (int i = 0; i < numero; i++) {
                dos.writeInt(generaNumerosAleatorios());
            }
        } catch (IOException e) {
            System.out.println("Fin de lectura");
        }
    }

    public static int generaNumerosAleatorios() {
        return (int) (Math.random() * 100) + 1;
    }

    public static void leerFichero(String ruta) {

        FileInputStream fis;
        DataInputStream dis;

        try {
            fis = new FileInputStream(ruta);
            dis = new DataInputStream(fis);
            int num = 0;

            while (true) {
                num = dis.readInt();
                System.out.println(num);
            }
        } catch (EOFException e) {
            System.out.println("Final del fichero");
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido encontrar el fichero");
        } catch (IOException e) {
            System.out.println("No se ha podido leer la información del fichero");
        }
    }
}