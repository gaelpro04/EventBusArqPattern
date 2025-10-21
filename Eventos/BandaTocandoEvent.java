package Eventos;

public class BandaTocandoEvent implements Evento {

    private String nombreBanda;
    private String nombreCancion;
    private int duracion;

    public BandaTocandoEvent(String nombreBanda, String nombreCancion, int duracion) {
        this.nombreBanda = nombreBanda;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String getNombreEvento() {
        return "Eventos.BandaTocandoEvent";
    }
}
