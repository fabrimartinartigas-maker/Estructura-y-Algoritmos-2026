/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 un sistema de turnos para una oficina usando una cola FIFO lineal basada en arreglo fijo y de capacidad configurable. Cada turno contiene el nombre de una persona.
 * Debe agregar una persona, atender (quitar) a la siguiente y consultar quién está primero sin retirarlo. Explicá que quien llega primero se atiende primero (FIFO), a diferencia de LIFO en una pila.
 * Usá índices front y rear lineales que avancen hacia adelante, sin módulo ni reutilización de posiciones anteriores a front. No uses Queue, Deque ni colecciones dinámicas para guardar turnos. Capacidad no positiva produce IllegalArgumentException; agregar cuando rear alcanzó el final o atender/consultar vacío produce IllegalStateException.
 * Documentá operaciones, estado e invariantes con Javadoc y sus complejidades. Separá estructura, demostración y pruebas.
 * Probá cola vacía, una persona, varias llegadas y atenciones en el mismo orden, y capacidad llena.
 * Incluí el prompt inicial como comentario al comienzo del .java e indicá al final si fue ajustado.
 */
package unidad4.ejercicio07;

/**
 * Cola lineal FIFO de nombres para atención por orden de llegada.
 */
public final class SistemaTurnos {
    private final String[] personas;
    private int front;
    private int rear = -1;
    private int size;

    /**
     * Crea una cola lineal vacía.
     *
     * @param capacidad cantidad máxima de turnos
     * @throws IllegalArgumentException si no es positiva
     */
    public SistemaTurnos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("la capacidad debe ser positiva");
        }
        personas = new String[capacidad];
    }

    /**
     * Agrega una persona al final de la cola lineal.
     *
     * @param persona nombre de quien llega
     * @throws IllegalStateException si rear alcanzó el final del arreglo
     * Tiempo O(1); espacio adicional O(1).
     */
    public void agregarPersona(String persona) {
        if (isFull()) {
            throw new IllegalStateException("la cola de turnos está llena");
        }
        personas[++rear] = persona;
        size++;
    }

    /**
     * Atiende y retira a la persona que llegó primero.
     *
     * @return nombre atendido
     * @throws IllegalStateException si no hay personas esperando
     * Tiempo O(1); espacio adicional O(1).
     */
    public String atenderSiguiente() {
        if (isEmpty()) {
            throw new IllegalStateException("no hay personas en espera");
        }
        String persona = personas[front];
        personas[front++] = null;
        size--;
        return persona;
    }

    /**
     * Consulta quién será atendido sin retirarlo.
     *
     * @return nombre al frente
     * @throws IllegalStateException si la cola está vacía
     */
    public String primero() {
        if (isEmpty()) {
            throw new IllegalStateException("no hay personas en espera");
        }
        return personas[front];
    }

    /**
     * Comprueba si no hay turnos en espera.
     *
     * @return si no hay personas esperando
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Comprueba si rear alcanzó la última posición física.
     *
     * @return si todas las posiciones están ocupadas
     */
    public boolean isFull() {
        return rear == personas.length - 1;
    }

    /**
     * Informa la cantidad de personas pendientes.
     *
     * @return cantidad de personas en espera
     */
    public int size() {
        return size;
    }
}
/*
 * Ajuste del prompt: ninguno; se mantiene una cola lineal como la estructura básica de la guía.
 */
