package pages.paginaQanova;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static Utils.Validaciones.esperar;
import static Utils.Validaciones.validarObjeto;

public class EnviarMail {
    public EnviarMail() { PageFactory.initElements(new DriverContext().getDriver(), this); }

    @FindBy(xpath = "//*[@id=\"pluginAppObj_4_01_jtable\"]/div/table/tbody/tr[1]")
    WebElement recuperado;
    // METODO PARA RECUPERAR LOS DATOS QUE VOY A ENVIAR POR CORREO
    public void recuperacion() {
        if (validarObjeto(recuperado, "los datos que voy a recuperar")) {
            esperar(10);
            String datos = recuperado.getText();
        } else {
            System.err.println("No se recuperaron los datos");
        }
    }
    //METODO PARA ENVIAR CORREO
    public void procesoDeEnvio(String mailEnvia, String asunto, String mensaje, String pass4, String destino){

        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host","smtp.gmail.com");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.port", 587);
        propiedades.put("mail.smtp.auth", "true");
        Session sesion = Session.getDefaultInstance(propiedades);
        MimeMessage correo = new MimeMessage(sesion);
        try{
          correo.setFrom(new InternetAddress(mailEnvia));
          correo.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
          correo.setSubject(asunto);
          correo.setText(mensaje);

          Transport transport = sesion.getTransport("smtp");
          transport.connect(mailEnvia,pass4);
          transport.sendMessage(correo,correo.getRecipients(Message.RecipientType.TO));
          transport.close();

        }catch(MessagingException e){
            System.out.println(e.getMessage());
        }
    }
}
