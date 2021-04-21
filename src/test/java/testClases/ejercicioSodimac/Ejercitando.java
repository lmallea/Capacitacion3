package testClases.ejercicioSodimac;

import Utils.ReadProperties;
import pages.sodimac.Login;
import pages.sodimac.LuegoDeFiltrarPinturas;

import java.io.IOException;

public class Ejercitando {
    String busqueda = ReadProperties.readFromConfig("propiedades.properties").getProperty("dato1");
    String dato = ReadProperties.readFromConfig("propiedades.properties").getProperty("ruta");
    public void ejecutandoLogin() throws IOException{
        Login pruebas = new Login();
        pruebas.clickMantener();
        pruebas.buscar(busqueda);
    }
    public void recuperarArchivo() throws IOException {
        LuegoDeFiltrarPinturas luegoDeFiltrarPinturas = new LuegoDeFiltrarPinturas();
        luegoDeFiltrarPinturas.recuperando(dato);
    }
}
