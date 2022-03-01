package XML.EjercicioXML.Ejercicio2;

import org.xml.sax.Attributes;

public class GestionContenido {

    public GestionContenido() {
        super();
    }

    public void startDocument() {
        System.out.println("Principio documento");
    }

    public void endDocument() {
        System.out.println("Fin documento: ");
    }

    public void startElement(final String url, final String titulo, final String nombrec, final Attributes att) {
        System.out.println("Comienza el elemento: ");
    }

    public void endElement(final String url, final String titulo, final String nombrec) {
        System.out.println("Finaliza el elemento: ");
    }

    public void characters(final char[] ch, final int inicio, final int longitud) {
        String car = new String(ch, inicio, longitud);
        car = car.replaceAll("[\t\n]", "");
        System.out.println("Valor: " + car);

    }
}


