package basesDatos;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private static Connection con = null;
    public static Connection conectarMySQL() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaqanova", "root", "Qwerty123$");

        } catch (ClassNotFoundException | SQLException e) {
            throw new ClassNotFoundException(e.getMessage());
        }
        return con;
    }
}

