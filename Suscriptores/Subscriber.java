package Suscriptores;

import Eventos.Evento;

public interface Subscriber {
    void Handle(Evento evento) throws InterruptedException;
}
