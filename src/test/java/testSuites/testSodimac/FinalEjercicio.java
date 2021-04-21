package testSuites.testSodimac;

import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.ejercicioSodimac.Ejercitando;

import java.io.IOException;

public class FinalEjercicio {
    @BeforeMethod
    public void setUp() {
        DriverContext.setUp(Navegador.Chrome, ReadProperties.readFromConfig("propiedades.properties").getProperty("url4"));
    }
    @AfterMethod
    public void tearDown() {
        //DriverContext.closeDriver();
    }
    @Test
    public void buscando() throws IOException {
        Ejercitando ejercitando = new Ejercitando();
        ejercitando.ejecutandoLogin();
        ejercitando.recuperarArchivo();
    }
}
