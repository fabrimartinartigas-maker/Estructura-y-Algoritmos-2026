/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una función recursiva que multiplique dos enteros no negativos sin usar el operador * en la función algorítmica.
 * Representá a * b como la suma de a repetida b veces. Reducí el segundo parámetro en cada llamada: multiplicar(a, b) = a + multiplicar(a, b - 1). El caso base es b = 0 y devuelve 0.
 * Rechazá factores negativos. Usá int y detectá explícitamente el desbordamiento de las sumas.
 * Documentá propósito, razonamiento, parámetros, resultado, errores y complejidad temporal y espacial con Javadoc. Comentá el caso base y cómo se reduce b.
 * Separá implementación, ejemplos y pruebas. Probá cero en cada factor, 1 por un valor y varios productos no negativos; indicá los resultados esperados.
 */
package unidad2.ejercicio03;

/**
 * Multiplica enteros no negativos mediante sumas recursivas repetidas.
 */
public final class MultiplicacionPorSumas {
    private MultiplicacionPorSumas() {
    }

    /**
     * Calcula el producto sumando {@code a} un total de {@code b} veces.
     *
     * @param a sumando no negativo
     * @param b cantidad de veces que se suma {@code a}, no negativa
     * @return el producto de los factores
     * @throws IllegalArgumentException si alguno de los factores es negativo
     * @throws ArithmeticException si el resultado no cabe en un {@code int}
     *
     * Tiempo O(b); espacio O(b) por la pila recursiva.
     */
    public static int multiplicar(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("ambos factores deben ser no negativos");
        }
        if (b == 0) {
            return 0;
        }
        return Math.addExact(a, multiplicar(a, b - 1));
    }
}
