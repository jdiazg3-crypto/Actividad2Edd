import java.util.Arrays;

public class Utilidades {
    public static boolean estaOrdenado(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }

    public static int[] copiar(int[] a) {
        return Arrays.copyOf(a, a.length);
    }

    public static String aTexto(int[] a) {
        return Arrays.toString(a);
    }
}