public class ComidaPreparadaEvent implements Evento {

    private int pedidoID;
    private String plato;

    public ComidaPreparadaEvent(int pedidoID, String plato) {
        this.pedidoID = pedidoID;
        this.plato = plato;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    @Override
    public String getNombreEvento() {
        return "ComidaPreparadaEvent";
    }
}
