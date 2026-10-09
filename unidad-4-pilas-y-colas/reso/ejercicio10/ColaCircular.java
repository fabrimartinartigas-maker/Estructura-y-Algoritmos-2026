/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una cola circular de enteros usando un arreglo de capacidad fija configurable. Ofrece enqueue, dequeue, front, isEmpty, isFull y size.
 * Hacé avanzar front y rear circularmente usando módulo: índice = (índice + 1) % capacidad. Llevá un contador de elementos para distinguir sin ambigüedad cola vacía y llena. Reutilizá los espacios liberados al inicio.
 * Capacidad no positiva: IllegalArgumentException. enqueue llena y dequeue/front vacía: IllegalStateException. Documentá índices iniciales, contador, transiciones, invariantes, errores y complejidad O(1).
 * No uses Queue, Deque ni colecciones dinámicas para almacenar elementos. Separá implementación, demo y pruebas.
 * Probá capacidad 1, vacío, lleno, wrap-around, dequeue seguido de enqueue para reutilizar espacio y orden FIFO tras varias vueltas.
 * Incluí el prompt inicial al comienzo del .java y al final informá si hubo ajustes.
 */
package unidad4.ejercicio10;

/**
 * Cola FIFO circular de enteros respaldada por un arreglo.
 */
public final class ColaCircular {
    private final int[] elementos;
    private int front;
    private int rear;
    private int size;

    /**
     * Crea una cola circular vacía.
     *
     * @param capacidad tamaño del arreglo circular
     * @throws IllegalArgumentException si no es positiva
     */
    public ColaCircular(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("la capacidad debe ser positiva");
        }
        elementos = new int[capacidad];
    }

    /**
     * Inserta al final y avanza rear de forma circular.
     *
     * @param valor entero a agregar
     * @throws IllegalStateException si la cola está llena
     * Tiempo O(1); espacio adicional O(1).
     */
    public void enqueue(int valor) {
        if (isFull()) {
            throw new IllegalStateException("la cola está llena");
        }
        elementos[rear] = valor;
        rear = (rear + 1) % elementos.length;
        size++;
    }

    /**
     * Retira el elemento más antiguo y avanza front de forma circular.
     *
     * @return elemento retirado
     * @throws IllegalStateException si está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("la cola está vacía");
        }
        int valor = elementos[front];
        front = (front + 1) % elementos.length;
        size--;
        return valor;
    }

    /**
     * Consulta el elemento más antiguo.
     *
     * @return elemento del frente
     * @throws IllegalStateException si está vacía
     */
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("la cola está vacía");
        }
        return elementos[front];
    }

    /**
     * Comprueba si la cola no tiene elementos.
     *
     * @return si no contiene elementos
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Comprueba si todas las posiciones están ocupadas.
     *
     * @return si todas las posiciones están ocupadas
     */
    public boolean isFull() {
        return size == elementos.length;
    }

    /**
     * Informa la cantidad de elementos almacenados.
     *
     * @return cantidad de elementos actuales
     */
    public int size() {
        return size;
    }

    /**
     * Devuelve la posición de inserción siguiente.
     *
     * @return índice donde se insertará el próximo elemento
     */
    public int rearIndex() {
        return rear;
    }

    /**
     * Devuelve la posición del elemento más antiguo.
     *
     * @return índice del primer elemento
     */
    public int frontIndex() {
        return front;
    }
}
/*
 * Ajuste del prompt: ninguno; se usa size como contador para distinguir estados lleno y vacío.
 */
