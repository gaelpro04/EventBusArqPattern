
//Clase extra: Agregar un nuevo suscriptor
//Primero se parte en que se debe implementar la interfaz Subscriber
//para posteriormente añadir el desarrollo del metodo que hace distinguir
//entre los demas eventos
public class SistemaDeHumo implements Subscriber {

    //Aqui se hace el desarollo del evento que es especifico de cada suscriptor
    @Override
    public void Handle(Evento evento) throws InterruptedException {

        //Ademas se pregunta si el evento es de un evento especifico en interes
        if (evento instanceof BandaTocandoEvent) {
            BandaTocandoEvent eventoBanda = (BandaTocandoEvent) evento;

            //Si es la cancion "Through the Fire and Flames" se activa el humo
            if (eventoBanda.getNombreCancion().equals("Through the Fire and Flames")) {
                System.out.println("[SISTEMA HUMO] Generando humo...");
            }
        }
    }
}
