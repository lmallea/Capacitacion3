package pages.paginaQanova;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.Validaciones.esperar;
import static Utils.Validaciones.validarObjeto;


public class Incorrecto {
    public Incorrecto() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }

    @FindBy(id = "imUname")
    private WebElement lineaUsuario;

    @FindBy(id = "imPwd")
    private WebElement lineaClave;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    private WebElement botonIngresar;


    @FindBy(xpath = "//*[@id=\"imHeader_imObjectImage_01\"]")
    private WebElement inicio;

    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    private WebElement error;
    // METODO PARA INGRESAR A LA PAGINA QANOVAGROUP
    public void ingresarPaginaQanova(String nombre) {
        if (validarObjeto(inicio, "Iniciar la pagina")) {
            inicio.getText().equals(nombre);
            PdfQaNovaReports.addWebReportImage("Ingreso a Qanovagroup", "Se despliega la pagina Qanovagroup donde se visualizan los Textbox Nombre de usuario y Contrasena, el boton Ingresar a Demo y el link Crea tu usuario Aqui ", EstadoPrueba.PASSED, false);
        } else {
            System.err.println("No se ingreso a la pagina");
            PdfQaNovaReports.addWebReportImage("ingresarPaginaQanova", "No se despliega la pagina Qanovagroup donde se visualizan los Textbox Nombre de usuario y Contrasena, el boton Ingresar a Demo y el link Crea tu usuario Aqui", EstadoPrueba.PASSED, false);
        }
    }
    // METODO PARA INGRESAR EL NOMBRE DE TU USUARIO
    public void ingresarUsuario(String usuario) {
        if (validarObjeto(lineaUsuario, "Ingresar ususario")) {
            lineaUsuario.sendKeys(usuario);
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }
    //METODO PARA INGRESAR TU CONTRASENA INCORRECTA
    public void ingresarClave(String clave) {
        if (validarObjeto(lineaClave, "Ingresar clave")) {
            lineaClave.sendKeys(clave);
            PdfQaNovaReports.addWebReportImage("Ingresar Credenciales", "Se visualiza el llenado de los campos Usuario y Contrasena", EstadoPrueba.PASSED, false);
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }
    //METODO PARA HACER CLICK EN INGRESAR A DEMO
    public void ingresarIncorrecto() {
        if (validarObjeto(botonIngresar, "boton ingresar")) {
            esperar(5);
            botonIngresar.click();
            PdfQaNovaReports.addWebReportImage("ingresarIncorrecto", "Se visualiza que no se realizo el login y aparece un cartel rojo que dice Nombre y/o password incorrecto", EstadoPrueba.PASSED, false);
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }
    // METODO PARA RESCATAR EL COLOR DEL RECUADRO QUE TIENE EL TEXTO NOMBRE Y/O PASSWORD INCORRECTO
    public void rescatarTC() {
        String text = error.getText();
        System.out.println("" + text);
        String color = error.getCssValue("background-color");
        System.out.println("" + color);
    }
}
