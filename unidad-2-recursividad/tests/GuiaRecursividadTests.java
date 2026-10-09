/*
 * Prompt inicial utilizado para esta suite:
 * Creá pruebas y ejemplos Java sin dependencias que validen los diez ejercicios de la Unidad 2
 * conforme a sus prompts y a ESPECIFICACION.md. Mantené estas verificaciones separadas de reso.
 */
package unidad2.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import unidad2.ejercicio01.Factorial;
import unidad2.ejercicio02.SumaHastaN;
import unidad2.ejercicio03.MultiplicacionPorSumas;
import unidad2.ejercicio04.PotenciaRecursiva;
import unidad2.ejercicio05.ConteoRegresivo;
import unidad2.ejercicio06.ContarDigitos;
import unidad2.ejercicio07.SumarDigitos;
import unidad2.ejercicio08.InvertirPalabra;
import unidad2.ejercicio09.Palindromo;
import unidad2.ejercicio10.BuscarEnArreglo;

/**
 * Ejemplos y pruebas sin dependencias externas para los diez ejercicios de recursividad.
 */
public final class GuiaRecursividadTests {
    private static int verificaciones;

    private GuiaRecursividadTests() {
    }

    public static void main(String[] args) throws Exception {
        probarFactorial();
        probarSumaHastaN();
        probarMultiplicacion();
        probarPotencia();
        probarConteoRegresivo();
        probarContarDigitos();
        probarSumarDigitos();
        probarInvertirPalabra();
        probarPalindromo();
        probarBusqueda();
        System.out.println("OK: " + verificaciones + " verificaciones");
    }

    private static void probarFactorial() {
        igual(1, Factorial.factorial(0), "0!");
        igual(1, Factorial.factorial(1), "1!");
        igual(120, Factorial.factorial(5), "5!");
        igual(479001600, Factorial.factorial(12), "12!");
        excepcion(IllegalArgumentException.class, () -> Factorial.factorial(-1), "factorial negativo");
        excepcion(ArithmeticException.class, () -> Factorial.factorial(13), "desbordamiento de factorial");
    }

    private static void probarSumaHastaN() {
        igual(0, SumaHastaN.sumarHastaUno(0), "suma hasta 0");
        igual(1, SumaHastaN.sumarHastaUno(1), "suma hasta 1");
        igual(15, SumaHastaN.sumarHastaUno(5), "suma hasta 5");
        igual(5050, SumaHastaN.sumarHastaUno(100), "suma hasta 100");
        excepcion(IllegalArgumentException.class, () -> SumaHastaN.sumarHastaUno(-1), "suma negativa");
    }

    private static void probarMultiplicacion() {
        igual(0, MultiplicacionPorSumas.multiplicar(0, 8), "cero como primer factor");
        igual(0, MultiplicacionPorSumas.multiplicar(8, 0), "cero como segundo factor");
        igual(7, MultiplicacionPorSumas.multiplicar(1, 7), "factor uno");
        igual(42, MultiplicacionPorSumas.multiplicar(6, 7), "producto general");
        excepcion(IllegalArgumentException.class, () -> MultiplicacionPorSumas.multiplicar(-1, 2),
                "factor negativo");
        excepcion(ArithmeticException.class, () -> MultiplicacionPorSumas.multiplicar(1_000_000_000, 3),
                "desbordamiento de multiplicación");
    }

    private static void probarPotencia() {
        igual(1, PotenciaRecursiva.calcular(5, 0), "exponente cero");
        igual(1, PotenciaRecursiva.calcular(0, 0), "cero elevado a cero según caso base");
        igual(0, PotenciaRecursiva.calcular(0, 4), "base cero");
        igual(1, PotenciaRecursiva.calcular(1, 8), "base uno");
        igual(-8, PotenciaRecursiva.calcular(-2, 3), "base negativa");
        igual(1024, PotenciaRecursiva.calcular(2, 10), "potencia positiva");
        excepcion(IllegalArgumentException.class, () -> PotenciaRecursiva.calcular(2, -1),
                "exponente negativo");
        excepcion(ArithmeticException.class, () -> PotenciaRecursiva.calcular(2, 31),
                "desbordamiento de potencia");
    }

    private static void probarConteoRegresivo() throws Exception {
        igual("0\n", capturarConteo(0), "conteo desde cero");
        igual("3\n2\n1\n0\n", capturarConteo(3), "conteo hasta cero");
        excepcion(IllegalArgumentException.class, () -> ConteoRegresivo.imprimir(-1),
                "conteo negativo");
    }

    private static String capturarConteo(int n) throws Exception {
        PrintStream original = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (PrintStream captura = new PrintStream(bytes, true, StandardCharsets.UTF_8)) {
            System.setOut(captura);
            ConteoRegresivo.imprimir(n);
        } finally {
            System.setOut(original);
        }
        return bytes.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
    }

    private static void probarContarDigitos() {
        igual(1, ContarDigitos.contar(7), "un dígito");
        igual(4, ContarDigitos.contar(2026), "varios dígitos");
        igual(5, ContarDigitos.contar(12000), "dígitos con ceros finales");
        igual(10, ContarDigitos.contar(Integer.MAX_VALUE), "máximo int positivo");
        excepcion(IllegalArgumentException.class, () -> ContarDigitos.contar(0), "cero no positivo");
        excepcion(IllegalArgumentException.class, () -> ContarDigitos.contar(-12), "negativo no positivo");
    }

    private static void probarSumarDigitos() {
        igual(7, SumarDigitos.sumar(7), "suma de un dígito");
        igual(10, SumarDigitos.sumar(1234), "suma de varios dígitos");
        igual(3, SumarDigitos.sumar(1002), "suma con ceros internos");
        igual(3, SumarDigitos.sumar(1200), "suma con ceros finales");
        excepcion(IllegalArgumentException.class, () -> SumarDigitos.sumar(0), "suma de dígitos de cero");
        excepcion(IllegalArgumentException.class, () -> SumarDigitos.sumar(-123), "suma de dígitos negativos");
    }

    private static void probarInvertirPalabra() {
        igual("", InvertirPalabra.invertir(""), "cadena vacía");
        igual("x", InvertirPalabra.invertir("x"), "un carácter");
        igual("radar", InvertirPalabra.invertir("radar"), "palabra palíndroma");
        igual("nóisruceR", InvertirPalabra.invertir("Recursión"), "palabra con tilde");
        igual("!a A", InvertirPalabra.invertir("A a!"), "espacios, mayúscula y signo");
    }

    private static void probarPalindromo() {
        verdadero(Palindromo.esPalindromo(""), "cadena vacía");
        verdadero(Palindromo.esPalindromo("x"), "un carácter");
        verdadero(Palindromo.esPalindromo("radar"), "palíndromo");
        verdadero(Palindromo.esPalindromo("a a"), "espacio considerado literalmente");
        verdadero(Palindromo.esPalindromo("a,a"), "signo considerado literalmente");
        falso(Palindromo.esPalindromo("recursión"), "no palíndromo");
        falso(Palindromo.esPalindromo("Aba"), "comparación sensible a mayúsculas");
        falso(Palindromo.esPalindromo("abca"), "diferencia interior");
    }

    private static void probarBusqueda() {
        igual(-1, BuscarEnArreglo.buscar(new int[0], 4), "arreglo vacío");
        igual(0, BuscarEnArreglo.buscar(new int[] {4, 7, 4}, 4), "objetivo al inicio");
        igual(2, BuscarEnArreglo.buscar(new int[] {4, 7, 9}, 9), "objetivo al final");
        igual(-1, BuscarEnArreglo.buscar(new int[] {4, 7, 9}, 3), "objetivo ausente");
        igual(1, BuscarEnArreglo.buscar(new int[] {2, 5, 5}, 5), "primera coincidencia");
    }

    private static void igual(Object esperado, Object actual, String nombre) {
        verificaciones++;
        if (!esperado.equals(actual)) {
            throw new AssertionError(nombre + ": esperado " + esperado + ", recibido " + actual);
        }
    }

    private static void verdadero(boolean actual, String nombre) {
        igual(true, actual, nombre);
    }

    private static void falso(boolean actual, String nombre) {
        igual(false, actual, nombre);
    }

    private static void excepcion(Class<? extends RuntimeException> tipo, Runnable operacion, String nombre) {
        verificaciones++;
        try {
            operacion.run();
        } catch (RuntimeException error) {
            if (tipo.isInstance(error)) {
                return;
            }
            throw new AssertionError(nombre + ": excepción esperada " + tipo.getSimpleName()
                    + ", recibida " + error.getClass().getSimpleName(), error);
        }
        throw new AssertionError(nombre + ": no se produjo " + tipo.getSimpleName());
    }
}
