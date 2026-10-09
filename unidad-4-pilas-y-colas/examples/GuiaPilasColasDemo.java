package unidad4.examples;

import java.util.Arrays;

import unidad4.ejercicio01.PilaEnteros;
import unidad4.ejercicio02.TorreDePlatos;
import unidad4.ejercicio03.ValidadorParentesis;
import unidad4.ejercicio04.HistorialNavegacion;
import unidad4.ejercicio05.Pila;
import unidad4.ejercicio06.ColaEnteros;
import unidad4.ejercicio07.SistemaTurnos;
import unidad4.ejercicio08.ColaImpresion;
import unidad4.ejercicio09.ColaLinealDemostracion;
import unidad4.ejercicio10.ColaCircular;

/**
 * Demostraciones reproducibles de los diez ejercicios de la guía.
 */
public final class GuiaPilasColasDemo {
    private GuiaPilasColasDemo() {
    }

    public static void main(String[] args) {
        demoPilaEnteros();
        demoPlatos();
        demoParentesis();
        demoHistorial();
        demoPilaGenerica();
        demoColaEnteros();
        demoTurnos();
        demoImpresion();
        demoDesperdicio();
        demoColaCircular();
    }

    private static void demoPilaEnteros() {
        System.out.println("\n1. Pila de enteros");
        PilaEnteros pila = new PilaEnteros(3);
        pila.push(10);
        pila.push(20);
        System.out.println("peek=" + pila.peek() + ", size=" + pila.size());
        System.out.println("pop=" + pila.pop() + ", pop=" + pila.pop());
    }

    private static void demoPlatos() {
        System.out.println("\n2. Torre de platos");
        TorreDePlatos torre = new TorreDePlatos(3);
        torre.agregar("plato A");
        torre.agregar("plato B");
        System.out.println("Arriba: " + torre.platoSuperior());
        System.out.println("Retirado: " + torre.retirarSuperior());
        System.out.println("Ahora arriba: " + torre.platoSuperior());
    }

    private static void demoParentesis() {
        System.out.println("\n3. Paréntesis balanceados");
        System.out.println("(5 + 3) * (2 + 1): "
                + ValidadorParentesis.estaBalanceada("(5 + 3) * (2 + 1)"));
        System.out.println("(5 + 3)) * (2 + 1: "
                + ValidadorParentesis.estaBalanceada("(5 + 3)) * (2 + 1"));
    }

    private static void demoHistorial() {
        System.out.println("\n4. Historial de navegación");
        HistorialNavegacion historial = new HistorialNavegacion(4);
        historial.visitar("https://ejemplo.test/inicio");
        historial.visitar("https://ejemplo.test/temas");
        historial.visitar("https://ejemplo.test/colas");
        System.out.println("Actual: " + historial.paginaActual());
        System.out.println("Volver a: " + historial.volver().orElse("sin página anterior"));
    }

    private static void demoPilaGenerica() {
        System.out.println("\n5. Pila genérica");
        Pila<Integer> enteros = new Pila<>(2);
        enteros.push(42);
        System.out.println("Integer: " + enteros.pop());
        Pila<String> textos = new Pila<>(2);
        textos.push("Java");
        System.out.println("String: " + textos.pop());
        Pila<PersonaDemo> personas = new Pila<>(2);
        personas.push(new PersonaDemo("Ana"));
        System.out.println("Objeto: " + personas.pop());
    }

    private static void demoColaEnteros() {
        System.out.println("\n6. Cola lineal de enteros");
        ColaEnteros cola = new ColaEnteros(4);
        cola.enqueue(10);
        cola.enqueue(20);
        System.out.println("front=" + cola.front() + ", dequeue=" + cola.dequeue());
        System.out.println("siguiente=" + cola.front() + ", size=" + cola.size());
    }

    private static void demoTurnos() {
        System.out.println("\n7. Turnos de atención");
        SistemaTurnos turnos = new SistemaTurnos(4);
        turnos.agregarPersona("Ana");
        turnos.agregarPersona("Pedro");
        System.out.println("Primero: " + turnos.primero());
        System.out.println("Atendida: " + turnos.atenderSiguiente());
        turnos.agregarPersona("Lucia");
        System.out.println("Ahora primero: " + turnos.primero());
    }

    private static void demoImpresion() {
        System.out.println("\n8. Cola de impresión");
        ColaImpresion impresora = new ColaImpresion(3);
        impresora.agregar(new ColaImpresion.Documento("informe.pdf", 8));
        impresora.agregar(new ColaImpresion.Documento("resumen.txt", 2));
        System.out.println("Imprime: " + impresora.imprimirSiguiente());
        System.out.println("Luego: " + impresora.siguiente());
    }

    private static void demoDesperdicio() {
        System.out.println("\n9. Desperdicio en cola lineal");
        ColaLinealDemostracion cola = new ColaLinealDemostracion(5);
        cola.enqueue("A");
        mostrarEstadoLineal("enqueue A", cola);
        cola.enqueue("B");
        mostrarEstadoLineal("enqueue B", cola);
        cola.enqueue("C");
        mostrarEstadoLineal("enqueue C", cola);
        System.out.println("dequeue " + cola.dequeue());
        mostrarEstadoLineal("después de quitar A", cola);
        System.out.println("dequeue " + cola.dequeue());
        mostrarEstadoLineal("después de quitar B", cola);
        cola.enqueue("D");
        mostrarEstadoLineal("enqueue D", cola);
        cola.enqueue("E");
        mostrarEstadoLineal("enqueue E", cola);
        try {
            cola.enqueue("F");
        } catch (IllegalStateException esperado) {
            System.out.println("No puede agregar F: " + esperado.getMessage());
        }
    }

    private static void mostrarEstadoLineal(String operacion, ColaLinealDemostracion cola) {
        System.out.println(operacion + " -> " + Arrays.toString(cola.estadoArreglo())
                + ", front=" + cola.frontIndex() + ", rear=" + cola.rearIndex()
                + ", size=" + cola.size() + ", full=" + cola.isFull());
    }

    private static void demoColaCircular() {
        System.out.println("\n10. Cola circular");
        ColaCircular cola = new ColaCircular(3);
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        System.out.println("Sale: " + cola.dequeue());
        cola.enqueue(4);
        System.out.println("front=" + cola.front() + ", frontIndex=" + cola.frontIndex()
                + ", rearIndex=" + cola.rearIndex() + ", size=" + cola.size());
    }

    private record PersonaDemo(String nombre) {
    }
}
