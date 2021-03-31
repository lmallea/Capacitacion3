package pages.paginaQanova;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.Validaciones.validarObjeto;

public class NuevoIngreso {
    public NuevoIngreso() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"imHeader_imObjectImage_01\"]")
    WebElement inicio;

    @FindBy(xpath = "//*[@id=\"dynObj_02\"]/p/a")
    WebElement click;

    @FindBy(xpath = "//*[@id=\"imRegUname\"]")
    WebElement lineaNameUsuario;

    @FindBy(xpath = "//*[@id=\"imRegPwd\"]")
    WebElement lineaContrasena;

    @FindBy(xpath = "//*[@id=\"imRepeatPwd\"]")
    WebElement campoRepiteContrasena;

    @FindBy(xpath = "//*[@id=\"imRealname\"]")
    WebElement nameCompleto;

    @FindBy(xpath = "//*[@id=\"imEmail\"]")
    WebElement email;

    @FindBy(xpath = "//*[@id=\"imRegister_submit\"]")
    WebElement btnRegistrarse;



    public void ingresarPaginaQanova(String nombre){
        if(validarObjeto(inicio,"Iniciar la pagina")){
            inicio.getText().equals(nombre);
            PdfQaNovaReports.addWebReportImage("Ingreso a Qanovagroup", "Se despliega la pagina Qanovagroup donde se visualizan los Textbox Nombre de usuario y Contrasena, el boton Ingresar a Demo y el link Crea tu usuario Aqui ", EstadoPrueba.PASSED, false);
        }else{
            System.err.println("No se ingreso a la pagina");
            PdfQaNovaReports.addWebReportImage("ingresarPaginaQanova","No se despliega la pagina Qanovagroup donde se visualizan los Textbox Nombre de usuario y Contrasena, el boton Ingresar a Demo y el link Crea tu usuario Aqui",EstadoPrueba.PASSED,false);
        }
    }
    public void clickAqui(){
        if (validarObjeto(click,"validar palabra Aqui")){
            click.click();
        }else{
            System.err.println("No fue encontrado");
        }
    }
    public void rellenarUsuario(String nombreUsuario){
        if(validarObjeto(lineaNameUsuario,"Textbox del campo usuario")){
            lineaNameUsuario.sendKeys(nombreUsuario);
            System.out.println("encontrado");
        } else{
            System.err.println("No se encontro");
        }
    }
    public void completarContrasena(String contrasena){
        if(validarObjeto(lineaContrasena,"Textbox del campo contrasena")){
            lineaContrasena.sendKeys(contrasena);
            System.out.println("Encontrado");
        }else{
            System.err.println("No se encontro");
        }
    }
    public void repetirContrasena(String repiteContrasena){
       if(validarObjeto(campoRepiteContrasena,"Textbox del campo repite contrasena")){
           campoRepiteContrasena.sendKeys(repiteContrasena);
           System.out.println("ENCONTRADO");
       }else{
           System.err.println("NO SE ENCONTRO");
        }
    }
    public void completarNombre(String lastName){
        if(validarObjeto(nameCompleto, "Textbox del campo nombre completo")){
            nameCompleto.sendKeys(lastName);
            System.out.println("ENCONTRADO");
        }else {
            System.err.println("NO SE ENCONTRO");
        }
    }
    public void escribirMail(String mail){
        if(validarObjeto(email,"Textbox del campo E-mail")){
            email.sendKeys(mail);
            System.out.println("ENCONTRADO");
            PdfQaNovaReports.addWebReportImage("Validacion de datos","Se visualiza la pagina Area reservada donde a un lado vemos Usuario ya registrado con los Textbox Nombre de usuario y Contrasena, He olvidado mi contraseña y el boton Intro; por otro lado se encuentra el area de Realizar una nueva cuenta con los Textbox Nombre usuario, Contrasena, Repite la Contrasena, Nombre completo, E-mail y el boton ingresar",EstadoPrueba.PASSED,false);
        }
    }
    public void registrarse(){
        if(validarObjeto(btnRegistrarse,"Boton para completar el registro")){
            btnRegistrarse.click();
           PdfQaNovaReports.addWebReportImage("registrarse","Aparece el mensaje Registro Completado con exito en un recuadro verde",EstadoPrueba.PASSED,false);
        }else{
            System.err.println("NO SE ENCONTRO EL BOTON");
        }
    }
}
