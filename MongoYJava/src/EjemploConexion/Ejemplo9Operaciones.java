package EjemploConexion;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejemplo9Operaciones {

    public static void main(String[] args) {
        //Crear una conexión
        MongoClient cliente = new MongoClient();

        MongoClient cliente1 = new MongoClient("localhost", 2017);

        //Conectar a la BBDD
        MongoDatabase db = cliente.getDatabase("EmpleadosDepartamentos");

        //obteneer la colección
        MongoCollection<Document> coleccion = db.getCollection("empleados");

        //obtener el total de los salarios y el salario medio

        Document operaciones = new Document("_id", "")
                .append("totalSalarios", new Document("$sum", "$salario"))
                .append("salarioMedio", new Document("$avg", "$salario"));

        Document group = new Document("$group", operaciones);

        List<Document> lista = Arrays.asList(group);

        MongoCursor<Document> cursor = coleccion.aggregate(lista).iterator();
    }
}
