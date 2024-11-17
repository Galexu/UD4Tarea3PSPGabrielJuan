package pruebas;

public class Main {
    public static void main(String[] args) {
        final MessageRepository repository = new MessageRepository();
        new Thread(new Escritor(repository)).start();
        new Thread(new Lector(repository)).start();
    }
}
