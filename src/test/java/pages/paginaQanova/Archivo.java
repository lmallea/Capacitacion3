package pages.paginaQanova;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

import static Utils.Validaciones.esperar;
import static Utils.Validaciones.validarObjeto;

public class Archivo {
    public Archivo() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"imMnMnNode6\"]/a/span/span/span[2]")
    private WebElement cargar;

    @FindBy(id = "imObjectForm_1_2")
    private WebElement subir;

    @FindBy(id = "imObjectForm_1_submit")
    private WebElement btnEnvio;

    public void ingresarArchivo() {
        if (validarObjeto(cargar, "Se visualiza elemento cargar archivo")) {
            esperar(5);
            cargar.click();
        } else {
            System.err.println("No se visualiza el objeto");
        }
    }
    public void cargarArchivo(String url1){
        File file = new File(url1);
        String path = file.getAbsolutePath();
        esperar(5);
        subir.sendKeys(path);
    }
    public void enviar(){
        validarObjeto(btnEnvio,"Se visualiza el valida el elemento Boton Enviar");
        btnEnvio.click();
    }
}
