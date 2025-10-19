public class Contador {
    public int contador = 0;

    synchronized void incrementar() {
        contador++;
    }
}
