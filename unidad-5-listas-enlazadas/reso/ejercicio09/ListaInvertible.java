/*
 * Prompt inicial utilizado:
 * Implementá void invertir() para una lista simple de enteros, in-place.
 * Usa anterior, actual y siguiente; guarda siguiente antes de cambiar actual.siguiente = anterior; avanza referencias y al final actualiza head = anterior.
 * Explica por qué se guarda siguiente y por qué importa el orden para no perder nodos. No uses arreglos auxiliares ni colecciones.
 * Documenta O(n) tiempo/O(1) espacio; prueba vacío, uno, dos y varios nodos verificando orden, size y final null.
 */
package unidad5.ejercicio09;

/**
 * Lista enlazada simple con inversión in-place de los enlaces.
 */
public final class ListaInvertible {
    private Node head;
    private int size;

    private static final class Node {
        private final int dato;
        private Node siguiente;

        private Node(int dato) {
            this.dato = dato;
        }
    }

    /** Crea una lista vacía. */
    public ListaInvertible() {
    }

    /**
     * Agrega un dato al final de la lista.
     *
     * @param dato valor agregado
     */
    public void agregarAlFinal(int dato) {
        Node nuevo = new Node(dato);
        if (head == null) {
            head = nuevo;
        } else {
            Node actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        size++;
    }

    /**
     * Invierte los enlaces usando tres referencias auxiliares y reasigna head.
     *
     * Tiempo O(n); espacio adicional O(1).
     */
    public void invertir() {
        Node anterior = null;
        Node actual = head;
        while (actual != null) {
            Node siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }

    /**
     * Devuelve el número de nodos; invertir no altera este tamaño.
     *
     * @return cantidad de elementos
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder salida = new StringBuilder();
        for (Node actual = head; actual != null; actual = actual.siguiente) {
            salida.append(actual.dato).append(" -> ");
        }
        return salida.append("null").toString();
    }
}
/*
 * Ajustes realizados luego de la primera respuesta de OpenCode: ninguno.
 */
