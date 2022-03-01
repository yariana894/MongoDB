package EjemploConexion;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import javax.swing.text.Document;

public class Ejemplo5Filtros {

    public static void main(String[] args) {

        MongoClient cliente = new MongoClient();

        MongoDatabase db = cliente.getDatabase("empleados");

        MongoCollection coleccion = db.getCollection("Empleados");

        MongoCursor cursor = coleccion.find(Filters.gt("salario", 2500)).iterator();

        while (cursor.hasNext()) {
            Document empleado = (Document) cursor.next();

            //System.out.println(empleado.toJson());
        }

        cliente.close();
    }
}
