package pruebas;

import java.util.Random;

class Lector implements Runnable {
    private MessageRepository messageRepository;

    public Lector(MessageRepository messageRepository) {
        this. messageRepository = messageRepository;
    }

    @Override
    public void run() {
        Random random = new Random();
        String latestMessage = "";

        do {
            try {
                Thread.sleep(random.nextInt(500, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            latestMessage = messageRepository.read();
            System.out.println(latestMessage);
        } while (!latestMessage.equals("Fin"));
    }
}