/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una función recursiva que sume los dígitos de un entero positivo.
 * Obtené el último dígito con n % 10 y reducí el número mediante división entera n / 10. El caso base es un número entre 1 y 9 y devuelve ese mismo dígito. En el caso recursivo, devuelve n % 10 + sumarDigitos(n / 10).
 * La entrada debe ser positiva; rechazá cero y negativos según el dominio del ejercicio.
 * Documentá propósito, razonamiento, parámetro, resultado, error y complejidad temporal y espacial con Javadoc. Comentá el caso base y cómo se combinan los resultados.
 * Separá la función de los ejemplos y pruebas. Probá números de uno y varios dígitos con ceros internos o finales e indica las sumas esperadas.
 */
package unidad2.ejercicio07;

/**
 * Suma recursivamente los dígitos de un entero positivo.
 */
public final class SumarDigitos {
    private SumarDigitos() {
    }

    /**
     * Suma los dígitos decimales de {@code n}, extrayendo el último con módulo.
     *
     * @param n entero estrictamente positivo
     * @return suma de los dígitos decimales
     * @throws IllegalArgumentException si {@code n} no es positivo
     *
     * Tiempo O(d); espacio O(d), donde {@code d} es la cantidad de dígitos.
     */
    public static int sumar(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n debe ser positivo");
        }
        if (n < 10) {
            return n;
        }
        return n % 10 + sumar(n / 10);
    }
}
