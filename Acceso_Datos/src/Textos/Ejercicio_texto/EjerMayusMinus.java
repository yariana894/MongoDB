package Textos.Ejercicio_texto;

import IntroducirDatos.IntroducirDatos;

import java.io.*;

/*
 * Codificar un programa en Java que muestre un men� con 3 opciones:
 En la primera deber� crear un fichero (con el nombre que se quiera) en el que indicaremos en l�neas diferentes tu nombre, 
tus apellidos, tu ciudad de nacimiento.
En la segunda opci�n deber� mostrar por pantalla el contenido del fichero creado.
 En la tercera opci�n crearemos un fichero cuyo nombre y contenido introducimos por teclado. 
Despu�s de crear el fichero con la informaci�n introducida, se deber� mostrar por pantalla el texto del 
fichero variando entre may�sculas y min�sculas. Por ejemplo, si escribo Bienvenidos a Vigo deber� mostrar bIENVENIDOS A vIGO.
 */

public class EjerMayusMinus {
	
	static String nbFichero;
	
	public static void main(String[] args) {
		
		nbFichero = IntroducirDatos.introducirDatos("Introduce el nombre del fichero. (Ruta completa): ");
		
		int opcion = 0;
		do{
			try{
				System.out.println("1.- Crear fichero Lineas");
				System.out.println("2.- Leer del fichero Lineas");
				System.out.println("3.- Crear Fichero. Mayus Minus");
				System.out.println("4.- Salir");
			
				opcion = Integer.parseInt(IntroducirDatos.introducirDatos("Elegir una opci�n: "));

				switch (opcion){
				case 1:
					crearFicheroLineas();
					break;
				case 2:
					LecturaFicheroLineas();
					break;
				case 3:
					LeerFicheroMayusMinus();
					break;
				case 4:
					System.exit(0);
				default:
					System.out.println("Error en la opci�n");
				}

			}catch(NumberFormatException e){
				System.out.println("Error al introducir la opcion");
			}
		}while(opcion != 4);
	}// fin main

	private static void LeerFicheroMayusMinus() {
		FileReader fr = null;
		
		int caracter; // se guarda cada caracter leido
		
		try {
			fr = new FileReader(nbFichero);
			
			while((caracter = fr.read()) != -1) {
				if((char)caracter >= 97 && (char)caracter <= 122)
					caracter -=32;
				else if((char)caracter >= 65 && (char)caracter <=90)
					caracter +=32;
				
				System.out.println((char)caracter);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

	private static void LecturaFicheroLineas() {
		FileReader fr = null;
		BufferedReader br = null;

	
		
		String linea;
		
		try {
			fr = new FileReader(nbFichero);
			br = new BufferedReader(fr);
			
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
			e.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	private static void crearFicheroLineas() {
		FileWriter fw = null;
		
		String nombre =  null;
		String apellidos =  null;
		String ciudad = null;

		try {
			fw = new FileWriter(nbFichero, true);

			while(!(nombre = IntroducirDatos.introducirDatos("Nombre. <F> Para finalizar: ")).equalsIgnoreCase("F")) {

				fw.write(nombre);
				fw.write("\n");
				
				apellidos = IntroducirDatos.introducirDatos("Apellidos: ");
				ciudad = IntroducirDatos.introducirDatos("Ciudada: ");
				fw.write(apellidos);
				fw.write("\n");
				fw.write(ciudad);
				fw.write("\n");
			} }
		catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}
