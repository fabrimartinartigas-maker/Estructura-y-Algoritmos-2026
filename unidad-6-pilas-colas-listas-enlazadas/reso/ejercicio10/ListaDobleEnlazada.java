/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 ListaDobleEnlazada<T> con nodos propios que tengan dato, anterior y siguiente.
 * Mantené head y tail; implementá insertarAlInicio, insertarAlFinal, eliminar, imprimirAdelante,
 * imprimirAtras y estaVacia. eliminar quita la primera coincidencia según Objects.equals y devuelve boolean.
 * Admití null y mantené head.anterior == null, tail.siguiente == null y enlaces recíprocos.
 * Documentá contratos, casos de extremos y complejidades. Separá implementación, demo y pruebas.
 */
package unidad6.ejercicio10;

import java.util.Objects;

/**
 * Lista doblemente enlazada genérica que permite recorrer en ambos sentidos.
 *
 * <p>El primer nodo no tiene anterior y el último no tiene siguiente. Los dos
 * extremos se actualizan en cada inserción o eliminación.
 *
 * @param <T> tipo de dato almacenado
 */
public final class ListaDobleEnlazada<T> {
    private static final class Nodo<E> {
        private final E dato;
        private Nodo<E> anterior;
        private Nodo<E> siguiente;

        private Nodo(E dato) {
            this.dato = dato;
        }
    }

    private Nodo<T> head;
    private Nodo<T> tail;

    /** Crea una lista doblemente enlazada vacía. */
    public ListaDobleEnlazada() {
    }

    /**
     * Inserta un dato antes del primer nodo.
     *
     * @param dato dato que se agrega; puede ser {@code null}
     * Tiempo O(1); espacio adicional O(1).
     */
    public void insertarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = head;
        if (head == null) {
            tail = nuevo;
        } else {
            head.anterior = nuevo;
        }
        head = nuevo;
    }

    /**
     * Inserta un dato después del último nodo.
     *
     * @param dato dato que se agrega; puede ser {@code null}
     * Tiempo O(1); espacio adicional O(1).
     */
    public void insertarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.anterior = tail;
        if (tail == null) {
            head = nuevo;
        } else {
            tail.siguiente = nuevo;
        }
        tail = nuevo;
    }

    /**
     * Elimina la primera coincidencia por igualdad nula-segura.
     *
     * @param dato valor que se elimina
     * @return {@code true} si se encontró y desvinculó un nodo
     * Tiempo O(n) por la búsqueda; desvincular el nodo encontrado es O(1).
     */
    public boolean eliminar(T dato) {
        Nodo<T> actual = head;
        while (actual != null && !Objects.equals(actual.dato, dato)) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            return false;
        }

        if (actual.anterior == null) {
            head = actual.siguiente;
        } else {
            actual.anterior.siguiente = actual.siguiente;
        }
        if (actual.siguiente == null) {
            tail = actual.anterior;
        } else {
            actual.siguiente.anterior = actual.anterior;
        }
        actual.anterior = null;
        actual.siguiente = null;
        return true;
    }

    /**
     * Indica si no hay nodos.
     *
     * @return {@code true} si la lista está vacía
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Representa los datos desde head hasta tail.
     *
     * @return datos separados por flechas y terminados en {@code null}
     * Tiempo O(n); espacio adicional O(n) para la cadena resultante.
     */
    public String imprimirAdelante() {
        StringBuilder salida = new StringBuilder();
        for (Nodo<T> nodo = head; nodo != null; nodo = nodo.siguiente) {
            salida.append(nodo.dato).append(" <-> ");
        }
        return salida.append("null").toString();
    }

    /**
     * Representa los datos desde tail hasta head.
     *
     * @return datos en orden inverso, separados por flechas y terminados en {@code null}
     * Tiempo O(n); espacio adicional O(n) para la cadena resultante.
     */
    public String imprimirAtras() {
        StringBuilder salida = new StringBuilder();
        for (Nodo<T> nodo = tail; nodo != null; nodo = nodo.anterior) {
            salida.append(nodo.dato).append(" <-> ");
        }
        return salida.append("null").toString();
    }
}
/*
 * Ajuste del prompt: se definió eliminar por valor la primera coincidencia, decisión confirmada por el usuario.
 */
