package unidad5.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import unidad5.ejercicio01.ListaEnterosBasica;
import unidad5.ejercicio02.ListaConBusqueda;
import unidad5.ejercicio03.ListaConAccesoPosicional;
import unidad5.ejercicio04.ListaConInsercionPosicional;
import unidad5.ejercicio05.ListaConEliminacionPorValor;
import unidad5.ejercicio06.ListaConEliminacionPosicional;
import unidad5.ejercicio07.ListaConModificacion;
import unidad5.ejercicio08.ListaConConteo;
import unidad5.ejercicio09.ListaInvertible;
import unidad5.ejercicio10.ListaEnlazada;

/**
 * Pruebas de comportamiento y límites para las diez soluciones de listas enlazadas.
 */
public final class GuiaListasEnlazadasTests {
    private static int verificaciones;

    private GuiaListasEnlazadasTests() {
    }

    public static void main(String[] args) throws Exception {
        probarListaBasica();
        probarBusqueda();
        probarAccesoPosicional();
        probarInsercionPosicional();
        probarEliminacionPorValor();
        probarEliminacionPosicional();
        probarModificacion();
        probarConteo();
        probarInversion();
        probarListaGenerica();
        System.out.println("OK: " + verificaciones + " verificaciones");
    }

    private static void probarListaBasica() throws Exception {
        ListaEnterosBasica lista = new ListaEnterosBasica();
        verdadero(lista.estaVacia(), "lista inicial vacía");
        igual(0, lista.getSize(), "size inicial");
        igual("null\n", capturarImpresion(lista::imprimir), "imprime lista vacía");
        lista.insertarAlFinal(20);
        lista.insertarAlInicio(10);
        lista.insertarAlFinal(30);
        falso(lista.estaVacia(), "lista con elementos");
        igual(3, lista.getSize(), "size tras inserciones");
        igual("10 -> 20 -> 30 -> null", lista.toString(), "orden inicio/final");
        igual("10 -> 20 -> 30 -> null\n", capturarImpresion(lista::imprimir), "imprime recorrido");
    }

    private static void probarBusqueda() {
        ListaConBusqueda lista = new ListaConBusqueda();
        falso(lista.buscar(1), "buscar lista vacía");
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(20);
        verdadero(lista.buscar(10), "buscar primero");
        verdadero(lista.buscar(30), "buscar último");
        verdadero(lista.buscar(20), "buscar medio/duplicado");
        falso(lista.buscar(99), "buscar ausente");
        igual(4, lista.getSize(), "size búsqueda");
    }

    private static void probarAccesoPosicional() {
        ListaConAccesoPosicional lista = new ListaConAccesoPosicional();
        excepcion(IndexOutOfBoundsException.class, () -> lista.obtener(0), "obtener vacía");
        lista.agregar(11);
        lista.agregar(22);
        lista.agregar(33);
        igual(11, lista.obtener(0), "obtener primero");
        igual(22, lista.obtener(1), "obtener medio");
        igual(33, lista.obtener(2), "obtener último");
        excepcion(IndexOutOfBoundsException.class, () -> lista.obtener(-1), "obtener negativo");
        excepcion(IndexOutOfBoundsException.class, () -> lista.obtener(3), "obtener size");
    }

    private static void probarInsercionPosicional() {
        ListaConInsercionPosicional lista = new ListaConInsercionPosicional();
        lista.insertarEnPosicion(20, 0);
        lista.insertarEnPosicion(10, 0);
        lista.insertarEnPosicion(40, 2);
        lista.insertarEnPosicion(30, 2);
        igual("10 -> 20 -> 30 -> 40 -> null", lista.toString(), "inserción inicio/medio/final");
        igual(4, lista.getSize(), "size inserción");
        ListaConInsercionPosicional vacia = new ListaConInsercionPosicional();
        vacia.insertarEnPosicion(5, 0);
        igual("5 -> null", vacia.toString(), "insertar en lista vacía");
        excepcion(IndexOutOfBoundsException.class, () -> lista.insertarEnPosicion(1, -1),
                "insertar posición negativa");
        excepcion(IndexOutOfBoundsException.class, () -> lista.insertarEnPosicion(1, 5),
                "insertar mayor que size");
    }

    private static void probarEliminacionPorValor() {
        ListaConEliminacionPorValor lista = new ListaConEliminacionPorValor();
        falso(lista.eliminar(1), "eliminar vacía");
        lista.agregarAlFinal(10);
        lista.agregarAlFinal(20);
        lista.agregarAlFinal(30);
        lista.agregarAlFinal(20);
        verdadero(lista.eliminar(10), "eliminar head");
        igual("20 -> 30 -> 20 -> null", lista.toString(), "head desvinculado");
        verdadero(lista.eliminar(30), "eliminar medio");
        igual("20 -> 20 -> null", lista.toString(), "medio desvinculado");
        verdadero(lista.eliminar(20), "eliminar primera coincidencia");
        igual("20 -> null", lista.toString(), "solo primera aparición removida");
        verdadero(lista.eliminar(20), "eliminar último");
        falso(lista.eliminar(99), "eliminar ausente");
        igual(0, lista.getSize(), "size después de eliminar todos");
    }

    private static void probarEliminacionPosicional() {
        ListaConEliminacionPosicional lista = new ListaConEliminacionPosicional();
        excepcion(IndexOutOfBoundsException.class, () -> lista.eliminarEnPosicion(0),
                "eliminar posición en vacía");
        lista.agregarAlFinal(10);
        lista.agregarAlFinal(20);
        lista.agregarAlFinal(30);
        lista.agregarAlFinal(40);
        lista.eliminarEnPosicion(0);
        igual("20 -> 30 -> 40 -> null", lista.toString(), "eliminar por posición head");
        lista.eliminarEnPosicion(1);
        igual("20 -> 40 -> null", lista.toString(), "eliminar por posición medio");
        lista.eliminarEnPosicion(1);
        igual("20 -> null", lista.toString(), "eliminar por posición último");
        igual(1, lista.getSize(), "size eliminación posicional");
        excepcion(IndexOutOfBoundsException.class, () -> lista.eliminarEnPosicion(-1),
                "eliminar posición negativa");
        excepcion(IndexOutOfBoundsException.class, () -> lista.eliminarEnPosicion(1),
                "eliminar posición size");
    }

    private static void probarModificacion() {
        ListaConModificacion lista = new ListaConModificacion();
        lista.agregarAlFinal(10);
        lista.agregarAlFinal(20);
        lista.agregarAlFinal(30);
        lista.modificar(0, 11);
        lista.modificar(1, 22);
        lista.modificar(2, 33);
        igual("11 -> 22 -> 33 -> null", lista.toString(), "modificar todas posiciones");
        igual(3, lista.getSize(), "modificar no cambia size");
        excepcion(IndexOutOfBoundsException.class, () -> lista.modificar(-1, 0),
                "modificar negativo");
        excepcion(IndexOutOfBoundsException.class, () -> lista.modificar(3, 0),
                "modificar size");
    }

    private static void probarConteo() {
        ListaConConteo lista = new ListaConConteo();
        igual(0, lista.contarOcurrencias(10), "conteo vacía");
        lista.agregarAlFinal(10);
        lista.agregarAlFinal(20);
        lista.agregarAlFinal(10);
        lista.agregarAlFinal(30);
        lista.agregarAlFinal(10);
        igual("10 -> 20 -> 10 -> 30 -> 10 -> null", lista.toString(), "ejemplo de conteo");
        igual(3, lista.contarOcurrencias(10), "conteo múltiple");
        igual(1, lista.contarOcurrencias(20), "conteo única");
        igual(0, lista.contarOcurrencias(99), "conteo ausente");
    }

    private static void probarInversion() {
        ListaInvertible vacia = new ListaInvertible();
        vacia.invertir();
        igual("null", vacia.toString(), "invertir vacía");

        ListaInvertible una = new ListaInvertible();
        una.agregarAlFinal(1);
        una.invertir();
        igual("1 -> null", una.toString(), "invertir un nodo");

        ListaInvertible dos = new ListaInvertible();
        dos.agregarAlFinal(1);
        dos.agregarAlFinal(2);
        dos.invertir();
        igual("2 -> 1 -> null", dos.toString(), "invertir dos nodos");
        igual(2, dos.getSize(), "size al invertir dos");

        ListaInvertible varias = new ListaInvertible();
        for (int valor : new int[] {10, 20, 30, 40}) {
            varias.agregarAlFinal(valor);
        }
        varias.invertir();
        igual("40 -> 30 -> 20 -> 10 -> null", varias.toString(), "invertir varios");
        igual(4, varias.getSize(), "size al invertir varios");
        varias.invertir();
        igual("10 -> 20 -> 30 -> 40 -> null", varias.toString(), "invertir dos veces");
    }

    private static void probarListaGenerica() {
        ListaEnlazada<Integer> enteros = new ListaEnlazada<>();
        enteros.insertarAlFinal(10);
        enteros.insertarAlFinal(20);
        enteros.insertarAlFinal(10);
        verdadero(enteros.buscar(20), "genérica busca integer");
        igual(2, enteros.contarOcurrencias(10), "genérica cuenta integer");
        igual(Integer.valueOf(20), enteros.obtener(1), "genérica obtener");
        enteros.insertarEnPosicion(15, 1);
        enteros.modificar(1, 16);
        igual("10 -> 16 -> 20 -> 10 -> null", enteros.toString(), "genérica insertar/modificar");
        verdadero(enteros.eliminar(Integer.valueOf(10)), "genérica eliminar primera");
        igual("16 -> 20 -> 10 -> null", enteros.toString(), "genérica mantiene duplicado");
        enteros.eliminarEnPosicion(1);
        igual("16 -> 10 -> null", enteros.toString(), "genérica eliminar posición");
        enteros.invertir();
        igual("10 -> 16 -> null", enteros.toString(), "genérica invertir");

        ListaEnlazada<String> textos = new ListaEnlazada<>();
        textos.insertarAlInicio("uno");
        textos.insertarAlFinal("dos");
        verdadero(textos.buscar(new String("uno")), "genérica equals String");
        igual(1, textos.contarOcurrencias("dos"), "genérica cuenta String");
        textos.modificar(0, "primero");
        igual("primero -> dos -> null", textos.toString(), "genérica modificar String");

        ListaEnlazada<Alumno> alumnos = new ListaEnlazada<>();
        Alumno ana = new Alumno("Ana", 1);
        Alumno luis = new Alumno("Luis", 2);
        alumnos.insertarAlFinal(ana);
        alumnos.insertarAlFinal(luis);
        verdadero(alumnos.buscar(new Alumno("Ana", 1)), "genérica equals objeto");
        igual(1, alumnos.contarOcurrencias(new Alumno("Luis", 2)), "genérica cuenta objeto");
        verdadero(alumnos.eliminar(new Alumno("Ana", 1)), "genérica elimina objeto");
        igual(luis, alumnos.obtener(0), "genérica conserva objeto");
        verdadero(enteros.estaVacia() == false, "genérica no vacía");
        igual(2, enteros.getSize(), "genérica size");
        excepcion(IndexOutOfBoundsException.class, () -> textos.obtener(-1),
                "genérica obtener negativo");
        excepcion(IndexOutOfBoundsException.class, () -> textos.insertarEnPosicion("x", 3),
                "genérica insertar inválido");
        excepcion(IndexOutOfBoundsException.class, () -> textos.modificar(2, "x"),
                "genérica modificar size");

        ListaEnlazada<String> nulos = new ListaEnlazada<>();
        nulos.insertarAlFinal(null);
        nulos.insertarAlFinal("x");
        verdadero(nulos.buscar(null), "genérica admite null y lo busca");
        igual(1, nulos.contarOcurrencias(null), "genérica cuenta null");
        verdadero(nulos.eliminar(null), "genérica elimina null");
    }

    private static String capturarImpresion(Runnable accion) throws Exception {
        PrintStream original = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (PrintStream captura = new PrintStream(bytes, true, StandardCharsets.UTF_8)) {
            System.setOut(captura);
            accion.run();
        } finally {
            System.setOut(original);
        }
        return bytes.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
    }

    private static void igual(Object esperado, Object actual, String nombre) {
        verificaciones++;
        if (esperado == null ? actual != null : !esperado.equals(actual)) {
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

    private static void excepcion(Class<? extends RuntimeException> tipo, Runnable accion,
            String nombre) {
        verificaciones++;
        try {
            accion.run();
        } catch (RuntimeException error) {
            if (tipo.isInstance(error)) {
                return;
            }
            throw new AssertionError(nombre + ": esperada " + tipo.getSimpleName()
                    + ", recibida " + error.getClass().getSimpleName(), error);
        }
        throw new AssertionError(nombre + ": no se lanzó " + tipo.getSimpleName());
    }

    private record Alumno(String nombre, int legajo) {
    }
}
