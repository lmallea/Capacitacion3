package testClases.pruebaDeDescarga;

import Utils.ReadProperties;
import pages.descargar.DescargarArchivo;

public class Descargando {
    String nombre = ReadProperties.readFromConfig("propiedades.properties").getProperty("nameArchivo");
    public void probarDescarga(){
        DescargarArchivo descargarArchivo = new DescargarArchivo();
        descargarArchivo.deleteArchivo();
        descargarArchivo.archivoDescarga();
        descargarArchivo.validacionDeArchivo(nombre);

    }
}
