import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random(42); // semilla fija: resultados reproducibles

        calentarJVM();

        System.out.println("===== DEMOSTRACIÓN VISUAL (n = 10) =====");
        comparar(10, rnd, true);

        for (int n : new int[]{100, 1000, 5000}) {
            System.out.println("\n===== EXPERIMENTO n = " + n + " =====");
            comparar(n, rnd, false);
        }

        mostrarAnalisis();
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

    // Ejecuta los algoritmos antes de medir para que el JIT de Java no distorsione los tiempos
    private static void calentarJVM() {
        int[] datos = GeneradorArreglos.aleatorio(2000, 1000, new Random(1));
        for (int i = 0; i < 5; i++) {
            BubbleSortOptimizado.ordenar(Utilidades.copiar(datos));
            InsertionSort.ordenar(Utilidades.copiar(datos));
        }
    }

    private static void mostrarAnalisis() {
        System.out.println("\n===== ANÁLISIS =====");
        System.out.println("- Aleatorio: ambos hacen O(n²). Bubble y Insertion realizan los mismos");
        System.out.println("  movimientos (= inversiones del arreglo), pero Bubble compara más.");
        System.out.println("- Casi ordenado: Insertion es el mejor, trabaja casi O(n).");
        System.out.println("  Bubble optimizado también mejora, pero recorre el arreglo en cada pase.");
        System.out.println("- Inverso: peor caso de ambos, O(n²) en comparaciones y movimientos.");
    }
}