package unidad6.tests;

import java.util.Objects;
import java.util.Optional;

import unidad6.ejercicio01.PilaEnteros;
import unidad6.ejercicio02.ColaEnteros;
import unidad6.ejercicio03.Pila;
import unidad6.ejercicio04.Cola;
import unidad6.ejercicio05.HistorialNavegacion;
import unidad6.ejercicio06.ColaAtencionClientes;
import unidad6.ejercicio07.VerificadorParentesis;
import unidad6.ejercicio08.InvertidorPalabra;
import unidad6.ejercicio09.ColaImpresion;
import unidad6.ejercicio10.ListaDobleEnlazada;

/**
 * Pruebas autocontenidas de contratos, orden y casos límite de la Unidad 6.
 */
public final class GuiaPilasColasEnlazadasTests {
    private static int verificaciones;

    private GuiaPilasColasEnlazadasTests() {
    }

    private record Cliente(String nombre) {
    }

    /**
     * Ejecuta todas las comprobaciones y falla en la primera expectativa incumplida.
     *
     * @param args argumentos ignorados
     */
    public static void main(String[] args) {
        probarPilaEnteros();
        probarColaEnteros();
        probarPilaGenerica();
        probarColaGenerica();
        probarHistorial();
        probarAtencionClientes();
        probarParentesis();
        probarInversion();
        probarColaImpresion();
        probarListaDoble();
        System.out.println("OK: " + verificaciones + " verificaciones");
    }

    private static void probarPilaEnteros() {
        PilaEnteros pila = new PilaEnteros();
        comprobar(pila.estaVacia(), "pila de enteros vacía inicialmente");
        igual("null", pila.imprimir(), "impresión de pila vacía");
        esperar(IllegalStateException.class, pila::desapilar, "desapilar vacío");
        esperar(IllegalStateException.class, pila::consultarTope, "consultar tope vacío");
        pila.apilar(7);
        igual(7, pila.consultarTope(), "tope de pila unitaria");
        pila.apilar(12);
        pila.apilar(7);
        igual("7 -> 12 -> 7 -> null", pila.imprimir(), "pila impresa del tope al fondo");
        comprobar(pila.contiene(12), "búsqueda de valor presente en pila");
        comprobar(!pila.contiene(99), "búsqueda de valor ausente en pila");
        igual(7, pila.desapilar(), "primer elemento retirado respeta LIFO");
        igual(12, pila.desapilar(), "segundo elemento retirado respeta LIFO");
        igual(7, pila.desapilar(), "último elemento retirado");
        comprobar(pila.estaVacia(), "pila vacía después de retirar todo");
    }

    private static void probarColaEnteros() {
        ColaEnteros cola = new ColaEnteros();
        comprobar(cola.estaVacia(), "cola de enteros vacía inicialmente");
        igual("null", cola.imprimir(), "impresión de cola vacía");
        esperar(IllegalStateException.class, cola::desencolar, "desencolar vacío");
        esperar(IllegalStateException.class, cola::consultarFrente, "consultar frente vacío");
        cola.encolar(4);
        cola.encolar(8);
        cola.encolar(12);
        igual(4, cola.consultarFrente(), "consulta no destructiva de frente");
        igual("4 -> 8 -> 12 -> null", cola.imprimir(), "cola conserva FIFO");
        comprobar(cola.contiene(8), "búsqueda de valor presente en cola");
        comprobar(!cola.contiene(99), "búsqueda de valor ausente en cola");
        igual(4, cola.desencolar(), "primer elemento de cola");
        igual(8, cola.desencolar(), "segundo elemento de cola");
        igual(12, cola.desencolar(), "tercer elemento de cola");
        comprobar(cola.estaVacia(), "cola vacía después de retirar todo");
        cola.encolar(20);
        igual(20, cola.desencolar(), "cola permite encolar tras quedar vacía");
    }

    private static void probarPilaGenerica() {
        Pila<Integer> enteros = new Pila<>();
        enteros.apilar(3);
        enteros.apilar(9);
        igual(9, enteros.consultarTope(), "pila genérica de enteros");
        igual(9, enteros.desapilar(), "pila genérica conserva LIFO");
        comprobar(enteros.contiene(3), "búsqueda genérica de entero");

        Pila<String> textos = new Pila<>();
        textos.apilar("inicio");
        textos.apilar("fin");
        comprobar(textos.contiene("inicio"), "búsqueda genérica de texto");
        igual("fin -> inicio -> null", textos.imprimir(), "impresión genérica");
        igual("fin", textos.desapilar(), "retira tope de pila de texto");
        igual("inicio", textos.desapilar(), "retira fondo de pila de texto");
        comprobar(textos.estaVacia(), "pila de texto vacía tras retirar ambos elementos");

        Pila<Cliente> objetos = new Pila<>();
        objetos.apilar(new Cliente("Ada"));
        comprobar(objetos.contiene(new Cliente("Ada")), "búsqueda de objeto por equals");
        Pila<String> admiteNulos = new Pila<>();
        admiteNulos.apilar(null);
        comprobar(admiteNulos.contiene(null), "pila genérica encuentra null");
        igual(null, admiteNulos.desapilar(), "pila genérica retira null");
        esperar(IllegalStateException.class, textos::desapilar, "desapilar pila genérica vacía");
    }

    private static void probarColaGenerica() {
        Cola<String> nombres = new Cola<>();
        nombres.encolar("Ana");
        nombres.encolar("Luis");
        igual("Ana", nombres.consultarFrente(), "cola genérica consulta frente");
        comprobar(nombres.contiene("Luis"), "cola genérica busca texto");
        igual("Ana -> Luis -> null", nombres.imprimir(), "cola genérica orden FIFO");
        igual("Ana", nombres.desencolar(), "cola genérica atiende primero");
        igual("Luis", nombres.desencolar(), "cola genérica atiende segundo");
        comprobar(nombres.estaVacia(), "cola genérica queda vacía");
        nombres.encolar("Mora");
        igual("Mora", nombres.desencolar(), "cola genérica reinicia extremos");

        Cola<Cliente> clientes = new Cola<>();
        clientes.encolar(new Cliente("Eva"));
        clientes.encolar(new Cliente("Leo"));
        comprobar(clientes.contiene(new Cliente("Leo")), "cola genérica busca objeto por equals");
        igual(new Cliente("Eva"), clientes.desencolar(), "cola de objetos conserva FIFO");
        igual(new Cliente("Leo"), clientes.desencolar(), "cola de objetos retira siguiente");
        comprobar(clientes.estaVacia(), "cola de objetos queda vacía tras retirar");
        Cola<String> conNulo = new Cola<>();
        conNulo.encolar(null);
        comprobar(conNulo.contiene(null), "cola genérica encuentra null");
        igual(null, conNulo.desencolar(), "cola genérica retira null");
        esperar(IllegalStateException.class, nombres::consultarFrente, "consulta de cola genérica vacía");
    }

    private static void probarHistorial() {
        HistorialNavegacion historial = new HistorialNavegacion();
        igual(Optional.empty(), historial.paginaActual(), "página actual en historial vacío");
        igual("null", historial.imprimirHistorial(), "impresión de historial vacío");
        esperar(IllegalStateException.class, historial::volver, "volver con historial vacío");
        esperar(NullPointerException.class, () -> historial.visitar(null), "URL nula");
        historial.visitar("inicio");
        igual(Optional.of("inicio"), historial.paginaActual(), "visita única se vuelve actual");
        igual(Optional.empty(), historial.volver(), "volver desde visita única");
        comprobar(historial.paginaActual().isEmpty(), "una vuelta deja historial vacío");
        historial.visitar("inicio");
        historial.visitar("temas");
        historial.visitar("listas");
        igual("listas", historial.paginaActual().orElseThrow(), "actual tras varias visitas");
        igual("listas -> temas -> inicio -> null", historial.imprimirHistorial(), "historial en orden LIFO");
        igual(Optional.of("temas"), historial.volver(), "primer retroceso");
        igual(Optional.of("inicio"), historial.volver(), "segundo retroceso");
        igual(Optional.empty(), historial.volver(), "retroceso desde última visita");
    }

    private static void probarAtencionClientes() {
        ColaAtencionClientes cola = new ColaAtencionClientes();
        comprobar(cola.estaVacia(), "fila de clientes vacía");
        esperar(IllegalStateException.class, cola::atenderProximo, "atender fila vacía");
        esperar(IllegalStateException.class, cola::consultarProximo, "consultar fila vacía");
        ColaAtencionClientes.Cliente ana =
                new ColaAtencionClientes.Cliente("Ana", 10, "Cuenta");
        ColaAtencionClientes.Cliente luis =
                new ColaAtencionClientes.Cliente("Luis", 11, "Préstamo");
        cola.agregarCliente(ana);
        cola.agregarCliente(luis);
        igual(ana, cola.consultarProximo(), "consulta del primer cliente");
        comprobar(cola.imprimirFila().contains("Ana") && cola.imprimirFila().indexOf("Ana")
                < cola.imprimirFila().indexOf("Luis"), "fila representa orden de llegada");
        igual(ana, cola.atenderProximo(), "atención FIFO del primer cliente");
        igual(luis, cola.atenderProximo(), "atención FIFO del siguiente cliente");
        comprobar(cola.estaVacia(), "fila de clientes vacía tras atender a todos");
        cola.agregarCliente(ana);
        igual(ana, cola.atenderProximo(), "fila reutiliza tail tras vaciarse");
    }

    private static void probarParentesis() {
        VerificadorParentesis verificador = new VerificadorParentesis();
        comprobar(verificador.esBalanceada(""), "expresión vacía balanceada");
        comprobar(verificador.esBalanceada("sin paréntesis"), "texto sin paréntesis balanceado");
        comprobar(verificador.esBalanceada("(2 + 3) * (5 - 1)"), "ejemplo válido simple");
        comprobar(verificador.esBalanceada("((a + b) * c)"), "ejemplo válido anidado");
        comprobar(!verificador.esBalanceada("(2 + 3"), "apertura sin cerrar");
        comprobar(!verificador.esBalanceada("())("), "cierres extra");
        comprobar(!verificador.esBalanceada(")("), "cierre antes de apertura");
        esperar(NullPointerException.class, () -> verificador.esBalanceada(null), "expresión nula");
    }

    private static void probarInversion() {
        InvertidorPalabra invertidor = new InvertidorPalabra();
        igual("", invertidor.invertir(""), "palabra vacía");
        igual("a", invertidor.invertir("a"), "palabra de un carácter");
        igual("omtirogla", invertidor.invertir("algoritmo"), "ejemplo de la consigna");
        igual("B😀A", invertidor.invertir("A😀B"), "punto de código suplementario");
        esperar(NullPointerException.class, () -> invertidor.invertir(null), "palabra nula");
    }

    private static void probarColaImpresion() {
        ColaImpresion cola = new ColaImpresion();
        comprobar(cola.estaVacia(), "cola de impresión vacía");
        igual("null", cola.trabajosPendientes(), "sin trabajos pendientes");
        esperar(IllegalStateException.class, cola::imprimirProximo, "imprimir cola vacía");
        esperar(IllegalStateException.class, cola::consultarProximoArchivo, "consultar cola vacía");
        ColaImpresion.TrabajoImpresion primero =
                new ColaImpresion.TrabajoImpresion("a.pdf", 2, "Ana");
        ColaImpresion.TrabajoImpresion segundo =
                new ColaImpresion.TrabajoImpresion("b.pdf", 5, "Luis");
        cola.agregarTrabajo(primero);
        cola.agregarTrabajo(segundo);
        igual("a.pdf", cola.consultarProximoArchivo(), "consulta no retira archivo");
        comprobar(cola.trabajosPendientes().indexOf("a.pdf")
                < cola.trabajosPendientes().indexOf("b.pdf"), "pendientes en orden FIFO");
        igual(primero, cola.imprimirProximo(), "procesa primer trabajo");
        igual("b.pdf", cola.consultarProximoArchivo(), "segundo trabajo pasa al frente");
        igual(segundo, cola.imprimirProximo(), "procesa segundo trabajo");
        comprobar(cola.estaVacia(), "cola de impresión queda vacía");
    }

    private static void probarListaDoble() {
        ListaDobleEnlazada<String> lista = new ListaDobleEnlazada<>();
        comprobar(lista.estaVacia(), "lista doble inicialmente vacía");
        igual("null", lista.imprimirAdelante(), "lista vacía hacia adelante");
        igual("null", lista.imprimirAtras(), "lista vacía hacia atrás");
        lista.insertarAlFinal("B");
        lista.insertarAlInicio("A");
        lista.insertarAlFinal("C");
        igual("A <-> B <-> C <-> null", lista.imprimirAdelante(), "recorrido doble hacia adelante");
        igual("C <-> B <-> A <-> null", lista.imprimirAtras(), "recorrido doble hacia atrás");
        comprobar(!lista.eliminar("ausente"), "eliminar valor ausente no cambia lista");
        comprobar(lista.eliminar("B"), "eliminar nodo intermedio");
        igual("A <-> C <-> null", lista.imprimirAdelante(), "enlaces tras eliminar intermedio");
        igual("C <-> A <-> null", lista.imprimirAtras(), "enlaces inversos tras eliminar intermedio");
        comprobar(lista.eliminar("A"), "eliminar head");
        igual("C <-> null", lista.imprimirAdelante(), "head actualizado");
        comprobar(lista.eliminar("C"), "eliminar único nodo restante");
        comprobar(lista.estaVacia(), "lista doble vacía al eliminar último");
        comprobar(!lista.eliminar("C"), "eliminar de lista vacía");

        ListaDobleEnlazada<Integer> duplicados = new ListaDobleEnlazada<>();
        duplicados.insertarAlFinal(4);
        duplicados.insertarAlFinal(4);
        duplicados.insertarAlFinal(9);
        comprobar(duplicados.eliminar(4), "eliminar primera coincidencia duplicada");
        igual("4 <-> 9 <-> null", duplicados.imprimirAdelante(), "permanece segundo duplicado");

        ListaDobleEnlazada<String> nulos = new ListaDobleEnlazada<>();
        nulos.insertarAlInicio(null);
        nulos.insertarAlFinal("x");
        comprobar(nulos.eliminar(null), "eliminar dato null");
        igual("x <-> null", nulos.imprimirAdelante(), "extremo tras eliminar null");
        igual("x <-> null", nulos.imprimirAtras(), "extremo inverso tras eliminar null");
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
        } catch (Throwable error) {
            if (tipo.isInstance(error)) {
                return;
            }
            throw new AssertionError(descripcion + ": excepción inesperada " + error, error);
        }
        throw new AssertionError(descripcion + ": no se lanzó " + tipo.getSimpleName());
    }
}
