package unidad1.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Objects;

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
 * Pruebas autocontenidas para los diez ejercicios de análisis de algoritmos.
 */
public final class GuiaAnalisisTests {
    private static int verificaciones;

    private GuiaAnalisisTests() {
    }

    /**
     * Ejecuta todas las comprobaciones y falla ante la primera expectativa incorrecta.
     *
     * @param args argumentos ignorados
     * @throws Exception si falla la captura de la traza de búsqueda binaria
     */
    public static void main(String[] args) throws Exception {
        probarMinimo();
        probarBusquedaLineal();
        probarBusquedaBinaria();
        probarDuplicados();
        probarOcurrencias();
        probarComparacion();
        probarInversion();
        probarSumaMatriz();
        probarMaximoMatriz();
        probarBubbleSort();
        System.out.println("OK: " + verificaciones + " verificaciones");
    }

    private static void probarMinimo() {
        igual(OptionalInt.empty(), MinimoVector.encontrar(new int[0]), "mínimo de vector vacío");
        igual(OptionalInt.of(7), MinimoVector.encontrar(new int[] {7}), "mínimo unitario");
        igual(OptionalInt.of(-9), MinimoVector.encontrar(new int[] {4, -9, 0, -2}), "mínimo negativo");
        igual(OptionalInt.of(Integer.MIN_VALUE),
                MinimoVector.encontrar(new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE}),
                "mínimo en límites de int");
        esperar(NullPointerException.class, () -> MinimoVector.encontrar(null), "vector null para mínimo");
    }

    private static void probarBusquedaLineal() {
        BusquedaLineal.Resultado primero = BusquedaLineal.buscar(new int[] {6, 9, 2}, 6);
        igual(OptionalInt.of(0), primero.indice(), "búsqueda lineal al inicio");
        igual(1, primero.posicionesInspeccionadas(), "inspecciones de objetivo inicial");

        BusquedaLineal.Resultado ultimo = BusquedaLineal.buscar(new int[] {6, 9, 2}, 2);
        igual(OptionalInt.of(2), ultimo.indice(), "búsqueda lineal al final");
        igual(3, ultimo.posicionesInspeccionadas(), "inspecciones de objetivo final");

        BusquedaLineal.Resultado ausente = BusquedaLineal.buscar(new int[] {6, 9, 2}, 5);
        igual(OptionalInt.empty(), ausente.indice(), "búsqueda lineal ausente");
        igual(3, ausente.posicionesInspeccionadas(), "inspecciona todo para objetivo ausente");

        BusquedaLineal.Resultado vacio = BusquedaLineal.buscar(new int[0], 5);
        igual(OptionalInt.empty(), vacio.indice(), "búsqueda lineal de vector vacío");
        igual(0, vacio.posicionesInspeccionadas(), "cero inspecciones en vector vacío");

        BusquedaLineal.Resultado repetido = BusquedaLineal.buscar(new int[] {4, 7, 4}, 4);
        igual(OptionalInt.of(0), repetido.indice(), "búsqueda lineal toma primera coincidencia");
        igual(1, repetido.posicionesInspeccionadas(), "búsqueda se detiene en primera coincidencia");
        esperar(NullPointerException.class, () -> BusquedaLineal.buscar(null, 1), "vector null en búsqueda");
    }

    private static void probarBusquedaBinaria() throws Exception {
        igual(1, buscarBinario(new int[] {2, 5, 8, 11, 14}, 5).indice(), "binaria primer índice");
        igual(0, buscarBinario(new int[] {2, 5, 8, 11, 14}, 2).indice(), "binaria inicio");
        igual(4, buscarBinario(new int[] {2, 5, 8, 11, 14}, 14).indice(), "binaria final");
        igual(2, buscarBinario(new int[] {2, 5, 8, 11, 14}, 8).indice(), "binaria punto medio");
        igual(-1, buscarBinario(new int[] {2, 5, 8, 11, 14}, 1).indice(), "binaria menor ausente");
        igual(-1, buscarBinario(new int[] {2, 5, 8, 11, 14}, 13).indice(), "binaria entre elementos");
        Captura vacia = buscarBinario(new int[0], 1);
        igual(-1, vacia.indice(), "binaria vector vacío");
        comprobar(vacia.traza().contains("no encontrado"), "traza de vector vacío indica ausencia");
        Captura traza = buscarBinario(new int[] {1, 3, 5, 7, 9, 11, 13}, 11);
        comprobar(traza.traza().contains("bajo=0, alto=6, medio=3, valor=7: buscar a la derecha"),
                "traza muestra límites, medio y comparación");
        comprobar(traza.traza().contains("Resultado: índice 5"), "traza informa conclusión encontrada");
        esperar(NullPointerException.class, () -> BusquedaBinaria.buscar(null, 1, System.out),
                "vector null binario");
        esperar(NullPointerException.class, () -> BusquedaBinaria.buscar(new int[] {1}, 1, null),
                "salida null binaria");
    }

    private record Captura(int indice, String traza) {
    }

    private static Captura buscarBinario(int[] valores, int objetivo) throws Exception {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        int indice;
        try (PrintStream salida = new PrintStream(bytes, true, StandardCharsets.UTF_8)) {
            indice = BusquedaBinaria.buscar(valores, objetivo, salida);
        }
        return new Captura(indice, bytes.toString(StandardCharsets.UTF_8).replace("\r\n", "\n"));
    }

    private static void probarDuplicados() {
        comprobarAmbosDuplicados(new int[0], false, "vector vacío");
        comprobarAmbosDuplicados(new int[] {8}, false, "vector unitario");
        comprobarAmbosDuplicados(new int[] {1, 2, 3, 4}, false, "todos distintos");
        comprobarAmbosDuplicados(new int[] {1, 2, 2, 3}, true, "duplicado adyacente");
        comprobarAmbosDuplicados(new int[] {1, 2, 3, 1}, true, "duplicado no adyacente");
        comprobarAmbosDuplicados(new int[] {5, 5}, true, "dos valores iguales");
    }

    private static void comprobarAmbosDuplicados(int[] valores, boolean esperado, String descripcion) {
        igual(esperado, DuplicadosCiclosAnidados.contieneDuplicados(valores),
                descripcion + " con ciclos anidados");
        igual(esperado, DuplicadosHashSet.contieneDuplicados(valores),
                descripcion + " con HashSet");
    }

    private static void probarOcurrencias() {
        igual(0, ContarOcurrencias.contar(new int[0], 4), "conteo vacío");
        igual(0, ContarOcurrencias.contar(new int[] {1, 2, 3}, 4), "conteo ausente");
        igual(3, ContarOcurrencias.contar(new int[] {4, 1, 4, 4, 9}, 4), "conteo repetido");
        igual(4, ContarOcurrencias.contar(new int[] {-2, -2, -2, -2}, -2), "todos coinciden");
        esperar(NullPointerException.class, () -> ContarOcurrencias.contar(null, 4), "vector null en conteo");
    }

    private static void probarComparacion() {
        comprobar(CompararVectores.sonIguales(new int[0], new int[0]), "vectores vacíos iguales");
        comprobar(CompararVectores.sonIguales(new int[] {1, 2, 3}, new int[] {1, 2, 3}),
                "vectores iguales");
        comprobar(!CompararVectores.sonIguales(new int[] {1}, new int[] {1, 0}),
                "longitudes distintas");
        comprobar(!CompararVectores.sonIguales(new int[] {1, 2, 3}, new int[] {9, 2, 3}),
                "diferencia en primera posición");
        comprobar(!CompararVectores.sonIguales(new int[] {1, 2, 3}, new int[] {1, 2, 9}),
                "diferencia en última posición");
        comprobar(!CompararVectores.sonIguales(new int[] {1, 2}, new int[] {1, 2, 0}),
                "longitud distinta con prefijo igual");
        esperar(NullPointerException.class, () -> CompararVectores.sonIguales(null, new int[0]),
                "primer vector null");
        esperar(NullPointerException.class, () -> CompararVectores.sonIguales(new int[0], null),
                "segundo vector null");
    }

    private static void probarInversion() {
        comprobarArreglos(new int[0], InvertirConAuxiliar.invertir(new int[0]), "auxiliar vacío");
        comprobarArreglos(new int[] {7}, InvertirConAuxiliar.invertir(new int[] {7}), "auxiliar unitario");
        comprobarArreglos(new int[] {4, 3, 2, 1},
                InvertirConAuxiliar.invertir(new int[] {1, 2, 3, 4}), "auxiliar longitud par");
        comprobarArreglos(new int[] {5, 3, 1},
                InvertirConAuxiliar.invertir(new int[] {1, 3, 5}), "auxiliar longitud impar");

        int[] original = {1, 2, 3};
        int[] copia = InvertirConAuxiliar.invertir(original);
        comprobarArreglos(new int[] {1, 2, 3}, original, "auxiliar conserva entrada");
        comprobar(original != copia, "auxiliar devuelve una referencia distinta");

        comprobarInversionInPlace(new int[0], new int[0], "in-place vacío");
        comprobarInversionInPlace(new int[] {8}, new int[] {8}, "in-place unitario");
        comprobarInversionInPlace(new int[] {1, 2, 3, 4}, new int[] {4, 3, 2, 1},
                "in-place longitud par");
        comprobarInversionInPlace(new int[] {1, 2, 3, 4, 5}, new int[] {5, 4, 3, 2, 1},
                "in-place longitud impar");
        esperar(NullPointerException.class, () -> InvertirConAuxiliar.invertir(null), "auxiliar null");
        esperar(NullPointerException.class, () -> InvertirInPlace.invertir(null), "in-place null");
    }

    private static void comprobarInversionInPlace(int[] entrada, int[] esperado, String descripcion) {
        InvertirInPlace.invertir(entrada);
        comprobarArreglos(esperado, entrada, descripcion);
    }

    private static void probarSumaMatriz() {
        igual(new SumarMatriz.Resultado(0, 0), SumarMatriz.sumar(new int[0][]), "matriz sin filas");
        igual(new SumarMatriz.Resultado(0, 0),
                SumarMatriz.sumar(new int[][] {{}, {}}), "matriz de filas vacías");
        igual(new SumarMatriz.Resultado(7, 1),
                SumarMatriz.sumar(new int[][] {{7}}), "matriz unitaria");
        igual(new SumarMatriz.Resultado(9, 6),
                SumarMatriz.sumar(new int[][] {{1, 2, 3}, {-4, 5, 2}}), "matriz rectangular");
        igual(new SumarMatriz.Resultado(9, 5),
                SumarMatriz.sumar(new int[][] {{1, 2}, {-3}, {4, 5}}), "matriz irregular");
        esperar(NullPointerException.class, () -> SumarMatriz.sumar(null), "matriz null al sumar");
        esperar(NullPointerException.class, () -> SumarMatriz.sumar(new int[][] {{1}, null}),
                "fila null al sumar");
    }

    private static void probarMaximoMatriz() {
        igual(OptionalInt.empty(), MaximoMatriz.encontrar(new int[0][]), "máximo sin filas");
        igual(OptionalInt.empty(), MaximoMatriz.encontrar(new int[][] {{}, {}}), "máximo en filas vacías");
        igual(OptionalInt.of(-5), MaximoMatriz.encontrar(new int[][] {{-5}}), "máximo unitario negativo");
        igual(OptionalInt.of(9), MaximoMatriz.encontrar(new int[][] {{9, 2}, {3, 4}}),
                "máximo al inicio");
        igual(OptionalInt.of(12), MaximoMatriz.encontrar(new int[][] {{-7, 2}, {3, 12}}),
                "máximo al final");
        igual(OptionalInt.of(Integer.MIN_VALUE),
                MaximoMatriz.encontrar(new int[][] {{Integer.MIN_VALUE}}), "máximo mínimo int");
        esperar(NullPointerException.class, () -> MaximoMatriz.encontrar(null), "matriz null al buscar máximo");
        esperar(NullPointerException.class, () -> MaximoMatriz.encontrar(new int[][] {null}),
                "fila null al buscar máximo");
    }

    private static void probarBubbleSort() {
        int[] vacio = new int[0];
        igual(new BubbleSort.Metricas(0, 0), BubbleSort.ordenar(vacio), "Bubble Sort vacío");
        comprobarArreglos(new int[0], vacio, "Bubble Sort vacío conserva vector");

        int[] unitario = {7};
        igual(new BubbleSort.Metricas(0, 0), BubbleSort.ordenar(unitario), "Bubble Sort unitario");
        comprobarArreglos(new int[] {7}, unitario, "Bubble Sort unitario ordenado");

        int[] ordenado = {1, 2, 3};
        igual(new BubbleSort.Metricas(3, 0), BubbleSort.ordenar(ordenado), "Bubble Sort ordenado");
        comprobarArreglos(new int[] {1, 2, 3}, ordenado, "Bubble Sort entrada ordenada");

        int[] inverso = {3, 2, 1};
        igual(new BubbleSort.Metricas(3, 3), BubbleSort.ordenar(inverso), "Bubble Sort inverso");
        comprobarArreglos(new int[] {1, 2, 3}, inverso, "Bubble Sort entrada inversa");

        int[] repetidos = {2, 1, 2, 1};
        igual(new BubbleSort.Metricas(6, 3), BubbleSort.ordenar(repetidos), "Bubble Sort repetidos");
        comprobarArreglos(new int[] {1, 1, 2, 2}, repetidos, "Bubble Sort ordena repetidos");
        esperar(NullPointerException.class, () -> BubbleSort.ordenar(null), "Bubble Sort null");
    }

    private static void comprobarArreglos(int[] esperado, int[] actual, String descripcion) {
        verificaciones++;
        if (!Arrays.equals(esperado, actual)) {
            throw new AssertionError(descripcion + ": esperado " + Arrays.toString(esperado)
                    + ", obtenido " + Arrays.toString(actual));
        }
    }

    private static void comprobar(boolean condicion, String descripcion) {
        verificaciones++;
        if (!condicion) {
            throw new AssertionError(descripcion);
        }
    }

    private static void igual(Object esperado, Object actual, String descripcion) {
        comprobar(Objects.equals(esperado, actual),
                descripcion + ": esperado <" + esperado + ">, obtenido <" + actual + ">");
    }

    private static void esperar(Class<? extends Throwable> tipo, Runnable operacion, String descripcion) {
        verificaciones++;
        try {
            operacion.run();
        } catch (RuntimeException error) {
            if (tipo.isInstance(error)) {
                return;
            }
            throw new AssertionError(descripcion + ": excepción inesperada " + error, error);
        }
        throw new AssertionError(descripcion + ": no se lanzó " + tipo.getSimpleName());
    }
}
