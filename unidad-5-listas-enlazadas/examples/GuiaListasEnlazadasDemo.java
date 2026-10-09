package unidad5.examples;

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
 * Demostraciones simples y reproducibles de los diez ejercicios.
 */
public final class GuiaListasEnlazadasDemo {
    private GuiaListasEnlazadasDemo() {
    }

    public static void main(String[] args) {
        ListaEnterosBasica basica = new ListaEnterosBasica();
        basica.insertarAlInicio(20);
        basica.insertarAlInicio(10);
        basica.insertarAlFinal(30);
        System.out.println("1. Lista: " + basica);

        ListaConBusqueda busqueda = new ListaConBusqueda();
        busqueda.agregar(10);
        busqueda.agregar(20);
        System.out.println("2. ¿Contiene 20? " + busqueda.buscar(20));

        ListaConAccesoPosicional acceso = new ListaConAccesoPosicional();
        acceso.agregar(10);
        acceso.agregar(20);
        System.out.println("3. Elemento en posición 1: " + acceso.obtener(1));

        ListaConInsercionPosicional insercion = new ListaConInsercionPosicional();
        insercion.insertarEnPosicion(10, 0);
        insercion.insertarEnPosicion(30, 1);
        insercion.insertarEnPosicion(20, 1);
        System.out.println("4. Inserción posicional: " + insercion);

        ListaConEliminacionPorValor eliminacion = new ListaConEliminacionPorValor();
        eliminacion.agregarAlFinal(10);
        eliminacion.agregarAlFinal(20);
        eliminacion.agregarAlFinal(30);
        eliminacion.eliminar(20);
        System.out.println("5. Eliminación por valor: " + eliminacion);

        ListaConEliminacionPosicional eliminacionPosicional = new ListaConEliminacionPosicional();
        eliminacionPosicional.agregarAlFinal(10);
        eliminacionPosicional.agregarAlFinal(20);
        eliminacionPosicional.agregarAlFinal(30);
        eliminacionPosicional.eliminarEnPosicion(1);
        System.out.println("6. Eliminación por posición: " + eliminacionPosicional);

        ListaConModificacion modificacion = new ListaConModificacion();
        modificacion.agregarAlFinal(10);
        modificacion.agregarAlFinal(20);
        modificacion.modificar(1, 25);
        System.out.println("7. Modificación: " + modificacion);

        ListaConConteo conteo = new ListaConConteo();
        conteo.agregarAlFinal(10);
        conteo.agregarAlFinal(20);
        conteo.agregarAlFinal(10);
        System.out.println("8. Ocurrencias de 10: " + conteo.contarOcurrencias(10));

        ListaInvertible inversion = new ListaInvertible();
        inversion.agregarAlFinal(10);
        inversion.agregarAlFinal(20);
        inversion.agregarAlFinal(30);
        inversion.invertir();
        System.out.println("9. Invertida: " + inversion);

        ListaEnlazada<String> generica = new ListaEnlazada<>();
        generica.insertarAlFinal("nodos");
        generica.insertarAlFinal("genéricos");
        System.out.println("10. Lista genérica: " + generica);
    }
}
