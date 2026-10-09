/*
 * Prompt inicial utilizado:
 * Implementá void modificar(int posicion, int nuevoDato) en una lista simple de enteros.
 * Valida antes del recorrido 0 <= posicion < size; inválida lanza IndexOutOfBoundsException. Recorre head hasta el nodo y reemplaza su dato.
 * Explica que el dato cambia pero la referencia siguiente no debe cambiar. No uses colecciones para almacenar; documenta O(n)/O(1).
 * Prueba primer, medio, último, -1 y size, comprobando size y enlaces inalterados.
 */
package unidad5.ejercicio07;

/**
 * Lista enlazada simple que reemplaza el dato de un nodo sin reordenar enlaces.
 */
public final class ListaConModificacion {
    private Node head;
    private int size;

    private static final class Node {
        private int dato;
        private Node siguiente;

        private Node(int dato) {
            this.dato = dato;
        }
    }

    /** Crea una lista vacía. */
    public ListaConModificacion() {
    }

    /**
     * Agrega un dato al final para construir la secuencia inicial.
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
     * Cambia únicamente el dato del nodo en la posición indicada.
     *
     * @param posicion índice desde cero
     * @param nuevoDato valor que reemplaza al existente
     * @throws IndexOutOfBoundsException si posicion no pertenece a 0..size-1
     * Tiempo O(n); espacio adicional O(1).
     */
    public void modificar(int posicion, int nuevoDato) {
        validar(posicion);
        Node actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        actual.dato = nuevoDato;
    }

    private void validar(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("posición " + posicion + ", size " + size);
        }
    }

    /**
     * Devuelve el tamaño; modificar datos no altera este valor.
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
