package pages.sodimac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static Utils.Validaciones.esperar;

public class LuegoDeFiltrarPinturas {
    @FindBy(xpath= "//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]")
    WebElement pagina;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[6]/div/div[1]/div/div/i")
    List<WebElement> listaEstrellas;
    // METODO PARA RECUPERAR LOS DATOS DE LOS PRODUCTOS Y GUARDARLOS EN UN TXT
    public void recuperando(String ruta) throws IOException {
        File file = new File(ruta);
        FileWriter fwr = new FileWriter(file);
        PrintWriter bwr = new PrintWriter(fwr);
        String d = "";
        String c;
        double total = 0.0;
        String parametro = "jsx-3921358990 icon cs-icon-star-filled";
        String parametro1 = "jsx-3921358990 icon cs-icon-star-half_filled";
        esperar(10);
        List<WebElement> list = pagina.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div"));
        List<WebElement> nombreMarcas = pagina.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[3]"));
        List<WebElement> producto = pagina.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[4]"));
        List<WebElement> calificaciones = pagina.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[6]/div/div[1]/span"));
        List<WebElement> precios = pagina.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[6]/div/div[3]"));;
        List<WebElement> despachos = pagina.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[6]/div/div[4]/div[1]"));
        List<WebElement> retiros = pagina.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[5]/div[3]/div/div[1]/div[3]/div/div/div[6]/div/div[4]/div[2]"));
        int cantidad = list.size();
        List<Double> arreglo = new ArrayList<>();
        for(int i = 0; i < cantidad; i++ ) {
            for (int j = i; j < listaEstrellas.size(); j++) {
                c = listaEstrellas.get(j).getAttribute("class");
                if ((j % 5) == 0 && j != 0) {
                    arreglo.add(total);
                    total = 0;
                }
                if (c.equals(parametro)) {
                    total = total + 1.0;
                } else if (c.equals(parametro1)) {
                    total = total + 0.5;
                } else {
                }
            }
            d ="Nombre de la Marca: " +nombreMarcas.get(i).getText() + "\n" + "Nombre del producto: " +producto.get(i).getText() + "\n" +"Cantidad de estrellas: " + arreglo.get(i) + "\n" + "Calificaciones obtenidas: " + calificaciones.get(i).getText() + "\n" + "Precio del producto: " + precios.get(i).getText() + "\n" + despachos.get(i).getText()+ "\n" + retiros.get(i).getText() + "\n++++++++++++++++\n\n";
            System.out.println(d);
            bwr.write(d);
        }
        //PrintWriter bwr = new PrintWriter(fwr);
        bwr.close();
    }
}