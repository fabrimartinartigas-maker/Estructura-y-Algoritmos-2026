import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio 3: factorial de un número (recursivo).
 *
 * <p>Complejidad:
 * <ul>
 *   <li>Tiempo: O(n) — se realizan {@code n} llamadas recursivas.</li>
 *   <li>Espacio: O(n) — la pila de recursión acumula un marco por llamada.</li>
 * </ul></p>
 */
public class FactorialRecursivo {

    /**
     * Mayor factorial que puede representarse en un {@code long}
     * sin desbordamiento: 20! = 2432902008176640000.
     */
    public static final int MAX_N = 20;

    /**
     * Calcula el factorial de {@code n} de forma recursiva.
     *
     * <p>Caso base: {@code factorial(0) = 1}. Caso recursivo:
     * {@code factorial(n) = n * factorial(n - 1)}.</p>
     *
     * @param n entero no negativo a calcular
     * @return n!
     * @throws IllegalArgumentException si {@code n} es negativo
     * @throws ArithmeticException     si {@code n} supera {@link #MAX_N} y el
     *                                 resultado se desborda en {@code long}
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos: " + n);
        }
        if (n > MAX_N) {
            throw new ArithmeticException("Desbordamiento: " + n + "! no cabe en un long (máximo 20!).");
        }
        // Caso base: 0! = 1
        if (n == 0) {
            return 1;
        }
        // Caso recursivo: n! = n * (n - 1)!
        return n * factorial(n - 1);
    }

    /**
     * Punto de entrada. Con el argumento "pruebas" ejecuta la autoverificación;
     * sin argumentos, inicia la demo interactiva.
     *
     * @param args "pruebas" para el modo de verificación automática (opcional)
     */
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("pruebas")) {
            ejecutarPruebas();
            return;
        }
        demoInteractiva();
    }

    /**
     * Demo interactiva: solicita {@code n} por teclado, valida la entrada
     * y muestra {@code n!}, advirtiendo si el resultado se desbordaría.
     */
    private static void demoInteractiva() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese un número entero no negativo (0 a 20): ");
            int n = scanner.nextInt();
            while (n < 0) {
                System.out.print("El número no puede ser negativo. Ingrese nuevamente: ");
                n = scanner.nextInt();
            }
            try {
                long resultado = factorial(n);
                System.out.printf("%d! = %d%n", n, resultado);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida: se esperaba un número entero.");
        } finally {
            scanner.close();
        }
    }

    /**
     * Autoverificación sin frameworks: ejecuta casos predefinidos e imprime
     * PASÓ/FALLÓ por caso junto con un resumen final.
     */
    private static void ejecutarPruebas() {
        int total = 0;
        int pasados = 0;

        total++;
        pasados += reportar("factorial(0) == 1 (caso base)",
                factorial(0) == 1L);

        total++;
        pasados += reportar("factorial(1) == 1",
                factorial(1) == 1L);

        total++;
        pasados += reportar("factorial(5) == 120",
                factorial(5) == 120L);

        total++;
        pasados += reportar("factorial(12) == 479001600 (máximo que cabe en int)",
                factorial(12) == 479001600L);

        total++;
        pasados += reportar("factorial(20) == 2432902008176640000 (máximo que cabe en long)",
                factorial(20) == 2432902008176640000L);

        total++;
        boolean excepcionNegativo = false;
        try {
            factorial(-1);
        } catch (IllegalArgumentException e) {
            excepcionNegativo = true;
        }
        pasados += reportar("factorial(-1) lanza IllegalArgumentException", excepcionNegativo);

        total++;
        boolean excepcionDesborde = false;
        try {
            factorial(21);
        } catch (ArithmeticException e) {
            excepcionDesborde = true;
        }
        pasados += reportar("factorial(21) lanza ArithmeticException (desbordamiento de long)", excepcionDesborde);

        System.out.println("Resumen: " + pasados + "/" + total + " casos pasaron.");
        if (pasados != total) {
            System.exit(1);
        }
    }

    /**
     * Imprime el resultado de un caso de prueba y devuelve 1 si pasó, 0 si falló.
     */
    private static int reportar(String descripcion, boolean condicion) {
        System.out.println((condicion ? "PASÓ   " : "FALLÓ  ") + descripcion);
        return condicion ? 1 : 0;
    }
}