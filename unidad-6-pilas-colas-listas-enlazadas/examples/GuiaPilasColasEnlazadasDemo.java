package unidad6.examples;

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
 * Ejecuta ejemplos breves y reproducibles de los diez ejercicios de la unidad.
 */
public final class GuiaPilasColasEnlazadasDemo {
    private GuiaPilasColasEnlazadasDemo() {
    }

    /**
     * Muestra el comportamiento principal de cada estructura.
     *
     * @param args argumentos ignorados
     */
    public static void main(String[] args) {
        PilaEnteros pila = new PilaEnteros();
        pila.apilar(10);
        pila.apilar(20);
        System.out.println("1. Pila (tope a fondo): " + pila.imprimir());

        ColaEnteros cola = new ColaEnteros();
        cola.encolar(10);
        cola.encolar(20);
        System.out.println("2. Cola (frente a final): " + cola.imprimir());

        Pila<String> pilaGenerica = new Pila<>();
        pilaGenerica.apilar("Java");
        pilaGenerica.apilar("OpenCode");
        System.out.println("3. Pila genérica: " + pilaGenerica.imprimir());

        Cola<String> colaGenerica = new Cola<>();
        colaGenerica.encolar("Ana");
        colaGenerica.encolar("Luis");
        System.out.println("4. Cola genérica: " + colaGenerica.imprimir());
        Cola<ColaAtencionClientes.Cliente> colaClientes = new Cola<>();
        colaClientes.encolar(new ColaAtencionClientes.Cliente("Mora", 1, "Cuenta"));
        colaClientes.encolar(new ColaAtencionClientes.Cliente("Nico", 2, "Tarjeta"));
        System.out.println("   Cola genérica de clientes: " + colaClientes.imprimir());

        HistorialNavegacion historial = new HistorialNavegacion();
        historial.visitar("https://ejemplo.test/inicio");
        historial.visitar("https://ejemplo.test/algoritmos");
        System.out.println("5. Historial (actual a anterior): " + historial.imprimirHistorial());

        ColaAtencionClientes clientes = new ColaAtencionClientes();
        clientes.agregarCliente(new ColaAtencionClientes.Cliente("Mora", 1, "Cuenta"));
        clientes.agregarCliente(new ColaAtencionClientes.Cliente("Nico", 2, "Tarjeta"));
        System.out.println("6. Fila del banco: " + clientes.imprimirFila());

        VerificadorParentesis verificador = new VerificadorParentesis();
        System.out.println("7. ¿Balanceada? " + verificador.esBalanceada("((a + b) * c)"));

        System.out.println("8. Palabra invertida: "
                + new InvertidorPalabra().invertir("algoritmo"));

        ColaImpresion impresora = new ColaImpresion();
        impresora.agregarTrabajo(new ColaImpresion.TrabajoImpresion("informe.pdf", 4, "Mora"));
        impresora.agregarTrabajo(new ColaImpresion.TrabajoImpresion("resumen.pdf", 2, "Nico"));
        System.out.println("9. Trabajos pendientes: " + impresora.trabajosPendientes());

        ListaDobleEnlazada<String> lista = new ListaDobleEnlazada<>();
        lista.insertarAlInicio("primero");
        lista.insertarAlFinal("último");
        System.out.println("10. Lista hacia adelante: " + lista.imprimirAdelante());
        System.out.println("    Lista hacia atrás:   " + lista.imprimirAtras());
    }
}
