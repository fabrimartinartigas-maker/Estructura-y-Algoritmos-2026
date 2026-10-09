/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una clase genérica Pila<T> respaldada por un arreglo de capacidad fija configurable. Debe ofrecer push, pop, peek, isEmpty, isFull y size.
 * Usá un arreglo interno de Object y encapsulá la conversión a T dentro de la clase; los clientes no deben necesitar casts ni usar tipos crudos. Limpiá el espacio liberado al hacer pop.
 * Rechazá capacidad no positiva con IllegalArgumentException. push en pila llena y pop/peek en vacía lanzan IllegalStateException.
 * Explicá qué resuelven los genéricos: una sola implementación reutilizable conserva comprobación de tipos para Integer, String u objetos simples, a diferencia de una pila solo de int. Documentá invariantes, errores y complejidad O(1).
 * No uses Stack ni colecciones para el almacenamiento. Separá implementación, ejemplo y pruebas. Demostrá Integer, String y un objeto simple; probá límites y LIFO.
 * Comentá el prompt inicial al inicio del .java y explicá al final si el prompt requirió ajustes.
 */
package unidad4.ejercicio05;

/**
 * Pila genérica LIFO respaldada por un arreglo de capacidad fija.
 *
 * @param <T> tipo de los valores almacenados
 */
public final class Pila<T> {
    private final Object[] elementos;
    private int top = -1;

    /**
     * Crea una pila genérica vacía.
     *
     * @param capacidad capacidad máxima
     * @throws IllegalArgumentException si no es positiva
     */
    public Pila(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("la capacidad debe ser positiva");
        }
        elementos = new Object[capacidad];
    }

    /**
     * Apila un elemento.
     *
     * @param elemento valor del tipo {@code T}
     * @throws IllegalStateException si la pila está llena
     * Tiempo O(1); espacio O(1) adicional.
     */
    public void push(T elemento) {
        if (isFull()) {
            throw new IllegalStateException("la pila está llena");
        }
        elementos[++top] = elemento;
    }

    /**
     * Retira el elemento superior y libera su celda.
     *
     * @return elemento retirado
     * @throws IllegalStateException si está vacía
     * Tiempo O(1); espacio O(1) adicional.
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("la pila está vacía");
        }
        T elemento = (T) elementos[top];
        elementos[top--] = null;
        return elemento;
    }

    /**
     * Consulta el elemento superior.
     *
     * @return elemento superior, sin retirarlo
     * @throws IllegalStateException si está vacía
     * Tiempo O(1); espacio O(1) adicional.
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("la pila está vacía");
        }
        return (T) elementos[top];
    }

    /**
     * Comprueba si no hay valores apilados.
     *
     * @return si la pila está vacía
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Comprueba si se alcanzó la capacidad.
     *
     * @return si la pila está llena
     */
    public boolean isFull() {
        return top == elementos.length - 1;
    }

    /**
     * Informa cuántos valores contiene.
     *
     * @return cantidad actual de elementos
     */
    public int size() {
        return top + 1;
    }
}
/*
 * Ajuste del prompt: ninguno; la conversión queda encapsulada en pop/peek.
 */
