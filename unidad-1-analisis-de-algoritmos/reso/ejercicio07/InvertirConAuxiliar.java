/*
 * Prompt inicial utilizado:
 * Implementá una inversión que construya y devuelva otro vector en orden inverso sin modificar
 * el recibido. Documentá O(n) tiempo/O(n) espacio y casos vacío, unitario, longitud par e impar.
 */
package unidad1.ejercicio07;

import java.util.Objects;

/**
 * Invierte un vector construyendo un resultado en memoria auxiliar.
 */
public final class InvertirConAuxiliar {
    private InvertirConAuxiliar() {
    }

    /**
     * Copia los valores en orden inverso y conserva intacta la entrada.
     *
     * @param valores vector original
     * @return nuevo vector con los elementos invertidos
     * @throws NullPointerException si {@code valores} es null
     * Tiempo O(n); espacio auxiliar O(n).
     */
    public static int[] invertir(int[] valores) {
        Objects.requireNonNull(valores, "el vector no puede ser null");
        int[] invertido = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            invertido[i] = valores[valores.length - 1 - i];
        }
        return invertido;
    }
}
/*
 * Ajuste del prompt: ninguno; el vector de entrada se conserva sin cambios.
 */
