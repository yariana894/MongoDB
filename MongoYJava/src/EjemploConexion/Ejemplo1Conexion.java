package EjemploConexion;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo1Conexion {

    public static void main(String[] args) {

        //Crear una conexión
        MongoClient cliente = new MongoClient();

        MongoClient cliente1 = new MongoClient("localhost", 2017);

        //Conectar a la BBDD
        MongoDatabase db = cliente.getDatabase("EmpleadosDepartamentos");

        //obteneer la colección
        MongoCollection<Document> coleccion = db.getCollection("empleados");

        //Visualizar los documentos
        ArrayList<Document> empleados = coleccion.find().into(new ArrayList<Document>());

        //recorrer los documentos
        for (int i = 0; i < empleados.size(); i++) {
            //System.out.println(empleados.get(i).toString());
            Document empleado = empleados.get(i);
            System.out.println(empleado.getString("nombre") + "\t" + empleado.get("salario"));
        }

        cliente.close();
    }
}
