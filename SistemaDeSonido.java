public class SistemaDeSonido implements Subscriber {
    @Override
    public void Handle(Evento evento) {
        if (evento instanceof BandaTocandoEvent)  {
            BandaTocandoEvent eventoBanda = (BandaTocandoEvent) evento;

            System.out.println("[SISTEMA SONIDO] Ajustando ecualizador para: " + "[" + eventoBanda.getNombreCancion() + "]");
        }
    }
}
