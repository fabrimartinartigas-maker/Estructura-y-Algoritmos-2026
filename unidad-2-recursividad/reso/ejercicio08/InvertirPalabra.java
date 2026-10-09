/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una función recursiva que invierta un String.
 * El caso base es una cadena vacía o de un carácter, que se devuelve sin cambios. Para reducir el problema, separá el primer carácter del resto. Reconstruí el resultado al volver de la recursión: invertir(resto) + primer carácter.
 * La inversión es literal: conserva mayúsculas, espacios y signos tal como son, pero invierte su orden.
 * Documentá propósito, razonamiento, parámetro, resultado y complejidad temporal y espacial con Javadoc. Comentá el caso base, la reducción y la reconstrucción.
 * Separá la función de ejemplos y pruebas. Probá cadena vacía, un carácter y palabras de varios caracteres, incluyendo una palabra palíndroma.
 */
package unidad2.ejercicio08;

import java.util.Objects;

/**
 * Invierte recursivamente una cadena conservando literalmente sus caracteres.
 */
public final class InvertirPalabra {
    private InvertirPalabra() {
    }

    /**
     * Separa el primer carácter y lo agrega al final del resultado de invertir el resto.
     *
     * @param palabra cadena no nula que se desea invertir
     * @return cadena con los caracteres en orden inverso
     * @throws NullPointerException si {@code palabra} es nula
     *
     * Tiempo O(n^2) por la creación y concatenación de subcadenas; espacio O(n^2)
     * en caracteres asignados y O(n) en profundidad de pila.
     */
    public static String invertir(String palabra) {
        Objects.requireNonNull(palabra, "palabra");
        if (palabra.length() <= 1) {
            return palabra;
        }
        return invertir(palabra.substring(1)) + palabra.charAt(0);
    }
}
