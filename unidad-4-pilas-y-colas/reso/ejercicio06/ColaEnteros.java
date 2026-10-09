/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una clase ColaEnteros con arreglo fijo de capacidad recibida en el constructor. Debe ofrecer enqueue, dequeue, front, isEmpty, isFull y size.
 * Mantené índices front y rear lineales: rear avanza al agregar, front al quitar. No uses módulo ni reutilices celdas anteriores a front; esta cola simple debe distinguirse de una circular.
 * Rechazá capacidad no positiva con IllegalArgumentException. enqueue llena y dequeue/front vacía lanzan IllegalStateException. Documentá los valores iniciales de índices, transiciones, resultados y complejidad.
 * Separá estructura, demo y pruebas. Validá FIFO, estado vacío/lleno, capacidad 1 y transiciones de tamaño.
 * Comentá el prompt inicial al principio del fuente y agregá al final una nota breve indicando si fue modificado.
 */
package unidad4.ejercicio06;

/**
 * Cola FIFO lineal de enteros implementada con arreglo; no reutiliza posiciones anteriores a front.
 */
public final class ColaEnteros {
    private final int[] elementos;
    private int front;
    private int rear = -1;
    private int size;

    /**
     * Crea una cola lineal vacía.
     *
     * @param capacidad cantidad de celdas del arreglo
     * @throws IllegalArgumentException si la capacidad no es positiva
     */
    public ColaEnteros(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("la capacidad debe ser positiva");
        }
        elementos = new int[capacidad];
    }

    /**
     * Inserta al final de la cola lineal.
     *
     * @param valor entero agregado
     * @throws IllegalStateException si rear ya llegó al final del arreglo
     * Tiempo O(1); espacio adicional O(1).
     */
    public void enqueue(int valor) {
        if (isFull()) {
            throw new IllegalStateException("la cola lineal está llena");
        }
        elementos[++rear] = valor;
        size++;
    }

    /**
     * Retira y devuelve el elemento más antiguo.
     *
     * @return elemento del frente
     * @throws IllegalStateException si está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("la cola está vacía");
        }
        int valor = elementos[front++];
        size--;
        return valor;
    }

    /**
     * Consulta el primer elemento sin retirarlo.
     *
     * @return elemento del frente
     * @throws IllegalStateException si está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("la cola está vacía");
        }
        return elementos[front];
    }

    /**
     * Comprueba si no quedan elementos.
     *
     * @return si no contiene elementos
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Comprueba si rear alcanzó la última posición física.
     *
     * @return si rear alcanzó la última posición física
     */
    public boolean isFull() {
        return rear == elementos.length - 1;
    }

    /**
     * Informa cuántos elementos siguen pendientes.
     *
     * @return cantidad de elementos pendientes
     */
    public int size() {
        return size;
    }

    /**
     * Devuelve el índice del primer elemento actual.
     *
     * @return índice lineal del primer elemento actual
     */
    public int frontIndex() {
        return front;
    }

    /**
     * Devuelve el índice de la última posición ocupada.
     *
     * @return índice de la última posición ocupada
     */
    public int rearIndex() {
        return rear;
    }
}
/*
 * Ajuste del prompt: ninguno; la cola se conserva deliberadamente lineal, no circular.
 */
