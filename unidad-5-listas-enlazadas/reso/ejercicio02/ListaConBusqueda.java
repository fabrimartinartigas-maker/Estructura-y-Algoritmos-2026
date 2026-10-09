/*
 * Prompt inicial utilizado:
 * Implementá una lista enlazada simple de enteros con boolean buscar(int dato).
 * Recorré desde head por siguiente hasta encontrar el dato o llegar a null. Explicá que no hay acceso directo por índice como en arreglo.
 * No uses colecciones para almacenar. Documentá O(n) tiempo/O(1) espacio y separá implementación de demo y pruebas.
 * Prueba lista vacía, presentes al inicio y final, ausente y duplicados.
 */
package unidad5.ejercicio02;

/**
 * Lista simple de enteros que busca mediante recorrido secuencial.
 */
public final class ListaConBusqueda {
    private Node head;
    private int size;

    private static final class Node {
        private final int dato;
        private Node siguiente;

        private Node(int dato) {
            this.dato = dato;
        }
    }

    /** Crea una lista vacía para construir los casos de búsqueda. */
    public ListaConBusqueda() {
    }

    /**
     * Agrega al final para construir la secuencia de búsqueda.
     *
     * @param dato entero agregado
     */
    public void agregar(int dato) {
        Node nodo = new Node(dato);
        if (head == null) {
            head = nodo;
        } else {
            Node actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nodo;
        }
        size++;
    }

    /**
     * Busca inspeccionando cada nodo en orden hasta hallar una coincidencia o null.
     *
     * @param dato valor a localizar
     * @return true si se encuentra
     * Tiempo O(n); espacio adicional O(1).
     */
    public boolean buscar(int dato) {
        Node actual = head;
        while (actual != null) {
            if (actual.dato == dato) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    /**
     * Devuelve la cantidad de nodos de la lista.
     *
     * @return cantidad de nodos
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
