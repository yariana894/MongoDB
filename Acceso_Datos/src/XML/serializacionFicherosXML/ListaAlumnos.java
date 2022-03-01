package XML.serializacionFicherosXML;

import java.util.ArrayList;

public class ListaAlumnos {
	public ArrayList<Alumno> lista = new ArrayList<Alumno>();

	public ListaAlumnos() {
		super();
	}
	
	public void add(Alumno alumno){
		lista.add(alumno);
	}
	public ArrayList<Alumno> getListaAlumno(){
		return lista;
	}
}
