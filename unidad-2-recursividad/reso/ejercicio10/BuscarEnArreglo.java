/*
 * Prompt inicial utilizado:
 * Implementá en Java 21 una función recursiva que busque un entero objetivo en un arreglo de enteros, sin usar ciclos.
 * La búsqueda comienza en la posición 0 y avanza una posición por llamada recursiva. Caso base de éxito: el elemento en la posición actual coincide con el objetivo. Caso base de fracaso: el índice alcanza la longitud del arreglo. Devuelve el índice de la primera coincidencia o -1 si el valor no existe.
 * No uses for, while, streams ni otra técnica iterativa para recorrer el arreglo.
 * Documentá propósito, razonamiento, parámetros, resultado y complejidad temporal y espacial con Javadoc. Comentá los dos casos base y el avance del índice.
 * Separá implementación, ejemplos y pruebas. Probá arreglo vacío, objetivo al inicio y al final, valor ausente y valor repetido.
 */
package unidad2.ejercicio10;

import java.util.Objects;

/**
 * Busca recursivamente un valor en un arreglo sin ciclos.
 */
public final class BuscarEnArreglo {
    private BuscarEnArreglo() {
    }

    /**
     * Busca desde el índice cero y devuelve la primera posición coincidente.
     *
     * @param valores arreglo no nulo que se inspecciona
     * @param objetivo valor buscado
     * @return índice de la primera coincidencia o {@code -1} si no existe
     * @throws NullPointerException si {@code valores} es nulo
     *
     * Tiempo O(n); espacio O(n) por la pila recursiva en el peor caso.
     */
    public static int buscar(int[] valores, int objetivo) {
        Objects.requireNonNull(valores, "valores");
        return buscarDesde(valores, objetivo, 0);
    }

    private static int buscarDesde(int[] valores, int objetivo, int indice) {
        if (indice == valores.length) {
            return -1;
        }
        if (valores[indice] == objetivo) {
            return indice;
        }
        return buscarDesde(valores, objetivo, indice + 1);
    }
}
