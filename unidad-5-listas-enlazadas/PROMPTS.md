# Prompts para OpenCode — Unidad 5: Listas Enlazadas Simples

Cada prompt es independiente. Pegalo en OpenCode para generar la solución indicada en Java 21, sin usar colecciones Java para almacenar la lista.

## Ejercicio 1 — Crear una lista desde cero

```text
Implementá en Java 21 una lista enlazada simple de números enteros, sin usar ArrayList, LinkedList ni estructuras similares.
Representá cada nodo con dato entero y referencia siguiente. head debe apuntar al primer nodo o ser null si la lista está vacía; mantené size actualizado.
Ofrecé insertarAlInicio(int dato), insertarAlFinal(int dato), imprimir(), estaVacia() y getSize(). imprimir() debe mostrar dato -> ... -> null, o null para la lista vacía, sin modificar enlaces.
Documentá la estructura, propósito de head, actualizaciones de referencias, entradas/salidas y complejidad con Javadoc. Separá clase, demo y pruebas.
Probá inserción al inicio y final, lista vacía, un elemento, orden de varios nodos y tamaño tras cada operación.
Al comienzo del archivo .java incluye el prompt inicial con el formato pedido; al final, indica ajustes realizados o que no hubo.
```

## Ejercicio 2 — Buscar elementos

```text
Implementá en Java 21 una lista enlazada simple de enteros con un método boolean buscar(int dato).
El recorrido comienza en head y sigue nodo a nodo por siguiente hasta hallar el valor o llegar a null. Explicá que una lista enlazada no permite acceso directo por índice como un arreglo, por lo que la búsqueda requiere recorrido secuencial.
No uses colecciones de Java para almacenar los elementos. Documentá nodos, referencias, entradas, resultado y complejidad temporal O(n), espacial O(1).
Separá implementación de la demo y pruebas. Incluí métodos mínimos para construir una lista y una representación legible.
Probá lista vacía, valor al inicio, al final, ausente y duplicados.
Poné el prompt inicial al comienzo del archivo fuente y una nota al final sobre los ajustes efectuados.
```

## Ejercicio 3 — Obtener elemento por posición

```text
Implementá en Java 21 una lista enlazada simple de enteros con int obtener(int posicion).
Las posiciones válidas van de 0 a size-1. Valida posicion < 0 o posicion >= size antes de recorrer y lanza IndexOutOfBoundsException. Para un índice válido, parte de head y avanza nodo a nodo; explica por qué no hay acceso directo como en un arreglo.
No uses colecciones de Java como almacenamiento. Documentá razonamiento, parámetros, resultado, excepción y complejidad O(n) tiempo/O(1) espacio adicional.
Separá solución, demo y pruebas. Probá primero, medio, último, lista vacía, -1 y size.
Incluí el prompt inicial en comentario al inicio del .java y al final indica si fue ajustado.
```

## Ejercicio 4 — Insertar en una posición específica

```text
Implementá en Java 21 una lista enlazada simple de enteros con void insertarEnPosicion(int dato, int posicion).
La inserción admite posiciones 0..size inclusive: 0 inserta al inicio, size al final y las intermedias entre nodos. Índice fuera de ese rango lanza IndexOutOfBoundsException.
En una inserción intermedia, preserva primero el enlace siguiente: nuevo.siguiente = actual.siguiente; después actual.siguiente = nuevo. Explica que invertir ese orden puede perder el resto de la lista. Trata la posición cero actualizando head y aumenta size exactamente una vez.
No uses colecciones Java. Documentá invariantes, parámetros, error y complejidad O(n) tiempo/O(1) espacio adicional. Separa solución, demo y pruebas.
Prueba inserción al inicio, medio, final, lista vacía, -1 y size+1; confirma orden, size y terminación en null.
Comenta el prompt inicial al inicio del fuente y al final los ajustes realizados.
```

## Ejercicio 5 — Eliminar nodo por valor

```text
Implementá en Java 21 una lista enlazada simple de enteros con boolean eliminar(int dato), que elimine solo la primera aparición.
Contempla lista vacía, eliminación de head, nodo intermedio, último nodo y dato inexistente. Al eliminar head, mueve head al siguiente; en otro caso, enlaza el nodo anterior directamente con el siguiente del nodo eliminado. Actualiza size y devuelve true si eliminó, false si no encontró el valor.
Explica que Java no libera manualmente el nodo: al quedar sin referencias desde la lista, el Garbage Collector podrá recuperarlo.
No uses colecciones Java para almacenar nodos. Documentá razonamiento de enlaces, resultado y complejidad O(n) tiempo/O(1) espacio.
Separá implementación, demo y pruebas. Incluye duplicados y verifica que solo desaparezca la primera coincidencia.
Incluí el prompt inicial en comentario al principio y al final registra si hubo ajustes.
```

## Ejercicio 6 — Eliminar nodo por posición

```text
Implementá en Java 21 una lista enlazada simple de enteros con void eliminarEnPosicion(int posicion).
Valida primero que 0 <= posicion < size; para un índice inválido lanza IndexOutOfBoundsException. Si posicion es 0, avanza head. En otro caso recorre hasta el nodo anterior y hace que su siguiente apunte al siguiente del nodo eliminado. Decrementa size una sola vez.
Explica cómo se encuentra el nodo anterior y por qué la referencia al nodo eliminado queda fuera de la lista. No uses colecciones Java.
Documentá parámetros, resultado, error y complejidad O(n) tiempo/O(1) espacio adicional. Separa implementación de demo y pruebas.
Prueba lista vacía, -1, size, primer, medio y último nodo, verificando secuencia y size.
Escribe el prompt inicial como comentario al comienzo del .java e incluye al final una nota de ajustes.
```

## Ejercicio 7 — Modificar un elemento

```text
Implementá en Java 21 una lista enlazada simple de enteros con void modificar(int posicion, int nuevoDato).
Antes de recorrer, valida 0 <= posicion < size; si no, lanza IndexOutOfBoundsException. Recorre desde head hasta el nodo indicado y reemplaza solo su dato.
Explica la diferencia entre cambiar el dato almacenado y cambiar la referencia siguiente: modificar no debe alterar enlaces ni size.
No uses colecciones Java para almacenar nodos. Documentá entradas, resultado, error y complejidad O(n) tiempo/O(1) espacio adicional.
Separá código, demostración y pruebas. Prueba primer, medio, último y posiciones inválidas -1 y size; confirma que orden, enlaces y size no cambian.
Incluye el prompt inicial en el comentario inicial del archivo y al final especifica los ajustes hechos.
```

## Ejercicio 8 — Contar ocurrencias

```text
Implementá en Java 21 una lista enlazada simple de enteros con int contarOcurrencias(int dato).
Recorre todos los nodos desde head hasta null e incrementa el contador en cada coincidencia. No termines el recorrido en la primera coincidencia porque se pide el total.
Usa el ejemplo 10 -> 20 -> 10 -> 30 -> 10 -> null y devuelve 3 para dato 10. No uses colecciones Java para almacenar la lista.
Documentá estrategia, parámetro, resultado y complejidad O(n) tiempo/O(1) espacio adicional. Separa solución, demo y pruebas.
Prueba lista vacía, ninguna coincidencia, una coincidencia y varias apariciones al inicio, medio y final.
Comenta el prompt inicial al comienzo del .java e indica al final si fue necesario ajustarlo.
```

## Ejercicio 9 — Invertir lista enlazada

```text
Implementá en Java 21 el método void invertir() para una lista enlazada simple de enteros, modificándola in-place.
Usa referencias anterior, actual y siguiente. En cada paso guarda primero siguiente = actual.siguiente; después cambia actual.siguiente = anterior; luego avanza anterior = actual y actual = siguiente. Al terminar, asigna head = anterior.
Explica por qué guardar siguiente antes de actualizar enlaces evita perder los nodos restantes y por qué el orden de las asignaciones importa.
No uses arreglo auxiliar ni colección. Documentá complejidad O(n) tiempo/O(1) espacio adicional y casos vacíos/unitarios.
Separa implementación, demo y pruebas. Prueba lista vacía, un nodo, dos nodos y varios; verifica orden inverso, size y terminación null.
Incluye prompt inicial en comentario al comienzo del archivo y nota final sobre ajustes realizados.
```

## Ejercicio 10 — Convertir la lista en genérica

```text
Implementá en Java 21 Nodo<T> y ListaEnlazada<T> usando referencias simples, head y size, sin ArrayList, LinkedList ni otras colecciones para almacenar nodos.
Permite insertarAlInicio(T dato), insertarAlFinal(T dato), buscar(T dato), obtener(int posicion), insertarEnPosicion(T dato, int posicion), eliminar(T dato), eliminarEnPosicion(int posicion), modificar(int posicion, T nuevoDato), contarOcurrencias(T dato), invertir(), estaVacia(), getSize() e imprimir().
Explica qué cambia al sustituir int por T y qué se mantiene igual: recorrido, actualización de enlaces y administración de head/size no dependen del tipo almacenado. Para búsqueda, eliminación y ocurrencias usa Objects.equals.
Usa IndexOutOfBoundsException: insertar admite índices 0..size; obtener/modificar/eliminar por posición admiten 0..size-1. Elimina solo la primera coincidencia.
Documentá clases y métodos con Javadoc, tipos, resultados, errores y complejidades. Separa código de demo y pruebas.
Demuestra ListaEnlazada<Integer>, ListaEnlazada<String> y ListaEnlazada<Alumno>; prueba inserción, recorrido, búsqueda, modificación y eliminación en cada caso.
Pon el prompt inicial en comentario al inicio del .java y una nota final sobre los ajustes hechos.
```
