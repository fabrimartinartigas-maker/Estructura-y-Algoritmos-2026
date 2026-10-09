/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una cola FIFO de enteros con nodos enlazados propios, sin arreglos ni colecciones.
 * Mantené head y tail; encolar agrega al final y desencolar retira del frente, ambas O(1).
 * Implementá encolar, desencolar, consultarFrente, estaVacia, contiene e imprimir.
 * Al retirar el último nodo, head y tail deben quedar null. Consultar o retirar vacío lanza IllegalStateException.
 * Documentá invariantes y complejidades; separá solución, demo y pruebas con casos FIFO y vacíos.
 */
package unidad6.ejercicio02;

/**
 * Cola FIFO de enteros enlazada, con inserción y extracción en tiempo constante.
 *
 * <p>{@code head} identifica el frente y {@code tail} el último nodo. Mantener
 * ambos extremos evita recorrer la cola al agregar elementos.
 */
public final class ColaEnteros {
    private static final class Nodo {
        private final int dato;
        private Nodo siguiente;

        private Nodo(int dato) {
            this.dato = dato;
        }
    }

    private Nodo head;
    private Nodo tail;

    /** Crea una cola de enteros vacía. */
    public ColaEnteros() {
    }

    /**
     * Agrega un entero al final de la fila.
     *
     * @param dato entero que se encola
     * Tiempo O(1); espacio adicional O(1).
     */
    public void encolar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            head = nuevo;
        } else {
            tail.siguiente = nuevo;
        }
        tail = nuevo;
    }

    /**
     * Retira y devuelve el entero más antiguo.
     *
     * @return elemento del frente
     * @throws IllegalStateException si la cola está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public int desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("la cola está vacía");
        }
        int dato = head.dato;
        head = head.siguiente;
        if (head == null) {
            tail = null;
        }
        return dato;
    }

    /**
     * Consulta el entero más antiguo sin quitarlo.
     *
     * @return elemento del frente
     * @throws IllegalStateException si la cola está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public int consultarFrente() {
        if (estaVacia()) {
            throw new IllegalStateException("la cola está vacía");
        }
        return head.dato;
    }

    /**
     * Indica si la cola no contiene nodos.
     *
     * @return {@code true} si está vacía
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Busca un valor desde el frente hasta el final.
     *
     * @param dato entero que se busca
     * @return {@code true} si el valor está en la cola
     * Tiempo O(n); espacio adicional O(1).
     */
    public boolean contiene(int dato) {
        for (Nodo actual = head; actual != null; actual = actual.siguiente) {
            if (actual.dato == dato) {
                return true;
            }
        }
        return false;
    }

    /**
     * Representa los valores desde el frente hasta el final.
     *
     * @return elementos unidos por flechas y terminados en {@code null}
     * Tiempo O(n); espacio adicional O(n) para la cadena resultante.
     */
    public String imprimir() {
        StringBuilder salida = new StringBuilder();
        for (Nodo actual = head; actual != null; actual = actual.siguiente) {
            salida.append(actual.dato).append(" -> ");
        }
        return salida.append("null").toString();
    }
}
/*
 * Ajuste del prompt: ninguno; head y tail mantienen operaciones de extremos O(1).
 */
