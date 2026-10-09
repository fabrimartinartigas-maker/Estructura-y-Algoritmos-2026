/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 la suma de todos los elementos de int[][] recorriendo fila por fila.
 * Contabilizá exclusivamente cada operación acumulador += elemento; por tanto, el contador
 * coincide con el número total de elementos. Admití filas de distintas longitudes y matriz
 * sin elementos; rechazá referencias de fila null. Documentá suma, contador y complejidad.
 */
package unidad1.ejercicio08;

import java.util.Objects;

/**
 * Suma todos los elementos de una matriz posiblemente irregular.
 */
public final class SumarMatriz {
    private SumarMatriz() {
    }

    /**
     * Acumula una vez el valor de cada elemento, recorriendo las filas en orden.
     *
     * @param matriz filas de enteros; puede tener cero filas o filas vacías
     * @return suma total y cantidad de operaciones de suma del acumulador
     * @throws NullPointerException si la matriz o alguna fila es null
     * Tiempo O(r + m), donde r es la cantidad de filas y m el total de elementos;
     * espacio auxiliar O(1). En una matriz rectangular no vacía equivale a O(r × c).
     */
    public static Resultado sumar(int[][] matriz) {
        Objects.requireNonNull(matriz, "la matriz no puede ser null");
        long suma = 0;
        long operacionesSuma = 0;
        for (int[] fila : matriz) {
            Objects.requireNonNull(fila, "las filas no pueden ser null");
            for (int elemento : fila) {
                suma += elemento;
                operacionesSuma++;
            }
        }
        return new Resultado(suma, operacionesSuma);
    }

    /**
     * Resultado del recorrido de suma.
     *
     * @param suma suma de todos los valores
     * @param operacionesSuma cantidad exacta de veces que se sumó un elemento al acumulador
     */
    public record Resultado(long suma, long operacionesSuma) {
    }
}
/*
 * Ajuste del prompt: se definió el tratamiento de matrices irregulares y filas null.
 */
