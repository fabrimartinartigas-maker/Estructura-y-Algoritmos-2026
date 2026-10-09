/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 el conteo completo de un objetivo dentro de int[].
 * No termines al hallar la primera coincidencia; devolvé el total y documentá O(n)/O(1).
 * Un vector vacío devuelve cero. Separá implementación, demostración y pruebas.
 */
package unidad1.ejercicio05;

import java.util.Objects;

/**
 * Cuenta todas las apariciones de un valor en un vector.
 */
public final class ContarOcurrencias {
    private ContarOcurrencias() {
    }

    /**
     * Recorre todos los elementos porque cualquier posición puede sumar otra aparición.
     *
     * @param valores vector de enteros
     * @param objetivo valor del que se cuentan apariciones
     * @return cantidad de coincidencias; cero para un vector vacío o sin coincidencias
     * @throws NullPointerException si {@code valores} es null
     * Tiempo O(n); espacio auxiliar O(1).
     */
    public static int contar(int[] valores, int objetivo) {
        Objects.requireNonNull(valores, "el vector no puede ser null");
        int cantidad = 0;
        for (int valor : valores) {
            if (valor == objetivo) {
                cantidad++;
            }
        }
        return cantidad;
    }
}
/*
 * Ajuste del prompt: ninguno; el recorrido siempre llega al final del vector.
 */
