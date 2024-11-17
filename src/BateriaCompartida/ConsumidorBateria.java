package BateriaCompartida;

import java.util.Random;

public class ConsumidorBateria extends Thread {
    private final Bateria bateria;

    public ConsumidorBateria(Bateria bateria) {
        this.bateria = bateria;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            bateria.consumirEnergia(random.nextInt(50) + 1);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}