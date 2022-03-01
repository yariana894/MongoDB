package EjemploConexion;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import javax.print.Doc;

public class Ejemplo4Filtrar {

    public static void main(String[] args) {

        MongoClient cliente = new MongoClient();

        MongoDatabase db = cliente.getDatabase("Empleados departamentos");

        MongoCollection<Document> collection = db.getCollection("empleados");

        Document documento = collection.find(Filters.eq("nombre", "Bea")).first();
    }
}

