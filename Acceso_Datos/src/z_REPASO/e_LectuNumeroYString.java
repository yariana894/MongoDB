package z_REPASO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class e_LectuNumeroYString {
    public static void main(String[] args) {

        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream("EnterosNombres.txt");
            dis = new DataInputStream(fis);

            while (true){
                System.out.println(dis.readInt() +" ");
                System.out.println(dis.readUTF() +" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
