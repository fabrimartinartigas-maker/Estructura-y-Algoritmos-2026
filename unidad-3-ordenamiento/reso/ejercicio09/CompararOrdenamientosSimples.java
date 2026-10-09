package unidad3.ejercicio09;

import java.util.Objects;

/**
 * Implementaciones de ordenamiento simple con métricas uniformes.
 */
public final class CompararOrdenamientosSimples {
    private CompararOrdenamientosSimples() {
    }

    /**
     * Contadores de un algoritmo simple.
     *
     * @param comparaciones comparaciones entre claves
     * @param movimientos intercambios (Bubble/Selection) o desplazamientos (Insertion)
     */
    public record Metricas(long comparaciones, long movimientos) {
    }

    /**
     * Bubble Sort: solo cuenta intercambios entre posiciones distintas.
     *
     * @param array arreglo modificado in-place
     * @return comparaciones entre valores e intercambios
     * @throws NullPointerException si el arreglo es nulo
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
     * Selection Sort: el último contador es el número de intercambios reales.
     *
     * @param array arreglo modificado in-place
     * @return comparaciones entre valores e intercambios
     * @throws NullPointerException si el arreglo es nulo
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

    /**
     * Insertion Sort: movimientos cuenta claves desplazadas a la derecha, no la inserción final.
     *
     * @param array arreglo modificado in-place
     * @return comparaciones entre claves y desplazamientos
     * @throws NullPointerException si el arreglo es nulo
     */
    public static Metricas insertionSort(int[] array) {
        Objects.requireNonNull(array, "array");
        long comparaciones = 0;
        long desplazamientos = 0;
        for (int i = 1; i < array.length; i++) {
            int clave = array[i];
            int j = i - 1;
            while (j >= 0) {
                comparaciones++;
                if (array[j] > clave) {
                    array[j + 1] = array[j];
                    desplazamientos++;
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = clave;
        }
        return new Metricas(comparaciones, desplazamientos);
    }

    private static void intercambiar(int[] array, int a, int b) {
        int temporal = array[a];
        array[a] = array[b];
        array[b] = temporal;
    }
}
