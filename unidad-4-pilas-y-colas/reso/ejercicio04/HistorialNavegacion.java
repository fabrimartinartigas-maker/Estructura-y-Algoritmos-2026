/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 un simulador de historial de navegación que almacene URLs en una pila implementada con arreglo fijo de capacidad configurable.
 * Cada visita apila la URL. La operación volver quita con pop la página actual y deja como actual la página anterior; permití consultar la página actual sin quitarla.
 * Explicá por qué el historial sigue LIFO: la última página visitada es la primera de la que se vuelve. Si volver retira la única página, deja el historial vacío y devuelve Optional.empty() porque no hay página anterior; si ya estaba vacío al iniciar volver, lanza IllegalStateException.
 * Capacidad no positiva: IllegalArgumentException. Visitar con pila llena o consultar sin página actual: IllegalStateException.
 * Documentá contratos, cambios de estado y complejidades; separá la clase de la demo y pruebas. Probá varias visitas y dos retornos consecutivos, así como historial vacío y capacidad llena.
 * Incluí el prompt inicial en un comentario al comienzo del fuente y al final una nota sobre ajustes (o que no hubo).
 */
package unidad4.ejercicio04;

import java.util.Optional;

/**
 * Historial LIFO de páginas visitadas, representadas por URLs.
 */
public final class HistorialNavegacion {
    private final String[] paginas;
    private int top = -1;

    /**
     * Crea un historial vacío con capacidad limitada.
     *
     * @param capacidad cantidad máxima de páginas retenidas
     * @throws IllegalArgumentException si la capacidad no es positiva
     */
    public HistorialNavegacion(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("la capacidad debe ser positiva");
        }
        paginas = new String[capacidad];
    }

    /**
     * Registra una visita como página actual.
     *
     * @param url página visitada
     * @throws IllegalStateException si se alcanzó la capacidad
     * Tiempo O(1), espacio O(1) adicional.
     */
    public void visitar(String url) {
        if (top == paginas.length - 1) {
            throw new IllegalStateException("el historial está lleno");
        }
        paginas[++top] = url;
    }

    /**
     * Vuelve a la página anterior retirando la actual.
     *
     * @return URL de la página anterior, o vacío si se retiró la única página
     * @throws IllegalStateException si el historial ya estaba vacío
     * Tiempo O(1), espacio O(1) adicional.
     */
    public Optional<String> volver() {
        if (top == -1) {
            throw new IllegalStateException("el historial está vacío");
        }
        paginas[top--] = null;
        return top == -1 ? Optional.empty() : Optional.of(paginas[top]);
    }

    /**
     * Consulta la página actual sin modificar el historial.
     *
     * @return URL actual
     * @throws IllegalStateException si no se ha visitado ninguna página
     */
    public String paginaActual() {
        if (top == -1) {
            throw new IllegalStateException("el historial está vacío");
        }
        return paginas[top];
    }

    /**
     * Comprueba si no hay páginas registradas.
     *
     * @return si el historial no tiene páginas
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Devuelve la cantidad de páginas retenidas.
     *
     * @return cantidad de páginas en el historial
     */
    public int size() {
        return top + 1;
    }
}
/*
 * Ajuste del prompt: se usa Optional.empty() al volver desde la única página para representar
 * que el historial queda vacío sin inventar una URL.
 */
