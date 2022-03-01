package Binario.Ejercicio_Binario;
import java.io.*;
import java.util.Random; // para utilizar la clase Random

public class Ejercicio02NumerosAleatorios {

	/*
	 * Hacer un programa que cree un fichero de nombre �resul.txt� 
	que contenga valores num�ricos 
	 * enteros obtenidos aleatoriamente. Una vez creado el fichero, el programa deber� mostrar su 
	 * contenido en pantalla.
	 */
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int opcion = 0;
		do{
			try{
				System.out.println("1.- Generar numero aleatorio");
				System.out.println("2.- Leer del fichero");
				System.out.println("3.- Salir");
				System.out.println("Elegir opcion: ");
				opcion = Integer.parseInt(br.readLine());
				
				switch (opcion){
				case 1:
					EscrituraDisco();
					break;
				case 2:
					LecturaDisco();
					break;
				}
	
			}catch(NumberFormatException e){
				System.out.println("Error al introducir la opcion");
			}catch(IOException ioe){
				System.out.println("Error al introducir la opcion");
			}
		}while(opcion != 3);
	}// fin main
	
	static void EscrituraDisco(){

		File archivo = new File ("Aleatoris.dat");
		DataOutputStream flujoescritura = null;
		String respuesta = new String();
		
		Random rnd = new Random();
				
		try{
			if (archivo.exists()){
				respuesta= introducirDatos("El fichero ya existe Desea sobreescribirlo (SI/NO)?");
			}
			//compareToIgnoreCase es que compare sin distinguir mayusculas y minusculas
			if (respuesta.compareToIgnoreCase("si")==0){
				flujoescritura = new DataOutputStream ( new FileOutputStream(archivo));
			}else{
				flujoescritura= new DataOutputStream (new FileOutputStream(archivo,true));
			}
	
			for(int i = 0; i<10; i++ ){
				// genera 10 numeros aleatorios entre 1 y 49
				flujoescritura.writeInt((int) (rnd.nextDouble()*49 + 1));
				System.out.println( (int) (rnd.nextDouble()*49 + 1));
			
			}
			}catch (IOException ioe){
				System.out.println("Nose ha podido escribir la informaci�n en el fichero " +archivo.getName());
			}finally{
				try{
					if (flujoescritura != null){
						flujoescritura.close();
					}
				}catch (IOException ioe){
					System.out.println("No se ha podido cerrar correctamente el flujo del fichero " + archivo.getName());
				}
		}

	}

	static void LecturaDisco(){

		File archivo = new File ("Aleatoris.dat");
		DataInputStream flujolectura = null;;
		
		try{
			System.out.println ("N�meros");
			flujolectura= new DataInputStream (new FileInputStream(archivo));
			
			while (true){
				System.out.println (flujolectura.readInt());
			}
		}catch (FileNotFoundException fnf){
			System.out.println("No se ha podido encontrar el fichero " +archivo.getName());
		}catch (EOFException eof){
		}catch (IOException ioe){
			System.out.println("No se ha podido leer la informaci�n del ficheroO " +archivo.getName());
		}finally{
			try{
				if (flujolectura!=null){
					flujolectura.close();
				}
			}catch (IOException ioe){
				System.out.println("Nose ha podido cerrar el flujo del fichero " + archivo.getName());
			}
		} //fin finally
	}// fin metodo
	
	// metodo para introducir datos desde el teclado
	static String introducirDatos(String mensaje){ 
		BufferedReader br = null;

		try {
			System.out.println("--------------------------------------------------------");
			System.out.print(mensaje);
			return (new BufferedReader(new InputStreamReader(System.in))).readLine();
		} catch (IOException ioe) {
			System.out.println("\nError interno en sistema de entrada/salida\n");
		}
		return "";
	} // fin del m�todo introducirDatos

}// fin de la clase
