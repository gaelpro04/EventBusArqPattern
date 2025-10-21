public class PanelLED implements Subscriber {
    @Override
    public void Handle(Evento evento) throws InterruptedException {
        if (evento instanceof PedidoRealizafoEvent) {
            PedidoRealizafoEvent eventoPedido = (PedidoRealizafoEvent) evento;
            Thread.sleep(6000);
            System.out.println("[PANEL LED] Pedido listo: mesa " + eventoPedido.getMesaID() + ", pedido " + eventoPedido.getPedidoID());

            for (Evento eventos : eventoPedido.getItems()) {
                if (eventos instanceof BebidaServidaEvent) {
                    BebidaServidaEvent eventoBebidas = (BebidaServidaEvent) eventos;
                    System.out.println("[PANEL LED] Bebidas servidas: " + eventoBebidas.getBebida() + " de la mesa " + eventoBebidas.getMesaID());
                } else if (eventos instanceof ComidaPreparadaEvent) {
                    ComidaPreparadaEvent eventoComida = (ComidaPreparadaEvent) eventos;
                    System.out.println("[PANEL LED] Comida servidas: " + eventoComida.getPlato() + " del pedido " + eventoComida.getPedidoID());
                }
            }
        } else if (evento instanceof BandaTocandoEvent) {
            BandaTocandoEvent eventoBanda = (BandaTocandoEvent) evento;
            System.out.println("[PANEL LED] Tocando: " + eventoBanda.getNombreCancion() + " de la banda " + ((BandaTocandoEvent) evento).getNombreBanda());
        }
    }
}
