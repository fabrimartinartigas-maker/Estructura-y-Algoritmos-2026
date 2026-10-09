/*
 * Prompt inicial utilizado:
 * Implementá int obtener(int posicion) para una lista enlazada simple de enteros.
 * Valida antes del recorrido que 0 <= posicion < size; fuera de rango lanza IndexOutOfBoundsException.
 * Para un índice válido, recorre desde head nodo a nodo. Explica que la posición no da acceso directo como en un arreglo.
 * No uses colecciones Java. Documenta O(n) tiempo/O(1) espacio; prueba primero, medio, último, vacío, -1 y size.
 */
package unidad5.ejercicio03;

/**
 * Lista simple de enteros que resuelve el acceso por posición con recorrido.
 */
public final class ListaConAccesoPosicional {
    private Node head;
    private int size;

    private static final class Node {
        private final int dato;
        private Node siguiente;

        private Node(int dato) {
            this.dato = dato;
        }
    }

    /** Crea una lista vacía para demostrar el acceso posicional secuencial. */
    public ListaConAccesoPosicional() {
    }

    /**
     * Agrega un nodo al final de la secuencia.
     *
     * @param dato dato que se agrega
     */
    public void agregar(int dato) {
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
     * Devuelve el dato recorriendo desde head.
     *
     * @param posicion índice desde cero
     * @return dato almacenado en la posición
     * @throws IndexOutOfBoundsException si la posición no pertenece a 0..size-1
     * Tiempo O(posicion), peor O(n); espacio O(1).
     */
    public int obtener(int posicion) {
        validar(posicion);
        Node actual = head;
        for (int indice = 0; indice < posicion; indice++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    private void validar(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("posición " + posicion + ", size " + size);
        }
    }

    /**
     * Devuelve el número de nodos almacenados.
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
