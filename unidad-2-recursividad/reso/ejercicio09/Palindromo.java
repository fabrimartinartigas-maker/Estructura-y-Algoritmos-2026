/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una función recursiva que determine si un String es palíndromo.
 * Compará el primer y último carácter. Si son distintos, devuelve false; si coinciden, reduce el problema eliminando ambos extremos y continúa recursivamente. El caso base devuelve true cuando queda una cadena vacía o un solo carácter.
 * La comparación debe ser literal y sensible a mayúsculas; espacios y signos se consideran caracteres y no se normalizan.
 * Documentá propósito, razonamiento, parámetro, resultado y complejidad temporal y espacial con Javadoc. Comentá la comparación, la reducción y los casos base.
 * Separá la función de los ejemplos y pruebas. Probá cadena vacía, un carácter, palíndromos y no palíndromos, incluidas diferencias de mayúsculas, espacios o caracteres interiores.
 */
package unidad2.ejercicio09;

import java.util.Objects;

/**
 * Determina recursivamente si una cadena es palíndroma mediante comparación de extremos.
 */
public final class Palindromo {
    private Palindromo() {
    }

    /**
     * Comprueba si la cadena es palíndroma con comparación literal, sensible a mayúsculas.
     *
     * @param texto cadena no nula
     * @return {@code true} si se lee igual en ambos sentidos; para la cadena vacía devuelve
     *         {@code true}
     * @throws NullPointerException si {@code texto} es nulo
     *
     * Tiempo O(n); espacio O(n) por la pila recursiva.
     */
    public static boolean esPalindromo(String texto) {
        Objects.requireNonNull(texto, "texto");
        return comprobarExtremos(texto, 0, texto.length() - 1);
    }

    private static boolean comprobarExtremos(String texto, int inicio, int fin) {
        if (inicio >= fin) {
            return true;
        }
        if (texto.charAt(inicio) != texto.charAt(fin)) {
            return false;
        }
        return comprobarExtremos(texto, inicio + 1, fin - 1);
    }
}
