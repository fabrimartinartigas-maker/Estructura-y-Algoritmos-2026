/*
 * Prompt inicial utilizado:
 * Implementá búsqueda binaria iterativa para vector ordenado ascendentemente.
 * Mostrá límites, medio y comparación en cada iteración; usá medio = bajo + (alto-bajo)/2.
 * Devolvé índice o -1 si no existe, documentá precondición y complejidad O(log n)/O(1).
 * Separá solución y pruebas; incluye vector vacío, extremos, medio y ausentes.
 */
package unidad1.ejercicio03;

import java.io.PrintStream;
import java.util.Objects;

/**
 * Búsqueda binaria iterativa sobre un vector ascendente.
 */
public final class BusquedaBinaria {
    private BusquedaBinaria() {
    }

    /**
     * Busca un objetivo e imprime cada actualización del intervalo.
     *
     * @param valores vector de enteros ordenado ascendentemente
     * @param objetivo valor buscado
     * @param salida destino de la traza
     * @return índice encontrado o -1 si no aparece
     * @throws NullPointerException si el vector o el destino de salida es null
     * Tiempo O(log n); espacio auxiliar O(1). El vector ordenado es precondición y
     * no se verifica recorriéndolo, para conservar la complejidad de la búsqueda.
     */
    public static int buscar(int[] valores, int objetivo, PrintStream salida) {
        Objects.requireNonNull(valores, "el vector no puede ser null");
        Objects.requireNonNull(salida, "la salida no puede ser null");
        int bajo = 0;
        int alto = valores.length - 1;

        while (bajo <= alto) {
            int medio = bajo + (alto - bajo) / 2;
            int valorMedio = valores[medio];
            if (valorMedio == objetivo) {
                salida.printf("bajo=%d, alto=%d, medio=%d, valor=%d: encontrado%n",
                        bajo, alto, medio, valorMedio);
                salida.printf("Resultado: índice %d%n", medio);
                return medio;
            }
            if (valorMedio < objetivo) {
                salida.printf("bajo=%d, alto=%d, medio=%d, valor=%d: buscar a la derecha%n",
                        bajo, alto, medio, valorMedio);
                bajo = medio + 1;
            } else {
                salida.printf("bajo=%d, alto=%d, medio=%d, valor=%d: buscar a la izquierda%n",
                        bajo, alto, medio, valorMedio);
                alto = medio - 1;
            }
        }
        salida.println("Resultado: no encontrado");
        return -1;
    }
}
/*
 * Ajuste del prompt: la traza se escribe en un PrintStream recibido por parámetro
 * para mantener la solución comprobable y separar su salida de la demostración.
 */
