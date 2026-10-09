# Especificación — Unidad 4: Pilas y Colas con Arreglos

## Objetivo

Implementar diez ejercicios didácticos de pilas y colas basadas en arreglos usando Java 21 y OpenCode. Cada ejercicio debe incluir un prompt razonado, una solución independiente con el prompt inicial en comentario, una demostración separada y pruebas representativas.

## Alcance y decisiones acordadas

- La guía se ubica en su propia carpeta, como Unidad 4, separada de las anteriores.
- Lenguaje: Java 21, sin dependencias externas.
- Cada ejercicio tiene una solución autónoma bajo `reso/ejercicioNN/`; las salidas de demostración y las verificaciones automatizadas se guardan fuera de `reso/`.
- Las capacidades de pilas y colas basadas en arreglo son fijas por instancia y se reciben al construir la estructura. Se rechazan capacidades no positivas con `IllegalArgumentException`.
- En desbordamiento o subdesbordamiento de una estructura, los métodos de inserción/extracción/consulta lanzan `IllegalStateException`. `isEmpty`, `isFull` y `size` consultan el estado.
- La pila genérica usa un arreglo interno de `Object` con conversión encapsulada en la clase, sin API no tipada para los clientes.
- Cola simple mantiene índices lineales: las posiciones previas a `front` no se reutilizan; esta limitación es parte intencional del ejercicio 9. Cola circular usa módulo y reutiliza esas posiciones.
- Para torres de platos se usan etiquetas `String`; historial almacena URLs; cola de turnos almacena nombres; cola de impresión almacena documentos con nombre y páginas.
- Los simuladores ofrecen operaciones de estructura como métodos invocables; las demostraciones usan secuencias acotadas y reproducibles, sin requerir interacción por consola.
- En historial, volver después de una única visita retira la página actual, deja el historial vacío y devuelve `Optional.empty()` porque ya no hay página anterior; intentar volver si el historial ya estaba vacío es un error.
- Los sistemas de turnos y de impresión, al igual que la cola del ejercicio 6, usan cola lineal simple con arreglo y no reutilizan posiciones previas a `front`. La cola circular se implementa específicamente en el ejercicio 10.
- Cada archivo de solución comienza con el prompt inicial utilizado. Los archivos indican al final si el prompt se mantuvo o qué ajuste se hizo y por qué.

## Requisitos funcionales por ejercicio

1. **Pila de enteros:** clase `PilaEnteros` con arreglo fijo de capacidad configurable y `top` inicializado para representar vacío; métodos `push`, `pop`, `peek`, `isEmpty`, `isFull` y `size`. Mostrar el comportamiento LIFO y los límites de pila llena/vacía.
2. **Torre de platos:** agregar plato, retirar el superior y consultar el superior usando pila de etiquetas. Explicar por qué el acceso LIFO corresponde a agregar/retirar por arriba y no a una cola. Probar operaciones vacía y llena, además del orden de apilado.
3. **Paréntesis balanceados:** recibir una expresión y determinar balance de `(` y `)` usando una pila de posiciones/caracteres abiertos. Rechazar al encontrar cierre sin apertura, y al final aceptar solo si no quedan aperturas. Otros caracteres se ignoran. Probar expresión vacía, anidamiento correcto, cierre extra y apertura sin cerrar.
4. **Historial de navegación:** apilar URL visitadas y permitir volver con `pop`; consultar página actual y manejar historial vacío explícitamente. Si se vuelve desde la única página, retirarla y devolver `Optional.empty()`. Aplicar LIFO. Probar secuencia de visitas y retorno.
5. **Pila genérica:** clase `Pila<T>` implementada con arreglo, con operaciones estándar de pila y capacidad fija configurable. Demostrar uso con `Integer`, `String` y un objeto simple; explicar seguridad de tipos/genéricos frente a una pila solo de `int`.
6. **Cola simple de enteros:** arreglo de capacidad fija con índices `front` y `rear`; métodos `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull` y `size`. `rear` avanza al insertar y `front` al retirar. No compactar ni circularizar la cola.
7. **Turnos de atención:** agregar personas a cola lineal FIFO, atender la siguiente y consultar quién sigue. Mostrar FIFO y distinguirlo de LIFO. Probar vacío, una persona, orden de múltiples turnos y límite de capacidad.
8. **Cola de impresión:** cola lineal FIFO de documentos con nombre y cantidad de páginas; procesarlos en el mismo orden agregado. Mostrar trabajos pendientes y orden de impresión. Probar vacía, un trabajo, varios trabajos y capacidad llena.
9. **Desperdicio en cola simple:** implementar cola lineal basada en arreglo y exponer una representación de diagnóstico para la demostración. Secuencia de operaciones debe avanzar `front`, dejar espacios vacíos al inicio y mostrar que `rear` al final impide agregar, aunque queden posiciones iniciales libres.
10. **Cola circular:** arreglo con índices `front` y `rear` que avanzan por módulo; reutilizar celdas liberadas. Detectar vacío y lleno inequívocamente mediante un contador de elementos (o una convención equivalente documentada). Probar wrap-around, lleno, vacío y reutilización.

## Requisitos técnicos y restricciones

- Usar estructuras implementadas con arreglos, no reemplazarlas por `Stack`, `Queue`, `Deque`, `ArrayList` u otra colección dinámica de Java.
- Las clases de cada ejercicio son independientes y exponen operaciones documentadas y testeables.
- Los simuladores y demos usan las estructuras implementadas en la solución del ejercicio correspondiente.
- Cada clase debe documentar propósito, operaciones, razonamiento de índices, parámetros, valores devueltos, errores y complejidad temporal/espacial cuando corresponda.
- Cada fuente incluye el prompt inicial utilizado y una nota al final que indique si fue necesario ajustarlo.
- Los ejemplos y pruebas no deben mezclarse con la implementación de las estructuras.
- No modificar las unidades previas ni agregar dependencias.

## Casos límite

- Capacidad cero y negativa rechazada; capacidad uno.
- `push`/`enqueue` en estructura llena y `pop`/`peek`/`dequeue`/`front` vacía.
- Transiciones vacío → un elemento → lleno → parcial → vacío.
- Pila: orden LIFO, elemento superior, limpieza del slot al extraer.
- Paréntesis: expresión vacía, varios niveles, cierres extra, aperturas pendientes y texto sin paréntesis.
- Cola simple: front/rear convergen al consumir, rear alcanza el fin y quedan celdas iniciales libres no reutilizables.
- Cola circular: front/rear dan la vuelta, llega a lleno tras wrap-around, elimina y reutiliza una celda.
- Simuladores: conservar orden LIFO/FIFO incluso para más de un elemento; historial de una sola página al volver.

## Criterios de aceptación

- La carpeta contiene README, especificación, diez prompts independientes, diez soluciones Java, demos separadas y pruebas.
- Las operaciones requeridas y sus resultados cumplen las políticas de capacidad y errores acordadas.
- El ejercicio 9 demuestra de manera observable que la cola lineal no reutiliza posiciones del prefijo; el ejercicio 10 sí las reutiliza con aritmética modular.
- Los casos límite anteriores están cubiertos por pruebas con expectativas concretas.
- Fuentes, pruebas y demostraciones compilan con `javac --release 21`; todas las pruebas pasan sin dependencias.
- README indica cómo compilar, ejecutar demos y correr las pruebas.
