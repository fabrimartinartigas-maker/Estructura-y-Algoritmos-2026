package unidad3.ejercicio10;

import java.util.Objects;

/**
 * Ranking de jugadores ordenado descendentemente mediante Insertion Sort estable.
 */
public final class RankingPuntajes {
    private RankingPuntajes() {
    }

    /**
     * Jugador con nombre y puntaje.
     *
     * @param nombre nombre no nulo
     * @param puntaje puntaje entero
     */
    public record Jugador(String nombre, int puntaje) {
        /**
         * Crea un jugador para el ranking.
         *
         * @param nombre identificador no nulo del jugador
         * @param puntaje puntaje entero usado para ordenar
         * @throws NullPointerException si el nombre es nulo
         */
        public Jugador {
            Objects.requireNonNull(nombre, "nombre");
        }
    }

    /**
     * Ordena de mayor a menor puntaje sin cambiar el orden relativo de los empates.
     *
     * @param jugadores arreglo no nulo de jugadores, modificado in-place
     * @throws NullPointerException si el arreglo o alguno de sus elementos es nulo
     *
     * Tiempo mejor O(n), peor O(n^2); espacio auxiliar O(1).
     */
    public static void ordenar(Jugador[] jugadores) {
        Objects.requireNonNull(jugadores, "jugadores");
        for (Jugador jugador : jugadores) {
            Objects.requireNonNull(jugador, "jugador");
        }
        for (int i = 1; i < jugadores.length; i++) {
            Jugador clave = jugadores[i];
            int j = i - 1;
            while (j >= 0 && jugadores[j].puntaje() < clave.puntaje()) {
                jugadores[j + 1] = jugadores[j];
                j--;
            }
            jugadores[j + 1] = clave;
        }
    }
}
