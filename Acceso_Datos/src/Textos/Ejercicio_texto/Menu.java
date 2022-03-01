package Textos.Ejercicio_texto;

import java.io.*;
import java.util.Scanner;

/*Codificar un programa en Java que muestre un menú con 3 opciones:
 En la primera deberá crear un fichero (con el nombre que se quiera) en el que
indicaremos en líneas diferentes tu nombre, tus apellidos, tu ciudad de nacimiento.
 En la segunda opción deberá mostrar por pantalla el contenido del fichero creado.
 En la tercera opción crearemos un fichero cuyo nombre y contenido introducimos por
teclado. Después de crear el fichero con la información introducida, se deberá mostrar
por pantalla el texto del fichero variando entre mayúsculas y minúsculas. Por ejemplo, si
escribo Bienvenidos a Vigo deberá mostrar bIENVENIDOS A vIGO.*/

public class Menu {

    static String nombreFichero;
    static String texto;

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);

        int op;

        do {
            System.out.println("1-Crear fichero");
            System.out.println("2-Mostrar contenido del fichero creado");
            System.out.println("3-Crear fichero y mostrar variando mayúsculas y minísculas");
            System.out.println("4-Salir");

            op = sc.nextInt();
            switch (op) {
                case 1: {
                    crearFicheroDatos();
                    break;
                }
                case 2: {
                    mostrarFicheroDatos();
                    break;
                }
                case 3: {
                    crearFichero();
                    String cadena = new String(devolverTexto());

                    char[] cadenaMinusculas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'q', 'l', 'm', 'n', 'ñ', 'o', 'p', 'k', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
                    char[] cadenaMaysculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'Q', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'K', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

                    invertirCadena(cadena, cadenaMinusculas, cadenaMaysculas);
                    break;
                }
            }
        } while (op != 4);
    }

    public static String solicitarFichero() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el nombre del fichero");
        nombreFichero = teclado.nextLine();
        return nombreFichero;
    }

    public static String devolverFichero() {
        return nombreFichero;
    }

    public static String solicitarTexto() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el contenido del fichero");
        texto = teclado.nextLine();
        return texto;
    }

    public static String devolverTexto() {
        return texto;
    }

    public static void crearFichero() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(solicitarFichero() + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            escribirFichero(pw);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void escribirFichero(PrintWriter pw) throws Exception {
        pw.println(solicitarTexto());

    }

    public static void invertirCadena(String cadena, char[] cadenaMinusculas, char[] cadenaMaysculas) {
        char[] cadenaFinal;
        cadenaFinal = cadena.toCharArray();

        char[] cadenaChar;
        cadenaChar = cadena.toCharArray();

        for (int i = 0; i < cadenaChar.length; i++) {

            for (int j = 0; j < cadenaMinusculas.length; j++) {
                if (cadenaChar[i] == cadenaMinusculas[j]) {
                    cadenaFinal[i] = cadenaMaysculas[j];
                }

                if (cadenaChar[i] == cadenaMaysculas[j]) {
                    cadenaFinal[i] = cadenaMinusculas[j];
                }
            }
        }
        System.out.println(cadenaFinal);
    }









    public static void mostrarFicheroDatos() {
        FileReader fr = null;
        try {
            File fichero = new File(devolverFichero() + ".txt");
            fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            leerFicheroDatos(br);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void crearFicheroDatos() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(solicitarFichero() + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            escribirFicheroDatos(pw);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void escribirFicheroDatos(PrintWriter pw) throws Exception {
        Scanner sc = new Scanner(System.in);
        String opcion;
        System.out.println("Introduce tu nombre");
        opcion = sc.nextLine();
        pw.println(opcion);
        System.out.println("Introduce tus apellidos");
        opcion = sc.nextLine();
        pw.println(opcion);
        System.out.println("Introduce tu ciudad de nacimiento");
        opcion = sc.nextLine();
        pw.println(opcion);
    }

    public static void leerFicheroDatos(BufferedReader br) throws Exception {
        String linea;
        linea = br.readLine();
        while (linea != null) {
            System.out.println(linea);
            linea = br.readLine();
        }
    }
}

