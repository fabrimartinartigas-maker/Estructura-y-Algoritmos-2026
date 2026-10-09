package unidad3.ejercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Bubble Sort que conserva una instantánea del arreglo después de cada pasada.
 */
public final class BubbleSortPasoAPaso {
    private BubbleSortPasoAPaso() {
    }

    /**
     * Ordena el arreglo recibido en forma ascendente y registra cada pasada completa.
     *
     * @param array arreglo de enteros, modificado in-place
     * @return copias del estado posterior a cada pasada; lista vacía si hay menos de dos valores
     * @throws NullPointerException si el arreglo es nulo
     *
     * Tiempo O(n^2); espacio O(n^2) debido a las instantáneas de la traza.
     */
    public static List<int[]> ordenar(int[] array) {
        Objects.requireNonNull(array, "array");
        List<int[]> pasadas = new ArrayList<>();
        for (int fin = array.length - 1; fin > 0; fin--) {
            for (int i = 0; i < fin; i++) {
                if (array[i] > array[i + 1]) {
                    int temporal = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temporal;
                }
            }
            pasadas.add(array.clone());
        }
        return List.copyOf(pasadas);
    }
}
