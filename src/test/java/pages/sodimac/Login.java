package pages.sodimac;

import Utils.DriverContext;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static Utils.Validaciones.esperar;
import static Utils.Validaciones.validarObjeto;

public class Login {
    public Login() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }
    @FindBy(xpath = "//*[@id=\"header-med-search-bar-SearchBar-79247401-c89a-4b16-9d3c-f91206c21c2c-desktop\"]/input")
    WebElement lineaDeBuscar;
    @FindBy(xpath = "/html/body/div[3]/div/div/button[1]")
    WebElement mantener2;
    @FindBy(xpath ="/html/body/div[2]/div/div/button[1]")
    WebElement mantener1;
    // METODO PARA HACER CLICK EN BOTON MANTANER QUE APARECE EN UNA PESTANA DEL INICIO
    public void clickMantener() {
         if (validarObjeto(mantener2, "Boton con la palabra Mantener")) {
             mantener2.click();
         } else if (validarObjeto(mantener1, "Boton con la palabra Mantener ")) {
             mantener1.click();
         } else {
             System.err.println("No se encontro ninguno de los objetos");
         }
     }
     // METODO PARA REALIZAR UNA BUSQUEDA
    public void buscar(String dato){
        if(validarObjeto(lineaDeBuscar, "lugar donde se coloca la busqueda")) {
            esperar(5);
            lineaDeBuscar.sendKeys(dato);
            lineaDeBuscar.sendKeys(Keys.ENTER);
            System.out.println("Realizado con exito");
        }else{
            System.err.println("No se encontro el elemento");
        }
    }

}
