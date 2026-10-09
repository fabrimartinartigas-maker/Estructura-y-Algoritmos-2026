/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una pila de enteros con nodos enlazados propios, sin arreglos ni colecciones.
 * head representa el tope. Implementá apilar, desapilar, consultarTope, estaVacia, contiene e imprimir.
 * Apilar y desapilar son O(1); búsqueda e impresión son O(n). Desapilar el último nodo deja head en null.
 * Consultar o desapilar vacío lanza IllegalStateException. Documentá contratos, errores e invariantes.
 * Separá solución, demo y pruebas; probá vacío, LIFO, búsqueda e impresión.
 */
package unidad6.ejercicio01;

/**
 * Pila LIFO de enteros implementada con una lista enlazada simple.
 *
 * <p>El nodo indicado por {@code head} es el tope; por eso insertar o retirar
 * ese nodo no requiere recorrer la estructura.
 */
public final class PilaEnteros {
    private static final class Nodo {
        private final int dato;
        private final Nodo siguiente;

        private Nodo(int dato, Nodo siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    private Nodo head;

    /** Crea una pila de enteros vacía. */
    public PilaEnteros() {
    }

    /**
     * Apila un entero en el tope.
     *
     * @param dato entero que se agrega
     * Tiempo O(1); espacio adicional O(1).
     */
    public void apilar(int dato) {
        head = new Nodo(dato, head);
    }

    /**
     * Retira y devuelve el entero del tope.
     *
     * @return elemento retirado
     * @throws IllegalStateException si la pila está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public int desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("la pila está vacía");
        }
        int dato = head.dato;
        head = head.siguiente;
        return dato;
    }

    /**
     * Consulta el entero del tope sin retirarlo.
     *
     * @return elemento superior
     * @throws IllegalStateException si la pila está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public int consultarTope() {
        if (estaVacia()) {
            throw new IllegalStateException("la pila está vacía");
        }
        return head.dato;
    }

    /**
     * Indica si no hay nodos enlazados.
     *
     * @return {@code true} si la pila está vacía
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Busca un entero recorriendo desde el tope.
     *
     * @param dato valor que se busca
     * @return {@code true} si el valor aparece en la pila
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
     * Representa la pila desde el tope hasta el fondo.
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
 * Ajuste del prompt: ninguno; se mantuvieron los contratos y la estructura solicitados.
 */
