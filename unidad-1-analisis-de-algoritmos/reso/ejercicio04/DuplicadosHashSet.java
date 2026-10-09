/*
 * Prompt inicial utilizado:
 * Implementá detección de duplicados recorriendo int[] con HashSet<Integer>.
 * Si add(valor) informa que ya estaba, devolvé true. Documentá tiempo esperado O(n),
 * peor caso dependiente de colisiones y espacio auxiliar O(n). Separá solución y pruebas.
 */
package unidad1.ejercicio04;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Detecta duplicados guardando los valores ya observados en un conjunto hash.
 */
public final class DuplicadosHashSet {
    private DuplicadosHashSet() {
    }

    /**
     * Devuelve al encontrar el primer valor que ya fue agregado al conjunto.
     *
     * @param valores vector de enteros
     * @return {@code true} si contiene un duplicado
     * @throws NullPointerException si {@code valores} es null
     * Tiempo esperado O(n), con posible degradación por colisiones; espacio auxiliar O(n).
     */
    public static boolean contieneDuplicados(int[] valores) {
        Objects.requireNonNull(valores, "el vector no puede ser null");
        Set<Integer> vistos = new HashSet<>();
        for (int valor : valores) {
            if (!vistos.add(valor)) {
                return true;
            }
        }
        return false;
    }
}
/*
 * Ajuste del prompt: ninguno; HashSet almacena únicamente valores ya visitados.
 */
