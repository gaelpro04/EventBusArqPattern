package Eventos;

import Publicador.Publisher;
import Suscriptores.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBusT implements EventBus {

    //Atributos de la clase
    //Una almacena suscriptores. En cada evento presentado pueden presentarse varios suscriptores que atienden
    //un mismo evento
    private Map<String, List<Subscriber>> suscriptores;

    //Publicador encargado de mandar el pedido al eventBus
    private List<Publisher> publicadores;

    public EventBusT() {
        suscriptores = new HashMap<>();
        publicadores = new ArrayList<>();
    }

    //Metodo que permite suscribir nuevos suscriptores con respectivo evento, primero se checa que existe para añadirlo
    @Override
    public void suscribir(Evento evento, Subscriber suscriptor) {
        List<Subscriber> lista = suscriptores.get(evento.getNombreEvento());

        if (lista == null) {
            lista = new ArrayList<>();
            suscriptores.put(evento.getNombreEvento(), lista);
        }

        lista.add(suscriptor);
    }

    //La contraparte del metodo anterior, este desuscribe pero sigue verificado si existe el suscriptor y evento concreto
    @Override
    public void desuscribir(Evento evento, Subscriber suscriptor) {
        List<Subscriber> lista = suscriptores.get(evento.getNombreEvento());

        if (lista != null) {
            lista.remove(suscriptor);

            if (lista.isEmpty()) {
                suscriptores.remove(evento.getNombreEvento());
            }
        }
    }

    //El eventBus publica el nuevo evento, los suscriptores encargados de ese evento, se hacen cargo del mismo
    @Override
    public void publicar(Evento evento) throws InterruptedException {
        List<Subscriber> lista = suscriptores.get(evento.getNombreEvento());

        if (lista != null) {
            for (Subscriber suscriptor : lista) {
                new Thread(() -> {
                    try {
                        suscriptor.Handle(evento);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }

    }

    //añadir publicadores
    @Override
    public void addPublicador(Publisher publisher)
    {
        publicadores.add(publisher);
    }

}
