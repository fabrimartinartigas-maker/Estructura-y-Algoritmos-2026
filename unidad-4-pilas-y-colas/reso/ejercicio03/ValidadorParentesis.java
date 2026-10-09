/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 un validador de paréntesis '(' y ')' con una pila respaldada por arreglo.
 * Al encontrar '(' apilalo; ante ')' devuelve inválido si no hay apertura o hace pop. Al final es válido si no quedan aperturas. Ignora otros caracteres.
 * La capacidad del arreglo de la pila debe bastar para los caracteres de entrada. Documentá propósito, algoritmo, entradas, resultado y complejidad O(n) tiempo/O(n) espacio. La cadena vacía y una cadena sin paréntesis son válidas.
 * Separá el validador de ejemplos y pruebas. Incluí "(5 + 3) * (2 + 1)" como válido y "(5 + 3)) * (2 + 1" como inválido, además de anidamiento, cierre extra y apertura pendiente.
 * Poné este prompt inicial en comentario al principio del .java y al final anotá si necesitaste ajustarlo.
 */
package unidad4.ejercicio03;

import java.util.Objects;

/**
 * Valida paréntesis redondos de una expresión usando una pila de caracteres.
 */
public final class ValidadorParentesis {
    private ValidadorParentesis() {
    }

    /**
     * Comprueba que cada cierre tenga una apertura previa y que no queden aperturas.
     *
     * @param expresion texto donde solo se consideran {@code (} y {@code )}
     * @return {@code true} si los paréntesis están balanceados
     * @throws NullPointerException si la expresión es nula
     * Tiempo O(n); espacio O(n) en el peor caso, con n cantidad de caracteres.
     */
    public static boolean estaBalanceada(String expresion) {
        Objects.requireNonNull(expresion, "expresion");
        char[] pila = new char[expresion.length()];
        int top = -1;
        for (int i = 0; i < expresion.length(); i++) {
            char actual = expresion.charAt(i);
            if (actual == '(') {
                pila[++top] = actual;
            } else if (actual == ')') {
                if (top == -1) {
                    return false;
                }
                top--;
            }
        }
        return top == -1;
    }
}
/*
 * Ajuste del prompt: ninguno; se ignoran los caracteres no parentéticos según el alcance acordado.
 */
