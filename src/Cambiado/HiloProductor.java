package Cambiado;

class HiloProductor implements Runnable {
    private final Contenedor<Integer> contenedor;
    private String nombre;

    public HiloProductor(Contenedor<Integer> contenedor, String nombre) {
        this.nombre = nombre;
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        for (int i = 1; ; i++) {
            synchronized (contenedor) {
                while (this.contenedor.isDatoDisponible()) {
                    try {
                        contenedor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.printf("Hilo %s produce el valor %d.\n", this.nombre, i);
                this.contenedor.put(i);
                contenedor.notifyAll();
            }
        }
    }
}