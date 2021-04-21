package pages.chileAutos;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utils.Validaciones.esperar;
import static Utils.Validaciones.validarObjeto;

public class AnunciosDeAutos {
    public AnunciosDeAutos() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }
    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div/a/div[2]/div[2]/span/span[1]")
    WebElement fotos;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div/a/div[2]/div[2]/span/span[2]")
    WebElement videos;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div/div[4]/div[2]/a[2]")
    List<WebElement> listSeleccionar;
    String c;
    public void recuperar(){
        if (validarObjeto(fotos,"Cantidad de fotos")){
            c = fotos.getText();
            System.out.println("Fotos: " + c);
        }else{
            System.err.println("No se encontro la descripcion");
        }
        if (validarObjeto(videos,"Cantidad de videos")){
            c = videos.getText();
            System.out.println("Videos: " + c);
        }
    }
    public void clickDetalles(){
        for(int i = 0; i< listSeleccionar.size(); i ++){
            listSeleccionar.get(0).click();
        }
    }
}
