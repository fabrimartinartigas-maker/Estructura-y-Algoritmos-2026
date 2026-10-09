/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una cola enlazada FIFO propia de trabajos de impresión.
 * TrabajoImpresion contiene nombre de archivo, cantidad de páginas y usuario.
 * Ofrecé agregarTrabajo, imprimirProximo, consultarProximoArchivo, trabajosPendientes y estaVacia.
 * Insertá en tail y procesá desde head en O(1); al vaciar, ambos extremos son null.
 * Consultar/procesar vacío lanza IllegalStateException. Documentá y probá orden, vacíos y consulta.
 */
package unidad6.ejercicio09;

/**
 * Cola FIFO de documentos pendientes de impresión.
 */
public final class ColaImpresion {
    /**
     * Datos de un trabajo enviado a imprimir.
     *
     * @param nombreArchivo nombre del archivo
     * @param cantidadPaginas número de páginas
     * @param usuario persona que envió el trabajo
     */
    public record TrabajoImpresion(String nombreArchivo, int cantidadPaginas, String usuario) {
    }

    private static final class Nodo {
        private final TrabajoImpresion trabajo;
        private Nodo siguiente;

        private Nodo(TrabajoImpresion trabajo) {
            this.trabajo = trabajo;
        }
    }

    private Nodo head;
    private Nodo tail;

    /** Crea una cola de impresión vacía. */
    public ColaImpresion() {
    }

    /**
     * Agrega un trabajo al final de la cola.
     *
     * @param trabajo trabajo que se incorpora
     * Tiempo O(1); espacio adicional O(1).
     */
    public void agregarTrabajo(TrabajoImpresion trabajo) {
        Nodo nuevo = new Nodo(trabajo);
        if (estaVacia()) {
            head = nuevo;
        } else {
            tail.siguiente = nuevo;
        }
        tail = nuevo;
    }

    /**
     * Retira y devuelve el trabajo que se imprimirá a continuación.
     *
     * @return trabajo más antiguo
     * @throws IllegalStateException si no hay trabajos
     * Tiempo O(1); espacio adicional O(1).
     */
    public TrabajoImpresion imprimirProximo() {
        if (estaVacia()) {
            throw new IllegalStateException("no hay trabajos pendientes");
        }
        TrabajoImpresion trabajo = head.trabajo;
        head = head.siguiente;
        if (head == null) {
            tail = null;
        }
        return trabajo;
    }

    /**
     * Consulta el nombre del próximo archivo sin retirar el trabajo.
     *
     * @return nombre de archivo del frente
     * @throws IllegalStateException si no hay trabajos
     * Tiempo O(1); espacio adicional O(1).
     */
    public String consultarProximoArchivo() {
        if (estaVacia()) {
            throw new IllegalStateException("no hay trabajos pendientes");
        }
        return head.trabajo.nombreArchivo();
    }

    /**
     * Indica si no hay documentos en espera.
     *
     * @return {@code true} si la cola está vacía
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Representa todos los trabajos desde el próximo a imprimir.
     *
     * @return trabajos pendientes en orden FIFO, o {@code null} si está vacía
     * Tiempo O(n); espacio adicional O(n) para la cadena resultante.
     */
    public String trabajosPendientes() {
        StringBuilder salida = new StringBuilder();
        for (Nodo nodo = head; nodo != null; nodo = nodo.siguiente) {
            salida.append(nodo.trabajo).append(" -> ");
        }
        return salida.append("null").toString();
    }
}
/*
 * Ajuste del prompt: ninguno; la cola procesa los trabajos en orden FIFO.
 */
