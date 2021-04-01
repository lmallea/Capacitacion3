package pages.paginaQanova;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.Validaciones.esperar;
import static Utils.Validaciones.validarObjeto;


public class GuardarCorreos {
    public GuardarCorreos() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }

    @FindBy(id = "pluginAppObj_4_01_filter_field")
    private WebElement lineaDeFiltrar;

    @FindBy(id = "pluginAppObj_4_01_filter_button")
    private WebElement filtrar;

    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr[2]/td[3]")
    private WebElement recuperarCorreo;

    @FindBy(xpath = "//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]")
    private WebElement matriz;

    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr[1]")
    private WebElement datos;
    // METODO PARA INGRESAR A LA PAGINA MATRIZ DE INFORMACION
    public void clickMatriz() {
        if (validarObjeto(matriz, "Matriz")) {
            esperar(5);
            matriz.click();
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }
    // METODO PARA ESCRIBIR EN EL TEXTBOX QUE APARECE ANTES DEL BOTON FILTRAR
    public void escribir(String buscar) {
        if (validarObjeto(lineaDeFiltrar, "ESCRIBIR")) {
            lineaDeFiltrar.sendKeys(buscar);
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }
    // METODO PARA HACER CLICK EN FILTRAR
    public void enter() {
        if (validarObjeto(filtrar, "Filtrar")) {
            esperar(5);
            filtrar.click();
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }
    //METODO PARA RECUPERAR EL CORREO QUE APARE LUEGO DE FILTRAR
    public void recuperar() {
        if (validarObjeto(recuperarCorreo, "REecuperacion de correo")) {
            esperar(5);
            String correo = recuperarCorreo.getText();
            System.out.println("" + correo);
        }
            else {
            System.err.println("No se encontro el correo");
        }
    }
    //METODO PARA GUARDAR TODOS LOS DATOS LUEGO DE FILTRAR
    public void guardarDatos(){
        if (validarObjeto(datos, "Guardar datos")) {
            esperar(5);
            String componentes = datos.getText();
            System.out.println("" + componentes);
        }
        else {
            System.err.println("No se encontraron los datos");
        }
    }
}
