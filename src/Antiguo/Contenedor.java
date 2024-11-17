package Antiguo;

class Contenedor<T> {
    private T dato;

    public T get() {
        T result = this.dato;
        this.dato = null;
        return result;
    }

    public void put(T valor) {
        this.dato = valor;
    }

    public boolean isDatoDisponible() {
        return (this.dato != null);
    }
}
