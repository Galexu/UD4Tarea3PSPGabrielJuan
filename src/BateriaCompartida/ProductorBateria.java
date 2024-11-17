package BateriaCompartida;

import java.util.Random;

public class ProductorBateria extends Thread {
    private final Bateria bateria;

    public ProductorBateria(Bateria bateria) {
        this.bateria = bateria;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            bateria.agregarEnergia(random.nextInt(50) + 1);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}