package unidad3.ejercicio05;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ShellSort con gaps que se reducen a la mitad y traza por etapa.
 */
public final class ShellSortConGaps {
    private ShellSortConGaps() {
    }

    /**
     * Estado del arreglo luego de completar una etapa con el gap indicado.
     *
     * @param gap salto de la etapa
     * @param estado copia del arreglo al terminar la etapa
     */
    public record Etapa(int gap, int[] estado) {
        /**
         * Crea una etapa guardando una copia del estado recibido.
         *
         * @param gap salto aplicado
         * @param estado estado del arreglo al finalizar la etapa
         */
        public Etapa {
            estado = estado.clone();
        }

        /**
         * Devuelve una copia del estado de la etapa.
         *
         * @return copia del arreglo después de completar el gap
         */
        @Override
        public int[] estado() {
            return estado.clone();
        }
    }

    /**
     * Ordena ascendentemente aplicando inserción sobre subsecuencias separadas por cada gap.
     *
     * @param numeros arreglo modificado in-place
     * @return etapas de gaps n/2, n/4, ..., 1 y copias de sus estados finales
     * @throws NullPointerException si el arreglo es nulo
     *
     * Tiempo dependiente de la secuencia; con gaps por mitades su peor caso es O(n^2).
     * Espacio auxiliar O(1), sin contar la traza, que ocupa O(n log n).
     */
    public static List<Etapa> ordenar(int[] numeros) {
        Objects.requireNonNull(numeros, "numeros");
        List<Etapa> etapas = new ArrayList<>();
        for (int gap = numeros.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < numeros.length; i++) {
                int clave = numeros[i];
                int j = i;
                while (j >= gap && numeros[j - gap] > clave) {
                    numeros[j] = numeros[j - gap];
                    j -= gap;
                }
                numeros[j] = clave;
            }
            etapas.add(new Etapa(gap, numeros));
        }
        return List.copyOf(etapas);
    }
}
