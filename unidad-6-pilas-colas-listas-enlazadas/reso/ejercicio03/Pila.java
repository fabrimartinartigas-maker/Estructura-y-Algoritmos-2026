/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 Pila<T> mediante nodos enlazados propios, sin arreglos ni colecciones.
 * head representa el tope. Implementá apilar, desapilar, consultarTope, estaVacia, contiene e imprimir.
 * Usá Objects.equals y admití null como dato. Las operaciones de tope son O(1), búsqueda/impresión O(n).
 * Operar sobre pila vacía para consultar o desapilar lanza IllegalStateException.
 * Documentá genéricos, contratos y complejidad; demostrá Integer, String y objetos propios.
 */
package unidad6.ejercicio03;

import java.util.Objects;

/**
 * Pila LIFO genérica implementada con nodos enlazados.
 *
 * <p>El tipo parametrizado mantiene la comprobación de tipos para cada cliente;
 * las referencias {@code next} y la lógica de la pila son independientes de T.
 *
 * @param <T> tipo de los elementos apilados
 */
public final class Pila<T> {
    private static final class Nodo<E> {
        private final E dato;
        private final Nodo<E> siguiente;

        private Nodo(E dato, Nodo<E> siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    private Nodo<T> head;

    /** Crea una pila genérica vacía. */
    public Pila() {
    }

    /**
     * Agrega un elemento al tope.
     *
     * @param dato elemento que se apila; puede ser {@code null}
     * Tiempo O(1); espacio adicional O(1).
     */
    public void apilar(T dato) {
        head = new Nodo<>(dato, head);
    }

    /**
     * Retira y devuelve el elemento superior.
     *
     * @return elemento retirado, que puede ser {@code null}
     * @throws IllegalStateException si la pila está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public T desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("la pila está vacía");
        }
        T dato = head.dato;
        head = head.siguiente;
        return dato;
    }

    /**
     * Consulta el elemento superior sin retirarlo.
     *
     * @return elemento del tope, que puede ser {@code null}
     * @throws IllegalStateException si la pila está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public T consultarTope() {
        if (estaVacia()) {
            throw new IllegalStateException("la pila está vacía");
        }
        return head.dato;
    }

    /**
     * Indica si no hay nodos.
     *
     * @return {@code true} si la pila está vacía
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Busca un elemento usando igualdad nula-segura.
     *
     * @param dato elemento buscado
     * @return {@code true} si aparece en la pila
     * Tiempo O(n); espacio adicional O(1).
     */
    public boolean contiene(T dato) {
        for (Nodo<T> actual = head; actual != null; actual = actual.siguiente) {
            if (Objects.equals(actual.dato, dato)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Representa los elementos desde el tope hasta el fondo.
     *
     * @return elementos separados por flechas y terminados en {@code null}
     * Tiempo O(n); espacio adicional O(n) para la cadena resultante.
     */
    public String imprimir() {
        StringBuilder salida = new StringBuilder();
        for (Nodo<T> actual = head; actual != null; actual = actual.siguiente) {
            salida.append(actual.dato).append(" -> ");
        }
        return salida.append("null").toString();
    }
}
/*
 * Ajuste del prompt: ninguno; la implementación admite null y usa Objects.equals para búsqueda.
 */
