public class Pruebas {

    public static void main(String[] args) {
        probarOrdenamiento("arreglo vacío", new int[]{});
        probarOrdenamiento("un elemento", new int[]{7});
        probarOrdenamiento("todos iguales", new int[]{4, 4, 4, 4});
        probarOrdenamiento("con repetidos", new int[]{5, 1, 4, 1, 5, 2, 2});
        probarOrdenamiento("ya ordenado", new int[]{1, 2, 3, 4, 5});

        // Mejor caso: arreglo ordenado -> n-1 comparaciones y 0 movimientos
        int[] ord = {1, 2, 3, 4, 5, 6};
        Resultado rb = BubbleSortOptimizado.ordenar(Utilidades.copiar(ord));
        Resultado ri = InsertionSort.ordenar(Utilidades.copiar(ord));
        verificar("Bubble mejor caso (5 comparaciones, 0 intercambios)",
                rb.getComparaciones() == 5 && rb.getMovimientos() == 0);
        verificar("Insertion mejor caso (5 comparaciones, 0 desplazamientos)",
                ri.getComparaciones() == 5 && ri.getMovimientos() == 0);

        // Peor caso sin repetidos: n(n-1)/2 movimientos = 15 para n = 6
        int[] inv = {6, 5, 4, 3, 2, 1};
        rb = BubbleSortOptimizado.ordenar(Utilidades.copiar(inv));
        ri = InsertionSort.ordenar(Utilidades.copiar(inv));
        verificar("Bubble peor caso (15 intercambios)", rb.getMovimientos() == 15);
        verificar("Insertion peor caso (15 desplazamientos)", ri.getMovimientos() == 15);
    }

    private static void probarOrdenamiento(String nombre, int[] datos) {
        int[] a = Utilidades.copiar(datos);
        int[] b = Utilidades.copiar(datos);
        BubbleSortOptimizado.ordenar(a);
        InsertionSort.ordenar(b);
        verificar("Bubble - " + nombre, Utilidades.estaOrdenado(a));
        verificar("Insertion - " + nombre, Utilidades.estaOrdenado(b));
    }

    private static void verificar(String descripcion, boolean ok) {
        System.out.println((ok ? "[OK]    " : "[FALLO] ") + descripcion);
    }
}