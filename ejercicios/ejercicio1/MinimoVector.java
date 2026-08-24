/**
 * Ejercicio 1: valor mínimo de un vector de enteros.
 */
public class MinimoVector {

    /**
     * Devuelve el valor mínimo del vector en una sola pasada, O(n).
     *
     * <p>Precondición: {@code vector} no es {@code null} y tiene al menos un elemento.</p>
     *
     * @param vector vector de enteros no vacío
     * @return el menor elemento del vector
     */
    public static int encontrarMinimo(int[] vector) {
        int minimo = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < minimo) {
                minimo = vector[i];
            }
        }
        return minimo;
    }
}
