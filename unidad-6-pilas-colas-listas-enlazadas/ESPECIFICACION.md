# Especificación — Unidad 6: Pilas y Colas con Listas Enlazadas

## Objetivo

Resolver los diez ejercicios de la consigna `Pilas y colas con listas enlazadas` con implementaciones independientes en Java 21. La unidad practica pilas y colas construidas sobre nodos enlazados, genéricos, simuladores y una lista doblemente enlazada genérica.

## Alcance y decisiones

- Se organiza como Unidad 6, continuación de las Unidades 1–5.
- Lenguaje: Java 21. La consigna indica Java y OpenCode; se mantiene la versión Java 21 de las guías previas.
- Cada ejercicio tiene una solución autocontenida bajo `reso/ejercicioNN/`. La carpeta `reso/` respeta el nombre solicitado; no se modifica la organización de las guías anteriores.
- README, especificación, prompts, ejemplos y pruebas se mantienen separados de las implementaciones.
- Las soluciones usan nodos enlazados propios. No usan `Stack`, `Queue`, `Deque`, `LinkedList`, arreglos ni colecciones como almacenamiento de la estructura estudiada.
- Las operaciones que requieren un elemento de una estructura vacía lanzan `IllegalStateException`; no devuelven valores centinela.
- Las comparaciones por valor usan `Objects.equals`. En operaciones de eliminación por valor se elimina la primera coincidencia.
- Para el ejercicio 10, el usuario confirmó eliminación por valor de la primera coincidencia.
- En el historial, las páginas visitadas se apilan con la página actual en el tope. Volver quita la actual y devuelve la página anterior; si solo había una página, deja el historial vacío y devuelve `Optional.empty()`. Volver con el historial ya vacío lanza `IllegalStateException`.
- Una consulta de frente/tope o página actual no modifica la estructura.
- Cada fuente documenta el prompt inicial como comentario y aclara al final si necesitó ajustes.

## Requisitos funcionales por ejercicio

1. **Pila enlazada de enteros:** implementar `push`, `pop`, `peek`, `isEmpty`, búsqueda por valor e impresión. `head` representa el tope; agregar y quitar el tope se resuelven en O(1). Búsqueda e impresión recorren desde `head`.
2. **Cola enlazada de enteros:** implementar `enqueue`, `dequeue`, consulta del frente, `isEmpty`, búsqueda e impresión. Mantener referencias `head` y `tail`; insertar al final y quitar del inicio en O(1). Al retirar el último nodo, dejar ambas referencias en `null`.
3. **Pila genérica:** implementar una pila enlazada `Pila<T>` con las operaciones esenciales de pila. Demostrar `Integer`, `String` y un tipo de objeto propio; la lógica no depende del tipo almacenado.
4. **Cola genérica:** implementar una cola enlazada `Cola<T>` con operaciones FIFO. Demostrar nombres de personas y objetos `Cliente`, manteniendo `head`/`tail` y la independencia respecto del tipo.
5. **Historial de navegación:** permitir visitar una página, volver a la anterior, consultar la página actual e imprimir el historial usando una pila enlazada. Mantener la semántica de páginas actual/anterior definida en “Alcance y decisiones”.
6. **Cola de atención de clientes:** cada cliente contiene nombre, número de turno y motivo. Permitir agregar, atender al próximo, consultar quién sigue e imprimir la fila en orden de llegada.
7. **Paréntesis balanceados:** recibir una expresión y decidir si los paréntesis `(` y `)` están balanceados usando una pila enlazada. Un cierre sin apertura invalida inmediatamente; al finalizar no deben quedar aperturas. Los demás caracteres se ignoran.
8. **Invertir palabra con pila:** recibir una palabra, apilar sus caracteres y producirlos en orden inverso al desapilar. Ejemplo contractual: `algoritmo` produce `omtirogla`.
9. **Cola de impresión:** cada trabajo contiene nombre de archivo, cantidad de páginas y usuario. Permitir agregar, procesar el próximo trabajo, consultar el próximo archivo y mostrar los pendientes en FIFO.
10. **Lista doblemente enlazada genérica:** implementar una lista genérica cuyos nodos tienen referencias `anterior` y `siguiente`. Permitir insertar al inicio y al final, eliminar la primera coincidencia por valor e imprimir hacia adelante y hacia atrás. Mantener correctamente `head`, `tail` y los enlaces de los extremos.

## Requisitos técnicos y restricciones

- Cada solución es independiente y contiene los nodos necesarios, evitando depender de las clases de otros ejercicios.
- Mantener los invariantes de cada estructura:
  - Pila: `head` es el tope; `head == null` representa vacío.
  - Cola: `head == null` si y solo si `tail == null`; `tail.next == null` cuando no está vacía.
  - Lista doble: los enlaces externos cumplen `head.anterior == null` y `tail.siguiente == null`; enlaces vecinos son recíprocos.
- Para nodos genéricos usar tipos parametrizados, sin tipos crudos ni conversiones requeridas por el cliente.
- Si se admite `null` como dato, búsqueda/eliminación debe comparar con `Objects.equals`; no se exige excluirlo.
- No liberar memoria manualmente: al retirar un elemento se desvincula el nodo y se deja que el Garbage Collector lo recupere.
- Métodos públicos con Javadoc que describa propósito, parámetros, resultado, errores y complejidad temporal/espacial pertinente.
- Demos reproducibles y pruebas sin dependencias externas, en directorios separados de `reso/`.
- El README debe incluir compilación, ejecución de demostraciones y pruebas con JDK 21.
- No modificar las Unidades 1–5 ni agregar dependencias.

## Casos límite que deben probarse

- Pila y cola vacías; consulta o extracción de vacío; transiciones vacío → un elemento → vacío.
- Capacidad no aplica: las estructuras son enlazadas y no tienen límite fijo artificial.
- Pila con un elemento y varios: orden LIFO, búsqueda presente/ausente y salida de impresión.
- Cola con un elemento y varios: orden FIFO, búsqueda presente/ausente, consulta sin extracción y limpieza de `tail` al quedar vacía.
- Genéricos con enteros, strings y objetos propios; igualdad por valor/`equals`.
- Historial vacío, una única visita, varias visitas y varios retrocesos.
- Paréntesis: expresión vacía, sin paréntesis, anidamiento válido, cierre extra y aperturas sin cerrar.
- Inversión de palabra vacía, un carácter y varios caracteres; la entrada original no debe modificarse.
- Clientes y trabajos: preservación de orden, consulta del siguiente sin quitarlo y cola vacía.
- Lista doble: inserción en lista vacía, un nodo y varios; eliminación de head, tail, nodo intermedio, duplicados y valor ausente; recorrido en ambos sentidos después de cada cambio.

## Criterios de aceptación

- La carpeta de la Unidad 6 incluye `README.md`, `ESPECIFICACION.md`, `PROMPTS.md`, las diez soluciones bajo `reso/`, una demostración separada y pruebas independientes.
- Hay un prompt completo de OpenCode por ejercicio y cada solución conserva ese prompt en comentario inicial.
- Se cumplen los contratos e invariantes descritos; especialmente O(1) para push/pop de pila y enqueue/dequeue de cola al mantener los extremos.
- Las pruebas verifican tanto resultados como orden y enlaces en los casos límite relevantes.
- Todo compila con `javac --release 21 -Xlint:all`; la demostración y todas las pruebas se ejecutan correctamente sin dependencias externas.
- El README permite repetir la compilación, las demostraciones y las pruebas siguiendo sus instrucciones.
