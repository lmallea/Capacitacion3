package testClases.pruebaQanova;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import pages.paginaQanova.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Ingresar {
    String user = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
    String pass = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
    String incorrect = ReadProperties.readFromConfig("propiedades.properties").getProperty("claveIncorrecta");
    String texto1 = ReadProperties.readFromConfig("propiedades.properties").getProperty("txt");
    String mail1 = ReadProperties.readFromConfig("propiedades.properties").getProperty("mail");
    String dato1 = ReadProperties.readFromConfig("propiedades.properties").getProperty("dato");
    String date1 = ReadProperties.readFromConfig("propiedades.properties").getProperty("date");
    String elemento = ReadProperties.readFromConfig("propiedades.properties").getProperty("valor");
    String buscador = ReadProperties.readFromConfig("propiedades.properties").getProperty("buscar");
    String direccion = ReadProperties.readFromConfig("propiedades.properties").getProperty("url1");
    String calendario = ReadProperties.readFromConfig("propiedades.properties").getProperty("date");
    String name = ReadProperties.readFromConfig("propiedades.properties").getProperty("nombre");
    String usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("nombreUsuario");
    String pass1 = ReadProperties.readFromConfig("propiedades.properties").getProperty("contrasena");
    String pass2 = ReadProperties.readFromConfig("propiedades.properties").getProperty("repiteContrasena");
    String last = ReadProperties.readFromConfig("propiedades.properties").getProperty("nombreCompleto");
    String correo = ReadProperties.readFromConfig("propiedades.properties").getProperty("E-mail");
    String palabra = ReadProperties.readFromConfig("propiedades.properties").getProperty("oracion");
    String message = ReadProperties.readFromConfig("propiedades.properties").getProperty("asunto");
    String sms = ReadProperties.readFromConfig("propiedades.properties").getProperty("mensaje");
    String clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("pass4");
    String mail2 = ReadProperties.readFromConfig("propiedades.properties").getProperty("mailEnvia");
    String destinatario = ReadProperties.readFromConfig("propiedades.properties").getProperty("destino");

    public void introducir() {
        IngresarQanova ingresarQanova = new IngresarQanova();
        ingresarQanova.ingresarPaginaQanova(name);
        ingresarQanova.ingresarUsuario(user);
        ingresarQanova.ingresarClave(pass);
        ingresarQanova.ingresarDemo();
        ingresarQanova.validarProximaPagina(palabra);
    }
    public void loginIncorrecto() {
        Incorrecto incorrecto = new Incorrecto();
        incorrecto.ingresarPaginaQanova(name);
        incorrecto.ingresarUsuario(user);
        //incorrecto.ingresarClave(incorrect);
        //incorrecto.ingresarIncorrecto();
        //incorrecto.rescatarTC();
    }
    public void registroPagina() {
        NuevoIngreso nuevoIngreso = new NuevoIngreso();
        nuevoIngreso.ingresarPaginaQanova(name);
        nuevoIngreso.clickAqui();
        nuevoIngreso.rellenarUsuario(usuario);
        nuevoIngreso.completarContrasena(pass1);
        nuevoIngreso.repetirContrasena(pass2);
        nuevoIngreso.completarNombre(last);
        nuevoIngreso.escribirMail(correo);
        nuevoIngreso.registrarse();
    }
    public void rellenar() {
        CargaInformacion cargaInformacion = new CargaInformacion();
        cargaInformacion.ingresarTexto(texto1);
        cargaInformacion.ingresarCorreo(mail1);
        cargaInformacion.ingresarArea(dato1);
        //cargaInformacion.clickCalendario();
        //cargaInformacion.seleccionarFecha(calendario);
        cargaInformacion.ingresarFecha(date1);
        cargaInformacion.ingresarLista();
        cargaInformacion.seleccionar(elemento);
        cargaInformacion.ingresarLista();
        cargaInformacion.clickMultiple();
        cargaInformacion.clickRadio();
        cargaInformacion.clickEnviar();
    }
    public void recuperarCorreo() {
        GuardarCorreos guardarCorreos = new GuardarCorreos();
        guardarCorreos.clickMatriz();
        guardarCorreos.escribir(buscador);
        guardarCorreos.enter();
        guardarCorreos.guardarDatos();
        guardarCorreos.recuperar();
    }
    public void cargaDeArchivo() {
        Archivo archivo = new Archivo();
        archivo.ingresarArchivo();
        archivo.cargarArchivo(direccion);
        archivo.enviar();
    }
    public void envioDeCorreo() {
        EnviarMail enviarMail = new EnviarMail();
        GuardarCorreos guardarCorreos = new GuardarCorreos();
        guardarCorreos.escribir(buscador);
        guardarCorreos.enter();
        guardarCorreos.guardarDatos();
        enviarMail.recuperacion();
        enviarMail.procesoDeEnvio(mail2,sms,message,clave,destinatario);
    }
    public void login()throws Exception{
        String json = "";
        String linea;
        BufferedReader brr = new BufferedReader(new FileReader("usuarios.json"));
        while ((linea = brr.readLine()) != null){
            json += linea;
        }
        brr.close();
        System.out.println(json);
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Users>>(){}.getType();
        ArrayList<Users> arrayDeJson = gson.fromJson(json, listType);
        for (int i = 0; i < arrayDeJson.size(); i++){
            IngresarQanova ingresarQanova = new IngresarQanova();
            ingresarQanova.ingresarUsuario(arrayDeJson.get(i).nombre);
            ingresarQanova.ingresarClave(arrayDeJson.get(i).clave);
            System.out.println(arrayDeJson.get(i).nombre + "\n");
            System.out.println(arrayDeJson.get(i).clave + "\n");
            PdfQaNovaReports.addWebReportImage("Ingresar Credenciales " + (i + 1), "Se visualiza el llenado de los campos Usuario y Contrasena", EstadoPrueba.PASSED, false);
            ingresarQanova.ingresarDemo();
            DriverContext.getDriver().navigate().back();
        }
    }
    public void login1()throws Exception {
        IngresarQanova ingresarQanova = new IngresarQanova();
        String json1 = "";
        String linea1;
        BufferedReader brr = new BufferedReader(new FileReader("users.json"));
        while ((linea1 = brr.readLine()) != null) {
            json1 += linea1;
        }
        brr.close();
        System.out.println(json1);
        JsonObject jsonObject = new Gson().fromJson(json1,JsonObject.class);
        JsonArray jsonUsers = jsonObject.getAsJsonArray("Usuarios");
        String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("url");
        for (int i = 0; i < jsonUsers.size(); i++){
            JsonObject jsonArreglo = (JsonObject) jsonUsers.get(i);
            ingresarQanova.ingresarPaginaQanova(name);
            usuario = jsonArreglo.get("nombre").getAsString();
            ingresarQanova.ingresarUsuario(usuario);
            clave = jsonArreglo.get("clave").getAsString();
            ingresarQanova.ingresarClave(clave);
            ingresarQanova.ingresarDemo();
            ingresarQanova.validarProximaPagina(palabra);
            DriverContext.getDriver().navigate().to(url);

        }
    }
}
