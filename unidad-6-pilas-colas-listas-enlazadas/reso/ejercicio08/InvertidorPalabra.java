/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 invertir(String) usando una pila enlazada propia de puntos de código,
 * sin Stack, arreglos ni colecciones como almacenamiento. Apilá y desapilá para invertir;
 * preservá pares sustitutos Unicode. "algoritmo" produce "omtirogla"; vacío produce vacío.
 * Rechazá null y documentá razonamiento LIFO y complejidad O(n) tiempo/O(n) espacio.
 * Separá implementación, demo y pruebas, incluyendo punto de código suplementario.
 */
package unidad6.ejercicio08;

import java.util.Objects;

/**
 * Invierte una palabra mediante una pila enlazada de puntos de código Unicode.
 */
public final class InvertidorPalabra {
    private static final class Nodo {
        private final int puntoCodigo;
        private final Nodo siguiente;

        private Nodo(int puntoCodigo, Nodo siguiente) {
            this.puntoCodigo = puntoCodigo;
            this.siguiente = siguiente;
        }
    }

    /** Crea un inversor sin estado persistente entre llamadas. */
    public InvertidorPalabra() {
    }

    /**
     * Invierte el orden de los puntos de código de una palabra.
     *
     * @param palabra texto que se invierte
     * @return palabra invertida
     * @throws NullPointerException si {@code palabra} es null
     * Tiempo O(n); espacio adicional O(n), donde n es la cantidad de puntos de código.
     */
    public String invertir(String palabra) {
        Objects.requireNonNull(palabra, "palabra no puede ser null");
        Nodo tope = null;
        for (int indice = 0; indice < palabra.length();) {
            int puntoCodigo = palabra.codePointAt(indice);
            tope = new Nodo(puntoCodigo, tope);
            indice += Character.charCount(puntoCodigo);
        }

        StringBuilder invertida = new StringBuilder(palabra.length());
        for (Nodo nodo = tope; nodo != null; nodo = nodo.siguiente) {
            invertida.appendCodePoint(nodo.puntoCodigo);
        }
        return invertida.toString();
    }
}
/*
 * Ajuste del prompt: se apilan puntos de código para no separar caracteres Unicode suplementarios.
 */
