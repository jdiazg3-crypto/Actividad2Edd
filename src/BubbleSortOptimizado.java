public class BubbleSortOptimizado {

    /** Ordena ascendentemente in-place y devuelve las métricas. */
    public static Resultado ordenar(int[] a) {
        long comparaciones = 0;
        long intercambios = 0;
        long inicio = System.nanoTime();

        int n = a.length;
        for (int pase = 0; pase < n - 1; pase++) {
            boolean huboIntercambio = false;
            // en cada pase el mayor "sube" al final, por eso se recorta el límite
            for (int i = 0; i < n - 1 - pase; i++) {
                comparaciones++;
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    intercambios++;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) break; // optimización: ya está ordenado
        }

        long fin = System.nanoTime();
        return new Resultado("Bubble optimizado", comparaciones, intercambios, fin - inicio);
    }
}