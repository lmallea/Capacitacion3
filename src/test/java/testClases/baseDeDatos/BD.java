package testClases.baseDeDatos;

import Utils.ReadProperties;
import basesDatos.ConsultasDB;
import basesDatos.InsertarBD;

public class BD {
    String query1 = ReadProperties.readFromConfig("pruebaqanova.properties").getProperty("consulta1");
    String query = ReadProperties.readFromConfig("pruebaqanova.properties").getProperty("consulta");
    String dato = ReadProperties.readFromConfig("pruebaqanova.properties").getProperty("query");

    public void insertando(){
        InsertarBD insertarBD = new InsertarBD();
        insertarBD.insetarDatos(query,query1);
    }
    public void actualizando(){
        ConsultasDB consultasDB = new ConsultasDB();
        consultasDB.consulta(dato);
    }
}
