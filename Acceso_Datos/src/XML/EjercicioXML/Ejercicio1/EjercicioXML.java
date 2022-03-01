package XML.EjercicioXML.Ejercicio1;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/*1o) A partir del fichero aleatorio Libros.DAT (creado en el ejercicio de ficheros
aleatorios), crear un documento XML, libros.xml, usando DOM. Visualizar el
fichero XML.*/

public class EjercicioXML {
    private static final long tamanhoRegistro = 200;


    public static void main(final String[] args) throws IOException {
        File fichero = new File("Libros.dat");
        RandomAccessFile raf = new RandomAccessFile(fichero, "r");

        int codigo;
        int precio, cantidad;
        long posicion = 0; // para situarnos al principio del fichero
        String titulo, autor;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementacion = db.getDOMImplementation();
            // crea el documento con el nodo raíz de nombre Personas
            Document documento = implementacion.createDocument(null, "Libros", null);
            documento.setXmlVersion("1.0"); // asignamos la versión de nuestro XML

            int numRegistros = (int) (raf.length() / tamanhoRegistro);
            System.out.println(numRegistros);
            for (int i = 0; i <= numRegistros; i++) {
                raf.seek(posicion); // nos posicionamos al comienzo del fichero
                codigo = raf.readInt();    // leemos los datos del fichero
                titulo = raf.readUTF();
                autor = raf.readUTF();
                precio = raf.readInt();
                cantidad = raf.readInt();

                System.out.println(codigo+" "+titulo+" "+autor );


                if (codigo > 0) {
                    Element raiz = documento.createElement("libros");    //creamos el  nodo persona
                    documento.getDocumentElement().appendChild(raiz);// lo pegamos a la raíz del documento
                    CrearElemento("codigo", Long.toString(codigo), raiz, documento); // añadir codigo
                    CrearElemento("titulo", titulo.trim(), raiz, documento); // añadir titulo
                    CrearElemento("autor", autor.trim(), raiz, documento); // añadir titulo
                    CrearElemento("precio", Integer.toString(precio), raiz, documento);// añadir edad
                    CrearElemento("cantidad", Integer.toString(cantidad), raiz, documento);// añadir edad

                    // el método trim() elimina los espacios en blanco al pricipio y al final de la cadena
                }// fin if codigo

                posicion = posicion + tamanhoRegistro; // se posiciona para el siguiente registro

            }// fin del for que recorre el fichero

            // recorremos el fichero XML para ver su contenido
            Source fuente = new DOMSource(documento);
            Result resultado = new StreamResult(new java.io.File("Libros1.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(fuente, resultado);

            // para mostrar el documento por pantalla,podemos especificar como resultado el canal de salida System.out
            //	Result consola = new StreamResult(System.out);
            //		transformer.transform(fuente, consola);

        } catch (EOFException e) {
            System.err.println("Fin de la lectura: " + e);

        } catch (Exception e) {
            e.printStackTrace();
        }
        raf.close();
    }// fin del main


    // metodo de insercion de los datos de la persona
    static void CrearElemento(final String datoLibro, final String valor, final Element raiz, final Document documento) {
        Element elemento = documento.createElement(datoLibro); // creamos hijo
        Text texto = documento.createTextNode(valor); // damos valor
        raiz.appendChild(elemento); // pegamos el elemento hijo a la raiz
        elemento.appendChild(texto); // pegamos el valor
    }// fin del metodo
}// fin de la clase