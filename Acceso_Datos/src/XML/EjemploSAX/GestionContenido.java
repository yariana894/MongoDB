package XML.EjemploSAX;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class GestionContenido extends DefaultHandler {
    public GestionContenido() {
        super();
    }

    @Override
    public void startDocument() {
        System.out.println("Comienzo del documento XML");
    }

    @Override
    public void endDocument() {
        System.out.println("Final del documento XML");
    }

    public void startElement(final String uri, final String nombre, final String nombreC, final Attributes aatts) {
        //System.out.println("Principio Elemento: " +nombre);
    }

    @Override
    public void endElement(final String uri, final String nombre, final String nombreC) {
        //System.out.println("Fin Elemento: " +nombre);
    }

    @Override
    public void characters(final char[] ch, final int inicio, final int longitud) {
        String car = new String(ch, inicio, longitud);
        car = car.replaceAll("[\t\n]", ""); //quitar saltos de linea
        System.out.println("\tTexto: " + car);
    }
}
