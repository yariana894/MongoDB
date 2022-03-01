package XML.crearObjetosXml.src.serializacionFicherosXML;

import java.io.Serializable;

public class Alumno implements Serializable{
	//atributos
		String dni;
		String nombre;
		long telefono;
		
		// constructores
		public Alumno() {
			super();
		}
			
		public Alumno(String dni, String nombre, long telefono) {
			super();
			this.dni = dni;
			this.nombre = nombre;
			this.telefono = telefono;
		}
		// metodos get y set

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public long getTelefono() {
			return telefono;
		}

		public void setTelefono(long telefono) {
			this.telefono = telefono;
		}

		@Override
		public String toString() {
			return "Alumno [dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + "]";
		}
		
		
	}
