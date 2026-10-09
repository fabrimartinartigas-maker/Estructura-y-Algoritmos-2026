/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una función recursiva que calcule base elevado a exponente sin usar Math.pow.
 * Explicá que una potencia representa multiplicaciones sucesivas. El caso base es exponente 0 y devuelve 1. En el caso recursivo, reducí el exponente: potencia(base, exponente) = base * potencia(base, exponente - 1).
 * Admití exponentes no negativos y rechazá exponentes negativos. En particular, potencia(0, 0) devuelve 1 según el caso base indicado. Usá int y detectá explícitamente el desbordamiento.
 * Documentá propósito, razonamiento, parámetros, resultado, error y complejidad temporal y espacial con Javadoc. Comentá el caso base y la reducción.
 * Separá la función de ejemplos y pruebas. Probá exponentes 0 y 1, bases 0, 1, negativas y positivas, y un caso cuyo resultado desborde int.
 */
package unidad2.ejercicio04;

/**
 * Calcula potencias enteras con exponente no negativo mediante recursividad.
 */
public final class PotenciaRecursiva {
    private PotenciaRecursiva() {
    }

    /**
     * Calcula {@code base} elevada a {@code exponente}.
     *
     * @param base base entera
     * @param exponente exponente no negativo
     * @return la potencia; por el caso base, devuelve uno para exponente cero
     * @throws IllegalArgumentException si el exponente es negativo
     * @throws ArithmeticException si el resultado no cabe en un {@code int}
     *
     * Tiempo O(exponente); espacio O(exponente) por la pila recursiva.
     */
    public static int calcular(int base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("el exponente debe ser no negativo");
        }
        if (exponente == 0) {
            return 1;
        }
        return Math.multiplyExact(base, calcular(base, exponente - 1));
    }
}
