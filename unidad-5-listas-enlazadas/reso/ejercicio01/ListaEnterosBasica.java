/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una lista enlazada simple de enteros sin ArrayList ni LinkedList.
 * Cada nodo contiene dato y siguiente; head apunta al primer nodo o es null. Mantén size actualizado.
 * Ofrece insertarAlInicio, insertarAlFinal, imprimir, estaVacia y getSize. imprimir muestra dato -> ... -> null y null para lista vacía.
 * Documenta propósito, referencias y complejidades. Separa implementación de demo/pruebas y prueba lista vacía, inicio, final y size.
 */
package unidad5.ejercicio01;

import java.util.Objects;

/**
 * Lista enlazada simple de enteros con inserción en ambos extremos.
 */
public final class ListaEnterosBasica {
    private Node head;
    private int size;

    private static final class Node {
        private final int dato;
        private Node siguiente;

        private Node(int dato) {
            this.dato = dato;
        }
    }

    /** Crea una lista vacía, con head null y size cero. */
    public ListaEnterosBasica() {
    }

    /**
     * Inserta al comienzo y convierte el nodo nuevo en head.
     *
     * @param dato valor a agregar
     * Tiempo O(1); espacio O(1).
     */
    public void insertarAlInicio(int dato) {
        Node nuevo = new Node(dato);
        nuevo.siguiente = head;
        head = nuevo;
        size++;
    }

    /**
     * Inserta al final recorriendo desde head hasta el último nodo.
     *
     * @param dato valor a agregar
     * Tiempo O(n); espacio O(1).
     */
    public void insertarAlFinal(int dato) {
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
     * Imprime los datos en orden de enlace y el terminador null.
     * Tiempo O(n); espacio O(n) para formar la representación.
     */
    public void imprimir() {
        System.out.println(this);
    }

    /**
     * Comprueba si no hay un nodo inicial.
     *
     * @return true si head no apunta a ningún nodo
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Devuelve el tamaño mantenido durante las inserciones.
     *
     * @return cantidad de nodos
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder salida = new StringBuilder();
        Node actual = head;
        while (actual != null) {
            salida.append(actual.dato).append(" -> ");
            actual = actual.siguiente;
        }
        return salida.append("null").toString();
    }
}
/*
 * Ajustes realizados luego de la primera respuesta de OpenCode: no hubo ajustes.
 */
