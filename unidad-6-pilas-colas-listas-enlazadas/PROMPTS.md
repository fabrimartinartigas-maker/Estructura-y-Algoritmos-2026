# Prompts para OpenCode — Unidad 6

Cada prompt es independiente y está listo para solicitar a OpenCode una solución de Java 21. El prompt utilizado también queda como comentario inicial del archivo fuente correspondiente.

## Ejercicio 1 — Pila enlazada de enteros

```text
Implementá en Java 21 una pila de enteros usando nodos de una lista enlazada simple propia; no uses arreglos ni colecciones como almacenamiento. El nodo tiene dato y referencia al siguiente, y head representa el tope.
Implementá apilar(int), desapilar(), consultarTope(), estaVacia(), contiene(int) e imprimir(). Apilar y desapilar deben ser O(1); contiene e imprimir recorren la lista en O(n). Al desapilar el último elemento, head debe volver a null.
Si se consulta o desapila una pila vacía, lanzá IllegalStateException, sin centinelas. Documentá propósito, invariante, parámetros, resultados, excepciones y complejidades con Javadoc.
Separá implementación, demostración y pruebas. Probá vacía, un elemento, varios elementos en orden LIFO, búsqueda presente/ausente e impresión.
Incluí este prompt como comentario inicial del fuente y una nota final que indique si se ajustó.
```

## Ejercicio 2 — Cola enlazada de enteros

```text
Implementá en Java 21 una cola FIFO de enteros usando nodos enlazados propios, sin arreglos ni colecciones como almacenamiento. Mantené referencias head y tail: encolar inserta en tail y desencolar retira head, ambas O(1). Explicá qué problema de eficiencia habría si se mantuviera solo head y se debiera recorrer para insertar al final.
Implementá encolar(int), desencolar(), consultarFrente(), estaVacia(), contiene(int) e imprimir(). Si al desencolar se quita el último nodo, asigná null tanto a head como a tail. Las consultas/extracciones de cola vacía lanzan IllegalStateException.
Documentá invariantes, contratos, errores y complejidades con Javadoc. Separá implementación, demo y pruebas; probá vacía, FIFO, búsqueda, impresión y transición a vacía.
Incluí el prompt inicial como comentario y una nota final sobre ajustes.
```

## Ejercicio 3 — Pila genérica enlazada

```text
Implementá en Java 21 una clase genérica Pila<T> respaldada por nodos enlazados propios; no uses Stack, arreglos ni colecciones como almacenamiento. El nodo guarda T y su enlace siguiente; head es el tope.
Ofrecé apilar(T), desapilar(), consultarTope(), estaVacia(), contiene(T) e imprimir(). Las operaciones de tope son O(1); búsqueda e impresión O(n). Usá Objects.equals para buscar y admití null como dato. Consultar o desapilar vacío lanza IllegalStateException.
Explicá con Javadoc qué aportan los genéricos y por qué el algoritmo no depende del tipo. Demostrá Integer, String y un objeto propio. Separá solución, demo y pruebas; comprobá LIFO y búsqueda.
Poné el prompt como comentario inicial del fuente y anotá al final si se ajustó.
```

## Ejercicio 4 — Cola genérica enlazada

```text
Implementá en Java 21 una clase genérica Cola<T> FIFO con nodos enlazados propios, sin Queue, Deque, arreglos ni colecciones como almacenamiento. Mantené head y tail para encolar y desencolar en O(1), y limpiá ambas referencias al quitar el último nodo.
Ofrecé encolar(T), desencolar(), consultarFrente(), estaVacia(), contiene(T) e imprimir(). Usá Objects.equals y admití null como dato. Consultar o desencolar una cola vacía lanza IllegalStateException.
Documentá cómo FIFO se mantiene independientemente del tipo almacenado. Demostrá una cola de nombres y otra de objetos Cliente. Separá implementación, demo y pruebas; verifica orden, búsqueda, consulta no destructiva y transición a vacía.
Incluí el prompt inicial al comienzo del fuente y una nota final sobre los ajustes.
```

## Ejercicio 5 — Historial de navegación

```text
Implementá en Java 21 un historial de navegación con una pila enlazada simple propia (sin Stack, arreglos ni colecciones como almacenamiento). Cada visita apila una URL y la página actual queda en el tope. Explicá por qué LIFO modela volver atrás: primero se abandona la última página visitada para revelar la anterior.
Ofrecé visitar(String), volver(), paginaActual() e imprimirHistorial(). volver quita la página actual y devuelve la anterior; si había solo una página, deja el historial vacío y devuelve Optional.empty(). volver si ya estaba vacío lanza IllegalStateException. paginaActual en vacío devuelve Optional.empty() y no modifica la pila. Rechazá URL null con NullPointerException.
Documentá estado, semántica LIFO, parámetros, resultados, excepciones y complejidad. Separá solución, demo y pruebas; probá vacío, una visita, múltiples retrocesos y retorno a vacío.
Dejá este prompt como comentario inicial y explica al final si fue ajustado.
```

## Ejercicio 6 — Cola de atención de clientes

```text
Implementá en Java 21 una cola FIFO enlazada propia para atender clientes de un banco, sin Queue, Deque, arreglos ni colecciones como almacenamiento. Cada Cliente contiene nombre, número de turno y motivo de consulta.
Ofrecé agregarCliente(Cliente), atenderProximo(), consultarProximo(), estaVacia() e imprimirFila(). Mantené head/tail, encolar al final y retirar del frente en O(1), limpiando ambos extremos al quedar vacía. Consultar/atender vacío lanza IllegalStateException.
Documentá por qué FIFO representa el orden de llegada. Separá implementación, demo y pruebas; prueba vacía, orden de varios clientes, consulta no destructiva y transición a vacía.
Incluí el prompt inicial al principio del fuente y al final indica si hubo ajustes.
```

## Ejercicio 7 — Paréntesis balanceados

```text
Implementá en Java 21 un verificador de paréntesis balanceados con una pila enlazada simple propia; no uses Stack, arreglos ni colecciones como almacenamiento. El método esBalanceada(String) debe apilar cada '(' para recordar las aperturas pendientes y desapilar ante ')'; un cierre sin apertura invalida inmediatamente y al final no deben quedar aperturas. Ignorá todos los demás caracteres.
La cadena vacía y una cadena sin paréntesis son válidas. Rechazá null con NullPointerException. Documentá algoritmo, resultado, error y complejidad O(n) tiempo/O(n) espacio.
Separá código, demo y pruebas. Probá los dos ejemplos válidos e inválidos de la consigna, anidamiento, texto sin paréntesis, cierre extra y apertura sin cerrar.
Incluí este prompt en comentario al inicio del archivo y una nota final sobre ajustes.
```

## Ejercicio 8 — Invertir una palabra con pila

```text
Implementá en Java 21 un método invertir(String) que utilice una pila enlazada propia para apilar y desapilar los caracteres, sin Stack, arreglos ni colecciones como almacenamiento. Explicá que LIFO devuelve primero el último carácter apilado, invirtiendo así el orden. El resultado debe invertir el orden de los puntos de código Unicode, preservando pares sustitutos.
Por ejemplo, "algoritmo" debe producir "omtirogla". La palabra vacía produce una cadena vacía; null se rechaza con NullPointerException. Documentá el razonamiento LIFO, entradas, resultado, error y complejidades O(n) tiempo/O(n) espacio.
Separá implementación de demo y pruebas. Probá vacía, un carácter, ejemplo de la consigna y texto con caracteres suplementarios.
Incluí el prompt inicial como comentario al principio del fuente y una nota final sobre ajustes.
```

## Ejercicio 9 — Cola de impresión

```text
Implementá en Java 21 una cola enlazada FIFO propia para trabajos de impresión, sin Queue, Deque, arreglos ni colecciones como almacenamiento. Cada TrabajoImpresion guarda nombre de archivo, cantidad de páginas y usuario. Explicá que FIFO hace que el trabajo enviado primero sea el siguiente en imprimirse y conserva el orden de llegada.
Ofrecé agregarTrabajo(TrabajoImpresion), imprimirProximo(), consultarProximoArchivo(), trabajosPendientes(), y estaVacia(). Encolar al tail y procesar desde head en O(1); al vaciar, head y tail vuelven a null. Consultar o procesar sin trabajos lanza IllegalStateException.
Representá los pendientes en orden FIFO sin exponer ni sustituir el almacenamiento enlazado. Documentá campos, contratos, errores y complejidad. Separá solución, demo y pruebas; prueba vacío, varios trabajos, consulta no destructiva y orden procesado.
Incluí el prompt al comienzo del fuente y una nota final de ajustes.
```

## Ejercicio 10 — Lista doblemente enlazada genérica

```text
Implementá en Java 21 una ListaDobleEnlazada<T> genérica con nodos propios que tengan dato, anterior y siguiente; no uses LinkedList, arreglos ni colecciones como almacenamiento. Explicá que el enlace anterior permite recorrer hacia atrás y actualizar el vecino previo al eliminar, mientras siguiente permite avanzar y enlazar el próximo nodo. Mantené head y tail.
Ofrecé insertarAlInicio(T), insertarAlFinal(T), eliminar(T), imprimirAdelante(), imprimirAtras() y estaVacia(). eliminar debe quitar solo la primera coincidencia según Objects.equals y devolver boolean. Cubrí correctamente lista vacía, único nodo, head, tail y nodo intermedio. Mantén head.anterior == null y tail.siguiente == null; enlaces vecinos deben ser recíprocos. Inserciones en extremos y eliminación al encontrar nodo son O(1), búsqueda necesaria O(n), recorridos O(n).
Admití datos null. Documentá estructura, invariantes, enlaces, contratos, resultados y complejidad. Separá solución, demo y pruebas; probá recorridos en ambas direcciones y cada caso de eliminación, incluidos duplicado y valor ausente.
Incluí el prompt como comentario inicial del fuente y una nota final sobre ajustes.
```
