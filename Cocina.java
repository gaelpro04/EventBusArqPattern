public class Cocina implements Subscriber, Publisher {

    private EventBus eventBus;

    public Cocina(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void Handle(Evento evento) {

    }

    @Override
    public void publicar(Evento evento) {

    }

    @Override
    public void setEventBus(EventBus eventBus) {

    }

    @Override
    public String getPublicador() {
        return "";
    }
}
