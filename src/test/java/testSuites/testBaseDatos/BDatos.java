package testSuites.testBaseDatos;

import org.testng.annotations.Test;
import testClases.baseDeDatos.BD;

public class BDatos {
    @Test
    public void probando(){
        BD bd = new BD();
        bd.insertando();
    }
    @Test
    public void probando2() {
       BD bd = new BD();
       bd.actualizando();
    }
}
