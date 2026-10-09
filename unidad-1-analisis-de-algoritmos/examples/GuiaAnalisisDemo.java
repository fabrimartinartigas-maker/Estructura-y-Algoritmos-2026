package unidad1.examples;

import java.util.Arrays;

import unidad1.ejercicio01.MinimoVector;
import unidad1.ejercicio02.BusquedaLineal;
import unidad1.ejercicio03.BusquedaBinaria;
import unidad1.ejercicio04.DuplicadosCiclosAnidados;
import unidad1.ejercicio04.DuplicadosHashSet;
import unidad1.ejercicio05.ContarOcurrencias;
import unidad1.ejercicio06.CompararVectores;
import unidad1.ejercicio07.InvertirConAuxiliar;
import unidad1.ejercicio07.InvertirInPlace;
import unidad1.ejercicio08.SumarMatriz;
import unidad1.ejercicio09.MaximoMatriz;
import unidad1.ejercicio10.BubbleSort;

/**
 * Demuestra separadamente los algoritmos implementados en los diez ejercicios.
 */
public final class GuiaAnalisisDemo {
    private GuiaAnalisisDemo() {
    }

    /**
     * Ejecuta ejemplos deterministas y muestra resultados y métricas.
     *
     * @param args argumentos ignorados
     */
    public static void main(String[] args) {
        System.out.println("1. Mínimo: " + MinimoVector.encontrar(new int[] {8, -3, 5, 0}));

        BusquedaLineal.Resultado lineal = BusquedaLineal.buscar(new int[] {9, 4, 7, 4}, 7);
        System.out.printf("2. Búsqueda lineal: índice=%s, inspecciones=%d%n",
                lineal.indice(), lineal.posicionesInspeccionadas());

        System.out.println("3. Búsqueda binaria:");
        int indiceBinario = BusquedaBinaria.buscar(new int[] {2, 5, 8, 11, 14, 17}, 11, System.out);
        System.out.println("   Índice devuelto: " + indiceBinario);

        int[] duplicados = {3, 8, 5, 8};
        System.out.printf("4. Duplicados: ciclos=%s, HashSet=%s%n",
                DuplicadosCiclosAnidados.contieneDuplicados(duplicados),
                DuplicadosHashSet.contieneDuplicados(duplicados));

        System.out.println("5. Ocurrencias de 2: "
                + ContarOcurrencias.contar(new int[] {2, 4, 2, 2, 7}, 2));

        System.out.println("6. Vectores iguales: "
                + CompararVectores.sonIguales(new int[] {1, 2, 3}, new int[] {1, 2, 3}));

        int[] original = {1, 2, 3, 4, 5};
        System.out.println("7. Inversión con auxiliar: "
                + Arrays.toString(InvertirConAuxiliar.invertir(original)));
        int[] inPlace = original.clone();
        InvertirInPlace.invertir(inPlace);
        System.out.println("   Inversión in-place: " + Arrays.toString(inPlace));

        SumarMatriz.Resultado suma = SumarMatriz.sumar(new int[][] {{1, 2}, {-3}, {4, 5}});
        System.out.printf("8. Suma matriz: %d, sumas del acumulador=%d%n",
                suma.suma(), suma.operacionesSuma());

        System.out.println("9. Máximo matriz: "
                + MaximoMatriz.encontrar(new int[][] {{-8, -3}, {-2}}));

        int[] porOrdenar = {5, 2, 4, 1, 3};
        BubbleSort.Metricas metricas = BubbleSort.ordenar(porOrdenar);
        System.out.printf("10. Bubble Sort: %s; comparaciones=%d; intercambios=%d%n",
                Arrays.toString(porOrdenar), metricas.comparaciones(), metricas.intercambios());
    }
}
