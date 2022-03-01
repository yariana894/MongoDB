package XML.crearObjetosXml.src.serializacionFicherosXML;
/*
 * Lectura de un fichero XML a objetos
 */

import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeerFicheroXML {
    public static void main(final String[] args) throws FileNotFoundException {

        //crear una instancia de la clase XStream
        XStream xstream = new XStream();
        //cambiar de nombre a las etiquetas XML
        xstream.alias("ListadoAlumnos", ListaAlumnos.class);
        xstream.alias("DatosAlumno", Alumno.class);
        //quitar etiqueta lista (atributo de la clase ListaAlumnos
        xstream.addImplicitCollection(ListaAlumnos.class, "lista");
        ListaAlumnos listadoTodas = (ListaAlumnos)
                xstream.fromXML(new FileInputStream("Alumnos1.xml"));
        System.out.println("Numero de alumnos: " + listadoTodas.getListaAlumno());
        List<Alumno> listaAlumnos = new ArrayList<Alumno>();
        listaAlumnos = listadoTodas.getListaAlumno();
        Iterator iterator = listaAlumnos.listIterator(); //recorrer los elementos
        while (iterator.hasNext()) {
            Alumno alu = (Alumno) iterator.next(); //obtenemos el elemento
            System.out.println("DNI: " + alu.getDni() + "\tNombre: " + alu.getNombre() + "\tTelefono: "
                    + alu.getTelefono());
        }// fin del while
        System.out.println("\n\nFin del listado... ");
    }// fin main
}//fin clase
