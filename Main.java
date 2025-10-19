public class Main {
    public static void main(String[] args) throws  InterruptedException {
        Contador contador = new Contador();

        Thread t1 = new Thread(() -> contador.incrementar());
        Thread t2 = new Thread(() -> contador.incrementar());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Valor final: " + contador.contador);
    }
}
