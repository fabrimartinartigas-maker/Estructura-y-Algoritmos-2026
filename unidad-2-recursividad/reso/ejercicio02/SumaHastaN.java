/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una función recursiva que sume los enteros desde n hasta 1.
 * Explicá que el caso más simple es suma(0) = 0 y que suma(n) = n + suma(n - 1), porque cada llamada agrega n y reduce el problema a n - 1.
 * La entrada debe ser n >= 0; rechazá n negativo. Usá int y detectá explícitamente el desbordamiento.
 * Documentá propósito, razonamiento recursivo, parámetro, resultado, errores y complejidad temporal y espacial con Javadoc. Comentá caso base y paso recursivo.
 * Mantené la función separada de los ejemplos y pruebas. Validá 0, 1 y varios valores positivos, indicando resultados esperados.
 */
package unidad2.ejercicio02;

/**
 * Suma recursivamente los enteros desde un valor no negativo hasta uno.
 */
public final class SumaHastaN {
    private SumaHastaN() {
    }

    /**
     * Calcula {@code n + (n - 1) + ... + 1}.
     *
     * @param n límite superior no negativo
     * @return la suma desde {@code n} hasta uno; cero cuando {@code n} es cero
     * @throws IllegalArgumentException si {@code n} es negativo
     * @throws ArithmeticException si la suma no cabe en un {@code int}
     *
     * Tiempo O(n); espacio O(n) por la pila recursiva.
     */
    public static int sumarHastaUno(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n debe ser no negativo");
        }
        if (n == 0) {
            return 0;
        }
        return Math.addExact(n, sumarHastaUno(n - 1));
    }
}
