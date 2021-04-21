package testSuites.testArchivo;

import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.pruebaDeDescarga.Descargando;


public class TestDescargar {


    @BeforeMethod
    public void setUp() {
        PdfQaNovaReports.createPDF();
        DriverContext.setUp(Navegador.Chrome, ReadProperties.readFromConfig("propiedades.properties").getProperty("url2"));

    }

    @AfterMethod
    public void tearDown() {
        DriverContext.closeDriver();

    }

    @Test
    public void descargandoArchivo() {
        Descargando descargando = new Descargando();
        descargando.probarDescarga();
        PdfQaNovaReports.closePDF();
    }
}