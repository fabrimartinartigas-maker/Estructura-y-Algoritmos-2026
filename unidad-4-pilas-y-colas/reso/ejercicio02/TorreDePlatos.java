/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 un simulador de torre de platos con etiquetas String y pila respaldada por arreglo fijo de capacidad configurable.
 * Permite agregar un plato, retirar el superior y consultar cuál está arriba. Explica por qué corresponde LIFO y no FIFO.
 * Rechazá capacidad no positiva con IllegalArgumentException y las operaciones de insertar en lleno o retirar/consultar vacío con IllegalStateException.
 * Documentá clase, operaciones, errores y complejidades; no uses Stack, Deque ni colecciones dinámicas para almacenar los platos. Separa solución, demo y pruebas.
 * Probá torre vacía, agregar varios platos, consultar y retirar en orden inverso, y capacidad llena.
 * Incluí el prompt inicial como comentario al comienzo del archivo y una nota final sobre si fue modificado.
 */
package unidad4.ejercicio02;

/**
 * Torre de platos cuyo acceso se realiza únicamente por el elemento superior (LIFO).
 */
public final class TorreDePlatos {
    private final String[] platos;
    private int top = -1;

    /**
     * Crea la torre con el límite de almacenamiento indicado.
     *
     * @param capacidad máximo de platos que puede contener la torre
     * @throws IllegalArgumentException si la capacidad no es positiva
     */
    public TorreDePlatos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("la capacidad debe ser positiva");
        }
        platos = new String[capacidad];
    }

    /**
     * Agrega un plato arriba de la torre.
     *
     * @param plato etiqueta del plato
     * @throws IllegalStateException si la torre está llena
     * Tiempo O(1), espacio O(1) adicional.
     */
    public void agregar(String plato) {
        if (isFull()) {
            throw new IllegalStateException("la torre está llena");
        }
        platos[++top] = plato;
    }

    /**
     * Retira y devuelve el plato superior.
     *
     * @return etiqueta retirada
     * @throws IllegalStateException si la torre está vacía
     * Tiempo O(1), espacio O(1) adicional.
     */
    public String retirarSuperior() {
        if (isEmpty()) {
            throw new IllegalStateException("la torre está vacía");
        }
        String plato = platos[top];
        platos[top--] = null;
        return plato;
    }

    /**
     * Consulta sin retirar el plato superior.
     *
     * @return etiqueta del plato superior
     * @throws IllegalStateException si la torre está vacía
     * Tiempo O(1), espacio O(1) adicional.
     */
    public String platoSuperior() {
        if (isEmpty()) {
            throw new IllegalStateException("la torre está vacía");
        }
        return platos[top];
    }

    /**
     * Comprueba si la torre está vacía.
     *
     * @return si no hay platos
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Comprueba si la torre alcanzó su capacidad fija.
     *
     * @return si se alcanzó la capacidad fija
     */
    public boolean isFull() {
        return top == platos.length - 1;
    }

    /**
     * Cuenta los platos apilados.
     *
     * @return cantidad de platos
     */
    public int size() {
        return top + 1;
    }
}
/*
 * Ajuste del prompt: ninguno; se eligió String como etiqueta, opción permitida por la consigna.
 */
