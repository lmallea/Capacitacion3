package pages.chileAutos;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.Validaciones.esperar;
import static Utils.Validaciones.validarObjeto;

public class IngresarALaPagina {
    public IngresarALaPagina() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }
    @FindBy(xpath = "/html/body/div[3]/section[1]/div[2]/div/div/h1")
    WebElement verificacion;

    @FindBy(xpath = "//*[@id=\"search-form-container\"]/div/div[1]/a")
    WebElement buscar;
    public void ingresando(){
        if (validarObjeto(verificacion,"Verificacion de haber ingresado correctamente a la pagina")){
            verificacion.getText().equals("");
        }else{
            System.err.println("No se logro ingresar");
        }
    }
    public void buscando(){
        if(validarObjeto(buscar,"boton de buscar")){
            esperar(2);
            buscar.click();
            System.out.println("Se realizo la busqueda");
        }else{
            System.err.println("No se pudo realizar");
        }
    }
}
