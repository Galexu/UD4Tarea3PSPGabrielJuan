package pruebas;

import java.util.Random;

public class Escritor implements Runnable {
    private MessageRepository messageRepository;

    public Escritor(MessageRepository messageRepository) {
        this. messageRepository = messageRepository;
    }

    @Override
    public void run() {
        String messages[] = {
                "Programacion de servicios",
                "Acceso a datos",
                "Dispositivos móviles",
                "Desarrollo de interfaces",
                "Sistema de gestión empresarial"
        };

        Random random = new Random();
        for (int i = 0; i < messages.length; i++) {
            messageRepository.write(messages[i]);
            System.out.println("Escribo mensaje " + i);

            try {
                Thread.sleep(random.nextInt(500, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        messageRepository.write("EOF");
    }
}
