package IntroducirDatos;

public class Ejemplo {
    public static void main(String[] args) {
        String nombre = IntroducirDatos.introducirDatos("Introduce tu nombre: ");

        System.out.println(nombre);
        int num = Integer.parseInt(IntroducirDatos.introducirDatos("Introduce un número: "));
    }
}
