public class Resultado {
    private final String algoritmo;
    private final long comparaciones;
    private final long movimientos; // intercambios (Bubble) o desplazamientos (Insertion)
    private final long tiempoNs;

    public Resultado(String algoritmo, long comparaciones, long movimientos, long tiempoNs) {
        this.algoritmo = algoritmo;
        this.comparaciones = comparaciones;
        this.movimientos = movimientos;
        this.tiempoNs = tiempoNs;
    }

    public String getAlgoritmo() { return algoritmo; }
    public long getComparaciones() { return comparaciones; }
    public long getMovimientos() { return movimientos; }
    public double getTiempoMs() { return tiempoNs / 1_000_000.0; }
}