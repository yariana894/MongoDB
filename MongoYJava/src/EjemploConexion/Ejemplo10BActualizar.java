package EjemploConexion;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class Ejemplo10BActualizar {
    public static void main(String[] args) {
        //Crear una conexión
        MongoClient cliente = new MongoClient();

        MongoClient cliente1 = new MongoClient("localhost", 2017);

        //Conectar a la BBDD
        MongoDatabase db = cliente.getDatabase("EmpleadosDepartamentos");

        //obteneer la colección
        MongoCollection<Document> coleccion = db.getCollection("empleados");

        //obtener la colección
        MongoCollection<Document> collection = db.getCollection("empleados");

        Document findDocument = new Document("oficio", "Profesora");

        Document updateDocument = new Document("$set", new Document("salario", 2000));

        UpdateResult updateResult = coleccion.updateMany(findDocument, updateDocument);

        System.out.println(updateResult.getMatchedCount() + "\t" + updateResult.getModifiedCount());

        cliente.close();
    }
}
