package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LeerFicherosDOM {
    static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    public static void main(String[] args) {

        File f = new File("Personas.xml");

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse(f);
            //es para que crea la estructura de android el método parse
            documento.getDocumentElement().normalize();

            //la raiz es la etiqueta primera del xml
            System.out.println("Raiz: "
                    + documento.getDocumentElement().getNodeName());


            NodeList lista = documento.getElementsByTagName("persona");

            for (int i = 0; i < lista.getLength(); i++) {
                Node persona = lista.item(i);

                //este métodoo me devuelve el tipo de
                if (persona.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) persona;
                    System.out.println("Clave: " + getNodo("clave", elemento));
                    System.out.println("Nombre: " + getNodo("nombre", elemento));
                    System.out.println("Nota: " + getNodo("nota", elemento));
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    private static String getNodo(String string, Element elemento) {
        NodeList nodo = elemento.getElementsByTagName(string).item(0).getChildNodes();
        Node valorNodo = nodo.item(0);
        return valorNodo.getNodeValue();

    }
}
