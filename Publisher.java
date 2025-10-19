public interface Publisher {
    void publicar(Evento evento) throws InterruptedException;
    void setEventBus(EventBus eventBus);
    String getPublicador();

}
