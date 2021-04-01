package testSuites.paginaQanova;

import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.pruebaQanova.Ingresar;


public class PruebaNavegacion {
    @BeforeMethod
    public void setUp() {
        PdfQaNovaReports.createPDF();
        DriverContext.setUp(Navegador.Chrome, ReadProperties.readFromConfig("propiedades.properties").getProperty("url"));
    }
    @AfterMethod
    public void tearDown() {
        DriverContext.closeDriver();
    }
    @Test
    public void navegarEnLogin() {
        Ingresar ingresar = new Ingresar();
        ingresar.introducir();
        PdfQaNovaReports.closePDF();
    }
    @Test
    public void ingresarClaveIncorrecta() {
        Ingresar ingresar = new Ingresar();
        ingresar.loginIncorrecto();
        PdfQaNovaReports.closePDF();
    }
    @Test
    public void registroNuevoUsuario() {
        Ingresar ingresar = new Ingresar();
        ingresar.registroPagina();
        PdfQaNovaReports.closePDF();
    }
    @Test
    public void cargaInformacion() {
        Ingresar ingresar = new Ingresar();
        ingresar.introducir();
        ingresar.rellenar();
        PdfQaNovaReports.closePDF();
    }
    @Test
    public void busquedaEnMatriz() {
        Ingresar ingresar = new Ingresar();
        ingresar.introducir();
        ingresar.rellenar();
        ingresar.recuperarCorreo();
    }
    @Test
    public void envioCorreo() {
        Ingresar ingresar = new Ingresar();
        ingresar.introducir();
        ingresar.rellenar();
        ingresar.envioDeCorreo();
    }
}
