package Cambiado;

class HiloConsumidor implements Runnable {
    private Contenedor<Integer> contenedor;
    private final String nombre;

    public HiloConsumidor(Contenedor<Integer> contenedor, String nombre) {
        this.contenedor = contenedor;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (contenedor) {
                while (!this.contenedor.isDatoDisponible()) {
                    try {
                        contenedor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Integer dato = this.contenedor.get();
                System.out.printf("Hilo %s consume el valor %d.\n", nombre, dato);
                contenedor.notifyAll();
            }
        }
    }
}