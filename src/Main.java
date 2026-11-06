import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random(42); // semilla fija: resultados reproducibles

        System.out.println("===== DEMOSTRACIÓN VISUAL (n = 10) =====");
        comparar(10, rnd, true);
    }

    private static void comparar(int n, Random rnd, boolean mostrar) {
        int[] base = GeneradorArreglos.aleatorio(n, Math.max(5, n / 2), rnd);
        int[] casi = GeneradorArreglos.casiOrdenado(base, Math.max(1, n / 20), rnd);
        int[] inverso = GeneradorArreglos.inverso(base);

        System.out.printf("%-14s %-18s %14s %14s %12s%n",
                "Distribución", "Algoritmo", "Comparaciones", "Movimientos", "Tiempo (ms)");
        ejecutar("Aleatorio", base, mostrar);
        ejecutar("Casi ordenado", casi, mostrar);
        ejecutar("Inverso", inverso, mostrar);
    }

    private static void ejecutar(String distribucion, int[] original, boolean mostrar) {
        int[] copiaBubble = Utilidades.copiar(original);
        int[] copiaInsertion = Utilidades.copiar(original);

        Resultado rb = BubbleSortOptimizado.ordenar(copiaBubble);
        Resultado ri = InsertionSort.ordenar(copiaInsertion);

        if (!Utilidades.estaOrdenado(copiaBubble) || !Utilidades.estaOrdenado(copiaInsertion)
                || !Arrays.equals(copiaBubble, copiaInsertion)) {
            throw new IllegalStateException("Error: un algoritmo no ordenó correctamente");
        }

        if (mostrar) {
            System.out.println("\n[" + distribucion + "]");
            System.out.println("  Antes  : " + Utilidades.aTexto(original));
            System.out.println("  Después: " + Utilidades.aTexto(copiaBubble));
        }
        imprimirFila(distribucion, rb);
        imprimirFila(distribucion, ri);
    }

    private static void imprimirFila(String distribucion, Resultado r) {
        System.out.printf("%-14s %-18s %14d %14d %12.3f%n",
                distribucion, r.getAlgoritmo(), r.getComparaciones(),
                r.getMovimientos(), r.getTiempoMs());
    }
}