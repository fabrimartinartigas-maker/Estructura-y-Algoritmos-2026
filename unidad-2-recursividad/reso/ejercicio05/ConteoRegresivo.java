/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 un procedimiento recursivo que imprima el conteo desde n hasta 0, inclusive.
 * Explicá que no necesariamente devuelve un valor: su propósito es producir salida. Usá como caso base n = 0, imprimiendo 0 y retornando. En otro caso, imprimí n y llamá recursivamente con n - 1, acercándote al caso base.
 * Rechazá n negativo. Explicá que usar n + 1 en vez de n - 1 alejaría la llamada del caso base y causaría recursión sin fin hasta agotar la pila.
 * Documentá propósito, parámetro, salida, error y complejidad temporal y espacial con Javadoc. Mantené el procedimiento separado de ejemplos y pruebas.
 * Probá n = 0 y valores positivos; verifica la secuencia completa descendente hasta 0.
 */
package unidad2.ejercicio05;

/**
 * Imprime recursivamente un conteo regresivo hasta cero.
 */
public final class ConteoRegresivo {
    private ConteoRegresivo() {
    }

    /**
     * Imprime cada entero desde {@code n} hasta cero, inclusive.
     *
     * @param n inicio no negativo del conteo
     * @throws IllegalArgumentException si {@code n} es negativo
     *
     * Tiempo O(n); espacio O(n) por la pila recursiva.
     */
    public static void imprimir(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n debe ser no negativo");
        }
        System.out.println(n);
        if (n == 0) {
            return;
        }
        imprimir(n - 1);
    }
}
