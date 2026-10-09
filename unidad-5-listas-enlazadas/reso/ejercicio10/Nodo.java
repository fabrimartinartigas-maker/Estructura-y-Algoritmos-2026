/*
 * Prompt inicial utilizado:
 * Implementá Nodo<T> para una lista enlazada simple genérica con dato de tipo T y referencia siguiente.
 * Provee acceso tipado al dato y al siguiente nodo; no uses estructuras de colección.
 * Documenta el propósito de las referencias y agrega el prompt inicial y nota de ajustes.
 */
package unidad5.ejercicio10;

/**
 * Nodo genérico formado por un dato de tipo {@code T} y referencia al próximo nodo.
 *
 * @param <T> tipo de dato del nodo
 */
public final class Nodo<T> {
    private T dato;
    private Nodo<T> siguiente;

    /**
     * Construye un nodo cuyo enlace siguiente inicialmente es null.
     *
     * @param dato dato almacenado
     */
    public Nodo(T dato) {
        this.dato = dato;
    }

    /**
     * Devuelve el dato almacenado.
     *
     * @return dato del nodo
     */
    public T getDato() {
        return dato;
    }

    /**
     * Reemplaza el dato sin cambiar el enlace.
     *
     * @param dato nuevo dato almacenado
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Devuelve el enlace al próximo nodo.
     *
     * @return nodo siguiente, o null si este es el último
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    /**
     * Actualiza el enlace al próximo nodo.
     *
     * @param siguiente nodo que seguirá a este, o null
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}
/*
 * Ajustes realizados luego de la primera respuesta de OpenCode: se separó Nodo<T> en su propio
 * archivo para que sea un tipo público reutilizable junto con ListaEnlazada<T>.
 */
