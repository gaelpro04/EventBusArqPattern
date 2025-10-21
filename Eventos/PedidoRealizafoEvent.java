package Eventos;

import java.util.List;

public class PedidoRealizafoEvent implements Evento {

    private int mesaID;
    private int pedidoID;
    private List<Evento> items;

    public PedidoRealizafoEvent(int mesaID, int pedidoID, List<Evento> items) {
        this.mesaID = mesaID;
        this.pedidoID = pedidoID;
        this.items = items;
    }

    public int getMesaID() {
        return mesaID;
    }

    public void setMesaID(int mesaID) {
        this.mesaID = mesaID;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public List<Evento> getItems() {
        return items;
    }

    public void setItems(List<Evento> items) {
        this.items = items;
    }

    @Override
    public String getNombreEvento() {
        return "PedidoRealizadoEvent";
    }
}
