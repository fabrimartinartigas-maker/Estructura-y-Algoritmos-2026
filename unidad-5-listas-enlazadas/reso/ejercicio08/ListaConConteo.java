/*
 * Prompt inicial utilizado:
 * Implementá int contarOcurrencias(int dato) para una lista enlazada simple de enteros.
 * Recorre desde head hasta null e incrementa el contador por cada coincidencia; no pares en la primera.
 * Incluye el ejemplo 10 -> 20 -> 10 -> 30 -> 10 -> null, donde el conteo de 10 es 3.
 * Sin colecciones Java. Documenta O(n)/O(1), separa código, demo y pruebas; cubre vacío, ausente, una y varias ocurrencias.
 */
package unidad5.ejercicio08;

/**
 * Lista simple de enteros que cuenta todas las apariciones de un valor.
 */
public final class ListaConConteo {
    private Node head;
    private int size;

    private static final class Node {
        private final int dato;
        private Node siguiente;

        private Node(int dato) {
            this.dato = dato;
        }
    }

    /** Crea una lista vacía para contar ocurrencias. */
    public ListaConConteo() {
    }

    /**
     * Agrega un entero al final de la lista.
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
     * Inspecciona la lista completa aunque encuentre coincidencias tempranas.
     *
     * @param dato valor a contar
     * @return cantidad de nodos con ese dato
     * Tiempo O(n); espacio adicional O(1).
     */
    public int contarOcurrencias(int dato) {
        int cantidad = 0;
        for (Node actual = head; actual != null; actual = actual.siguiente) {
            if (actual.dato == dato) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Devuelve la cantidad de nodos.
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
