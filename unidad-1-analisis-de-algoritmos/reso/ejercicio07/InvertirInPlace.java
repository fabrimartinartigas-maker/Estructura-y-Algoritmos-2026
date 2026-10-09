/*
 * Prompt inicial utilizado:
 * Implementá inversión in-place de int[] intercambiando elementos desde ambos extremos.
 * No crees un vector auxiliar; documentá modificación de entrada, O(n) tiempo/O(1) espacio
 * y casos vacío, unitario, longitud par e impar.
 */
package unidad1.ejercicio07;

import java.util.Objects;

/**
 * Invierte un vector recibido intercambiando sus extremos hacia el centro.
 */
public final class InvertirInPlace {
    private InvertirInPlace() {
    }

    /**
     * Invierte el orden dentro del mismo vector.
     *
     * @param valores vector que se modifica
     * @throws NullPointerException si {@code valores} es null
     * Tiempo O(n); espacio auxiliar O(1), sin contar la entrada.
     */
    public static void invertir(int[] valores) {
        Objects.requireNonNull(valores, "el vector no puede ser null");
        int izquierda = 0;
        int derecha = valores.length - 1;
        while (izquierda < derecha) {
            int temporal = valores[izquierda];
            valores[izquierda] = valores[derecha];
            valores[derecha] = temporal;
            izquierda++;
            derecha--;
        }
    }
}
/*
 * Ajuste del prompt: ninguno; solo se usa una variable temporal para cada intercambio.
 */
