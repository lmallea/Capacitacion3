package pages.paginaQanova;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Utils.Validaciones.esperar;
import static Utils.Validaciones.validarObjeto;
public class IngresarQanova {
    public IngresarQanova() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }

    @FindBy(id = "imUname")
    WebElement lineaUsuario;

    @FindBy(id = "imPwd")
    WebElement lineaClave;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement botonIngresar;

    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    WebElement error;

    @FindBy(xpath = "//*[@id=\"imHeader_imObjectImage_01\"]")
    WebElement inicio;

    @FindBy(xpath = "//*[@id=\"imPgTitle\"]")
    WebElement validar;

    // METODO PARA INGRESAR A LA PAGINA QANOVAGRUPO
    public void ingresarPaginaQanova(String nombre) {
        if (validarObjeto(inicio,"Se inicia la pagina")) {
            esperar(5);
            inicio.getText().equals(nombre);
            PdfQaNovaReports.addWebReportImage("Ingreso a Qanovagroup", "Se despliega la pagina Qanovagroup donde se visualizan los Textbox Nombre de usuario y Contrasena, el boton Ingresar a Demo y el link Crea tu usuario Aqui ", EstadoPrueba.PASSED, false);
        } else {
            System.err.println("No se ingreso a la pagina");
            PdfQaNovaReports.addWebReportImage("ingresarPaginaQanova", "No se despliega la pagina Qanovagroup donde se visualizan los Textbox Nombre de usuario y Contrasena, el boton Ingresar a Demo y el link Crea tu usuario Aqui", EstadoPrueba.PASSED, false);
        }
    }
    // METODO PARA INGRESAR EL USUARIO EN EL TEXTBOX CORRESPONDIENTE
    public void ingresarUsuario(String usuario) {
        if (validarObjeto(lineaUsuario, "Campo de usuario")) {
            lineaUsuario.clear();
            lineaUsuario.sendKeys(usuario);
        } else {
            PdfQaNovaReports.addWebReportImage("ingresarUsuario", "No se visualiza el Campo Usuario", EstadoPrueba.FAILED, true);
            System.err.println("No se visualiza el objeto");
        }
    }
    // METODO PARA INGRESAR LA CLAVE EN EL TEXTBOX CORRESPONDIENTE
    public void ingresarClave(String clave) {
        if (validarObjeto(lineaClave, "Campo de Password")) {
            lineaClave.clear();
            lineaClave.sendKeys(clave);
            PdfQaNovaReports.addWebReportImage("Ingresar Credenciales", "Se visualiza el llenado de los campos Usuario y Contrasena", EstadoPrueba.PASSED, false);
        } else {
            PdfQaNovaReports.addWebReportImage("Ingresar Credenciales", "No se visualiza el llenado de los campos Usuario y Contrasena", EstadoPrueba.FAILED, true);
            System.err.println("No se visualiza el objeto");
        }
    }
    // METODO PARA HACER CLICK EN EL BOTON INGRESAR A DEMO
    public void ingresarDemo() {
        if (validarObjeto(botonIngresar, "Boton Ingresar")) {
            botonIngresar.click();
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }
    // METODO PARA VALIDAR QUE SE HALLA INGRESADO EXITOSAMENTE A LA PROXIMA PAGINA
    public void validarProximaPagina(String oracion) {
        if (validarObjeto(validar, "Se valida inicio proxima pagina")) {
            validar.getText().equals(oracion);
            PdfQaNovaReports.addWebReportImage("validarProximaPagina", "Se valida que queda realizado el login y seguidamente se despliega la pagina Carga de Informacion", EstadoPrueba.PASSED, false);
        } else {
            System.err.println("No se visualiza la proxima pagina");
            PdfQaNovaReports.addWebReportImage("validarProximaPagina", "No se valida que queda realizado el login y seguidamente se despliega la pagina Carga de Informacion", EstadoPrueba.FAILED, true);
        }
    }
}
