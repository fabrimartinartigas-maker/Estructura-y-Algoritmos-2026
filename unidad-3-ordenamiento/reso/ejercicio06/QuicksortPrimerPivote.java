package unidad3.ejercicio06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Quicksort recursivo que elige el primer elemento de cada rango como pivote.
 */
public final class QuicksortPrimerPivote {
    private QuicksortPrimerPivote() {
    }

    /**
     * Traza de una partición; los subarreglos son copias independientes.
     *
     * @param pivote valor elegido como pivote
     * @param izquierdo valores que quedaron antes del pivote
     * @param derecho valores que quedaron después del pivote
     */
    public record Particion(int pivote, int[] izquierdo, int[] derecho) {
        /**
         * Crea una partición con copias de ambos subarreglos.
         *
         * @param pivote valor que se colocó entre las partes
         * @param izquierdo elementos antes del pivote
         * @param derecho elementos después del pivote
         */
        public Particion {
            izquierdo = izquierdo.clone();
            derecho = derecho.clone();
        }

        /**
         * Devuelve una copia de la parte izquierda.
         *
         * @return elementos menores o iguales que el pivote que quedaron a su izquierda
         */
        @Override
        public int[] izquierdo() {
            return izquierdo.clone();
        }

        /**
         * Devuelve una copia de la parte derecha.
         *
         * @return elementos mayores que el pivote que quedaron a su derecha
         */
        @Override
        public int[] derecho() {
            return derecho.clone();
        }
    }

    /**
     * Ordena el arreglo in-place y devuelve cada partición en orden de ejecución.
     *
     * @param numeros arreglo modificado in-place
     * @return eventos con pivote y partes izquierda/derecha
     * @throws NullPointerException si el arreglo es nulo
     * @throws NullPointerException si el arreglo es nulo
     *
     * Tiempo promedio O(n log n), peor O(n^2); espacio de pila promedio O(log n),
     * peor O(n), además del almacenamiento de la traza.
     */
    public static List<Particion> ordenar(int[] numeros) {
        Objects.requireNonNull(numeros, "numeros");
        List<Particion> traza = new ArrayList<>();
        ordenar(numeros, 0, numeros.length - 1, traza);
        return List.copyOf(traza);
    }

    private static void ordenar(int[] numeros, int bajo, int alto, List<Particion> traza) {
        if (bajo >= alto) {
            return;
        }
        int pivote = numeros[bajo];
        int posicionPivote = particionar(numeros, bajo, alto, pivote);
        traza.add(new Particion(
                pivote,
                copiarRango(numeros, bajo, posicionPivote),
                copiarRango(numeros, posicionPivote + 1, alto + 1)));
        ordenar(numeros, bajo, posicionPivote - 1, traza);
        ordenar(numeros, posicionPivote + 1, alto, traza);
    }

    private static int particionar(int[] numeros, int bajo, int alto, int pivote) {
        intercambiar(numeros, bajo, alto);
        int siguienteMenor = bajo;
        for (int i = bajo; i < alto; i++) {
            if (numeros[i] <= pivote) {
                intercambiar(numeros, i, siguienteMenor);
                siguienteMenor++;
            }
        }
        intercambiar(numeros, siguienteMenor, alto);
        return siguienteMenor;
    }

    private static void intercambiar(int[] numeros, int a, int b) {
        int temporal = numeros[a];
        numeros[a] = numeros[b];
        numeros[b] = temporal;
    }

    private static int[] copiarRango(int[] numeros, int desde, int hastaExclusivo) {
        int[] copia = new int[hastaExclusivo - desde];
        System.arraycopy(numeros, desde, copia, 0, copia.length);
        return copia;
    }
}
