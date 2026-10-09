/*
 * Prompt inicial utilizado:
 * Implementá búsqueda lineal en un vector desordenado de enteros; inspeccioná en orden
 * y detenete ante la primera coincidencia. Devolvé índice opcional y posiciones inspeccionadas.
 * Documentá mejores, peores y promedio (objetivo equiprobable en cualquier posición),
 * además de espacio O(1). Separá solución, demo y pruebas; incluye vector vacío y ausente.
 */
package unidad1.ejercicio02;

import java.util.Objects;
import java.util.OptionalInt;

/**
 * Búsqueda secuencial de un objetivo en un vector sin precondición de orden.
 */
public final class BusquedaLineal {
    private BusquedaLineal() {
    }

    /**
     * Resultado de una búsqueda lineal, incluida la cantidad de posiciones examinadas.
     *
     * @param indice índice de la primera coincidencia, vacío si no aparece
     * @param posicionesInspeccionadas posiciones comparadas realmente
     */
    public record Resultado(OptionalInt indice, int posicionesInspeccionadas) {
        /**
         * Crea un resultado de búsqueda.
         *
         * @param indice posición encontrada o vacío
         * @param posicionesInspeccionadas cantidad no negativa de posiciones revisadas
         */
        public Resultado {
            Objects.requireNonNull(indice, "el índice no puede ser null");
            if (posicionesInspeccionadas < 0) {
                throw new IllegalArgumentException("las posiciones inspeccionadas no pueden ser negativas");
            }
        }
    }

    /**
     * Inspecciona elementos desde el índice cero y termina ante la primera coincidencia.
     *
     * @param valores vector desordenado
     * @param objetivo valor buscado
     * @return índice opcional y cantidad de elementos inspeccionados
     * @throws NullPointerException si {@code valores} es null
     * Mejor caso O(1); peor y promedio O(n), bajo el supuesto de posición de éxito
     * equiprobable. Espacio auxiliar O(1).
     */
    public static Resultado buscar(int[] valores, int objetivo) {
        Objects.requireNonNull(valores, "el vector no puede ser null");
        int inspeccionadas = 0;
        for (int i = 0; i < valores.length; i++) {
            inspeccionadas++;
            if (valores[i] == objetivo) {
                return new Resultado(OptionalInt.of(i), inspeccionadas);
            }
        }
        return new Resultado(OptionalInt.empty(), inspeccionadas);
    }
}
/*
 * Ajuste del prompt: el resultado combina OptionalInt y el contador exacto de inspecciones.
 */
