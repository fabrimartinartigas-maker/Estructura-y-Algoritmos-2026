package unidad3.ejercicio07;

import java.util.Objects;

/**
 * Quicksort con primer pivote y contador explícito de llamadas recursivas.
 */
public final class QuicksortPeorCaso {
    private QuicksortPeorCaso() {
    }

    /**
     * Resultado del ordenamiento y su contador de llamadas recursivas.
     *
     * @param llamadasRecursivas invocaciones posteriores a la inicial, incluidas las base
     */
    public record Resultado(long llamadasRecursivas) {
    }

    /**
     * Ordena in-place con el primer valor como pivote y cuenta llamadas recursivas.
     *
     * @param numeros arreglo modificado in-place
     * @return número de llamadas posteriores a la inicial, incluso con rangos vacíos/unitarios
     * @throws NullPointerException si el arreglo es nulo
     *
     * Tiempo promedio O(n log n), peor O(n^2); pila peor O(n).
     */
    public static Resultado ordenar(int[] numeros) {
        Objects.requireNonNull(numeros, "numeros");
        long[] llamadas = {0};
        ordenar(numeros, 0, numeros.length - 1, llamadas, true);
        return new Resultado(llamadas[0]);
    }

    private static void ordenar(int[] numeros, int bajo, int alto, long[] llamadas, boolean inicial) {
        if (!inicial) {
            llamadas[0]++;
        }
        if (bajo >= alto) {
            return;
        }
        int pivote = numeros[bajo];
        int posicion = particionar(numeros, bajo, alto, pivote);
        ordenar(numeros, bajo, posicion - 1, llamadas, false);
        ordenar(numeros, posicion + 1, alto, llamadas, false);
    }

    private static int particionar(int[] numeros, int bajo, int alto, int pivote) {
        int temporal = numeros[bajo];
        numeros[bajo] = numeros[alto];
        numeros[alto] = temporal;
        int destino = bajo;
        for (int i = bajo; i < alto; i++) {
            if (numeros[i] <= pivote) {
                temporal = numeros[i];
                numeros[i] = numeros[destino];
                numeros[destino] = temporal;
                destino++;
            }
        }
        temporal = numeros[destino];
        numeros[destino] = numeros[alto];
        numeros[alto] = temporal;
        return destino;
    }
}
