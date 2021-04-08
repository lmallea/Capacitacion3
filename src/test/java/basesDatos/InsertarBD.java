package basesDatos;

import Utils.ReadProperties;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarBD {
    Conexion conexion = new Conexion();
    //METODO PARA HACER INSERCIONES Y CAMBIOS EN UNA BASE DE DATOS
    public void insetarDatos(String consulta,String consulta1){
        try{
            Connection con = Conexion.conectarMySQL();
            PreparedStatement pst = con.prepareStatement(consulta1);
            pst.executeUpdate();
            pst.executeUpdate(consulta);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());

        }
    }

}
