package Utils;

import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Validaciones {

    public static boolean validarObjeto(WebElement elemento, String descripcionElemento) {
        WebDriverWait espera = new WebDriverWait(DriverContext.getDriver(),Integer.valueOf(ReadProperties.readFromConfig("propiedades.properties").getProperty("tiempoEsperaElementos")));
       // String identificador;
        try {
            espera.until(ExpectedConditions.visibilityOf(elemento));
           // identificador = elemento.getAttribute("xpath");
           // if (identificador == null) {
           //     identificador = elemento.getAttribute("id");
            //}
            System.out.println("Se despliega correctamente el elemento \"" + descripcionElemento  );
        return true;
        } catch (Exception e) {
            System.out.println("No se despliega el elemento \"" + descripcionElemento + "\"");
            return false;
        }
    }

    public static void esperar(int segundos){
        int aMilisegundos = segundos*1000;
        try {
            Thread.sleep(aMilisegundos);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
