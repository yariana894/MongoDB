package EjemploConexion;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Sorts.ascending;

public class Ejemplo8Agregaciones {
    public static void main(String[] args) {
        //Crear una conexión
        MongoClient cliente = new MongoClient();

        MongoClient cliente1 = new MongoClient("localhost", 2017);

        //Conectar a la BBDD
        MongoDatabase db = cliente.getDatabase("EmpleadosDepartamentos");

        //obteneer la colección
        MongoCollection<Document> coleccion = db.getCollection("empleados");

        //Listar los empleados con salario mayor de 2500
        Document match = new Document("$match", new Document("salario", 2500));

        Document projeccion = new Document("$proyect", new Document("nombre", 1)
                .append("salario", 1).append("_id", 0));

        //crear la agregación
        List<Document> lista = Arrays.asList(match, projeccion);

        MongoCursor<Document> cursor = coleccion.aggregate(lista).iterator();

        while (cursor.hasNext()) {
            Document empleado = cursor.next();
            System.out.println(empleado.toJson());
        }
        cliente.close();
    }
}
