package z_EXAMENES.SolucionExamenUD01.GrupoViernes;

import IntroducirDatos.IntroducirDatos;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

class PacienteAleatorio {

	// atributos
	private static final int TAMANHOREGISTRO = 148;
	
	private static final int LONGMAX = 30; // // longitud m�xima de los String 
													
	private static final int LONGFECHA = 16; // longitud m�xima de la fecha
	
	private static int codigo ;
	private static String nombre;
	private static String direccion ;
	private static int telefono ;
	private static String fecha ;
	private static int privado ;
	private static int alergias;
	
	static RandomAccessFile raf = null;
	
	public static void main(String[] args) {

//		C:\Users\34655\Documents\EjemplosFicheros\Paceintes.Dat
		//	File f = new File(JOptionPane.showInputDialog("Ruta completa del fichero: "));
			
			File f = new File("C:\\Users\\DAM2\\Desktop\\YARI\\Acceso_Datos\\Pacientes.dat");
		// Declaraciones
		int opcion = 0;

		do {
			// Men�
			
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"1.-Altas Pacientes\n"
					+ "2.-Modificar Pacientes \n"
					+ "3.- Listado completo Pacientes\n"
					+ "4.- Listado Privados o SS\n"
					+ "5.- Consultas por c�digo\n"
					+ "6.- Listado Pacientes con Alergias\n"
					+ "7.-Salir\n\nElija una opci�n: "));
			switch(opcion) {
			case 1:
				altasPacientes(f);
				break;
			case 2:
				modificarPacientes(f);
				break;
			case 3:
				listadoPacientes(f);
				break;
			case 4:
				listadoPrivados(f);
				break;
			case 5:
				consultarPaciente(f);
				break;
			case 6:
				listadoAlergias(f);
				break;
			case 7:
				System.exit(0);
			}
		}while(opcion != 7);
	}// fin main

	private static void listadoAlergias(File f) {
		int numRegistros = 0;
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Listas Pacientes \n"
				+ "0.- Al�rgicos\n"
				+ "1.- No al�rgicos"));
		try {
			raf = new RandomAccessFile(f, "r"); 
			
			numRegistros = (int) (raf.length()/TAMANHOREGISTRO);
			
			for(int i = 0; i <= numRegistros; i++) {
				raf.seek(i * TAMANHOREGISTRO);
				codigo = raf.readInt();
				if(codigo != 0) {
					nombre = raf.readUTF();
					direccion = raf.readUTF();
					telefono = raf.readInt();
					fecha = raf.readUTF();
					privado = raf.readInt();
					alergias = raf.readInt();
					if(privado == 0)
						System.out.println(codigo +"\t"+ nombre +"\t"+direccion+"\t"+telefono
							+"\t"+fecha+"\t"+privado+"\t"+alergias	);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void consultarPaciente(File f) {
		int codigo=0;
		String nombre="";
		int edad=0;
		
		int numRegistros = 0;
		try {
			// abriendo archivo, capturando datos
			raf = new RandomAccessFile (f,"r");


			codigo = Integer.parseInt(JOptionPane.showInputDialog("Introducir la clave. "
					+ "< 0 para Finalizar>: "));
			while(codigo != 0){
				numRegistros = (int) (raf.length()/TAMANHOREGISTRO);
				if(codigo > numRegistros) {
					System.out.println("Registro no existe");
				}else {

					//colocamos el puntero seg�n la clave
					raf.seek((codigo-1) * TAMANHOREGISTRO);

					//leemos los campos del registro
					codigo = raf.readInt();
					if(codigo != 0){
						nombre = raf.readUTF();
						direccion = raf.readUTF();
						telefono = raf.readInt();
						fecha = raf.readUTF();
						privado = raf.readInt();
						alergias = raf.readInt();

						//visualizamos los datos
						System.out.println(codigo +"\t"+ nombre +"\t"+direccion+"\t"+telefono
								+"\t"+fecha+"\t"+privado+"\t"+alergias	);
					}else
						System.out.println("El registro no existe");
				}
				codigo = Integer.parseInt(JOptionPane.showInputDialog("Introducir la clave. < 0 para Finalizar>: "));

			}// fin while
		}catch(NumberFormatException nfe){
			System.out.println("Error al introducir los datos");
		}catch (IOException ioe) { 
			System.out.println("Error de posicionamiento o lectura");
			System.out.println(ioe.getMessage());
		}finally{
			try{
				raf.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}

	private static void listadoPrivados(File f) {
		int numRegistros = 0;
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Listas Pacientes \n"
				+ "0.- Privados\n"
				+ "1.- S.S."));
		try {
			raf = new RandomAccessFile(f, "r"); 
			
			numRegistros = (int) (raf.length()/TAMANHOREGISTRO);
			
			for(int i = 0; i <= numRegistros; i++) {
				raf.seek(i * TAMANHOREGISTRO);
				codigo = raf.readInt();
				if(codigo != 0) {
					nombre = raf.readUTF();
					direccion = raf.readUTF();
					telefono = raf.readInt();
					fecha = raf.readUTF();
					privado = raf.readInt();
					alergias = raf.readInt();
					if(privado == 0)
						System.out.println(codigo +"\t"+ nombre +"\t"+direccion+"\t"+telefono
							+"\t"+fecha+"\t"+privado+"\t"+alergias	);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void listadoPacientes(File f) {
		int numRegistros = 0;
		try {
			raf = new RandomAccessFile(f, "r"); 
			
			numRegistros = (int) (raf.length()/TAMANHOREGISTRO);
			
			for(int i = 0; i <= numRegistros; i++) {
				raf.seek(i * TAMANHOREGISTRO);
				codigo = raf.readInt();
				if(codigo != 0) {
					nombre = raf.readUTF();
					direccion = raf.readUTF();
					telefono = raf.readInt();
					fecha = raf.readUTF();
					privado = raf.readInt();
					alergias = raf.readInt();
					System.out.println(codigo +"\t"+ nombre +"\t"+direccion+"\t"+telefono
							+"\t"+fecha+"\t"+privado+"\t"+alergias	);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void modificarPacientes(File f) {
		int codigo=0;
	
		String respuesta = "";
	
		
		try {
			// abriendo archivo, capturando datos
			raf = new RandomAccessFile (f,"rw");

			codigo = Integer.parseInt(JOptionPane.showInputDialog("Introducir la clave "
					+ "a modificar. < 0 para Finalizar>: "));
			while(codigo != 0){
				//colocamos el puntero seg�n la clave para leer el registro
				raf.seek((codigo-1) * TAMANHOREGISTRO);

				//leemos los campos del registro
				codigo = raf.readInt();
				if(codigo != 0) {
					nombre = raf.readUTF();
					direccion = raf.readUTF();
					telefono = raf.readInt();
					fecha = raf.readUTF();
					privado = raf.readInt();
					alergias = raf.readInt();

					System.out.println(codigo +"\t"+ nombre +"\t"+direccion+"\t"+telefono
							+"\t"+fecha+"\t"+privado+"\t"+alergias	);
				}	

				respuesta = JOptionPane.showInputDialog(("Desea modificar el registro. S/N"));
				if (respuesta.equalsIgnoreCase("s") ){
					nombre = comprobarLongitud(insertarDatos("Nombre: "), LONGMAX);
					
					direccion = comprobarLongitud(insertarDatos("Direccion: "), LONGMAX);
					telefono = Integer.parseInt(insertarDatos("Telefono: "));
					fecha = comprobarLongitud(insertarDatos("Ultima visita (dd/mm/aa): "), LONGFECHA);
					do {
						privado =  Integer.parseInt(insertarDatos("0.- Privado, 1- S.S."));
					}while(privado != 1 && privado != 0);
					do {
						alergias =  Integer.parseInt(insertarDatos("0.- Al�rgico, 1- No al�rgico."));
					}while(alergias != 1 && alergias != 0);
					
					// colocamos el puntero
					raf.seek((codigo-1) * TAMANHOREGISTRO);
					//escribimos los valores
					raf.writeInt(codigo);
					raf.writeUTF(nombre);
					raf.writeUTF(direccion);
					raf.writeInt(telefono);
					raf.writeUTF(fecha);
					raf.writeInt(privado);
					raf.writeInt(alergias);
					
				}
				codigo = Integer.parseInt(IntroducirDatos.introducirDatos("Introducir la clave. < 0 para Finalizar>: "));
			}// fin while
		}catch(NumberFormatException nfe){
			System.out.println("Error al introducir los datos");
		}catch (IOException ioe) { 
			System.out.println("Error de posicionamiento o lectura");
			System.out.println(ioe.getMessage());
		}finally{
			try{
				raf.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}

	private static void altasPacientes(File f) {
		try {
			raf = new RandomAccessFile(f, "rw");
			
			String respuesta = null;
			do {
				codigo = Integer.parseInt(insertarDatos("C�digo: "));
				nombre = comprobarLongitud(insertarDatos("Nombre: "), LONGMAX);
				
				direccion = comprobarLongitud(insertarDatos("Direccion: "), LONGMAX);
				telefono = Integer.parseInt(insertarDatos("Telefono: "));
				fecha = comprobarLongitud(insertarDatos("Ultima visita (dd/mm/aa): "), LONGFECHA);
				do {
					privado =  Integer.parseInt(insertarDatos("0.- Privado, 1- S.S."));
				}while(privado != 1 && privado != 0);
				do {
					alergias =  Integer.parseInt(insertarDatos("0.- Al�rgico, 1- No al�rgico."));
				}while(alergias != 1 && alergias != 0);
				
				// colocamos el puntero
				raf.seek((codigo-1) * TAMANHOREGISTRO);
				//escribimos los valores
				raf.writeInt(codigo);
				raf.writeUTF(nombre);
				raf.writeUTF(direccion);
				raf.writeInt(telefono);
				raf.writeUTF(fecha);
				raf.writeInt(privado);
				raf.writeInt(alergias);
				
				respuesta = JOptionPane.showInputDialog("Desea continuar S/N");
				
			}while(respuesta.equalsIgnoreCase("s"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static String comprobarLongitud(String nombre, int longmax) {
		
		if(nombre.length() > longmax)
			nombre=nombre.substring(0,longmax);
		else {
			for(int i=nombre.length(); i <longmax; i++)
				nombre=nombre+" ";
		}
			
		return nombre;
	}

	private static String insertarDatos(String string) {
		return JOptionPane.showInputDialog(string);
	}
	
	
		
}	
	
