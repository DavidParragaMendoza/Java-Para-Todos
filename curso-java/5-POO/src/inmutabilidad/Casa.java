package inmutabilidad;

public final class Casa {
    private final int puertas;
    private final int ventanas;
    private final double tamaño;

    public Casa(int puertas, int ventanas, double tamaño) {
        this.puertas = puertas;
        this.ventanas = ventanas;
        this.tamaño = tamaño;
    }

    public int getPuertas() {
        return puertas;
    }

    public int getVentanas() {
        return ventanas;
    }

    public double getTamaño() {
        return tamaño;
    }
}
