public class Banda implements Publisher {

    private EventBus eventBus;

    public Banda(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void publicar(Evento evento) throws InterruptedException {
        eventBus.publicar(evento);
    }

    @Override
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public String getPublicador() {
        return "Banda";
    }
}
