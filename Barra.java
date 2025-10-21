public class Barra implements Subscriber, Publisher {

    private EventBus eventBus;

    public Barra() {
        eventBus = new EventBusT();
    }

    public Barra(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void Handle(Evento evento) throws InterruptedException {
        if (evento instanceof PedidoRealizafoEvent) {
            PedidoRealizafoEvent pedido = (PedidoRealizafoEvent) evento;

            for (Evento eventoPedido : pedido.getItems()) {
                if (eventoPedido instanceof BebidaServidaEvent) {
                    System.out.println("[BARRA] Se recibio pedido: " + pedido.getPedidoID() + " de la mesa " + pedido.getMesaID());
                    Thread.sleep(2000);

                    BebidaServidaEvent eventoBarra = (BebidaServidaEvent) eventoPedido;
                    System.out.println("[BARRA] Bebidas terminadas: " + eventoBarra.getBebida() + " de la mesa " + pedido.getMesaID());

                    publicar(eventoBarra);
                }
            }
        }
    }

    @Override
    public void publicar(Evento evento) throws InterruptedException {
        if (eventBus != null) {
            eventBus.publicar(evento);
        }
    }

    @Override
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public String getPublicador() {
        return "Barra";
    }
}
