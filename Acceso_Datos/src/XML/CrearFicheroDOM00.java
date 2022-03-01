package XML;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;

import java.io.File;

public class CrearFicheroDOM00 {

    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // elemento raiz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Companhia");
            doc.appendChild(rootElement);

            // empleado
            Element empleado = doc.createElement("empleado");
            rootElement.appendChild(empleado);

            // atributo del elemento empleado
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            empleado.setAttributeNode(attr);

            // nombre
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode("Manuel"));
            empleado.appendChild(nombre);

            // apellidos
            Element apellidos = doc.createElement("apellidos");
            apellidos.appendChild(doc.createTextNode("Gonzalez"));
            empleado.appendChild(apellidos);

            // seccion
            Element seccion = doc.createElement("seccion");
            seccion.appendChild(doc.createTextNode("almacen"));
            empleado.appendChild(seccion);

            // salario
            Element salario = doc.createElement("salario");
            salario.appendChild(doc.createTextNode("1000"));
            empleado.appendChild(salario);

            //dia depende de salario
            Element dia = doc.createElement("dia");
            dia.appendChild(doc.createTextNode("31"));
            salario.appendChild(dia);

            //mes
            Element mes = doc.createElement("mes");
            mes.appendChild(doc.createTextNode("10"));
            salario.appendChild(mes);

            //anho
            Element anho = doc.createElement("anho");
            anho.appendChild(doc.createTextNode("2018"));
            salario.appendChild(anho);

            // empleado
            Element empleado1 = doc.createElement("empleado");
            rootElement.appendChild(empleado1);

            // atributo del elemento empleado
            Attr attr1 = doc.createAttribute("id");
            attr1.setValue("1");
            empleado.setAttributeNode(attr1);

            // nombre
            Element nombre1 = doc.createElement("nombre");
            nombre1.appendChild(doc.createTextNode("Manuel"));
            empleado.appendChild(nombre1);

            // apellidos
            Element apellidos1 = doc.createElement("apellidos");
            apellidos1.appendChild(doc.createTextNode("Gonzalez"));
            empleado.appendChild(apellidos1);

            // seccion
            Element seccion1 = doc.createElement("seccion");
            seccion1.appendChild(doc.createTextNode("almacen"));
            empleado.appendChild(seccion1);

            // salario
            Element salario1 = doc.createElement("salario");
            salario1.appendChild(doc.createTextNode("1000"));
            empleado.appendChild(salario1);


            // escribimos el contenido en un archivo .xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File("archivo1.xml"));
            transformer.transform(source, result);


            // Si se quiere mostrar por la consola...

            StreamResult result1 = new StreamResult(System.out);
            transformer.transform(source, result1);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

}// fin de la clase
