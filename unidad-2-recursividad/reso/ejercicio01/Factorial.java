/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una función recursiva que calcule el factorial de un entero n.
 * Antes del código, explicá por qué el problema puede resolverse recursivamente:
 * - Caso base: factorial(0) = 1 y factorial(1) = 1.
 * - Caso recursivo: factorial(n) = n * factorial(n - 1); cada llamada reduce n hasta alcanzar el caso base.
 * - La entrada debe ser n >= 0; rechazá n negativo.
 * Usá int y detectá explícitamente el desbordamiento en vez de devolver un resultado incorrecto.
 * Documentá propósito, razonamiento, parámetro, resultado, error y complejidad temporal y espacial con Javadoc. Comentá el caso base y recursivo.
 * Separá la función de los ejemplos y las pruebas. Probá 0, 1, 5, 12 y 13; explica cuáles son sus resultados y que 13! excede int.
 */
package unidad2.ejercicio01;

/**
 * Calcula factoriales de enteros no negativos mediante recursividad.
 */
public final class Factorial {
    private Factorial() {
    }

    /**
     * Calcula {@code n!} reduciendo el argumento en cada llamada.
     *
     * @param n entero no negativo cuyo factorial se calcula
     * @return el factorial de {@code n}
     * @throws IllegalArgumentException si {@code n} es negativo
     * @throws ArithmeticException si el resultado no cabe en un {@code int}
     *
     * Tiempo O(n); espacio O(n) por la pila recursiva.
     */
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n debe ser no negativo");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return Math.multiplyExact(n, factorial(n - 1));
    }
}
