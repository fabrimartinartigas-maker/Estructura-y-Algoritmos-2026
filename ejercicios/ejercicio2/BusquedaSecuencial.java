import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio 2: búsqueda de un elemento en un vector desordenado.
 *
 * <p>Estrategia elegida: búsqueda secuencial (lineal). Es el algoritmo
 * adecuado para datos desordenados porque la búsqueda binaria exige un
 * arreglo previamente ordenado (ordenarlo cuesta O(n log n)) y, sobre un
 * arreglo sin orden, la cota inferior es Ω(n): en el peor caso debe
 * examinarse cada elemento para poder afirmar que el valor no existe.</p>
 */
public class BusquedaSecuencial {

    /**
     * Resultado de una búsqueda: qué se encontró y cuánto costó encontrarlo.
     */
    public static class ResultadoBusqueda {
        boolean encontrado;
        int indice;                // -1 si no existe
        int posicionesRecorridas;  // elementos efectivamente examinados
    }

    /**
     * Busca {@code objetivo} en {@code vector} mediante búsqueda secuencial,
     * devolviendo el índice de su primera ocurrencia y la cantidad de
     * posiciones recorridas hasta resolver la búsqueda.
     *
     * <p>Complejidad:
     * <ul>
     *   <li>Mejor caso: Ω(1) — el elemento está en la primera posición.</li>
     *   <li>Peor caso: O(n) — está en la última posición o no existe.</li>
     *   <li>Caso promedio: O(n) — suponiendo distribución uniforme del
     *       elemento, una búsqueda exitosa examina (n+1)/2 posiciones en
     *       promedio; una búsqueda fallida siempre examina las n posiciones.</li>
     * </ul></p>
     *
     * @param vector   arreglo de enteros a recorrer; puede estar vacío, pero no ser null
     * @param objetivo valor a localizar
     * @return resultado con índice de la primera ocurrencia (-1 si no existe)
     *         y elementos efectivamente examinados
     * @throws IllegalArgumentException si {@code vector} es null
     */
    public static ResultadoBusqueda buscar(int[] vector, int objetivo) {
        if (vector == null) {
            throw new IllegalArgumentException("El vector no puede ser null.");
        }
        ResultadoBusqueda resultado = new ResultadoBusqueda();
        resultado.encontrado = false;
        resultado.indice = -1;
        resultado.posicionesRecorridas = 0;
        for (int i = 0; i < vector.length; i++) {
            resultado.posicionesRecorridas++;
            if (vector[i] == objetivo) {
                resultado.encontrado = true;
                resultado.indice = i;
                break;
            }
        }
        return resultado;
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
     * Demo interactiva: solicita el vector y el elemento por teclado y muestra
     * el resultado junto con las posiciones recorridas.
     */
    private static void demoInteractiva() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Cantidad de elementos (n >= 0): ");
            int n = scanner.nextInt();
            while (n < 0) {
                System.out.print("n no puede ser negativa. Ingrese nuevamente: ");
                n = scanner.nextInt();
            }
            int[] vector = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.printf("Elemento [%d]: ", i);
                vector[i] = scanner.nextInt();
            }
            System.out.print("Elemento a buscar: ");
            int objetivo = scanner.nextInt();

            ResultadoBusqueda r = buscar(vector, objetivo);
            if (r.encontrado) {
                System.out.printf("%nEncontrado en el índice %d.%n", r.indice);
            } else {
                System.out.printf("%nNo se encontró el elemento en el vector.%n");
            }
            System.out.println("Posiciones recorridas: " + r.posicionesRecorridas);
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
        ResultadoBusqueda r;

        total++;
        r = buscar(new int[]{10, 20, 30, 40}, 10);
        pasados += reportar("elemento al inicio (contador 1)",
                r.encontrado && r.indice == 0 && r.posicionesRecorridas == 1);

        total++;
        r = buscar(new int[]{10, 20, 30, 40}, 40);
        pasados += reportar("elemento al final (contador 4)",
                r.encontrado && r.indice == 3 && r.posicionesRecorridas == 4);

        total++;
        r = buscar(new int[]{10, 20, 30, 40}, 99);
        pasados += reportar("elemento inexistente (contador 4)",
                !r.encontrado && r.indice == -1 && r.posicionesRecorridas == 4);

        total++;
        r = buscar(new int[]{5, 7, 7, 9}, 7);
        pasados += reportar("duplicados: primera ocurrencia (índice 1, contador 2)",
                r.encontrado && r.indice == 1 && r.posicionesRecorridas == 2);

        total++;
        r = buscar(new int[]{}, 3);
        pasados += reportar("arreglo vacío (contador 0)",
                !r.encontrado && r.indice == -1 && r.posicionesRecorridas == 0);

        total++;
        boolean excepcionCorrecta = false;
        try {
            buscar(null, 1);
        } catch (IllegalArgumentException e) {
            excepcionCorrecta = true;
        }
        pasados += reportar("vector null lanza IllegalArgumentException", excepcionCorrecta);

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
