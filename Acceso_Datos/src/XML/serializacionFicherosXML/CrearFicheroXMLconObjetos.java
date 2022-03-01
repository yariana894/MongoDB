package XML.serializacionFicherosXML;
/*
 * Ejemplo que recorre el fichero Alumnos.Dat para crear una lista de alumnos
 * que despu�s se insertar�n en el fichero Alumnos.xml
 */

/*import com.thoughtworks.xstream.XStream;

import java.io.*;

public class CrearFicheroXMLconObjetos {
    public static void main(final String[] args) throws IOException, ClassNotFoundException {

        File fichero = new File("Alumnos.DAT");
        FileInputStream lectura = new FileInputStream(fichero); //

// conecta el flujo de bytes al flujo de datos
        ObjectInputStream datos = new ObjectInputStream(lectura);
        System.out.println("Comienza el proceso de creación del fichero XML....");

// Creamos un objeto Lista de alumnos
        ListaAlumnos listaalu = new ListaAlumnos();
        try {
            while (true) { // lectura del fichero
                Alumno alumno = (Alumno) datos.readObject();// leer


                listaalu.add(alumno); //añadir un alumno a la lista
            }// fin while
        } catch (EOFException eo) {
        }
        datos.close();
        try {
            XStream xstream = new XStream();
//cambiar de nombre a las etiquetas XML
            xstream.alias("ListadoAlumnos", ListaAlumnos.class);
            xstream.alias("DatosAlumno", Alumno.class);
//quitar etiqueta lista (atributo de la clase ListaAlumno
            xstream.addImplicitCollection(ListaAlumnos.class,

                    "lista");

//Insertar los objetos en el XML
            xstream.toXML(listaalu, new

                    FileOutputStream("Alumnos.xml"));

            System.out.println("Creado el fichero xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// fin main
}// fin clase*/