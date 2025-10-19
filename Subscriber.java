public interface Subscriber {
    void Handle(Evento evento) throws InterruptedException;
}
