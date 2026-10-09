/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una función recursiva que cuente los dígitos de un entero positivo.
 * Reducí el número mediante división entera por 10. El caso base es un valor entre 1 y 9, que tiene un dígito; para los demás, devuelve 1 + contarDigitos(n / 10).
 * La entrada debe ser positiva; rechazá cero y negativos porque el ejercicio especifica enteros positivos.
 * Documentá propósito, razonamiento recursivo, parámetro, resultado, error y complejidad temporal y espacial con Javadoc. Comentá caso base y reducción.
 * Separá función, ejemplos y pruebas. Probá números de uno y varios dígitos, incluidos valores terminados en cero.
 */
package unidad2.ejercicio06;

/**
 * Cuenta los dígitos de un entero positivo reduciéndolo por división entera.
 */
public final class ContarDigitos {
    private ContarDigitos() {
    }

    /**
     * Cuenta los dígitos decimales de {@code n}.
     *
     * @param n entero estrictamente positivo
     * @return cantidad de dígitos decimales
     * @throws IllegalArgumentException si {@code n} no es positivo
     *
     * Tiempo O(d); espacio O(d), donde {@code d} es la cantidad de dígitos.
     */
    public static int contar(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n debe ser positivo");
        }
        if (n < 10) {
            return 1;
        }
        return 1 + contar(n / 10);
    }
}
