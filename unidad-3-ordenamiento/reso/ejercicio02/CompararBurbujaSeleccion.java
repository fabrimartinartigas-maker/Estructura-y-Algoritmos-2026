package unidad3.ejercicio02;

import java.util.Objects;

/**
 * Implementa Bubble Sort y Selection Sort con métricas comparables.
 */
public final class CompararBurbujaSeleccion {
    private CompararBurbujaSeleccion() {
    }

    /**
     * Resultado de una ordenación con comparaciones entre claves e intercambios reales.
     *
     * @param comparaciones comparaciones entre valores del arreglo
     * @param intercambios intercambios entre posiciones distintas
     */
    public record Metricas(long comparaciones, long intercambios) {
    }

    /**
     * Ordena ascendentemente mediante Bubble Sort.
     *
     * @param array arreglo modificado in-place
     * @return cantidad de comparaciones de claves e intercambios efectuados
     * @throws NullPointerException si el arreglo es nulo
     *
     * Tiempo O(n^2); espacio auxiliar O(1).
     */
    public static Metricas bubbleSort(int[] array) {
        Objects.requireNonNull(array, "array");
        long comparaciones = 0;
        long intercambios = 0;
        for (int fin = array.length - 1; fin > 0; fin--) {
            for (int i = 0; i < fin; i++) {
                comparaciones++;
                if (array[i] > array[i + 1]) {
                    intercambiar(array, i, i + 1);
                    intercambios++;
                }
            }
        }
        return new Metricas(comparaciones, intercambios);
    }

    /**
     * Ordena ascendentemente mediante Selection Sort.
     *
     * @param array arreglo modificado in-place
     * @return cantidad de comparaciones de claves e intercambios efectuados
     * @throws NullPointerException si el arreglo es nulo
     *
     * Tiempo O(n^2); espacio auxiliar O(1).
     */
    public static Metricas selectionSort(int[] array) {
        Objects.requireNonNull(array, "array");
        long comparaciones = 0;
        long intercambios = 0;
        for (int inicio = 0; inicio < array.length - 1; inicio++) {
            int minimo = inicio;
            for (int i = inicio + 1; i < array.length; i++) {
                comparaciones++;
                if (array[i] < array[minimo]) {
                    minimo = i;
                }
            }
            if (minimo != inicio) {
                intercambiar(array, inicio, minimo);
                intercambios++;
            }
        }
        return new Metricas(comparaciones, intercambios);
    }

    private static void intercambiar(int[] array, int a, int b) {
        int temporal = array[a];
        array[a] = array[b];
        array[b] = temporal;
    }
}
