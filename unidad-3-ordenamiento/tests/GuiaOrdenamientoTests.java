package unidad3.tests;

import java.util.Arrays;
import java.util.List;

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
 * Ejemplos y pruebas automatizadas de la Unidad 3, sin dependencias externas.
 */
public final class GuiaOrdenamientoTests {
    private static int verificaciones;

    private GuiaOrdenamientoTests() {
    }

    public static void main(String[] args) {
        probarBubbleConTraza();
        probarComparacionBurbujaSeleccion();
        probarInsertionCasiOrdenado();
        probarSelectionNombres();
        probarShellSort();
        probarQuicksortConTraza();
        probarQuicksortPeorCaso();
        probarMergeSort();
        probarComparacionSimple();
        probarRanking();
        probarValoresNegativos();
        System.out.println("OK: " + verificaciones + " verificaciones");
    }

    private static void probarBubbleConTraza() {
        int[] valores = {5, 1, 4, 2};
        List<int[]> pasadas = BubbleSortPasoAPaso.ordenar(valores);
        arreglo(new int[] {1, 2, 4, 5}, valores, "Bubble Sort final");
        igual(3, pasadas.size(), "pasadas Bubble Sort");
        arreglo(new int[] {1, 4, 2, 5}, pasadas.get(0), "Bubble pasada 1");
        arreglo(new int[] {1, 2, 4, 5}, pasadas.get(1), "Bubble pasada 2");
        arreglo(new int[] {1, 2, 4, 5}, pasadas.get(2), "Bubble pasada 3");
        igual(2, BubbleSortPasoAPaso.ordenar(new int[] {1, 2, 3}).size(),
                "Bubble ordenado completa pasadas");
        int[] inverso = {4, 3, 2, 1};
        BubbleSortPasoAPaso.ordenar(inverso);
        arreglo(new int[] {1, 2, 3, 4}, inverso, "Bubble inverso");
        int[] repetidos = {2, 1, 2, 1};
        BubbleSortPasoAPaso.ordenar(repetidos);
        arreglo(new int[] {1, 1, 2, 2}, repetidos, "Bubble repetidos");
        igual(0, BubbleSortPasoAPaso.ordenar(new int[0]).size(), "Bubble vacío");
        igual(0, BubbleSortPasoAPaso.ordenar(new int[] {9}).size(), "Bubble unitario");
    }

    private static void probarComparacionBurbujaSeleccion() {
        int[] burbuja = {3, 1, 2};
        CompararBurbujaSeleccion.Metricas metricasBurbuja =
                CompararBurbujaSeleccion.bubbleSort(burbuja);
        arreglo(new int[] {1, 2, 3}, burbuja, "Burbuja ordena");
        igual(new CompararBurbujaSeleccion.Metricas(3, 2), metricasBurbuja,
                "métricas burbuja");

        int[] seleccion = {3, 1, 2};
        CompararBurbujaSeleccion.Metricas metricasSeleccion =
                CompararBurbujaSeleccion.selectionSort(seleccion);
        arreglo(new int[] {1, 2, 3}, seleccion, "Selección ordena");
        igual(new CompararBurbujaSeleccion.Metricas(3, 2), metricasSeleccion,
                "métricas selección");

        int[] ordenado = {1, 2, 3};
        igual(new CompararBurbujaSeleccion.Metricas(3, 0),
                CompararBurbujaSeleccion.bubbleSort(ordenado), "burbuja ordenado");
        igual(new CompararBurbujaSeleccion.Metricas(3, 0),
                CompararBurbujaSeleccion.selectionSort(new int[] {1, 2, 3}),
                "selección ordenado");
        arreglo(new int[] {1, 1, 2}, ordenarAmbosConRepetidos()[0], "burbuja repetidos");
        arreglo(new int[] {1, 1, 2}, ordenarAmbosConRepetidos()[1], "selección repetidos");
        int[] conNegativos = {0, -2, 1};
        CompararBurbujaSeleccion.bubbleSort(conNegativos);
        arreglo(new int[] {-2, 0, 1}, conNegativos, "comparación burbuja negativos");
        conNegativos = new int[] {0, -2, 1};
        CompararBurbujaSeleccion.selectionSort(conNegativos);
        arreglo(new int[] {-2, 0, 1}, conNegativos, "comparación selección negativos");
    }

    private static int[][] ordenarAmbosConRepetidos() {
        int[] primero = {2, 1, 1};
        int[] segundo = primero.clone();
        CompararBurbujaSeleccion.bubbleSort(primero);
        CompararBurbujaSeleccion.selectionSort(segundo);
        return new int[][] {primero, segundo};
    }

    private static void probarInsertionCasiOrdenado() {
        int[] ejemplo = {1, 2, 3, 5, 4, 6, 7};
        igual(1, InsertionSortCasiOrdenado.ordenar(ejemplo).desplazamientos(),
                "desplazamientos casi ordenado");
        arreglo(new int[] {1, 2, 3, 4, 5, 6, 7}, ejemplo, "Insertion ejemplo");

        int[] inverso = {4, 3, 2, 1};
        igual(6, InsertionSortCasiOrdenado.ordenar(inverso).desplazamientos(),
                "desplazamientos inverso");
        arreglo(new int[] {1, 2, 3, 4}, inverso, "Insertion inverso");
        igual(0, InsertionSortCasiOrdenado.ordenar(new int[] {1, 2, 3}).desplazamientos(),
                "Insertion ordenado");
        igual(0, InsertionSortCasiOrdenado.ordenar(new int[0]).desplazamientos(),
                "Insertion vacío");
        igual(0, InsertionSortCasiOrdenado.ordenar(new int[] {4}).desplazamientos(),
                "Insertion unitario");
    }

    private static void probarSelectionNombres() {
        String[] nombres = {"Lucia", "Ana", "Pedro", "Juan"};
        SelectionSortNombres.ordenar(nombres);
        arreglo(new String[] {"Ana", "Juan", "Lucia", "Pedro"}, nombres, "nombres ejemplo");

        String[] capitalizacion = {"ana", "Lucia", "Ana", "Ána"};
        SelectionSortNombres.ordenar(capitalizacion);
        arreglo(new String[] {"Ana", "Lucia", "ana", "Ána"}, capitalizacion,
                "orden String.compareTo");
        SelectionSortNombres.ordenar(new String[0]);
        String[] unitario = {"Una"};
        SelectionSortNombres.ordenar(unitario);
        arreglo(new String[] {"Una"}, unitario, "nombre unitario");
        excepcionNula(() -> SelectionSortNombres.ordenar(new String[] {null}),
                "nombre nulo");
    }

    private static void probarShellSort() {
        int[] valores = {8, 7, 6, 5, 4, 3, 2, 1};
        List<ShellSortConGaps.Etapa> etapas = ShellSortConGaps.ordenar(valores);
        arreglo(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, valores, "Shell final");
        igual(3, etapas.size(), "cantidad de gaps");
        igual(4, etapas.get(0).gap(), "gap inicial");
        igual(2, etapas.get(1).gap(), "gap intermedio");
        igual(1, etapas.get(2).gap(), "gap final");
        arreglo(new int[] {4, 3, 2, 1, 8, 7, 6, 5}, etapas.get(0).estado(),
                "Shell estado gap 4");
        arreglo(new int[] {2, 1, 4, 3, 6, 5, 8, 7}, etapas.get(1).estado(),
                "Shell estado gap 2");
        arreglo(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, etapas.get(2).estado(),
                "Shell estado gap 1");
        igual(0, ShellSortConGaps.ordenar(new int[0]).size(), "Shell vacío");
        igual(0, ShellSortConGaps.ordenar(new int[] {7}).size(), "Shell unitario");
        igual(1, ShellSortConGaps.ordenar(new int[] {2, 1}).size(), "Shell tamaño dos");
        int[] repetidos = {3, 1, 3, 2, 1};
        ShellSortConGaps.ordenar(repetidos);
        arreglo(new int[] {1, 1, 2, 3, 3}, repetidos, "Shell repetidos tamaño impar");
        int[] noPotenciaDeDos = {5, 1, 4, 2, 3};
        var etapasNoPotencia = ShellSortConGaps.ordenar(noPotenciaDeDos);
        arreglo(new int[] {1, 2, 3, 4, 5}, noPotenciaDeDos, "Shell tamaño no potencia de dos");
        arreglo(new int[] {2, 1}, etapasNoPotencia.stream().mapToInt(
                ShellSortConGaps.Etapa::gap).toArray(), "Shell gaps tamaño cinco");
    }

    private static void probarQuicksortConTraza() {
        int[] valores = {4, 2, 7, 1, 3, 6, 5};
        List<QuicksortPrimerPivote.Particion> traza = QuicksortPrimerPivote.ordenar(valores);
        arreglo(new int[] {1, 2, 3, 4, 5, 6, 7}, valores, "Quicksort traza final");
        igual(4, traza.get(0).pivote(), "primer pivote");
        arreglo(new int[] {2, 1, 3}, traza.get(0).izquierdo(), "subarreglo izquierdo inicial");
        arreglo(new int[] {7, 6, 5}, traza.get(0).derecho(), "subarreglo derecho inicial");
        igual(0, QuicksortPrimerPivote.ordenar(new int[0]).size(), "Quicksort vacío");
        igual(0, QuicksortPrimerPivote.ordenar(new int[] {1}).size(), "Quicksort unitario");
        int[] inverso = {5, 4, 3, 2, 1};
        QuicksortPrimerPivote.ordenar(inverso);
        arreglo(new int[] {1, 2, 3, 4, 5}, inverso, "Quicksort inverso");
        int[] repetidos = {3, 3, 2, 3, 1, 1};
        QuicksortPrimerPivote.ordenar(repetidos);
        arreglo(new int[] {1, 1, 2, 3, 3, 3}, repetidos, "Quicksort repetidos");
    }

    private static void probarQuicksortPeorCaso() {
        int[] ordenado = {1, 2, 3, 4, 5, 6, 7};
        igual(12, QuicksortPeorCaso.ordenar(ordenado).llamadasRecursivas(),
                "llamadas Quicksort n=7");
        arreglo(new int[] {1, 2, 3, 4, 5, 6, 7}, ordenado, "Quicksort peor caso ordenado");
        igual(0, QuicksortPeorCaso.ordenar(new int[0]).llamadasRecursivas(),
                "llamadas Quicksort vacío");
        igual(0, QuicksortPeorCaso.ordenar(new int[] {1}).llamadasRecursivas(),
                "llamadas Quicksort unitario");
        igual(2, QuicksortPeorCaso.ordenar(new int[] {1, 2}).llamadasRecursivas(),
                "llamadas Quicksort n=2");
    }

    private static void probarMergeSort() {
        int[] valores = {5, 2, 4, 1, 3};
        List<String> eventos = MergeSortPasoAPaso.ordenar(valores);
        arreglo(new int[] {1, 2, 3, 4, 5}, valores, "MergeSort impar");
        verdadero(eventos.stream().anyMatch(e -> e.startsWith("División ")),
                "MergeSort registra división");
        verdadero(eventos.stream().anyMatch(e -> e.startsWith("Corte ")),
                "MergeSort registra corte");
        verdadero(eventos.stream().anyMatch(e -> e.startsWith("Fusión ")),
                "MergeSort registra fusión");
        List<String> vacio = MergeSortPasoAPaso.ordenar(new int[0]);
        igual(1, vacio.size(), "MergeSort vacío registra corte");
        igual("Corte []", vacio.get(0), "MergeSort corte vacío");
        igual(1, MergeSortPasoAPaso.ordenar(new int[] {9}).size(), "MergeSort unitario corte");
        int[] repetidos = {2, 1, 2, 1};
        MergeSortPasoAPaso.ordenar(repetidos);
        arreglo(new int[] {1, 1, 2, 2}, repetidos, "MergeSort pares y repetidos");
        int[] yaOrdenado = {-2, 0, 3};
        MergeSortPasoAPaso.ordenar(yaOrdenado);
        arreglo(new int[] {-2, 0, 3}, yaOrdenado, "MergeSort ya ordenado");
    }

    private static void probarComparacionSimple() {
        int[] entrada = {3, 1, 2};
        int[] burbuja = entrada.clone();
        int[] seleccion = entrada.clone();
        int[] insercion = entrada.clone();
        igual(new CompararOrdenamientosSimples.Metricas(3, 2),
                CompararOrdenamientosSimples.bubbleSort(burbuja), "comparación burbuja");
        igual(new CompararOrdenamientosSimples.Metricas(3, 2),
                CompararOrdenamientosSimples.selectionSort(seleccion), "comparación selección");
        igual(new CompararOrdenamientosSimples.Metricas(3, 2),
                CompararOrdenamientosSimples.insertionSort(insercion), "comparación inserción");
        arreglo(new int[] {1, 2, 3}, burbuja, "comparación salida burbuja");
        arreglo(new int[] {1, 2, 3}, seleccion, "comparación salida selección");
        arreglo(new int[] {1, 2, 3}, insercion, "comparación salida inserción");

        igual(new CompararOrdenamientosSimples.Metricas(2, 0),
                CompararOrdenamientosSimples.insertionSort(new int[] {1, 2, 3}),
                "inserción ordenado");
        igual(new CompararOrdenamientosSimples.Metricas(3, 3),
                CompararOrdenamientosSimples.insertionSort(new int[] {3, 2, 1}),
                "inserción inverso");
        for (int[] caso : new int[][] {new int[0], {5}, {2, 1, 1}}) {
            int[] a = caso.clone();
            int[] b = caso.clone();
            int[] c = caso.clone();
            CompararOrdenamientosSimples.bubbleSort(a);
            CompararOrdenamientosSimples.selectionSort(b);
            CompararOrdenamientosSimples.insertionSort(c);
            arreglo(a, b, "comparación burbuja/selección límite");
            arreglo(a, c, "comparación burbuja/inserción límite");
        }
    }

    private static void probarRanking() {
        Jugador[] jugadores = {
            new Jugador("Ana", 1200),
            new Jugador("Pedro", 900),
            new Jugador("Lucia", 1500),
            new Jugador("Juan", 1200),
            new Jugador("Marta", 1200)
        };
        RankingPuntajes.ordenar(jugadores);
        arreglo(new Jugador[] {
            new Jugador("Lucia", 1500),
            new Jugador("Ana", 1200),
            new Jugador("Juan", 1200),
            new Jugador("Marta", 1200),
            new Jugador("Pedro", 900)
        }, jugadores, "ranking descendente estable");
        RankingPuntajes.ordenar(new Jugador[0]);
        Jugador[] unitario = {new Jugador("Solo", 7)};
        RankingPuntajes.ordenar(unitario);
        arreglo(new Jugador[] {new Jugador("Solo", 7)}, unitario, "ranking unitario");
        excepcionNula(() -> RankingPuntajes.ordenar(new Jugador[] {null}),
                "jugador nulo");
    }

    private static void probarValoresNegativos() {
        int[] bubble = {-3, 2, -1};
        BubbleSortPasoAPaso.ordenar(bubble);
        arreglo(new int[] {-3, -1, 2}, bubble, "Bubble negativos");

        int[] selection = {-3, 2, -1};
        CompararBurbujaSeleccion.selectionSort(selection);
        arreglo(new int[] {-3, -1, 2}, selection, "Selection negativos");

        int[] insertion = {-3, 2, -1};
        InsertionSortCasiOrdenado.ordenar(insertion);
        arreglo(new int[] {-3, -1, 2}, insertion, "Insertion negativos");

        int[] shell = {-3, 2, -1};
        ShellSortConGaps.ordenar(shell);
        arreglo(new int[] {-3, -1, 2}, shell, "Shell negativos");

        int[] quick = {-3, 2, -1};
        QuicksortPrimerPivote.ordenar(quick);
        arreglo(new int[] {-3, -1, 2}, quick, "Quicksort negativos");

        int[] merge = {-3, 2, -1};
        MergeSortPasoAPaso.ordenar(merge);
        arreglo(new int[] {-3, -1, 2}, merge, "MergeSort negativos");

        int[] simples = {-3, 2, -1};
        CompararOrdenamientosSimples.bubbleSort(simples);
        arreglo(new int[] {-3, -1, 2}, simples, "algoritmos simples negativos");

        int[] ranking = {-10, 0, 5};
        RankingPuntajes.Jugador[] jugadores = {
            new Jugador("Negativo", ranking[0]),
            new Jugador("Cero", ranking[1]),
            new Jugador("Positivo", ranking[2])
        };
        RankingPuntajes.ordenar(jugadores);
        arreglo(new Jugador[] {
            new Jugador("Positivo", 5),
            new Jugador("Cero", 0),
            new Jugador("Negativo", -10)
        }, jugadores, "ranking puntajes negativos");
    }

    private static void arreglo(int[] esperado, int[] actual, String nombre) {
        verificaciones++;
        if (!Arrays.equals(esperado, actual)) {
            throw new AssertionError(nombre + ": esperado " + Arrays.toString(esperado)
                    + ", recibido " + Arrays.toString(actual));
        }
    }

    private static void arreglo(String[] esperado, String[] actual, String nombre) {
        verificaciones++;
        if (!Arrays.equals(esperado, actual)) {
            throw new AssertionError(nombre + ": esperado " + Arrays.toString(esperado)
                    + ", recibido " + Arrays.toString(actual));
        }
    }

    private static void arreglo(Jugador[] esperado, Jugador[] actual, String nombre) {
        verificaciones++;
        if (!Arrays.equals(esperado, actual)) {
            throw new AssertionError(nombre + ": esperado " + Arrays.toString(esperado)
                    + ", recibido " + Arrays.toString(actual));
        }
    }

    private static void igual(long esperado, long actual, String nombre) {
        verificaciones++;
        if (esperado != actual) {
            throw new AssertionError(nombre + ": esperado " + esperado + ", recibido " + actual);
        }
    }

    private static void igual(Object esperado, Object actual, String nombre) {
        verificaciones++;
        if (!esperado.equals(actual)) {
            throw new AssertionError(nombre + ": esperado " + esperado + ", recibido " + actual);
        }
    }

    private static void verdadero(boolean actual, String nombre) {
        verificaciones++;
        if (!actual) {
            throw new AssertionError(nombre + ": se esperaba true");
        }
    }

    private static void excepcionNula(Runnable operacion, String nombre) {
        verificaciones++;
        try {
            operacion.run();
        } catch (NullPointerException esperada) {
            return;
        }
        throw new AssertionError(nombre + ": se esperaba NullPointerException");
    }
}
