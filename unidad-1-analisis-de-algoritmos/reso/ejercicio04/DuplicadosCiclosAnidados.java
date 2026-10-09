/*
 * Prompt inicial utilizado:
 * Implementá detección de duplicados en int[] comparando cada par con dos ciclos anidados,
 * sin estructura auxiliar. Detenete en la primera coincidencia y documentá O(n²) tiempo,
 * O(1) espacio, entradas y casos vacío, unitario, distintos, duplicados contiguos/no contiguos.
 */
package unidad1.ejercicio04;

import java.util.Objects;

/**
 * Detecta valores repetidos comparando pares de posiciones.
 */
public final class DuplicadosCiclosAnidados {
    private DuplicadosCiclosAnidados() {
    }

    /**
     * Compara cada posición con las posiciones posteriores y termina al hallar un duplicado.
     *
     * @param valores vector de enteros
     * @return {@code true} si dos posiciones distintas contienen el mismo valor
     * @throws NullPointerException si {@code valores} es null
     * Peor tiempo O(n²); espacio auxiliar O(1), siendo n la longitud del vector.
     */
    public static boolean contieneDuplicados(int[] valores) {
        Objects.requireNonNull(valores, "el vector no puede ser null");
        for (int i = 0; i < valores.length; i++) {
            for (int j = i + 1; j < valores.length; j++) {
                if (valores[i] == valores[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*
 * Ajuste del prompt: ninguno; la solución compara pares sin memoria auxiliar.
 */
