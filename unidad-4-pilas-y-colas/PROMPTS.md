# Prompts para OpenCode — Unidad 4: Pilas y Colas con Arreglos

Cada bloque es un prompt independiente para OpenCode. La implementación solicitada debe ser Java 21, usar arreglos y no depender de colecciones que reemplacen la estructura estudiada.

## Ejercicio 1 — Pila de enteros

```text
Implementá en Java 21 una clase PilaEnteros usando un arreglo de tamaño fijo recibido como capacidad en el constructor.
Debe tener push, pop, peek, isEmpty, isFull y size. Mantené top como índice del elemento superior; inicializalo en -1 para representar pila vacía. Al insertar, incrementá top; al quitar, devolvé el elemento y decrementalo.
Rechazá capacidad menor o igual a cero con IllegalArgumentException. push cuando esté llena y pop/peek cuando esté vacía deben lanzar IllegalStateException; no devuelvas centinelas.
Explicá LIFO y cómo top cambia. Documentá propósito, invariantes, parámetros, resultados, excepciones y complejidad O(1) de las operaciones con Javadoc.
Separá la clase de los ejemplos y pruebas. Probá capacidad 1, vacía, llena, insertar/quitar, y el orden LIFO.
Al comienzo del .java agregá este prompt como comentario; al final indicá si lo ajustaste y por qué.
```

## Ejercicio 2 — Simulador de torre de platos

```text
Implementá en Java 21 un simulador de torre de platos representando cada plato con una etiqueta String y usando una pila respaldada por arreglo fijo con capacidad configurable.
Permite agregar un plato, retirar el superior y consultar cuál está arriba. Muestra el orden de las operaciones.
Explicá por qué la pila es correcta: los platos se agregan y retiran por arriba, por lo que el último agregado es el primero que sale (LIFO); una cola impondría FIFO y no modelaría el acceso superior.
Rechazá capacidad no positiva con IllegalArgumentException y las operaciones de insertar en lleno o retirar/consultar vacío con IllegalStateException.
Documentá clase, operaciones, errores y complejidades; no uses Stack, Deque ni colecciones dinámicas para almacenar los platos. Separa solución, demo y pruebas.
Probá torre vacía, agregar varios platos, consultar y retirar en orden inverso, y capacidad llena.
Incluí el prompt inicial como comentario al comienzo del archivo y una nota final sobre si fue modificado.
```

## Ejercicio 3 — Validar paréntesis balanceados

```text
Implementá en Java 21 un validador que reciba una expresión String y determine si sus paréntesis '(' y ')' están balanceados, usando una pila implementada con arreglo.
Al encontrar '(', apilalo. Al encontrar ')', si la pila está vacía devuelve inválido; si no, hace pop. Al terminar, la expresión es válida solo si la pila está vacía. Ignorá todos los caracteres que no sean paréntesis.
La capacidad del arreglo de la pila debe bastar para los caracteres de entrada. Documentá propósito, algoritmo, entradas, resultado y complejidad O(n) tiempo/O(n) espacio. La cadena vacía y una cadena sin paréntesis son válidas.
Separá el validador de ejemplos y pruebas. Incluí "(5 + 3) * (2 + 1)" como válido y "(5 + 3)) * (2 + 1" como inválido, además de anidamiento, cierre extra y apertura pendiente.
Poné este prompt inicial en comentario al principio del .java y al final anotá si necesitaste ajustarlo.
```

## Ejercicio 4 — Historial de navegación

```text
Implementá en Java 21 un simulador simple de historial de navegación que almacene URLs en una pila implementada con arreglo de capacidad fija configurable.
Cada visita apila la URL. La operación volver quita con pop la página actual y deja como actual la página anterior; permití consultar la página actual sin quitarla.
Explicá por qué el historial sigue LIFO: la última página visitada es la primera de la que se vuelve. Si volver retira la única página, deja el historial vacío y devuelve Optional.empty() porque no hay página anterior; si ya estaba vacío al iniciar volver, lanza IllegalStateException.
Capacidad no positiva: IllegalArgumentException. Visitar con pila llena o consultar sin página actual: IllegalStateException.
Documentá contratos, cambios de estado y complejidades; separá la clase de la demo y pruebas. Probá varias visitas y dos retornos consecutivos, así como historial vacío y capacidad llena.
Incluí el prompt inicial en un comentario al comienzo del fuente y al final una nota sobre ajustes (o que no hubo).
```

## Ejercicio 5 — Pila genérica

```text
Implementá en Java 21 una clase genérica Pila<T> respaldada por un arreglo de capacidad fija configurable. Debe ofrecer push, pop, peek, isEmpty, isFull y size.
Usá un arreglo interno de Object y encapsulá la conversión a T dentro de la clase; los clientes no deben necesitar casts ni usar tipos crudos. Limpia el espacio liberado al hacer pop.
Rechazá capacidad no positiva con IllegalArgumentException. push en pila llena y pop/peek en vacía lanzan IllegalStateException.
Explicá qué resuelven los genéricos: una sola implementación reutilizable conserva comprobación de tipos para Integer, String u objetos simples, a diferencia de una pila solo de int. Documentá invariantes, errores y complejidad O(1).
No uses Stack ni colecciones para el almacenamiento. Separá implementación, ejemplo y pruebas. Demostrá Integer, String y un objeto simple; prueba límites y LIFO.
Comenta el prompt inicial al inicio del .java y explica al final si el prompt requirió ajustes.
```

## Ejercicio 6 — Cola simple de enteros

```text
Implementá en Java 21 una clase ColaEnteros con arreglo fijo de capacidad recibida en el constructor. Debe ofrecer enqueue, dequeue, front, isEmpty, isFull y size.
Mantén índices front y rear lineales: rear avanza al agregar, front al quitar. No uses módulo ni reutilices celdas anteriores a front; esta cola simple debe distinguirse de una circular.
Rechazá capacidad no positiva con IllegalArgumentException. enqueue llena y dequeue/front vacía lanzan IllegalStateException. Documentá los valores iniciales de índices, transiciones, resultados y complejidad.
Separá estructura, demo y pruebas. Valida FIFO, estado vacío/lleno, capacidad 1 y transiciones de tamaño.
Comenta el prompt inicial al principio del fuente y agrega al final una nota breve indicando si fue modificado.
```

## Ejercicio 7 — Sistema de turnos

```text
Implementá en Java 21 un sistema de turnos para una oficina usando una cola FIFO lineal basada en arreglo fijo y de capacidad configurable. Cada turno contiene el nombre de una persona.
Debe agregar una persona, atender (quitar) a la siguiente y consultar quién está primero sin retirarlo. Explicá que quien llega primero se atiende primero (FIFO), a diferencia de LIFO en una pila.
Usá índices front y rear lineales que avancen hacia adelante, sin módulo ni reutilización de posiciones anteriores a front. No uses Queue, Deque ni colecciones dinámicas para guardar turnos. Capacidad no positiva produce IllegalArgumentException; agregar cuando rear alcanzó el final o atender/consultar vacío produce IllegalStateException.
Documentá operaciones, estado e invariantes con Javadoc y sus complejidades. Separa estructura, demostración y pruebas.
Probá cola vacía, una persona, varias llegadas y atenciones en el mismo orden, y capacidad llena.
Incluí el prompt inicial como comentario al comienzo del .java e indica al final si fue ajustado.
```

## Ejercicio 8 — Cola de impresión

```text
Implementá en Java 21 una cola de impresión FIFO lineal usando un arreglo fijo de capacidad configurable. Cada documento tiene un nombre y una cantidad positiva de páginas.
Permite agregar documentos y procesar el siguiente. Los documentos deben procesarse exactamente en el orden agregado. Muestra qué documento se imprime y cuántas páginas tiene.
Mantén front y rear avanzando linealmente; no reutilices posiciones anteriores a front. No uses Queue, Deque ni colecciones para sustituir el arreglo. Capacidad no positiva: IllegalArgumentException; agregar cuando rear alcanzó el final o procesar/consultar vacío: IllegalStateException.
Documentá la estructura del documento, operaciones, invariantes, errores y complejidad. Separa implementación, demo y pruebas.
Prueba cola vacía, un documento, varios documentos para confirmar FIFO, capacidad llena y rechazo de páginas no positivas.
Escribe el prompt inicial como comentario inicial del .java y una nota al final sobre cambios del prompt.
```

## Ejercicio 9 — Desperdicio de espacio en cola simple

```text
Implementá en Java 21 una cola lineal simple con arreglo fijo y capacidad configurable que permita observar el desperdicio de espacio. Mantén front y rear como índices que avanzan solo hacia adelante; no compactes y no uses módulo.
Prepara una demostración reproducible: con capacidad 5 encola A, B, C; desencola dos elementos; luego encola D y E. Muestra el arreglo físico, front, rear, size y isFull tras cada operación relevante. Aun quedan celdas libres al inicio, pero al llegar rear al final la siguiente inserción debe indicar cola llena.
Implementa enqueue, dequeue, front, isEmpty, isFull y size. Capacidad no positiva: IllegalArgumentException; insertar lleno y consultar/quitar vacío: IllegalStateException.
Explica que el espacio inicial liberado no puede reutilizarse en esta cola simple y contrástalo conceptualmente con una circular sin implementarla aquí. Documenta la representación y complejidad.
Separa clase, demo y pruebas; prueba la secuencia exacta, FIFO, estados vacíos/llenos y capacidad 1. Incluye prompt inicial en comentario al inicio y nota final sobre ajustes.
```

## Ejercicio 10 — Cola circular

```text
Implementá en Java 21 una cola circular de enteros usando un arreglo de capacidad fija configurable. Ofrece enqueue, dequeue, front, isEmpty, isFull y size.
Haz avanzar front y rear circularmente usando módulo: índice = (índice + 1) % capacidad. Lleva un contador de elementos para distinguir sin ambigüedad cola vacía y llena. Reutiliza los espacios liberados al inicio.
Capacidad no positiva: IllegalArgumentException. enqueue llena y dequeue/front vacía: IllegalStateException. Documentá índices iniciales, contador, transiciones, invariantes, errores y complejidad O(1).
No uses Queue, Deque ni colecciones dinámicas para almacenar elementos. Separa implementación, demo y pruebas.
Probá capacidad 1, vacío, lleno, wrap-around, dequeue seguido de enqueue para reutilizar espacio y orden FIFO tras varias vueltas.
Incluí el prompt inicial al comienzo del .java y al final informa si hubo ajustes.
```
