package Binario.Ejercicio_Binario;

import java.io.*;

import javax.swing.JOptionPane;

public class SolNumerosAleatorios {

	/*
	 * Crea un programa que pida por teclado la ruta de un fichero y la cantidad de n�meros aleatorios que queremos generar. 
	 * Los n�meros generados se guardar�n en el fichero usando DataOutputStream, en otro m�todo los leeremos del fichero 
	 * utilizando DataInputStream y los  mostraremos en pantalla.
		El rango de los n�meros aleatorios estar� entre 0 y 100, incluyendo el 100.
		Cada vez que ejecutemos la aplicaci�n a�adiremos n�meros al fichero sin borrar los anteriores, es decir, 
		si creo el fichero a�adiendo 10 n�meros y despu�s a�adimos otros 10, al final el fichero habr� 20 n�meros 
		que se mostrar�n por pantalla.

	 */
	public static void main(String[] args) {
		
		String ruta = JOptionPane.showInputDialog("Escribe la ruta del fichero: ");
		int  numeros = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de n�meros aleatorios:"));
		
		escribeFichero(ruta, numeros);
		leeFichero(ruta);
	}

	private static void leeFichero(String ruta) {

		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(ruta));
			
			while(true)
				System.out.println(dis.readInt());
			
		} catch(EOFException eof) {
			System.out.println("Fin del fichero");
	}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void escribeFichero(String ruta, int numeros) {
		
			try {
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta, true));
				for(int i = 0; i < numeros; i++) {
					int numAleatorio = generarNumerosAleatorios();
					dos.writeInt(numAleatorio);
				}
				dos.flush();		// guardar los cambios
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
		
	}

	private static int generarNumerosAleatorios() {
		int numero = (int)Math.floor(Math.random()*101);
		return numero;
	}

}
