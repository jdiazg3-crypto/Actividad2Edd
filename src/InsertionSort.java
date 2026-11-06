public class InsertionSort {

    /** Ordena ascendentemente in-place y devuelve las métricas. */
    public static Resultado ordenar(int[] a) {
        long comparaciones = 0;
        long desplazamientos = 0;
        long inicio = System.nanoTime();

        for (int i = 1; i < a.length; i++) {
            int clave = a[i];
            int j = i - 1;
            while (j >= 0) {
                comparaciones++;
                if (a[j] > clave) {
                    a[j + 1] = a[j]; // desplazar a la derecha
                    desplazamientos++;
                    j--;
                } else {
                    break;
                }
            }
            a[j + 1] = clave; // insertar en su posición
        }

        long fin = System.nanoTime();
        return new Resultado("Insertion", comparaciones, desplazamientos, fin - inicio);
    }
}