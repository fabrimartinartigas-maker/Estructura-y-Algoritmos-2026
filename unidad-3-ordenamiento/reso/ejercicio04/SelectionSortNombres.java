package unidad3.ejercicio04;

import java.util.Objects;

/**
 * Selection Sort para nombres con el orden lexicográfico de {@link String#compareTo(String)}.
 */
public final class SelectionSortNombres {
    private SelectionSortNombres() {
    }

    /**
     * Ordena los nombres en el orden de {@code String.compareTo}.
     *
     * @param nombres arreglo no nulo de strings no nulos, modificado in-place
     * @throws NullPointerException si el arreglo o alguno de sus nombres es nulo
     *
     * Tiempo O(n^2) comparaciones; espacio auxiliar O(1).
     */
    public static void ordenar(String[] nombres) {
        Objects.requireNonNull(nombres, "nombres");
        for (String nombre : nombres) {
            Objects.requireNonNull(nombre, "nombre");
        }
        for (int inicio = 0; inicio < nombres.length - 1; inicio++) {
            int minimo = inicio;
            for (int i = inicio + 1; i < nombres.length; i++) {
                if (nombres[i].compareTo(nombres[minimo]) < 0) {
                    minimo = i;
                }
            }
            if (minimo != inicio) {
                String temporal = nombres[inicio];
                nombres[inicio] = nombres[minimo];
                nombres[minimo] = temporal;
            }
        }
    }
}
