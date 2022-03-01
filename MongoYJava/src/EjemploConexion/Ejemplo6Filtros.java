package EjemploConexion;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class Ejemplo6Filtros {

    public static void main(String[] args) {
        //Crear una conexión
        MongoClient cliente = new MongoClient();

        MongoClient cliente1 = new MongoClient("localhost", 2017);

        //Conectar a la BBDD
        MongoDatabase db = cliente.getDatabase("EmpleadosDepartamentos");

        //obteneer la colección
        MongoCollection<Document> coleccion = db.getCollection("empleados");

        //obtener los empleados con sueldos entre 1500 y 2500
        MongoCursor cursor = coleccion.find(Filters.and(Filters.gte("salario", 1500),
                Filters.lte("salario", 2500))).iterator();

        while (cursor.hasNext()) {
            Document empleado = (Document) cursor.next();
            System.out.println(empleado.toJson());
        }
    }
}
