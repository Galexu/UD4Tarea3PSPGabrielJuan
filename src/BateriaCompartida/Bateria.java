package BateriaCompartida;

public class Bateria {
    private int energia;

    public synchronized void agregarEnergia(int cantidad) {
        while (energia + cantidad > 300) {
            System.out.println("La bateria esta llena, esperando a que se consuma.");

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        energia += cantidad;
        System.out.println("El productor ha agregado " + cantidad + " unidades de energía -> Energía actual: " + energia);
        notifyAll();
    }

    public synchronized void consumirEnergia(int cantidad) {
        while (energia < cantidad) {
            System.out.println("No hay suficiente energía para consumir, esperando a que se recargue.");

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        energia -= cantidad;
        System.out.println("El consumidor ha usado " + cantidad + " unidades de energía -> Energía actual: " + energia);
        notifyAll();
    }
}