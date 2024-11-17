package BateriaCompartida;

public class MainBateria {
    public static void main(String[] args) {
        Bateria bateria = new Bateria();

        ProductorBateria productor1 = new ProductorBateria(bateria);
        ConsumidorBateria consumidor1 = new ConsumidorBateria(bateria);
        ProductorBateria productor2 = new ProductorBateria(bateria);
        ConsumidorBateria consumidor2 = new ConsumidorBateria(bateria);
        ProductorBateria productor3 = new ProductorBateria(bateria);
        ConsumidorBateria consumidor3 = new ConsumidorBateria(bateria);

        productor1.start();
        consumidor1.start();
        productor2.start();
        consumidor2.start();
        productor3.start();
        consumidor3.start();
    }
}
