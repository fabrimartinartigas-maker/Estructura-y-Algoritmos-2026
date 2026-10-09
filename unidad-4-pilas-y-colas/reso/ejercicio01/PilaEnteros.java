/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una clase PilaEnteros usando un arreglo de tamaño fijo recibido como capacidad en el constructor.
 * Debe tener push, pop, peek, isEmpty, isFull y size. Mantené top como índice del elemento superior; inicializalo en -1 para representar pila vacía. Al insertar, incrementá top; al quitar, devolvé el elemento y decrementalo.
 * Rechazá capacidad menor o igual a cero con IllegalArgumentException. push cuando esté llena y pop/peek cuando esté vacía deben lanzar IllegalStateException; no devuelvas centinelas.
 * Explicá LIFO y cómo top cambia. Documentá propósito, invariantes, parámetros, resultados, excepciones y complejidad O(1) de las operaciones con Javadoc.
 * Separá la clase de los ejemplos y pruebas. Probá capacidad 1, vacía, llena, insertar/quitar, y el orden LIFO.
 * Al comienzo del .java agregá este prompt como comentario; al final indicá si lo ajustaste y por qué.
 */
package unidad4.ejercicio01;

/**
 * Pila LIFO de enteros almacenada en un arreglo de capacidad fija.
 */
public final class PilaEnteros {
    private final int[] elementos;
    private int top = -1;

    /**
     * Crea una pila vacía con capacidad fija.
     *
     * @param capacidad número máximo de elementos
     * @throws IllegalArgumentException si la capacidad no es positiva
     */
    public PilaEnteros(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("la capacidad debe ser positiva");
        }
        elementos = new int[capacidad];
    }

    /**
     * Apila un valor en la parte superior.
     *
     * @param valor entero que se agrega
     * @throws IllegalStateException si la pila está llena
     * Tiempo O(1); espacio adicional O(1).
     */
    public void push(int valor) {
        if (isFull()) {
            throw new IllegalStateException("la pila está llena");
        }
        elementos[++top] = valor;
    }

    /**
     * Retira y devuelve el elemento superior.
     *
     * @return elemento retirado
     * @throws IllegalStateException si la pila está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("la pila está vacía");
        }
        return elementos[top--];
    }

    /**
     * Consulta el elemento superior sin retirarlo.
     *
     * @return elemento superior
     * @throws IllegalStateException si la pila está vacía
     * Tiempo O(1); espacio adicional O(1).
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("la pila está vacía");
        }
        return elementos[top];
    }

    /**
     * Comprueba si no hay elementos.
     *
     * @return {@code true} si no hay elementos
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Comprueba si se alcanzó la capacidad del arreglo.
     *
     * @return {@code true} si no queda capacidad disponible
     */
    public boolean isFull() {
        return top == elementos.length - 1;
    }

    /**
     * Informa cuántos valores están apilados.
     *
     * @return cantidad de elementos actuales
     */
    public int size() {
        return top + 1;
    }
}
/*
 * Ajuste del prompt: ninguno; la implementación respeta el contrato solicitado.
 */
