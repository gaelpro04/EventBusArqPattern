# EventBusArqPattern
Para ejecutar el proyecto ya hay una clase añadida que es el main, este ya tiene incializada todos los objetos necesarios para el funcionamiento del proyecto.

Primeramente fue incializar el publicador, eventBus, y suscriptores que fueron: barra, cocina, panelLED, sistemaDeSonido, banda y sistemeHumo(BONUS). Posteriormente se crean los eventos que consisten en comidaServida, bebidasServidas, pedidoRealizo. 

Se añaden los suscriptores al eventBus con el evento especificado. Por ultimo se publican en eventBus.

Otra cosa a destacar que para simular en paralelo se utilizaon de Threads en el metodo publicar de eventBus.
