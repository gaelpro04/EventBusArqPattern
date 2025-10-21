import Eventos.*;
import Publicador.Banda;
import Suscriptores.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws  InterruptedException {

        //Publicador
        SistemaDePedidos sistema = new SistemaDePedidos();

        //Event bus
        EventBusT eventBus = new EventBusT();

        //Suscriptores
        Barra barra = new Barra(eventBus);
        Cocina cocina = new Cocina(eventBus);
        PanelLED panel = new PanelLED();
        SistemaDeSonido sistemaSonido = new SistemaDeSonido();
        Banda banda = new Banda(eventBus);

        //Demostracion de extensibilidad(nuevo suscriptor)
        SistemaDeHumo sistemHumo = new SistemaDeHumo();

        //Eventos
        BandaTocandoEvent bandaEvent = new BandaTocandoEvent("Los seguidores de Dijkstra","El Algoritmo del amor", 180);
        BebidaServidaEvent bebidasEvent = new BebidaServidaEvent(5,"Cerveza");
        ComidaPreparadaEvent comidaEvent = new ComidaPreparadaEvent(123,"Hamburguesa");

        List<Evento> eventos = new ArrayList<>();
        eventos.add(bebidasEvent);
        eventos.add(comidaEvent);

        PedidoRealizafoEvent pedidoRealizado = new PedidoRealizafoEvent(bebidasEvent.getMesaID(), comidaEvent.getPedidoID(), eventos);

        eventBus.addPublicador(sistema);

        eventBus.suscribir(pedidoRealizado, barra);
        eventBus.suscribir(pedidoRealizado, cocina);
        eventBus.suscribir(bandaEvent, sistemaSonido);
        eventBus.suscribir(bandaEvent, panel);
        eventBus.suscribir(bandaEvent, sistemHumo);
        eventBus.suscribir(pedidoRealizado, panel);

        eventBus.publicar(pedidoRealizado);
        eventBus.publicar(bandaEvent);


    }
}
