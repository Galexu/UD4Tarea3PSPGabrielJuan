package Cambiado;

public class ProductorConsumidor {
    public static void main(String[] args) {
        Contenedor<Integer> almacen = new Contenedor<>();

        Thread hprod = new Thread(new HiloProductor(almacen, "P1"));
        Thread hprod2 = new Thread(new HiloProductor(almacen, "P2"));
        Thread hcons = new Thread(new HiloConsumidor(almacen, "C1"));
        Thread hcons2 = new Thread(new HiloConsumidor(almacen, "C2"));

        hprod.start();
        hprod2.start();
        hcons.start();
        hcons2.start();
    }
}