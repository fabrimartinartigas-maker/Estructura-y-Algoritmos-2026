package unidad3.ejercicio03;

import java.util.Objects;

/**
 * Insertion Sort que contabiliza los desplazamientos de claves hacia la derecha.
 */
public final class InsertionSortCasiOrdenado {
    private InsertionSortCasiOrdenado() {
    }

    /**
     * Métricas del ordenamiento por inserción.
     *
     * @param desplazamientos número de movimientos de elementos previos una posición a la derecha
     */
    public record Metricas(long desplazamientos) {
    }

    /**
     * Ordena ascendentemente, insertando cada clave en el prefijo ya ordenado.
     *
     * @param numeros arreglo modificado in-place
     * @return desplazamientos; no cuenta la escritura final de la clave temporal
     * @throws NullPointerException si el arreglo es nulo
     *
     * Tiempo mejor O(n), peor O(n^2); espacio auxiliar O(1).
     */
    public static Metricas ordenar(int[] numeros) {
        Objects.requireNonNull(numeros, "numeros");
        long desplazamientos = 0;
        for (int i = 1; i < numeros.length; i++) {
            int clave = numeros[i];
            int j = i - 1;
            while (j >= 0 && numeros[j] > clave) {
                numeros[j + 1] = numeros[j];
                desplazamientos++;
                j--;
            }
            numeros[j + 1] = clave;
        }
        return new Metricas(desplazamientos);
    }
}
