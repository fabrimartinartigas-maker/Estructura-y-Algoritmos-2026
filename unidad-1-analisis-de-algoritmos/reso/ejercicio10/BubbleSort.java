/*
 * Prompt inicial utilizado:
 * Implementá Bubble Sort ascendente in-place para int[]. Contá por separado comparaciones
 * adyacentes e intercambios realmente ejecutados. Usá las pasadas estándar sin salida temprana,
 * y documentá propósito didáctico, modificación de entrada, O(n²) tiempo/O(1) espacio y métricas.
 * Probá entrada vacía, unitaria, ordenada, inversa y con valores repetidos.
 */
package unidad1.ejercicio10;

import java.util.Objects;

/**
 * Ordena enteros con Bubble Sort y devuelve contadores observables del algoritmo.
 *
 * <p>El método usa las pasadas estándar sin detección de vector ya ordenado.
 * Bubble Sort es útil para estudiar comparaciones e intercambios o para conjuntos
 * pequeños, pero su tiempo cuadrático no es apropiado para grandes entradas.
 */
public final class BubbleSort {
    private BubbleSort() {
    }

    /**
     * Métricas contadas durante la ordenación.
     *
     * @param comparaciones cantidad de pares adyacentes comparados
     * @param intercambios cantidad de intercambios realizados
     */
    public record Metricas(long comparaciones, long intercambios) {
    }

    /**
     * Ordena ascendentemente el vector recibido, modificándolo.
     *
     * @param valores vector que se ordena
     * @return comparaciones ejecutadas e intercambios efectuados
     * @throws NullPointerException si {@code valores} es null
     * Tiempo O(n²) en cualquier orden de entrada al no usar salida temprana;
     * espacio auxiliar O(1). Las comparaciones son n(n-1)/2 para longitud n.
     */
    public static Metricas ordenar(int[] valores) {
        Objects.requireNonNull(valores, "el vector no puede ser null");
        long comparaciones = 0;
        long intercambios = 0;
        for (int pasada = 0; pasada < valores.length - 1; pasada++) {
            for (int indice = 0; indice < valores.length - 1 - pasada; indice++) {
                comparaciones++;
                if (valores[indice] > valores[indice + 1]) {
                    int temporal = valores[indice];
                    valores[indice] = valores[indice + 1];
                    valores[indice + 1] = temporal;
                    intercambios++;
                }
            }
        }
        return new Metricas(comparaciones, intercambios);
    }
}
/*
 * Ajuste del prompt: se eligió la variante estándar sin salida anticipada para que
 * las comparaciones dependan solo del tamaño y la definición de métrica sea inequívoca.
 */
