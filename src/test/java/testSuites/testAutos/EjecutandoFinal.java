package testSuites.testAutos;

import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.ejercicioChileAutos.EjecutandoMetodos;

public class EjecutandoFinal {
        @BeforeMethod
        public void setUp() {
            DriverContext.setUp(Navegador.Chrome, ReadProperties.readFromConfig("propiedades.properties").getProperty("url5"));
        }

        @AfterMethod
        public void tearDown() {
            //DriverContext.closeDriver();
        }
        @Test
    public void ejecutandoInicio(){
            EjecutandoMetodos ejecutandoMetodos = new EjecutandoMetodos();
            ejecutandoMetodos.ejecutandoIngreso();
            ejecutandoMetodos.seleccionando();
            ejecutandoMetodos.recuperando();
        }

}
