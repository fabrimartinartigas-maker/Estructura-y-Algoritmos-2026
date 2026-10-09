/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 un historial de navegación usando una pila enlazada simple propia.
 * visitar apila una URL; la página actual queda en el tope. volver quita la actual y devuelve la anterior.
 * Con una sola página volver deja el historial vacío y devuelve Optional.empty(); con historial ya vacío,
 * volver lanza IllegalStateException. paginaActual devuelve Optional.empty() si está vacío sin modificarlo.
 * Rechazá URL null. Implementá imprimirHistorial y documentá contratos, semántica LIFO y complejidad.
 * Separá solución, demo y pruebas con historial vacío, una página y varias visitas/retornos.
 */
package unidad6.ejercicio05;

import java.util.Optional;
import java.util.Objects;

/**
 * Historial LIFO de páginas visitadas, con la página actual en el tope.
 */
public final class HistorialNavegacion {
    private static final class Nodo {
        private final String url;
        private final Nodo anterior;

        private Nodo(String url, Nodo anterior) {
            this.url = url;
            this.anterior = anterior;
        }
    }

    private Nodo actual;

    /** Crea un historial sin visitas. */
    public HistorialNavegacion() {
    }

    /**
     * Agrega una visita y la convierte en página actual.
     *
     * @param url dirección de la página, no nula
     * @throws NullPointerException si {@code url} es null
     * Tiempo O(1); espacio adicional O(1).
     */
    public void visitar(String url) {
        actual = new Nodo(Objects.requireNonNull(url, "url no puede ser null"), actual);
    }

    /**
     * Retira la página actual y devuelve la que queda activa.
     *
     * @return página anterior, o vacío si se retiró la única visita
     * @throws IllegalStateException si el historial ya estaba vacío
     * Tiempo O(1); espacio adicional O(1).
     */
    public Optional<String> volver() {
        if (actual == null) {
            throw new IllegalStateException("el historial está vacío");
        }
        actual = actual.anterior;
        return Optional.ofNullable(actual == null ? null : actual.url);
    }

    /**
     * Consulta la página actual sin cambiar el historial.
     *
     * @return página actual, o vacío si no hubo visitas
     * Tiempo O(1); espacio adicional O(1).
     */
    public Optional<String> paginaActual() {
        return actual == null ? Optional.empty() : Optional.of(actual.url);
    }

    /**
     * Representa las visitas desde la página actual hacia las anteriores.
     *
     * @return URLs unidas por flechas y terminadas en {@code null}
     * Tiempo O(n); espacio adicional O(n) para la cadena resultante.
     */
    public String imprimirHistorial() {
        StringBuilder salida = new StringBuilder();
        for (Nodo nodo = actual; nodo != null; nodo = nodo.anterior) {
            salida.append(nodo.url).append(" -> ");
        }
        return salida.append("null").toString();
    }
}
/*
 * Ajuste del prompt: ninguno; volver retira la página actual según la semántica LIFO acordada.
 */
