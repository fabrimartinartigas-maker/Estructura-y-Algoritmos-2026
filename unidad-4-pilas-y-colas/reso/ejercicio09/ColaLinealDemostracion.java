/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una cola lineal simple con arreglo fijo y capacidad configurable que muestre el desperdicio de espacio.
 * front y rear avanzan hacia adelante sin compactar, módulo ni reutilización. Con capacidad 5, encola A,B,C; desencola dos; encola D,E. Muestra arreglo físico, front, rear, size e isFull y prueba que una inserción más falla aunque las posiciones del inicio estén libres.
 * Ofrece enqueue, dequeue, front, isEmpty, isFull, size y estado físico de diagnóstico. Capacidad no positiva: IllegalArgumentException; insertar lleno o acceder vacía: IllegalStateException.
 * Explica que el espacio inicial liberado no puede reutilizarse en esta cola simple y contrástalo conceptualmente con una circular sin implementarla aquí. Documentá la representación y complejidad.
 * Separá clase, demo y pruebas; probá la secuencia exacta, FIFO, estados vacíos/llenos y capacidad 1. Incluí el prompt inicial en comentario al inicio y nota final sobre ajustes.
 */
package unidad4.ejercicio09;

import java.util.Arrays;

/**
 * Cola lineal de etiquetas con acceso de diagnóstico al arreglo físico.
 */
public final class ColaLinealDemostracion {
    private final String[] elementos;
    private int front;
    private int rear = -1;
    private int size;

    /**
     * Crea una cola lineal vacía para observar sus índices físicos.
     *
     * @param capacidad cantidad de celdas disponibles
     * @throws IllegalArgumentException si no es positiva
     */
    public ColaLinealDemostracion(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("la capacidad debe ser positiva");
        }
        elementos = new String[capacidad];
    }

    /**
     * Agrega al final físico del arreglo; los espacios previos a front no se reutilizan.
     *
     * @param valor etiqueta a agregar
     * @throws IllegalStateException si rear ya llegó al final del arreglo
     * Tiempo O(1); espacio adicional O(1).
     */
    public void enqueue(String valor) {
        if (isFull()) {
            throw new IllegalStateException("no hay posición al final de la cola lineal");
        }
        elementos[++rear] = valor;
        size++;
    }

    /**
     * Retira el elemento más antiguo.
     *
     * @return etiqueta retirada
     * @throws IllegalStateException si está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public String dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("la cola está vacía");
        }
        String valor = elementos[front];
        elementos[front++] = null;
        size--;
        return valor;
    }

    /**
     * Consulta el elemento más antiguo.
     *
     * @return etiqueta al frente
     * @throws IllegalStateException si está vacía
     */
    public String front() {
        if (isEmpty()) {
            throw new IllegalStateException("la cola está vacía");
        }
        return elementos[front];
    }

    /**
     * Comprueba si no hay elementos pendientes.
     *
     * @return si no quedan elementos
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Comprueba si rear llegó al último índice físico.
     *
     * @return si rear llegó al último índice físico
     */
    public boolean isFull() {
        return rear == elementos.length - 1;
    }

    /**
     * Cuenta los elementos actuales.
     *
     * @return número actual de elementos encolados
     */
    public int size() {
        return size;
    }

    /**
     * Devuelve el índice del primer elemento actual.
     *
     * @return índice del primer elemento actual
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

    /**
     * Devuelve una copia del arreglo físico para diagnóstico.
     *
     * @return copia del arreglo físico, incluidos los espacios libres
     */
    public String[] estadoArreglo() {
        return Arrays.copyOf(elementos, elementos.length);
    }
}
/*
 * Ajuste del prompt: se definió una API de diagnóstico (índices y copia física) para hacer visible
 * el desperdicio de espacio solicitado por la consigna.
 */
