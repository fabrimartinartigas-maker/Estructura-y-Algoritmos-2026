/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 esBalanceada(String) con una pila enlazada simple propia, sin colecciones.
 * Apilá '(' y desapilá ante ')'; cierre sin apertura invalida y al final no deben quedar aperturas.
 * Ignorá caracteres distintos de paréntesis. Vacío y texto sin paréntesis son válidos; null se rechaza.
 * Documentá algoritmo y complejidad O(n) tiempo/O(n) espacio. Separá código, demo y pruebas.
 */
package unidad6.ejercicio07;

import java.util.Objects;

/**
 * Determina si los paréntesis de una expresión están correctamente balanceados.
 */
public final class VerificadorParentesis {
    private static final class Nodo {
        private final char dato;
        private final Nodo siguiente;

        private Nodo(char dato, Nodo siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    /** Crea un verificador sin estado persistente entre llamadas. */
    public VerificadorParentesis() {
    }

    /**
     * Evalúa el balance de paréntesis; los demás caracteres se ignoran.
     *
     * @param expresion texto que se analiza
     * @return {@code true} si cada apertura tiene un cierre posterior y no queda abierta
     * @throws NullPointerException si {@code expresion} es null
     * Tiempo O(n); espacio adicional O(n) en el peor caso.
     */
    public boolean esBalanceada(String expresion) {
        Objects.requireNonNull(expresion, "expresion no puede ser null");
        Nodo tope = null;
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (caracter == '(') {
                tope = new Nodo(caracter, tope);
            } else if (caracter == ')') {
                if (tope == null) {
                    return false;
                }
                tope = tope.siguiente;
            }
        }
        return tope == null;
    }
}
/*
 * Ajuste del prompt: ninguno; los caracteres ajenos a paréntesis se ignoran.
 */
