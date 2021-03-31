package pages.paginaQanova;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utils.Validaciones.esperar;
import static Utils.Validaciones.validarObjeto;


public class CargaInformacion {
    public CargaInformacion() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }

    @FindBy(id = "imObjectForm_1_2")
    private WebElement texto;

    @FindBy(id = "imObjectForm_1_3")
    private WebElement correo;

    @FindBy(id = "imObjectForm_1_4")
    private WebElement area;

    @FindBy(id = "imObjectForm_1_5")
    private WebElement fecha;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_6\"]")
    private WebElement lista;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_6\"]/option")
    List<WebElement> opciones;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_wrapper\"]/span")
    List<WebElement> listaSeleccion;

    @FindBy(id = "imObjectForm_1_7_2")
    private WebElement seleccion3;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_wrapper\"]/span")
    List<WebElement> listaRadio;

    @FindBy(id = "imObjectForm_1_8_0")
    private WebElement radio1;

    @FindBy(id = "imObjectForm_1_submit")
    private WebElement enviar;

    @FindBy(id = "imObjectForm_1_5_icon")
    private WebElement btnPulsar;

    @FindBy(xpath = "//*[@id=\"imDPcal\"]/table/tbody/tr/td")
    List<WebElement> dia;


    public void ingresarTexto(String txt) {
        if (validarObjeto(texto, "Se valida campo de Texto")) {
            texto.sendKeys(txt);
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }

    public void ingresarCorreo(String mail) {
        if (validarObjeto(correo, "Se valida campo de correo")) {
            correo.sendKeys(mail);
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }

    public void ingresarArea(String dato) {
        if (validarObjeto(area, "Se valida TextArea")) {
            area.sendKeys(dato);
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }

    public void ingresarFecha(String date) {
        if (validarObjeto(fecha, "Se valida campo de fecha")) {
            fecha.sendKeys(date);
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }

    public void ingresarLista() {
        if (validarObjeto(lista, "Se valida webelement para hacer lista")) {
            lista.click();
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }

    public void seleccionar(String valor) {
        for (WebElement categorias : opciones) {
            if (categorias.getText().equals(valor)) {
                categorias.click();
            }
        }
    }

    public void clickMultiple() {
        if (validarObjeto(seleccion3, "Se validan los checkbox")) {
            seleccion3.click();
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }

    public void clickRadio() {
        if (validarObjeto(radio1, "Se validan RadioButton")) {
            radio1.click();
            PdfQaNovaReports.addWebReportImage("visualizacion y rellenado","Se visualiza el despliegue de la pagina Carga de Informacion y se rellenan los Textbox Campo texto, campo mail, Campo Area de texto, Campo fecha, Campo Lista, Campo Seleccion Multiple; el Radiobutton Campo Radio Button y los botones Enviar y resetear", EstadoPrueba.PASSED, false);
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }

    public void clickEnviar() {
        if (validarObjeto(enviar, "Se valida botn enviar")) {
            enviar.click();
            PdfQaNovaReports.addWebReportImage("clickEnviar","Luego de hacer click en el boton Enviar se despliga la pagina Matriz de informacion con el registro realizado. Se visualizan los botones Filter y Export CSV, ademas del Formulario con los datos: id, Campo_texto, Campo_mail, Campo_Area_de_Texto, Campo_Fec ha, Campo_Lista, Campo_Sleccion_Multiple y Campo_Radio_Button ",EstadoPrueba.PASSED,false);
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }
    public void clickCalendario(){
        if (validarObjeto(btnPulsar, "Se valida calendario")) {
            esperar(5);
            btnPulsar.click();
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }
    public void seleccionarFecha(String date){
        for(WebElement categorias : dia ) {
            if (categorias.getText().equals(date)) {
                categorias.click();
            }
        }
    }

}



