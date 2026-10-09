package unidad3.examples;

import java.util.Arrays;

import unidad3.ejercicio01.BubbleSortPasoAPaso;
import unidad3.ejercicio02.CompararBurbujaSeleccion;
import unidad3.ejercicio03.InsertionSortCasiOrdenado;
import unidad3.ejercicio04.SelectionSortNombres;
import unidad3.ejercicio05.ShellSortConGaps;
import unidad3.ejercicio06.QuicksortPrimerPivote;
import unidad3.ejercicio07.QuicksortPeorCaso;
import unidad3.ejercicio08.MergeSortPasoAPaso;
import unidad3.ejercicio09.CompararOrdenamientosSimples;
import unidad3.ejercicio10.RankingPuntajes;
import unidad3.ejercicio10.RankingPuntajes.Jugador;

/**
 * Ejemplos de ejecución de los diez algoritmos, separados de sus implementaciones.
 */
public final class GuiaOrdenamientoDemo {
    private GuiaOrdenamientoDemo() {
    }

    public static void main(String[] args) {
        demoBubblePasoAPaso();
        demoBurbujaSeleccion();
        demoInsertion();
        demoNombres();
        demoShellSort();
        demoQuicksort();
        demoQuicksortPeorCaso();
        demoMergeSort();
        demoComparacion();
        demoRanking();
    }

    private static void demoBubblePasoAPaso() {
        System.out.println("\n1. Bubble Sort paso a paso");
        int[] numeros = {5, 1, 4, 2};
        System.out.println("Original: " + Arrays.toString(numeros));
        int pasada = 1;
        for (int[] estado : BubbleSortPasoAPaso.ordenar(numeros)) {
            System.out.println("Pasada " + pasada++ + ": " + Arrays.toString(estado));
        }
    }

    private static void demoBurbujaSeleccion() {
        System.out.println("\n2. Burbuja vs. selección");
        int[] original = {5, 1, 4, 2};
        int[] burbuja = original.clone();
        int[] seleccion = original.clone();
        var metricasBurbuja = CompararBurbujaSeleccion.bubbleSort(burbuja);
        var metricasSeleccion = CompararBurbujaSeleccion.selectionSort(seleccion);
        System.out.println("Burbuja: " + Arrays.toString(burbuja) + " " + metricasBurbuja);
        System.out.println("Selección: " + Arrays.toString(seleccion) + " " + metricasSeleccion);
    }

    private static void demoInsertion() {
        System.out.println("\n3. Insertion Sort casi ordenado");
        int[] numeros = {1, 2, 3, 5, 4, 6, 7};
        var metricas = InsertionSortCasiOrdenado.ordenar(numeros);
        System.out.println("Ordenado: " + Arrays.toString(numeros));
        System.out.println("Desplazamientos: " + metricas.desplazamientos());
    }

    private static void demoNombres() {
        System.out.println("\n4. Selection Sort de nombres");
        String[] nombres = {"Lucia", "Ana", "Pedro", "Juan"};
        System.out.println("Original: " + Arrays.toString(nombres));
        SelectionSortNombres.ordenar(nombres);
        System.out.println("Ordenado: " + Arrays.toString(nombres));
    }

    private static void demoShellSort() {
        System.out.println("\n5. ShellSort y gaps");
        int[] numeros = {8, 7, 6, 5, 4, 3, 2, 1};
        for (var etapa : ShellSortConGaps.ordenar(numeros)) {
            System.out.println("Gap " + etapa.gap() + ": " + Arrays.toString(etapa.estado()));
        }
    }

    private static void demoQuicksort() {
        System.out.println("\n6. Quicksort con primer pivote");
        int[] numeros = {4, 2, 7, 1, 3, 6, 5};
        for (var particion : QuicksortPrimerPivote.ordenar(numeros)) {
            System.out.println("Pivote " + particion.pivote()
                    + " | izquierda " + Arrays.toString(particion.izquierdo())
                    + " | derecha " + Arrays.toString(particion.derecho()));
        }
        System.out.println("Final: " + Arrays.toString(numeros));
    }

    private static void demoQuicksortPeorCaso() {
        System.out.println("\n7. Peor caso de Quicksort");
        int[] numeros = {1, 2, 3, 4, 5, 6, 7};
        var resultado = QuicksortPeorCaso.ordenar(numeros);
        System.out.println("Ordenado: " + Arrays.toString(numeros));
        System.out.println("Llamadas recursivas posteriores a la inicial: "
                + resultado.llamadasRecursivas());
    }

    private static void demoMergeSort() {
        System.out.println("\n8. MergeSort paso a paso");
        int[] numeros = {5, 2, 4, 1, 3};
        for (String evento : MergeSortPasoAPaso.ordenar(numeros)) {
            System.out.println(evento);
        }
        System.out.println("Final: " + Arrays.toString(numeros));
    }

    private static void demoComparacion() {
        System.out.println("\n9. Algoritmos simples");
        int[] original = {3, 1, 2};
        int[] burbuja = original.clone();
        int[] seleccion = original.clone();
        int[] insercion = original.clone();
        var metricasBurbuja = CompararOrdenamientosSimples.bubbleSort(burbuja);
        var metricasSeleccion = CompararOrdenamientosSimples.selectionSort(seleccion);
        var metricasInsercion = CompararOrdenamientosSimples.insertionSort(insercion);
        System.out.println("Burbuja: " + Arrays.toString(burbuja) + " " + metricasBurbuja);
        System.out.println("Selección: " + Arrays.toString(seleccion) + " " + metricasSeleccion);
        System.out.println("Inserción: " + Arrays.toString(insercion) + " " + metricasInsercion);
    }

    private static void demoRanking() {
        System.out.println("\n10. Ranking de puntajes");
        Jugador[] jugadores = {
            new Jugador("Ana", 1200),
            new Jugador("Pedro", 900),
            new Jugador("Lucia", 1500)
        };
        System.out.println("Original: " + Arrays.toString(jugadores));
        RankingPuntajes.ordenar(jugadores);
        System.out.println("Ranking: " + Arrays.toString(jugadores));
    }
}
