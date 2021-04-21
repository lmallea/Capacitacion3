package testClases.ejercicioChileAutos;

import pages.chileAutos.AnunciosDeAutos;
import pages.chileAutos.AutoSeleccionado;
import pages.chileAutos.IngresarALaPagina;

public class EjecutandoMetodos {
    public void ejecutandoIngreso(){
        IngresarALaPagina ingresarALaPagina = new IngresarALaPagina();
        ingresarALaPagina.ingresando();
        ingresarALaPagina.buscando();
    }
    public void seleccionando(){
        AnunciosDeAutos anunciosDeAutos = new AnunciosDeAutos();
        anunciosDeAutos.recuperar();
        anunciosDeAutos.clickDetalles();
    }
    public void recuperando(){
        AutoSeleccionado autoSeleccionado = new AutoSeleccionado();
        autoSeleccionado.recuperandoInformacion();
        autoSeleccionado.descargando();
    }
}
