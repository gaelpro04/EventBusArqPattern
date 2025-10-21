public class Cocina implements Subscriber, Publisher {

    private EventBus eventBus;

    public Cocina(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void Handle(Evento evento) throws InterruptedException {
        if (evento instanceof PedidoRealizafoEvent) {
            PedidoRealizafoEvent pedido = (PedidoRealizafoEvent) evento;

            for (Evento eventoPedido : pedido.getItems()) {
                if (eventoPedido instanceof ComidaPreparadaEvent) {
                    System.out.println("[COCINA] se recibio pedido " + pedido.getPedidoID() + " de la mesa " + pedido.getMesaID());
                    Thread.sleep(5000);

                    ComidaPreparadaEvent eventoCocina = (ComidaPreparadaEvent) eventoPedido;
                    System.out.println("[COCINA] Platillos terminados: " + eventoCocina.getPlato() + " de la mesa " + pedido.getMesaID());

                    publicar(eventoCocina);
                }
            }
        }
    }

    @Override
    public void publicar(Evento evento) throws InterruptedException {
        if (evento != null) {
            eventBus.publicar(evento);
        }
    }

    @Override
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public String getPublicador() {
        return "Cocina";
    }
}
