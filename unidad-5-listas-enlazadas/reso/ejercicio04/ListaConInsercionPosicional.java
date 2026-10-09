/*
 * Prompt inicial utilizado:
 * Implementá insertarEnPosicion(int dato, int posicion) en una lista simple de enteros.
 * Admite 0..size; cero inserta en head, size al final. Índices inválidos lanzan IndexOutOfBoundsException.
 * Para posición interna asigna primero nuevo.siguiente = actual.siguiente y luego actual.siguiente = nuevo; explica que el otro orden puede perder el resto. Mantén head y size.
 * Sin colecciones Java. Documenta complejidad y prueba inicio, medio, final, vacío y límites inválidos.
 */
package unidad5.ejercicio04;

/**
 * Lista simple de enteros con inserción en cualquier posición válida.
 */
public final class ListaConInsercionPosicional {
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
    public ListaConInsercionPosicional() {
    }

    /**
     * Inserta en la posición indicada conservando el enlace al resto de la lista.
     *
     * @param dato valor a insertar
     * @param posicion índice de inserción, desde cero hasta size inclusive
     * @throws IndexOutOfBoundsException si posicion &lt; 0 o posicion &gt; size
     * Tiempo O(n); espacio adicional O(1).
     */
    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException("posición " + posicion + ", size " + size);
        }
        Node nuevo = new Node(dato);
        if (posicion == 0) {
            nuevo.siguiente = head;
            head = nuevo;
        } else {
            Node anterior = nodoEn(posicion - 1);
            nuevo.siguiente = anterior.siguiente;
            anterior.siguiente = nuevo;
        }
        size++;
    }

    private Node nodoEn(int posicion) {
        Node actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }

    /**
     * Devuelve el número de nodos.
     *
     * @return tamaño actual
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
