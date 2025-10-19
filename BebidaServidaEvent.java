public class BebidaServidaEvent implements Evento {

    private int mesaID;
    private String bebida;

    public BebidaServidaEvent(int mesaID, String bebida) {
        this.mesaID = mesaID;
        this.bebida = bebida;
    }

    public int getMesaID() {
        return mesaID;
    }

    public void setMesaID(int mesaID) {
        this.mesaID = mesaID;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    @Override
    public String getNombreEvento() {
        return "BebidaServidaEvent";
    }
}
