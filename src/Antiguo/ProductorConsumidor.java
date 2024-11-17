package Antiguo;

public class ProductorConsumidor {
    public static void main(String[] args) {
        Contenedor<Integer> almacen = new Contenedor<>();
        Thread hprod = new Thread(new HiloProductor(almacen, "Prod"));
        Thread hcons = new Thread(new HiloConsumidor(almacen, "Consum"));
        hprod.start();
        hcons.start();
    }
}