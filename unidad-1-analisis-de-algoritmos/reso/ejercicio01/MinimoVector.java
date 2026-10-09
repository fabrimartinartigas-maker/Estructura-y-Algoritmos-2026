/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 un algoritmo que encuentre el mínimo de un vector de enteros.
 * Inicializá con el primer elemento y recorré una vez; no hace falta ordenar el vector.
 * Documentá entradas, resultado, complejidad O(n)/O(1) y el caso vacío sin valor centinela.
 * Separá la solución de ejemplos y pruebas; probá positivos, negativos, unitario y vacío.
 */
package unidad1.ejercicio01;

import java.util.Objects;
import java.util.OptionalInt;

/**
 * Busca el mínimo de un vector mediante una única pasada lineal.
 */
public final class MinimoVector {
    private MinimoVector() {
    }

    /**
     * Devuelve el menor valor sin ordenar ni modificar el vector.
     *
     * @param valores vector de enteros
     * @return mínimo presente, o vacío si el vector no tiene elementos
     * @throws NullPointerException si {@code valores} es null
     * Tiempo O(n); espacio auxiliar O(1), donde n es la longitud del vector.
     */
    public static OptionalInt encontrar(int[] valores) {
        Objects.requireNonNull(valores, "el vector no puede ser null");
        if (valores.length == 0) {
            return OptionalInt.empty();
        }

        int minimo = valores[0];
        for (int i = 1; i < valores.length; i++) {
            if (valores[i] < minimo) {
                minimo = valores[i];
            }
        }
        return OptionalInt.of(minimo);
    }
}
/*
 * Ajuste del prompt: se representa el caso vacío con OptionalInt.empty().
 */
