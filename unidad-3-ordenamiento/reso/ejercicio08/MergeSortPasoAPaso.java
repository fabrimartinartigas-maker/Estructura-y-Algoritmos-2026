package unidad3.ejercicio08;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * MergeSort que registra divisiones, cortes y fusiones.
 */
public final class MergeSortPasoAPaso {
    private MergeSortPasoAPaso() {
    }

    /**
     * Ordena el arreglo y devuelve eventos legibles de la ejecución.
     *
     * @param numeros arreglo modificado in-place
     * @return traza de divisiones, condiciones de corte y fusiones
     * @throws NullPointerException si el arreglo es nulo
     *
     * Tiempo O(n log n); espacio auxiliar O(n), además de O(n log n) caracteres de traza.
     */
    public static List<String> ordenar(int[] numeros) {
        Objects.requireNonNull(numeros, "numeros");
        List<String> eventos = new ArrayList<>();
        ordenar(numeros, 0, numeros.length, eventos);
        return List.copyOf(eventos);
    }

    private static void ordenar(int[] numeros, int desde, int hasta, List<String> eventos) {
        if (hasta - desde < 2) {
            eventos.add("Corte " + rango(numeros, desde, hasta));
            return;
        }
        int medio = desde + (hasta - desde) / 2;
        eventos.add("División " + rango(numeros, desde, hasta) + " en "
                + rango(numeros, desde, medio) + " y " + rango(numeros, medio, hasta));
        ordenar(numeros, desde, medio, eventos);
        ordenar(numeros, medio, hasta, eventos);
        fusionar(numeros, desde, medio, hasta);
        eventos.add("Fusión [" + desde + ", " + hasta + "): "
                + rango(numeros, desde, hasta));
    }

    private static void fusionar(int[] numeros, int desde, int medio, int hasta) {
        int[] temporal = new int[hasta - desde];
        int izquierda = desde;
        int derecha = medio;
        int salida = 0;
        while (izquierda < medio && derecha < hasta) {
            temporal[salida++] = numeros[izquierda] <= numeros[derecha]
                    ? numeros[izquierda++] : numeros[derecha++];
        }
        while (izquierda < medio) {
            temporal[salida++] = numeros[izquierda++];
        }
        while (derecha < hasta) {
            temporal[salida++] = numeros[derecha++];
        }
        System.arraycopy(temporal, 0, numeros, desde, temporal.length);
    }

    private static String rango(int[] numeros, int desde, int hasta) {
        return java.util.Arrays.toString(java.util.Arrays.copyOfRange(numeros, desde, hasta));
    }
}
