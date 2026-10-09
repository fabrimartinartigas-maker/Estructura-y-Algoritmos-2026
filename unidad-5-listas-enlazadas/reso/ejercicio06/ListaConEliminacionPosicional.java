/*
 * Prompt inicial utilizado:
 * Implementá void eliminarEnPosicion(int posicion) en una lista simple de enteros.
 * Valida 0 <= posicion < size y lanza IndexOutOfBoundsException si es inválida.
 * Si es cero avanza head; si no, recorre hasta el nodo anterior y enlaza ese nodo con el siguiente del eliminado. Decrementa size una vez.
 * Explica los enlaces, no uses colecciones Java, documenta O(n)/O(1) y prueba cabeza, medio, último y posiciones inválidas.
 */
package unidad5.ejercicio06;

/**
 * Lista enlazada simple con eliminación por índice.
 */
public final class ListaConEliminacionPosicional {
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
    public ListaConEliminacionPosicional() {
    }

    /**
     * Agrega un nodo para permitir preparar una lista de prueba.
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
     * Desvincula el nodo indicado y actualiza head si se elimina la cabeza.
     *
     * @param posicion índice desde cero
     * @throws IndexOutOfBoundsException si la posición no está en 0..size-1
     * Tiempo O(n); espacio adicional O(1).
     */
    public void eliminarEnPosicion(int posicion) {
        validar(posicion);
        if (posicion == 0) {
            head = head.siguiente;
        } else {
            Node anterior = nodoEn(posicion - 1);
            anterior.siguiente = anterior.siguiente.siguiente;
        }
        size--;
    }

    private void validar(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("posición " + posicion + ", size " + size);
        }
    }

    private Node nodoEn(int posicion) {
        Node actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }

    /**
     * Devuelve el número actual de nodos.
     *
     * @return tamaño de la lista
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
