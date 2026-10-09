/*
 * Prompt inicial utilizado:
 * Implementá igualdad elemento a elemento de dos vectores: compara longitudes primero y
 * termina ante la primera diferencia. Documentá mejor O(1), peor O(n) y promedio O(n)
 * si el índice de la primera diferencia es uniforme condicionado a que haya diferencia;
 * vectores iguales inspeccionan n elementos. Espacio auxiliar O(1).
 */
package unidad1.ejercicio06;

import java.util.Objects;

/**
 * Compara vectores de enteros con terminación temprana.
 */
public final class CompararVectores {
    private CompararVectores() {
    }

    /**
     * Comprueba igualdad de longitudes y luego compara valores en orden.
     *
     * @param primero primer vector
     * @param segundo segundo vector
     * @return {@code true} si tienen igual longitud y los mismos valores en cada posición
     * @throws NullPointerException si uno de los vectores es null
     * Mejor caso O(1) ante longitud distinta o diferencia inicial; peor O(n).
     * Bajo el supuesto de que la primera diferencia es uniforme entre las n posiciones,
     * el promedio es O(n) con (n + 1) / 2 comparaciones; vectores iguales requieren n.
     * Espacio auxiliar O(1).
     */
    public static boolean sonIguales(int[] primero, int[] segundo) {
        Objects.requireNonNull(primero, "el primer vector no puede ser null");
        Objects.requireNonNull(segundo, "el segundo vector no puede ser null");
        if (primero.length != segundo.length) {
            return false;
        }
        for (int i = 0; i < primero.length; i++) {
            if (primero[i] != segundo[i]) {
                return false;
            }
        }
        return true;
    }
}
/*
 * Ajuste del prompt: se especificó explícitamente el supuesto probabilístico del caso promedio.
 */
