/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 el máximo de los elementos de int[][] mediante un recorrido completo.
 * Representá una matriz sin elementos con OptionalInt.empty(), nunca con centinela.
 * Admití filas de distintas longitudes y rechazá referencias de fila null.
 * Documentá justificación de inspección completa y complejidad temporal/espacial.
 */
package unidad1.ejercicio09;

import java.util.Objects;
import java.util.OptionalInt;

/**
 * Encuentra el máximo recorriendo todos los valores de una matriz posiblemente irregular.
 */
public final class MaximoMatriz {
    private MaximoMatriz() {
    }

    /**
     * Conserva el mayor valor visto; inspecciona todos porque uno posterior podría superarlo.
     *
     * @param matriz filas de enteros; puede no contener elementos
     * @return máximo presente, o vacío si todas las filas están vacías
     * @throws NullPointerException si la matriz o alguna fila es null
     * Tiempo O(r + m), donde r es la cantidad de filas y m el total de elementos;
     * espacio auxiliar O(1). Para una matriz rectangular no vacía equivale a O(r × c).
     */
    public static OptionalInt encontrar(int[][] matriz) {
        Objects.requireNonNull(matriz, "la matriz no puede ser null");
        boolean hayElemento = false;
        int maximo = 0;
        for (int[] fila : matriz) {
            Objects.requireNonNull(fila, "las filas no pueden ser null");
            for (int elemento : fila) {
                if (!hayElemento || elemento > maximo) {
                    maximo = elemento;
                    hayElemento = true;
                }
            }
        }
        return hayElemento ? OptionalInt.of(maximo) : OptionalInt.empty();
    }
}
/*
 * Ajuste del prompt: OptionalInt representa matriz vacía y se admiten filas irregulares.
 */
