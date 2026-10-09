package unidad4.tests;

import java.util.Objects;

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
 * Pruebas funcionales de las estructuras de la guía, sin dependencias externas.
 */
public final class GuiaPilasColasTests {
    private static int verificaciones;

    private GuiaPilasColasTests() {
    }

    public static void main(String[] args) {
        probarPilaEnteros();
        probarTorre();
        probarParentesis();
        probarHistorial();
        probarPilaGenerica();
        probarColaEnteros();
        probarTurnos();
        probarColaImpresion();
        probarDesperdicio();
        probarColaCircular();
        System.out.println("OK: " + verificaciones + " verificaciones");
    }

    private static void probarPilaEnteros() {
        excepcion(IllegalArgumentException.class, () -> new PilaEnteros(0), "pila capacidad cero");
        PilaEnteros pila = new PilaEnteros(1);
        verdadero(pila.isEmpty(), "pila inicial vacía");
        igual(0, pila.size(), "pila inicial size");
        excepcion(IllegalStateException.class, pila::pop, "pop pila vacía");
        excepcion(IllegalStateException.class, pila::peek, "peek pila vacía");
        pila.push(7);
        verdadero(pila.isFull(), "pila capacidad uno llena");
        igual(7, pila.peek(), "peek conserva");
        excepcion(IllegalStateException.class, () -> pila.push(8), "push pila llena");
        igual(7, pila.pop(), "pop capacidad uno");
        verdadero(pila.isEmpty(), "pila vuelve vacía");

        PilaEnteros lifo = new PilaEnteros(3);
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        igual(3, lifo.pop(), "LIFO primero");
        igual(2, lifo.pop(), "LIFO segundo");
    }

    private static void probarTorre() {
        excepcion(IllegalArgumentException.class, () -> new TorreDePlatos(-1),
                "torre capacidad negativa");
        TorreDePlatos torre = new TorreDePlatos(2);
        excepcion(IllegalStateException.class, torre::platoSuperior, "consultar torre vacía");
        excepcion(IllegalStateException.class, torre::retirarSuperior, "retirar torre vacía");
        torre.agregar("A");
        torre.agregar("B");
        verdadero(torre.isFull(), "torre llena");
        excepcion(IllegalStateException.class, () -> torre.agregar("C"), "agregar torre llena");
        igual("B", torre.platoSuperior(), "plato superior");
        igual("B", torre.retirarSuperior(), "retirar plato superior");
        igual("A", torre.retirarSuperior(), "orden LIFO platos");
        verdadero(torre.isEmpty(), "torre vacía al final");
    }

    private static void probarParentesis() {
        verdadero(ValidadorParentesis.estaBalanceada(""), "expresión vacía");
        verdadero(ValidadorParentesis.estaBalanceada("sin paréntesis"), "sin paréntesis");
        verdadero(ValidadorParentesis.estaBalanceada("(5 + 3) * (2 + 1)"), "ejemplo válido");
        verdadero(ValidadorParentesis.estaBalanceada("((a) + (b))"), "anidamiento");
        falso(ValidadorParentesis.estaBalanceada("(5 + 3)) * (2 + 1"), "cierre extra");
        falso(ValidadorParentesis.estaBalanceada("((x)"), "apertura pendiente");
        falso(ValidadorParentesis.estaBalanceada(")("), "cierre antes de apertura");
        excepcion(NullPointerException.class,
                () -> ValidadorParentesis.estaBalanceada(null), "expresión nula");
    }

    private static void probarHistorial() {
        excepcion(IllegalArgumentException.class, () -> new HistorialNavegacion(0),
                "historial capacidad cero");
        HistorialNavegacion historial = new HistorialNavegacion(3);
        verdadero(historial.isEmpty(), "historial vacío inicial");
        excepcion(IllegalStateException.class, historial::paginaActual, "actual sin visitas");
        excepcion(IllegalStateException.class, historial::volver, "volver sin visitas");
        historial.visitar("inicio");
        igual("inicio", historial.paginaActual(), "primera página");
        historial.visitar("temas");
        historial.visitar("colas");
        igual("colas", historial.paginaActual(), "última visita actual");
        igual(java.util.Optional.of("temas"), historial.volver(), "primer back");
        igual("temas", historial.paginaActual(), "página tras back");
        igual(java.util.Optional.of("inicio"), historial.volver(), "segundo back");
        igual("inicio", historial.paginaActual(), "sigue una página tras dos back");
        igual(java.util.Optional.empty(), historial.volver(), "tercer back sin anterior");
        verdadero(historial.isEmpty(), "historial vacío tras back");
        historial.visitar("única");
        igual(java.util.Optional.empty(), historial.volver(), "back desde única página");
        verdadero(historial.isEmpty(), "historial vacío al volver única página");
        excepcion(IllegalStateException.class, historial::volver, "volver desde vacío");
        historial.visitar("a");
        historial.visitar("b");
        historial.visitar("c");
        excepcion(IllegalStateException.class, () -> historial.visitar("d"), "historial lleno");
    }

    private static void probarPilaGenerica() {
        excepcion(IllegalArgumentException.class, () -> new Pila<String>(0),
                "pila genérica capacidad cero");
        Pila<Integer> enteros = new Pila<>(2);
        enteros.push(10);
        enteros.push(20);
        igual(Integer.valueOf(20), enteros.peek(), "peek genérico");
        igual(Integer.valueOf(20), enteros.pop(), "pop genérico");
        igual(Integer.valueOf(10), enteros.pop(), "LIFO genérico");
        verdadero(enteros.isEmpty(), "pila genérica vacía");
        excepcion(IllegalStateException.class, enteros::pop, "pop genérico vacío");

        Pila<String> textos = new Pila<>(1);
        textos.push("Java");
        igual("Java", textos.pop(), "tipo String");
        Pila<Persona> personas = new Pila<>(1);
        Persona ana = new Persona("Ana");
        personas.push(ana);
        igual(ana, personas.peek(), "tipo objeto");
    }

    private static void probarColaEnteros() {
        excepcion(IllegalArgumentException.class, () -> new ColaEnteros(0), "cola capacidad cero");
        ColaEnteros cola = new ColaEnteros(4);
        verdadero(cola.isEmpty(), "cola vacía inicial");
        excepcion(IllegalStateException.class, cola::dequeue, "dequeue vacía");
        excepcion(IllegalStateException.class, cola::front, "front vacía");
        cola.enqueue(10);
        cola.enqueue(20);
        igual(10, cola.front(), "front consulta sin quitar");
        igual(10, cola.dequeue(), "FIFO primero");
        igual(20, cola.front(), "front cambia");
        cola.enqueue(30);
        cola.enqueue(40);
        verdadero(cola.isFull(), "cola simple rear al final");
        igual(3, cola.size(), "cola simple size");
        excepcion(IllegalStateException.class, () -> cola.enqueue(50), "cola simple llena");
        igual(20, cola.dequeue(), "FIFO segundo");
        igual(30, cola.dequeue(), "FIFO tercero");
        igual(40, cola.dequeue(), "FIFO cuarto");
        verdadero(cola.isEmpty(), "cola simple queda vacía");
        verdadero(cola.isFull(), "rear al final aunque ya se vació");
    }

    private static void probarTurnos() {
        excepcion(IllegalArgumentException.class, () -> new SistemaTurnos(-1),
                "turnos capacidad negativa");
        SistemaTurnos turnos = new SistemaTurnos(3);
        excepcion(IllegalStateException.class, turnos::primero, "turnos vacíos");
        excepcion(IllegalStateException.class, turnos::atenderSiguiente, "atender vacío");
        turnos.agregarPersona("Ana");
        turnos.agregarPersona("Pedro");
        turnos.agregarPersona("Lucia");
        verdadero(turnos.isFull(), "turnos llenos");
        excepcion(IllegalStateException.class, () -> turnos.agregarPersona("Juan"),
                "agregar turno lleno");
        igual("Ana", turnos.primero(), "primera persona");
        igual("Ana", turnos.atenderSiguiente(), "FIFO primer turno");
        igual("Pedro", turnos.atenderSiguiente(), "FIFO segundo turno");
        igual("Lucia", turnos.atenderSiguiente(), "FIFO tercer turno");
        verdadero(turnos.isEmpty(), "turnos vacíos al final");
    }

    private static void probarColaImpresion() {
        excepcion(IllegalArgumentException.class, () -> new ColaImpresion(0),
                "impresora capacidad cero");
        ColaImpresion impresora = new ColaImpresion(2);
        excepcion(IllegalStateException.class, impresora::siguiente, "cola impresión vacía");
        excepcion(IllegalStateException.class, impresora::imprimirSiguiente,
                "imprimir sin trabajos");
        excepcion(IllegalArgumentException.class,
                () -> new ColaImpresion.Documento("vacío.pdf", 0), "documento sin páginas");
        var primero = new ColaImpresion.Documento("uno.pdf", 4);
        var segundo = new ColaImpresion.Documento("dos.pdf", 2);
        impresora.agregar(primero);
        igual(primero, impresora.siguiente(), "siguiente consulta");
        impresora.agregar(segundo);
        verdadero(impresora.isFull(), "impresión llena");
        excepcion(IllegalStateException.class,
                () -> impresora.agregar(new ColaImpresion.Documento("tres.pdf", 1)),
                "agregar impresión llena");
        igual(primero, impresora.imprimirSiguiente(), "impresión FIFO 1");
        igual(segundo, impresora.imprimirSiguiente(), "impresión FIFO 2");
        verdadero(impresora.isEmpty(), "cola impresión vacía");
        excepcion(IllegalStateException.class, impresora::imprimirSiguiente,
                "impresión sigue vacía al final");
    }

    private static void probarDesperdicio() {
        excepcion(IllegalArgumentException.class, () -> new ColaLinealDemostracion(0),
                "cola desperdicio capacidad cero");
        ColaLinealDemostracion cola = new ColaLinealDemostracion(5);
        cola.enqueue("A");
        cola.enqueue("B");
        cola.enqueue("C");
        igual("A", cola.dequeue(), "cola demo retira A");
        igual("B", cola.dequeue(), "cola demo retira B");
        cola.enqueue("D");
        cola.enqueue("E");
        iguales(new String[] {null, null, "C", "D", "E"}, cola.estadoArreglo(),
                "huecos iniciales visibles");
        igual(2, cola.frontIndex(), "front cola desperdicio");
        igual(4, cola.rearIndex(), "rear cola desperdicio");
        igual(3, cola.size(), "size cola desperdicio");
        verdadero(cola.isFull(), "cola desperdicio reporta llena");
        excepcion(IllegalStateException.class, () -> cola.enqueue("F"),
                "cola simple no reutiliza espacios iniciales");
        igual("C", cola.front(), "front permanece C");
    }

    private static void probarColaCircular() {
        excepcion(IllegalArgumentException.class, () -> new ColaCircular(0),
                "circular capacidad cero");
        ColaCircular cola = new ColaCircular(3);
        verdadero(cola.isEmpty(), "circular vacía inicial");
        excepcion(IllegalStateException.class, cola::front, "front circular vacía");
        excepcion(IllegalStateException.class, cola::dequeue, "dequeue circular vacía");
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        verdadero(cola.isFull(), "circular llena");
        excepcion(IllegalStateException.class, () -> cola.enqueue(4), "enqueue circular llena");
        igual(1, cola.dequeue(), "circular sale 1");
        igual(2, cola.dequeue(), "circular sale 2");
        cola.enqueue(4);
        cola.enqueue(5);
        verdadero(cola.isFull(), "circular vuelve a llena");
        igual(2, cola.frontIndex(), "front tras wrap-around");
        igual(2, cola.rearIndex(), "rear tras wrap-around");
        igual(3, cola.dequeue(), "circular FIFO 3");
        igual(4, cola.dequeue(), "circular FIFO 4");
        igual(5, cola.dequeue(), "circular FIFO 5");
        verdadero(cola.isEmpty(), "circular vacía al terminar");

        ColaCircular uno = new ColaCircular(1);
        uno.enqueue(9);
        verdadero(uno.isFull(), "circular capacidad uno llena");
        igual(9, uno.dequeue(), "circular capacidad uno extrae");
        verdadero(uno.isEmpty(), "circular capacidad uno vacía");
        uno.enqueue(10);
        igual(10, uno.front(), "circular capacidad uno reutiliza");
    }

    private static void iguales(Object[] esperado, Object[] actual, String nombre) {
        verificaciones++;
        if (!java.util.Arrays.equals(esperado, actual)) {
            throw new AssertionError(nombre + ": esperado " + java.util.Arrays.toString(esperado)
                    + ", recibido " + java.util.Arrays.toString(actual));
        }
    }

    private static void igual(Object esperado, Object actual, String nombre) {
        verificaciones++;
        if (!Objects.equals(esperado, actual)) {
            throw new AssertionError(nombre + ": esperado " + esperado + ", recibido " + actual);
        }
    }

    private static void igual(int esperado, int actual, String nombre) {
        verificaciones++;
        if (esperado != actual) {
            throw new AssertionError(nombre + ": esperado " + esperado + ", recibido " + actual);
        }
    }

    private static void verdadero(boolean actual, String nombre) {
        verificaciones++;
        if (!actual) {
            throw new AssertionError(nombre + ": se esperaba true");
        }
    }

    private static void falso(boolean actual, String nombre) {
        verificaciones++;
        if (actual) {
            throw new AssertionError(nombre + ": se esperaba false");
        }
    }

    private static void excepcion(Class<? extends RuntimeException> tipo, Runnable operacion,
            String nombre) {
        verificaciones++;
        try {
            operacion.run();
        } catch (RuntimeException error) {
            if (tipo.isInstance(error)) {
                return;
            }
            throw new AssertionError(nombre + ": se esperaba " + tipo.getSimpleName()
                    + ", se obtuvo " + error.getClass().getSimpleName(), error);
        }
        throw new AssertionError(nombre + ": no se lanzó " + tipo.getSimpleName());
    }

    private record Persona(String nombre) {
    }
}
