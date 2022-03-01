package EjemploConexion;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;

public class Ejemplo2Insertar {

    public static void main(String[] args) {
        //Crear una conexión
        MongoClient cliente = new MongoClient();

        MongoClient cliente1 = new MongoClient("localhost", 2017);

        //Conectar a la BBDD
        MongoDatabase db = cliente.getDatabase("EmpleadosDepartamentos");

        //obteneer la colección
        MongoCollection<Document> coleccion = db.getCollection("empleados");

        //crear el documentos
        Document empleado = new Document();

        empleado.put("nombre", "Bea");
        empleado.put("salario", 2500);
        empleado.put("fecha", new Date());
        empleado.put("oficio", "Analista");

        coleccion.insertOne(empleado);

        Document empleado2 = new Document("nombre", "Rosario")
                .append("salario", 3200)
                .append("fecha", new Date())
                .append("oficio", new Document());

        coleccion.insertOne(empleado2);

        cliente.close();
    }
}
