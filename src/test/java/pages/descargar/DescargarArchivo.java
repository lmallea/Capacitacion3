package pages.descargar;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

import static Utils.Validaciones.esperar;
import static Utils.Validaciones.validarObjeto;


public class DescargarArchivo {


    public DescargarArchivo() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }

    private String carpeta = "C:\\Users\\gonza\\Desktop\\prueba";

    @FindBy(xpath = "//*[contains(text(),'some-file.txt')]")
    private WebElement btnArchivoDescargar;

    public void deleteArchivo() {
        esperar(5);
        File file = new File(carpeta + "\\some-file.txt");
        if (file.delete()) {
            System.out.println("Se ha borrado el archivo");
        } else {
            System.err.println("No ha sido borrado el archivo");
        }
    }

    public void archivoDescarga() {
        if (validarObjeto(btnArchivoDescargar, "Boton Archivo de descarga")) {
            btnArchivoDescargar.click();
            System.out.println("Encontrado");
        } else {
            System.err.println("No se encontro");
        }


    }

    public void validacionDeArchivo(String nameArchivo) {
        esperar(5);
        File file = new File(nameArchivo);
        if (file.exists()) {
            System.out.println("Existe el archivo");
        } else {
            System.err.println("No se encontro el archivo");
        }

    }


}
