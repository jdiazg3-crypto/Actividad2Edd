import java.util.Random;

public class GeneradorArreglos {

    /** Arreglo aleatorio; maxValor pequeño garantiza valores repetidos. */
    public static int[] aleatorio(int n, int maxValor, Random rnd) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rnd.nextInt(maxValor + 1);
        }
        return a;
    }

    /** Mismos elementos de 'base', ordenados ascendentemente. */
    public static int[] ordenado(int[] base) {
        int[] copia = Utilidades.copiar(base);
        InsertionSort.ordenar(copia); // nuestro propio algoritmo
        return copia;
    }

    /** Mismos elementos, ordenados pero con 'cambios' vecinos intercambiados. */
    public static int[] casiOrdenado(int[] base, int cambios, Random rnd) {
        int[] a = ordenado(base);
        if (a.length < 2) return a;
        for (int k = 0; k < cambios; k++) {
            int i = rnd.nextInt(a.length - 1);
            int tmp = a[i];
            a[i] = a[i + 1];
            a[i + 1] = tmp;
        }
        return a;
    }

    /** Mismos elementos, ordenados de mayor a menor (peor caso). */
    public static int[] inverso(int[] base) {
        int[] a = ordenado(base);
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        return a;
    }
}