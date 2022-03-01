package EjemploConexion;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Projections.include;

public class Ejemplo7Proyecciones {
    public static void main(String[] args) {
        //Crear una conexión
        MongoClient cliente = new MongoClient();

        MongoClient cliente1 = new MongoClient("localhost", 2017);

        //Conectar a la BBDD
        MongoDatabase db = cliente.getDatabase("EmpleadosDepartamentos");

        //obteneer la colección
        MongoCollection<Document> coleccion = db.getCollection("empleados");

        //obtener nombre, salario, fecha de alta de los empleados con sueldo
        //mayor de 2000 ordenadors por nombre
        MongoCursor<Document> cursor = coleccion.find(Filters.gt("salario", 2000))
                .sort(ascending("nombre"))
                .projection(include("nombre", "salario", "fechaalta")).iterator();

        while (cursor.hasNext()) {
            Document empleado = (Document) cursor.next();
            System.out.println(empleado.toJson());
        }
    }
}
