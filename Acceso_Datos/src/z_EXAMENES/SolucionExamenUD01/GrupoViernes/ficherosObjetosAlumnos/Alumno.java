package z_EXAMENES.SolucionExamenUD01.GrupoViernes.ficherosObjetosAlumnos;

import java.io.Serializable;

public class Alumno implements Serializable{
	//VARIABLES DE LA CLASE
	String nombre;
	int notaAccesoDatos ;
	int notaInterfaces;
	int notaMultimedia;
	int notaServicios;
	int notaSistemasGestion;
	int notaEmpresa;
	//CONSTRUCTORES
	public Alumno() {
		super();
	}
	public Alumno(String nombre, int notaAccesoDatos, int notaInterfaces, int notaMultimedia, int notaServicios,
			int notaSistemasGestion, int notaEmpresa) {
		super();
		this.nombre = nombre;
		this.notaAccesoDatos = notaAccesoDatos;
		this.notaInterfaces = notaInterfaces;
		this.notaMultimedia = notaMultimedia;
		this.notaServicios = notaServicios;
		this.notaSistemasGestion = notaSistemasGestion;
		this.notaEmpresa = notaEmpresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNotaAccesoDatos() {
		return notaAccesoDatos;
	}
	public void setNotaAccesoDatos(int notaAccesoDatos) {
		this.notaAccesoDatos = notaAccesoDatos;
	}
	public int getNotaInterfaces() {
		return notaInterfaces;
	}
	public void setNotaInterfaces(int notaInterfaces) {
		this.notaInterfaces = notaInterfaces;
	}
	public int getNotaMultimedia() {
		return notaMultimedia;
	}
	public void setNotaMultimedia(int notaMultimedia) {
		this.notaMultimedia = notaMultimedia;
	}
	public int getNotaServicios() {
		return notaServicios;
	}
	public void setNotaServicios(int notaServicios) {
		this.notaServicios = notaServicios;
	}
	public int getNotaSistemasGestion() {
		return notaSistemasGestion;
	}
	public void setNotaSistemasGestion(int notaSistemasGestion) {
		this.notaSistemasGestion = notaSistemasGestion;
	}
	public int getNotaEmpresa() {
		return notaEmpresa;
	}
	public void setNotaEmpresa(int notaEmpresa) {
		this.notaEmpresa = notaEmpresa;
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", notaAccesoDatos=" + notaAccesoDatos + ", notaInterfaces="
				+ notaInterfaces + ", notaMultimedia=" + notaMultimedia + ", notaServicios=" + notaServicios
				+ ", notaSistemasGestion=" + notaSistemasGestion + ", notaEmpresa=" + notaEmpresa + "]";
	}
	
	

}
