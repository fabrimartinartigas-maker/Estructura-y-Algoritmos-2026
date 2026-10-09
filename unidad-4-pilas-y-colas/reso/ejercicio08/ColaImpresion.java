/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una cola de impresión FIFO lineal usando un arreglo fijo de capacidad configurable. Cada documento tiene un nombre y una cantidad positiva de páginas.
 * Permite agregar documentos y procesar el siguiente. Los documentos deben procesarse exactamente en el orden agregado. Muestra qué documento se imprime y cuántas páginas tiene.
 * Mantén front y rear avanzando linealmente; no reutilices posiciones anteriores a front. No uses Queue, Deque ni colecciones para sustituir el arreglo. Capacidad no positiva: IllegalArgumentException; agregar cuando rear alcanzó el final o procesar/consultar vacío: IllegalStateException.
 * Documentá la estructura del documento, operaciones, invariantes, errores y complejidad. Separá implementación, demo y pruebas.
 * Probá cola vacía, un documento, varios documentos para confirmar FIFO, capacidad llena y rechazo de páginas no positivas.
 * Escribí el prompt inicial como comentario al inicio del .java y una nota al final sobre cambios del prompt.
 */
package unidad4.ejercicio08;

import java.util.Objects;

/**
 * Cola lineal FIFO de trabajos de impresión almacenada en un arreglo.
 */
public final class ColaImpresion {
    private final Documento[] trabajos;
    private int front;
    private int rear = -1;
    private int size;

    /**
     * Trabajo enviado a impresión; el nombre no es nulo y la cantidad de páginas es positiva.
     *
     * @param nombre identificador del documento
     * @param paginas cantidad positiva de páginas
     */
    public record Documento(String nombre, int paginas) {
        /**
         * Valida los datos del trabajo antes de almacenarlo.
         *
         * @param nombre identificador no nulo
         * @param paginas cantidad positiva de páginas
         * @throws NullPointerException si nombre es nulo
         * @throws IllegalArgumentException si paginas no es positiva
         */
        public Documento {
            Objects.requireNonNull(nombre, "nombre");
            if (paginas <= 0) {
                throw new IllegalArgumentException("las páginas deben ser positivas");
            }
        }
    }

    /**
     * Crea una cola de impresión con capacidad fija.
     *
     * @param capacidad cantidad máxima de trabajos pendientes
     * @throws IllegalArgumentException si no es positiva
     */
    public ColaImpresion(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("la capacidad debe ser positiva");
        }
        trabajos = new Documento[capacidad];
    }

    /**
     * Encola un documento para imprimir.
     *
     * @param documento trabajo a agregar
     * @throws IllegalStateException si rear alcanzó el final del arreglo
     * @throws NullPointerException si documento es nulo
     * Tiempo O(1); espacio adicional O(1).
     */
    public void agregar(Documento documento) {
        Objects.requireNonNull(documento, "documento");
        if (isFull()) {
            throw new IllegalStateException("la cola de impresión está llena");
        }
        trabajos[++rear] = documento;
        size++;
    }

    /**
     * Procesa el trabajo más antiguo.
     *
     * @return documento retirado para impresión
     * @throws IllegalStateException si no hay trabajos
     * Tiempo O(1); espacio adicional O(1).
     */
    public Documento imprimirSiguiente() {
        if (isEmpty()) {
            throw new IllegalStateException("no hay trabajos para imprimir");
        }
        Documento documento = trabajos[front];
        trabajos[front] = null;
        front++;
        size--;
        return documento;
    }

    /**
     * Consulta el próximo trabajo sin retirarlo.
     *
     * @return documento al frente
     * @throws IllegalStateException si la cola está vacía
     */
    public Documento siguiente() {
        if (isEmpty()) {
            throw new IllegalStateException("no hay trabajos para imprimir");
        }
        return trabajos[front];
    }

    /**
     * Comprueba si no hay documentos pendientes.
     *
     * @return si no hay trabajos
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Comprueba si todas las celdas están ocupadas.
     *
     * @return si se alcanzó la capacidad
     */
    public boolean isFull() {
        return rear == trabajos.length - 1;
    }

    /**
     * Devuelve la cantidad de documentos pendientes.
     *
     * @return trabajos pendientes
     */
    public int size() {
        return size;
    }
}
/*
 * Ajuste del prompt: ninguno; se mantiene la cola lineal y su capacidad fija.
 */
