package testClases.pruebaQanova;

import Utils.ReadProperties;
import pages.paginaQanova.*;

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


public void introducir(){
    IngresarQanova ingresarQanova = new IngresarQanova();
    CargaInformacion cargaInformacion = new CargaInformacion();
    GuardarCorreos guardarCorreos = new GuardarCorreos();
    Archivo archivo = new Archivo();
    ingresarQanova.ingresarPaginaQanova(name);
    ingresarQanova.ingresarUsuario(user);
    ingresarQanova.ingresarClave(pass);
    ingresarQanova.ingresarDemo();
    ingresarQanova.validarProximaPagina(palabra);

    /*guardarCorreos.clickMatriz();
    guardarCorreos.escribir(buscador);
    guardarCorreos.enter();
    guardarCorreos.guardarDatos();
    guardarCorreos.recuperar();
    archivo.ingresarArchivo();
    archivo.cargarArchivo(direccion);
    archivo.enviar() */
}
  public void loginIncorrecto(){
      Incorrecto incorrecto = new Incorrecto();
      incorrecto.ingresarPaginaQanova(name);
      incorrecto.ingresarUsuario(user);
      incorrecto.ingresarClave(incorrect);
      incorrecto.ingresarIncorrecto();
      incorrecto.rescatarTC();
  }
  public void registroPagina(){
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
  public void rellenar(){
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
}
