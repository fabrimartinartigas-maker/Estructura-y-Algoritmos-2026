/*
 * Prompt inicial utilizado:
 * Implementá boolean eliminar(int dato) para una lista simple de enteros; elimina solo la primera aparición.
 * Trata lista vacía, head, medio, último y ausencia. Desvincula head o enlaza anterior con siguiente del eliminado, actualiza size y devuelve si encontró.
 * Explica que Java no libera manualmente el nodo: al quedar inaccesible desde la lista podrá recuperarlo el Garbage Collector.
 * Sin colecciones de almacenamiento. Documenta O(n)/O(1) y prueba duplicados para verificar que solo se elimine la primera aparición.
 */
package unidad5.ejercicio05;

/**
 * Lista enlazada simple que elimina la primera coincidencia de un valor.
 */
public final class ListaConEliminacionPorValor {
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
    public ListaConEliminacionPorValor() {
    }

    /**
     * Agrega un nodo para construir una secuencia de prueba.
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
     * Desvincula la primera coincidencia; el nodo queda disponible para el GC.
     *
     * @param dato valor a eliminar
     * @return true si se encontró y eliminó; false si no existe
     * Tiempo O(n); espacio adicional O(1).
     */
    public boolean eliminar(int dato) {
        if (head == null) {
            return false;
        }
        if (head.dato == dato) {
            head = head.siguiente;
            size--;
            return true;
        }
        Node anterior = head;
        while (anterior.siguiente != null && anterior.siguiente.dato != dato) {
            anterior = anterior.siguiente;
        }
        if (anterior.siguiente == null) {
            return false;
        }
        anterior.siguiente = anterior.siguiente.siguiente;
        size--;
        return true;
    }

    /**
     * Devuelve el tamaño tras las operaciones de eliminación.
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
