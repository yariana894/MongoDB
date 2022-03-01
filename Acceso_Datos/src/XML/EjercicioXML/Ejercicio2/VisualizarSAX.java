package XML.EjercicioXML.Ejercicio2;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class VisualizarSAX {

}
   /* public static void main(String[] args) {

        try {
            XMLReader lectorXML = XMLReaderFactory.createXMLReader();
            GestionContenido gestor = new GestionContenido();
            lectorXML.setContentHandler(gestor);

            InputSource fichero = new InputSource("libros.xml");

            lectorXML.parse(fichero);

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}*/
