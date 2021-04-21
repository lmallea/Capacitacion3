package pages.chileAutos;

import Utils.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import static Utils.Validaciones.validarObjeto;

public class AutoSeleccionado {
    public AutoSeleccionado() {
        PageFactory.initElements(new DriverContext().getDriver(), this);
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/section[14]/div/div/a")
    WebElement leerMas;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/section[14]/div/div/div/p")
    WebElement comentario;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/section[16]/div")
    WebElement vision;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/section[4]/div")
    WebElement clickImagen;
    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div[2]/div/div[1]/div[3]/div/div/div")
    List<WebElement> imagenes;
    String d;
    String e;
    String url;
    public void recuperandoInformacion() {
        if (validarObjeto(leerMas, "Elemento q despliega el resto del texto")) {
            leerMas.click();
        } else {
            System.err.println("No se pudo realizar el click");
        }
        if (validarObjeto(comentario, "Descripcion del anuncio")) {
            d = comentario.getText();
            System.out.println("Comentarios: \n" + d);
        } else {
            System.err.println("No se encontro el texto");
        }
        if (validarObjeto(vision, "Vision general del anuncio")) {
            e = vision.getText();
            System.out.println(e);
        } else {
            System.err.println("No se encontro el texto");
        }
    }
    public void descargando() {
        clickImagen.click();
        for (int i = 0; i < imagenes.size(); i++) {
            String imagen = "/imagen" + i + ".jpg";
            url = imagenes.get(i).findElement(By.tagName("img")).getAttribute("src");
            System.out.println(url);
            String folder = "C:\\Users\\gonza\\Desktop\\fotos de autos";
            File dir = new File(folder);
            if (!dir.exists())
                if (!dir.mkdir())
                    return;
            File file = new File(folder + imagen);
            URLConnection conn = null;
            try {
                conn = new URL(url).openConnection();
                conn.connect();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("\ndescargando: \n");
            System.out.println("URL: " + url);
            System.out.println("NombreArchivo: " + imagen);
            System.out.println("Tamaño: " + conn.getContentLength() + " bytes");
            try {
                InputStream in = conn.getInputStream();
                OutputStream out = new FileOutputStream(file);
                int b = 0;
                while (b != -1) {
                    b = in.read();
                    if (b != -1)
                        out.write(b);
                }
                out.close();
                in.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
