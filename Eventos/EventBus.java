package Eventos;

import Publicador.Publisher;
import Suscriptores.Subscriber;

public interface EventBus {
    void suscribir(Evento evento, Subscriber suscriptor);
    void desuscribir(Evento evento, Subscriber suscriptor);
    void publicar(Evento evento) throws InterruptedException;
    void addPublicador(Publisher publisher);
}
