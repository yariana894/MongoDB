package z_EXAMENES.SolucionExamenUD01.GrupoViernes.ficherosObjetosAlumnos;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
	
	//	C:\Users\34655\Documents\EjemplosFicheros\Alumnos.Data
	//	File f = new File(JOptionPane.showInputDialog("Ruta completa del fichero: "));
		
		File f = new File("C:\\Users\\34655\\Documents\\EjemplosFicheros\\Alumnos.Data");
		
		int opcion = 0;// LO USAREMOS PARA EL MENU CON UN DOWHILE
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("1.- Introducir estudiante.\n"
					+ "2.- Listar estudiantes.\n"
					+ "3.- Listar estudiantes aprobados(media superior a 5).\n"
					+ "4.- Listar alumnos con todas las asignaturas aprobadas.\n"
					+ "5.- Salir del programa.\n"
					+ "Elija opci�n"));

			switch (opcion) {
			case 1:
				if (f.exists())
					insertarEstudianteExiste(f);
				else
					insertarEstudiante(f);
				break;
			case 2:
				listarEstudiantes(f);
				break;
			case 3:
				listarAprobados(f);
				break;
			case 4:
				listarTodasAsignaturasAprobadas(f);
				break;
			case 5:
				System.out.println("Saliendo.... out.");
				System.exit(0);
			}

		} while (opcion != 6);

	}

	private static void listarTodasAsignaturasAprobadas(File f) {
		// VARIABLES
				FileInputStream fis = null;
				ObjectInputStream ois = null;

				try {
					fis = new FileInputStream(f);
					ois = new ObjectInputStream(fis);
					
					listadoCabecera("Listado Alumnos con todos los m�dulos aprobados");
					// INTANCIAMOS LA CLASE
					Alumno alumno = new Alumno();

					while (true) {
						alumno = (Alumno) ois.readObject();
						int aprobado = 5;
						if(alumno.getNotaAccesoDatos() >=aprobado && alumno.getNotaEmpresa() >=aprobado && alumno.getNotaInterfaces() >=aprobado &&  alumno.getNotaMultimedia() >=aprobado && alumno.getNotaServicios() >=aprobado && alumno.getNotaSistemasGestion() >= aprobado ) {
							listadoAlumno(alumno);
						}else {
							
						}
					}
				} catch (EOFException e) {
					System.out.println("Fin de lectura. ");

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		try {
			ois.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void listadoAlumno(Alumno alumno) {
		System.out.println(alumno.getNombre()+"\t\t"+alumno.getNotaAccesoDatos()+"\t\t"+
				alumno.getNotaInterfaces()+"\t\t"+alumno.getNotaMultimedia()+"\t\t"+
				alumno.getNotaServicios()+"\t\t"+alumno.getNotaSistemasGestion()+"\t\t"+
				alumno.getNotaEmpresa()+"\t\t"+
				(alumno.getNotaAccesoDatos()+alumno.getNotaEmpresa()+alumno.getNotaInterfaces()
				+alumno.getNotaMultimedia()+alumno.getNotaServicios()+alumno.getNotaSistemasGestion())/6);
		
	}

	private static void listadoCabecera(String string) {
		System.out.println(string);
		System.out.println("___________________________________________________________");
		System.out.println("Alumno\t\tAcceso Datos\t\tInterfaces\t\tMultimedia\t\tServicios"
				+ "\t\tSistemas Gesti�n\t\tEmpresa\t\tMedia");
		
	}

	private static void listarAprobados(File f) {
		
		// VARIABLES
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			listadoCabecera("Listado Alumnos con la Media superior a 5");
			
			
			// INTANCIAMOS LA CLASE
			Alumno alumno = new Alumno();

			while (true) {
				alumno = (Alumno) ois.readObject();
				int notaMedia = (alumno.getNotaAccesoDatos()+alumno.getNotaEmpresa()+alumno.getNotaInterfaces()+alumno.getNotaMultimedia()+alumno.getNotaServicios()+alumno.getNotaSistemasGestion())/6;
				if(notaMedia>=5)
					listadoAlumno(alumno);
			}
		} catch (EOFException e) {
			System.out.println("Fin de lectura. ");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ois.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	private static void insertarEstudianteExiste(File f) {
		FileOutputStream fos = null;
		MiObjectOutputStream mos = null;

		try {
			fos = new FileOutputStream(f, true);
			mos = new MiObjectOutputStream(fos);

			// INSTANCIAMOS LA CLASE alumno, lo creamos y guardamos en el fichero
			Alumno alumno = crearAlumno();

			mos.writeObject(alumno);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			mos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static Alumno crearAlumno() {
		Alumno alumno = new Alumno(
				JOptionPane.showInputDialog("Nombre: "),
				Integer.parseInt(JOptionPane.showInputDialog("Nota AccesoDatos: ")),
				Integer.parseInt(JOptionPane.showInputDialog("Nota Interfaces: ")),
				Integer.parseInt(JOptionPane.showInputDialog("Nota Multimedia: ")),
				Integer.parseInt(JOptionPane.showInputDialog("Nota Servicios: ")),
				Integer.parseInt(JOptionPane.showInputDialog("Nota Sistemas de Gesti�n: ")),
				Integer.parseInt(JOptionPane.showInputDialog("Empresa: ")));
		return alumno;
	}

	private static void listarEstudiantes(File f) {
		// VARIABLES PARA LECTURA
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		int numAlumnos = 0; //contador alumnos
		int sumAcc =0, sumInt = 0, sumMul = 0, sumSer = 0, sumSis = 0, sumEmp = 0; //acumuladores notas

		try {

			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			
			listadoCabecera("Listado Alumnos y Medias");
			// INSTANCIAMOS LA CLASE
			Alumno alumno = new Alumno();

			while (true) {
				alumno = (Alumno) ois.readObject();
				int notaMedia = (alumno.getNotaAccesoDatos()+alumno.getNotaEmpresa()+alumno.getNotaInterfaces()+alumno.getNotaMultimedia()+alumno.getNotaServicios()+alumno.getNotaSistemasGestion())/6;
				
				listadoAlumno(alumno);
				
				numAlumnos++;
				sumAcc+= alumno.getNotaAccesoDatos();
				sumInt+= alumno.getNotaInterfaces();
				sumMul += alumno.getNotaMultimedia();
				sumSer += alumno.getNotaServicios();
				sumSis += alumno.getNotaSistemasGestion();
				sumEmp += alumno.getNotaEmpresa();
				
			}
		} catch (EOFException e) {
			System.out.println("============================================================================================");
			System.out.println("Medias\t\t" +sumAcc/numAlumnos +"\t\t"+	sumInt/numAlumnos
					+"\t\t"+sumMul/numAlumnos+"\t\t"+sumSer/numAlumnos+"\t\t"+sumSis/numAlumnos
					+"\t\t"+sumEmp/numAlumnos);
			System.out.println("Fin de lectura. ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void insertarEstudiante(File f) {
		// VARIABLES PARA ESCRITURA
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);

			// INSTANCIAMOS LA CLASE alumno, lo creamos y guardamos en el fichero
			Alumno alumno = crearAlumno();
				
			oos.writeObject(alumno);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
