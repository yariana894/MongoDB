package z_EXAMENES.SolucionExamenUD01.GrupoViernes;

import java.io.*;

import javax.swing.JOptionPane;

/*
 * Crear una aplicaci�n que guarde en un fichero el contenido de otros dos ficheros, 
 * de tal forma que en el fichero resultante aparezcan las l�neas de los primeros dos ficheros 
 * mezcladas, es decir, la primera l�nea ser� del primer fichero, la segunda ser� del segundo fichero, 
 * la tercera ser� la siguiente del primer fichero, etc. 
Los nombres de los dos ficheros origen y el nombre del fichero destino se introducir�n por teclado. 
Hay que tener en cuenta que los ficheros de donde se van cogiendo las l�neas pueden tener tama�os diferentes.
El programa deber� estar estructurado y controlar las excepciones que puedan aparecer.
 */

public class FusionFicheros {

	public static void main(String[] args) {
		File f1 = null;
		File f2 = null;
		File f3 = null;
		do {
			String ruta1 = introducirRuta("Ruta completa del primer fichero: ");
			//Creamos objetos File
			f1 = new File(ruta1);

		}while(!f1.exists());

		do {
			String ruta2 = introducirRuta("Ruta completa del segundo fichero: ");
			f2 = new File(ruta2);
		}while(!f2.exists());

		String ruta3 = introducirRuta("Ruta completa del tercer fichero: ");

		f3 = new File(ruta3);

		int respuesta = 1;
		if(f3.exists()) {
			respuesta = JOptionPane.showConfirmDialog(null, "Fichero existente. Sobrescribir el fichero?",
					"Informacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}else
			fusionFicheros(f1, f2, f3);

	}

	private static void fusionFicheros(File f1, File f2, File f3) {
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(f1));
			BufferedReader br2 = new BufferedReader(new FileReader(f2));
			BufferedWriter bw = new BufferedWriter(new FileWriter(f3));

			String linea1 = "";
			String linea2 = "";

			while ( (linea1 != null) || (linea2 != null) ) {
				linea1 = br1.readLine();
				linea2 = br2.readLine();

				if (linea1 != null) {
					bw.write(linea1 + "\n");
				}

				if (linea2 != null) {
					bw.write(linea2 + "\n");
				}
			} 

			br1.close();
			br2.close();
			bw.close();

		} catch (IOException ioe) {
			System.out.println("Se ha producido un error de lectura/escritura");
			System.err.println(ioe.getMessage());
		}


	}

	private static String introducirRuta(String string) {

		return JOptionPane.showInputDialog(string);
	}

}
