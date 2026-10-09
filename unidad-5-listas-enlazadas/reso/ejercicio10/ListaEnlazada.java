/*
 * Prompt inicial utilizado:
 * Implementá Nodo<T> y ListaEnlazada<T> en Java 21 con head y size, sin colecciones Java.
 * Soporta inserción al inicio/final/posición, imprimir, búsqueda, obtener, eliminar por valor/posición, modificar, contar ocurrencias e invertir.
 * La posición de inserción admite 0..size; acceso/modificación/eliminación por posición 0..size-1, inválidas lanzan IndexOutOfBoundsException. Elimina solo la primera coincidencia y usa Objects.equals.
 * Explica qué cambia int por T y qué se mantiene igual en recorrido, enlaces, head y size. Demuestra Integer, String y Alumno.
 * Documenta con Javadoc, separa implementación de demo/pruebas y comenta prompt inicial al principio y ajustes al final.
 */
package unidad5.ejercicio10;

import java.util.Objects;

/**
 * Lista enlazada simple genérica con operaciones de recorrido y actualización.
 *
 * @param <T> tipo almacenado en cada nodo
 */
public final class ListaEnlazada<T> {
    private Nodo<T> head;
    private int size;

    /** Crea una lista genérica vacía. */
    public ListaEnlazada() {
    }

    /**
     * Inserta un dato al principio.
     *
     * @param dato valor que se almacena
     * Tiempo O(1); espacio O(1).
     */
    public void insertarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(head);
        head = nuevo;
        size++;
    }

    /**
     * Agrega un dato al final recorriendo desde head.
     *
     * @param dato valor que se almacena
     * Tiempo O(n); espacio O(1).
     */
    public void insertarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (head == null) {
            head = nuevo;
        } else {
            Nodo<T> actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        size++;
    }

    /**
     * Inserta en cualquier índice desde cero hasta size inclusive.
     *
     * @param dato valor nuevo
     * @param posicion índice de inserción
     * @throws IndexOutOfBoundsException si posicion &lt; 0 o posicion &gt; size
     * Tiempo O(n); espacio adicional O(1).
     */
    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException("posición " + posicion + ", size " + size);
        }
        if (posicion == 0) {
            insertarAlInicio(dato);
            return;
        }
        Nodo<T> anterior = nodoEn(posicion - 1);
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(anterior.getSiguiente());
        anterior.setSiguiente(nuevo);
        size++;
    }

    /**
     * Busca usando igualdad de objetos y recorre hasta hallar el dato o null.
     *
     * @param dato valor a buscar
     * @return true si existe un elemento igual
     * Tiempo O(n); espacio O(1).
     */
    public boolean buscar(T dato) {
        for (Nodo<T> actual = head; actual != null; actual = actual.getSiguiente()) {
            if (Objects.equals(actual.getDato(), dato)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Recupera un dato mediante recorrido secuencial.
     *
     * @param posicion índice desde cero
     * @return dato del nodo indicado
     * @throws IndexOutOfBoundsException si posicion no pertenece a 0..size-1
     * Tiempo O(n); espacio O(1).
     */
    public T obtener(int posicion) {
        return nodoEn(posicion).getDato();
    }

    /**
     * Elimina la primera aparición igual al valor dado.
     *
     * @param dato valor buscado
     * @return true si eliminó un nodo
     * Tiempo O(n); espacio O(1).
     */
    public boolean eliminar(T dato) {
        if (head == null) {
            return false;
        }
        if (Objects.equals(head.getDato(), dato)) {
            head = head.getSiguiente();
            size--;
            return true;
        }
        Nodo<T> anterior = head;
        while (anterior.getSiguiente() != null
                && !Objects.equals(anterior.getSiguiente().getDato(), dato)) {
            anterior = anterior.getSiguiente();
        }
        if (anterior.getSiguiente() == null) {
            return false;
        }
        anterior.setSiguiente(anterior.getSiguiente().getSiguiente());
        size--;
        return true;
    }

    /**
     * Elimina por posición, actualizando head o el enlace del nodo anterior.
     *
     * @param posicion índice desde cero
     * @throws IndexOutOfBoundsException si posicion no pertenece a 0..size-1
     * Tiempo O(n); espacio O(1).
     */
    public void eliminarEnPosicion(int posicion) {
        validarElemento(posicion);
        if (posicion == 0) {
            head = head.getSiguiente();
        } else {
            Nodo<T> anterior = nodoEn(posicion - 1);
            anterior.setSiguiente(anterior.getSiguiente().getSiguiente());
        }
        size--;
    }

    /**
     * Modifica el dato del nodo sin alterar su enlace siguiente.
     *
     * @param posicion índice desde cero
     * @param nuevoDato nuevo valor
     * @throws IndexOutOfBoundsException si posicion no pertenece a 0..size-1
     * Tiempo O(n); espacio O(1).
     */
    public void modificar(int posicion, T nuevoDato) {
        nodoEn(posicion).setDato(nuevoDato);
    }

    /**
     * Cuenta todas las apariciones según {@link Objects#equals(Object, Object)}.
     *
     * @param dato valor a contar
     * @return cantidad de coincidencias
     * Tiempo O(n); espacio O(1).
     */
    public int contarOcurrencias(T dato) {
        int cantidad = 0;
        for (Nodo<T> actual = head; actual != null; actual = actual.getSiguiente()) {
            if (Objects.equals(actual.getDato(), dato)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Invierte los enlaces in-place preservando todos los nodos.
     * Tiempo O(n); espacio adicional O(1).
     */
    public void invertir() {
        Nodo<T> anterior = null;
        Nodo<T> actual = head;
        while (actual != null) {
            Nodo<T> siguiente = actual.getSiguiente();
            actual.setSiguiente(anterior);
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }

    /**
     * Comprueba si head es null.
     *
     * @return true cuando la lista está vacía
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Devuelve el tamaño mantenido por las operaciones mutables.
     *
     * @return cantidad de nodos
     */
    public int getSize() {
        return size;
    }

    /** Imprime el recorrido completo en formato dato -> ... -> null. */
    public void imprimir() {
        System.out.println(this);
    }

    private Nodo<T> nodoEn(int posicion) {
        validarElemento(posicion);
        Nodo<T> actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    private void validarElemento(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("posición " + posicion + ", size " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder salida = new StringBuilder();
        for (Nodo<T> actual = head; actual != null; actual = actual.getSiguiente()) {
            salida.append(actual.getDato()).append(" -> ");
        }
        return salida.append("null").toString();
    }
}
/*
 * Ajustes realizados luego de la primera respuesta de OpenCode: Nodo<T> se entrega en archivo
 * público independiente; la búsqueda, eliminación y cuenta comparan con Objects.equals.
 */
