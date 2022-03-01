package z_REPASO;

import java.io.File;

public class a_ListaDire {
    public static void main(String[] args) {
        File f = new File(".");
        String separador = File.separator;

        String[] archivos = f.list();
        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i]);
        }
    }
}
