/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 Cola<T> FIFO mediante nodos propios, sin arreglos ni colecciones.
 * Mantené head y tail para encolar/desencolar en O(1), limpiando ambos al retirar el último nodo.
 * Implementá encolar, desencolar, consultarFrente, estaVacia, contiene e imprimir.
 * Usá Objects.equals y admití null. Operar sobre cola vacía para consultar/desencolar lanza IllegalStateException.
 * Documentá FIFO y genéricos; probá nombres y objetos Cliente, orden, consulta y transición a vacía.
 */
package unidad6.ejercicio04;

import java.util.Objects;

/**
 * Cola FIFO genérica enlazada que conserva sus dos extremos.
 *
 * <p>El parámetro de tipo permite reutilizar la lógica con nombres, clientes
 * u otros datos sin perder comprobación estática de tipos.
 *
 * @param <T> tipo de los elementos encolados
 */
public final class Cola<T> {
    private static final class Nodo<E> {
        private final E dato;
        private Nodo<E> siguiente;

        private Nodo(E dato) {
            this.dato = dato;
        }
    }

    private Nodo<T> head;
    private Nodo<T> tail;

    /** Crea una cola genérica vacía. */
    public Cola() {
    }

    /**
     * Agrega un elemento detrás de los que ya esperan.
     *
     * @param dato elemento que se encola; puede ser {@code null}
     * Tiempo O(1); espacio adicional O(1).
     */
    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            head = nuevo;
        } else {
            tail.siguiente = nuevo;
        }
        tail = nuevo;
    }

    /**
     * Retira y devuelve el elemento que lleva más tiempo esperando.
     *
     * @return elemento del frente, que puede ser {@code null}
     * @throws IllegalStateException si la cola está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("la cola está vacía");
        }
        T dato = head.dato;
        head = head.siguiente;
        if (head == null) {
            tail = null;
        }
        return dato;
    }

    /**
     * Consulta el próximo elemento sin retirarlo.
     *
     * @return elemento del frente, que puede ser {@code null}
     * @throws IllegalStateException si la cola está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public T consultarFrente() {
        if (estaVacia()) {
            throw new IllegalStateException("la cola está vacía");
        }
        return head.dato;
    }

    /**
     * Indica si la cola no contiene nodos.
     *
     * @return {@code true} si está vacía
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Busca un elemento usando igualdad nula-segura.
     *
     * @param dato elemento buscado
     * @return {@code true} si aparece en la cola
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
     * Representa la cola desde el frente hasta el final.
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
 * Ajuste del prompt: ninguno; la estructura mantiene FIFO y admite datos null.
 */
