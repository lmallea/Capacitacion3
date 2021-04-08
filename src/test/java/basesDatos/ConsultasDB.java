package basesDatos;

import org.testng.annotations.Test;

import java.sql.*;

import static basesDatos.Conexion.conectarMySQL;
import static basesDatos.Conexion.*;

public class ConsultasDB {
    //METODO PARA HACER UNA CONSULTA A LA BASE DE DATOS
   public void consulta(String query) {
       Connection connection = null;
       try {
               Connection con = Conexion.conectarMySQL();
               Statement statement = con.createStatement();
               statement.setQueryTimeout(35);
               ResultSet rs = statement.executeQuery(query);

              while (rs.next()) {
                  System.out.println("Campo_Mail:" + rs.getString("Campo_Mail"));
                  System.out.println("Combo Radio Button:" + rs.getString("Combo_Radio_Button"));
              }
           }catch (SQLException | ClassNotFoundException e){
           System.out.println(e.getMessage());
       }
   }

}
