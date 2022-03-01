package z_REPASO.XML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;

public class LeerDom {

    public static final File XML_FILE = new File("C:\\Users\\Yari\\Documents\\2o DAM\\1aEv\\Acceso_Datos\\src\\z_REPASO\\XML\\Empleados.xml");

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        //parsear
        var domDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(XML_FILE);

        //URL xml
        System.out.println("url del xml: " + domDocument.getDocumentURI());

        //obtener la cabecera del xml, tenemos que ocmprobar sie s un noto documento
        var header = domDocument.getNodeType();
        System.out.println("NODO DOCUMENTO?" + (header == Node.DOCUMENT_NODE));

        //obtener la versión del documento
        System.out.println("versión " + domDocument.getXmlVersion());

        //obtener el encoding
        System.out.println("Encoding: " + domDocument.getXmlEncoding());

        //obtener nodos hijos
        System.out.println("Tamaño lista de nodos: " + domDocument.getChildNodes().getLength());

        //obtener elemento por etiqueta
        NodeList employees = domDocument.getElementsByTagName("employee");
        for (int i = 0; i < employees.getLength(); i++) {
            Node employee = employees.item(i);
            System.out.println(employee.getTextContent());
            System.out.println("Parent: " + employee.getParentNode().getNodeName());
            System.out.println("primer nodo válido: " + employee.getFirstChild().getNextSibling().getTextContent());

            System.out.println(employee.getTextContent());
            System.out.println("Parent: " + employee.getParentNode().getNodeName());
            System.out.println("último nodo válido: " + employee.getLastChild().getPreviousSibling().getTextContent());

            var childNodes = employee.getChildNodes();
            System.out.println(childNodes.item(0).getParentNode().getAttributes().getNamedItem("category").getNodeValue());
        }

        //lee todos los nodos
        IntStream.range(0, employees.getLength()).mapToObj(index -> employees.item(index).getTextContent()).forEach(System.out::println);


        browseNodeList(employees);

    }

    private static void browseNodeList(NodeList employees) {
        var count = IntStream.range(0, employees.getLength()).mapToObj(index -> employees.item(index)).filter(node -> node.getNodeType() == Node.ELEMENT_NODE).peek(LeerDom::printData).count();


        System.out.println("Procesados " + count + " nodos");

    }

    private static void printData(Node node) {

        if (!node.getNodeName().equals("employee")) {
            System.out.println("Nombre nodo: " + node.getNodeName() + ", contenido: " + node.getTextContent());

        } else {
            System.out.println("Empleado");
            System.out.println();
        }

        browseAttList(node.getAttributes());
        browseNodeList(node.getChildNodes());
    }

    private static void browseAttList(NamedNodeMap attributes) {

        if (attributes != null) {
            IntStream.range(0, attributes.getLength()).mapToObj(index -> attributes.item(index)).forEach(att -> System.out.println("AttNOmbre: " + att.getNodeName() + "//contenido:" + att.getNodeValue()));
        }
    }

}
