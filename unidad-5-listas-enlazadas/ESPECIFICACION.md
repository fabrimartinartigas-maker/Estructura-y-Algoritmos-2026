# Especificación — Unidad 5: Listas Enlazadas Simples

## Objetivo

Implementar diez ejercicios de listas enlazadas simples en Java 21 usando OpenCode. Los ejercicios introducen nodos y referencias, recorrido desde `head`, actualización de enlaces, eliminación por desvinculación, inversión in-place y generalización con tipos genéricos.

## Alcance y decisiones acordadas

- La guía se ubica en una carpeta propia como Unidad 5.
- Lenguaje: Java 21; sin dependencias externas.
- Cada ejercicio tiene una solución independiente en `reso/ejercicioNN/`, con una clase/lista mínima autocontenida para que el algoritmo se pueda estudiar y probar sin depender de otras soluciones.
- Ejemplos ejecutables y pruebas automatizadas se mantienen fuera de `reso/`.
- Posiciones inválidas producen `IndexOutOfBoundsException`. `insertarEnPosicion` admite `0 <= posicion <= size`; `obtener`, `eliminarEnPosicion` y `modificar` admiten `0 <= posicion < size`. Esta política fue confirmada por el usuario.
- Eliminación por valor elimina solo la primera coincidencia y devuelve `false` cuando no encuentra el valor; devolución booleana para distinguir éxito/ausencia.
- Impresión de lista usa el formato `dato -> ... -> null`; una lista vacía imprime `null`.
- En ejercicio 10, la lista genérica admite distintos tipos de referencia, incluyendo `Integer`, `String` y objetos; la igualdad en búsqueda/eliminación se basa en `Objects.equals`.
- Cada archivo de solución inicia con el comentario `Prompt inicial utilizado:` y contiene al final una breve nota indicando ajustes del prompt o que no hubo.

## Requisitos funcionales por ejercicio

1. **Crear lista simple desde cero:** nodo entero con dato y `next`, `head` nulo en vacío y `size`; métodos `insertarAlInicio`, `insertarAlFinal`, `imprimir`, `estaVacia` y `getSize`. Probar ambas inserciones y lista vacía.
2. **Buscar elementos:** `boolean buscar(int dato)` recorre secuencialmente desde `head` hasta coincidencia o `null`. Explicar que no hay acceso por índice constante como en arreglo. Probar vacío, presente al principio/al final y ausente.
3. **Obtener elemento por posición:** `int obtener(int posicion)` valida antes del recorrido y recorre nodo a nodo. Índices válidos `0..size-1`; fuera de rango lanza `IndexOutOfBoundsException`. Probar primero, medio, último y posiciones inválidas.
4. **Insertar en posición:** `void insertarEnPosicion(int dato, int posicion)` admite inicio, medio y final; valida `0..size`. Para posición interna, preservar referencias en este orden: `nuevo.siguiente = actual.siguiente`, luego `actual.siguiente = nuevo`; actualizar `head` para posición cero y `size` solo tras insertar. Explicar cómo invertir las asignaciones podría perder el resto de la lista. Probar límites y enlaces.
5. **Eliminar por valor:** `boolean eliminar(int dato)` elimina la primera aparición, contemplando vacío, `head`, medio, último y ausencia. No libera manualmente memoria: desvincula el nodo para que el Garbage Collector pueda recuperarlo. Actualizar tamaño.
6. **Eliminar por posición:** `void eliminarEnPosicion(int posicion)` valida `0..size-1`, desvincula el nodo en `head` o hace que el anterior apunte al siguiente del eliminado; actualizar tamaño. Probar primer, medio, último y fuera de rango.
7. **Modificar elemento:** `void modificar(int posicion, int nuevoDato)` valida el índice antes de recorrer; cambia solo el dato del nodo, no su enlace `next`. Probar varias posiciones y errores de rango.
8. **Contar ocurrencias:** `int contarOcurrencias(int dato)` recorre todos los nodos y cuenta coincidencias. No se detiene en la primera. Probar cero, una y múltiples apariciones, incluida lista vacía.
9. **Invertir lista:** `void invertir()` in-place con referencias auxiliares `anterior`, `actual` y `siguiente`, guardando `siguiente` antes de cambiar el enlace. Al final, reasignar `head`. Probar vacío, unitario, dos nodos y varios nodos.
10. **Lista genérica:** implementar `Nodo<T>` y `ListaEnlazada<T>` para distintos tipos. Mantener algoritmos de recorrido/inserción/eliminación independientes del tipo; permitir `ListaEnlazada<Integer>`, `ListaEnlazada<String>` y `ListaEnlazada<Alumno>`. Demostrar inserción, recorrido, búsqueda y eliminación usando igualdad apropiada al tipo.

## Requisitos técnicos y restricciones

- Representar enlaces con nodos propios que contienen dato y referencia al siguiente.
- No usar `ArrayList`, `LinkedList`, `Vector` ni estructuras equivalentes como almacenamiento o sustitución del recorrido enlazado.
- Mantener `head` como referencia al primer nodo; `null` marca fin de lista.
- Actualizar `size` de forma consistente en todas las operaciones mutables.
- Cada implementación documenta propósito, razonamiento de enlaces, entradas, salida, errores y complejidad temporal/espacial con Javadoc.
- `imprimir()` muestra la estructura sin exponer los nodos ni cambiar la lista.
- El código de prueba y las salidas demostrativas están separados de las clases de solución.
- No modificar las unidades previas ni incorporar dependencias.

## Casos límite

- Lista vacía en búsqueda, impresión, inserciones, eliminaciones, conteo e inversión.
- Lista de un nodo.
- Operaciones en head y en el último nodo, incluidos nodos repetidos.
- Índices `-1`, `size` y límites válidos `0`/`size-1`; inserción en `size` es válida.
- Búsqueda y eliminación por valor en listas con duplicados, confirmando que se elimina la primera aparición.
- Conteo completo con varias coincidencias al inicio, centro y final.
- Inversión de cero, uno, dos y varios nodos, verificando `head`, orden y terminación en `null`.
- Lista genérica con enteros, strings y objetos, sin casts en código cliente.

## Criterios de aceptación

- La carpeta contiene README, especificación, diez prompts completos, diez fuentes de solución, una demo y pruebas separadas.
- Cada fuente tiene el prompt inicial en comentario al inicio y la nota de ajustes al final.
- Los métodos cumplen contratos y casos de posición acordados; `size` concuerda con los nodos recorribles desde `head`.
- Se prueban resultados y estados de enlaces después de cada operación relevante, incluidos errores y duplicados.
- Todas las fuentes compilan con `javac --release 21 -Xlint:all`; las pruebas y demos se ejecutan sin dependencias externas.
- README explica compilación, ejecución de la demo y pruebas automatizadas.
