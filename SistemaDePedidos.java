public class SistemaDePedidos implements Publisher {

    private EventBus eventBus;

    public SistemaDePedidos(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public SistemaDePedidos() {
        eventBus = new EventBusT();
    }

    @Override
    public void publicar(Evento evento)
    {
        eventBus.publicar(evento);
    }

    @Override
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public EventBus getEventBus()
    {
        return eventBus;
    }

    @Override
    public String getPublicador() {
        return "SistemaDePedidos";
    }
}
