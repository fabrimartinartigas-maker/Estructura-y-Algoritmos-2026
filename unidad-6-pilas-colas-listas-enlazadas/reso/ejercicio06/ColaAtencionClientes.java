/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una cola FIFO enlazada propia para clientes de banco, sin colecciones como almacenamiento.
 * Cliente contiene nombre, número de turno y motivo. Ofrecé agregarCliente, atenderProximo,
 * consultarProximo, estaVacia e imprimirFila. Encolar al tail y retirar head en O(1);
 * limpiar ambos extremos al quedar vacía. Consultar o atender vacío lanza IllegalStateException.
 * Documentá FIFO y contratos; separá solución, demo y pruebas del orden de llegada.
 */
package unidad6.ejercicio06;

/**
 * Cola FIFO de clientes que esperan atención bancaria.
 */
public final class ColaAtencionClientes {
    /**
     * Datos de un cliente en espera.
     *
     * @param nombre nombre del cliente
     * @param numeroTurno número asignado para la atención
     * @param motivo motivo de consulta
     */
    public record Cliente(String nombre, int numeroTurno, String motivo) {
    }

    private static final class Nodo {
        private final Cliente cliente;
        private Nodo siguiente;

        private Nodo(Cliente cliente) {
            this.cliente = cliente;
        }
    }

    private Nodo head;
    private Nodo tail;

    /** Crea una fila de atención vacía. */
    public ColaAtencionClientes() {
    }

    /**
     * Agrega el cliente al final de la fila.
     *
     * @param cliente datos del cliente que espera
     * Tiempo O(1); espacio adicional O(1).
     */
    public void agregarCliente(Cliente cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (estaVacia()) {
            head = nuevo;
        } else {
            tail.siguiente = nuevo;
        }
        tail = nuevo;
    }

    /**
     * Retira al cliente que lleva más tiempo esperando.
     *
     * @return cliente atendido
     * @throws IllegalStateException si no hay clientes
     * Tiempo O(1); espacio adicional O(1).
     */
    public Cliente atenderProximo() {
        if (estaVacia()) {
            throw new IllegalStateException("no hay clientes para atender");
        }
        Cliente cliente = head.cliente;
        head = head.siguiente;
        if (head == null) {
            tail = null;
        }
        return cliente;
    }

    /**
     * Consulta quién será atendido sin quitarlo de la fila.
     *
     * @return siguiente cliente
     * @throws IllegalStateException si no hay clientes
     * Tiempo O(1); espacio adicional O(1).
     */
    public Cliente consultarProximo() {
        if (estaVacia()) {
            throw new IllegalStateException("no hay clientes para atender");
        }
        return head.cliente;
    }

    /**
     * Indica si no hay clientes en espera.
     *
     * @return {@code true} si la fila está vacía
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Representa los clientes en su orden de llegada.
     *
     * @return nombres separados por flechas y terminados en {@code null}
     * Tiempo O(n); espacio adicional O(n) para la cadena resultante.
     */
    public String imprimirFila() {
        StringBuilder salida = new StringBuilder();
        for (Nodo nodo = head; nodo != null; nodo = nodo.siguiente) {
            salida.append(nodo.cliente).append(" -> ");
        }
        return salida.append("null").toString();
    }
}
/*
 * Ajuste del prompt: ninguno; el orden de atención sigue el orden de llegada.
 */
