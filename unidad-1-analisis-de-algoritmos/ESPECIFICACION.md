# Especificación — Unidad 1: Análisis de Algoritmos

## Objetivo

Desarrollar diez ejercicios en Java 21 sobre vectores y matrices, incluyendo prompts completos para OpenCode, soluciones separadas, ejemplos de ejecución y pruebas; documentar las estrategias y complejidades algorítmicas.

## Alcance y decisiones

- La guía incluye diez prompts y una solución Java por ejercicio bajo `reso/ejercicioNN/`; los ejercicios 4 y 7 contienen dos implementaciones alternativas.
- Lenguaje: Java 21, sin dependencias externas.
- Ejemplos ejecutables y pruebas automatizadas se mantienen fuera de `reso/`.
- En el ejercicio 8, el contador registra únicamente las sumas ejecutadas al acumular los elementos; esta definición fue confirmada por el usuario.
- Las soluciones aceptan arreglos no nulos. Los métodos que reciben un arreglo o matriz rechazan referencias nulas con `NullPointerException`.
- Las matrices se procesan por sus filas y pueden ser irregulares; una fila nula se rechaza con `NullPointerException`. Una matriz sin filas o con todas sus filas vacías no contiene elementos.
- El código de cada ejercicio incluye el prompt inicial como comentario y una nota final que declara los ajustes realizados.

## Requisitos funcionales por ejercicio

1. **Encontrar el mínimo de un vector:** solicitar una pasada lineal, explicar por qué no hace falta ordenar y pedir las complejidades temporal y espacial. Incluir el caso vacío, donde no existe mínimo, sin aceptar un valor centinela como resultado válido.
2. **Buscar en un vector desordenado:** solicitar búsqueda lineal e informar cuántas posiciones se inspeccionan, tanto al encontrar el elemento como al determinar que no existe. Analizar mejor, peor y caso promedio.
3. **Buscar en un vector ordenado:** solicitar búsqueda binaria, explicar su ventaja frente a la lineal para datos ordenados y documentar la complejidad. Mostrar la evolución de los límites y del punto medio en cada iteración, incluido el resultado.
4. **Detectar duplicados:** solicitar dos implementaciones: comparación con ciclos anidados y uso de `HashSet`. Comparar tiempo y espacio; incluir vectores vacío, unitario, sin duplicados y con duplicado.
5. **Contar ocurrencias:** recorrer completamente el vector para contar todas las apariciones del valor solicitado y justificar por qué no se puede detener la búsqueda al encontrar una coincidencia. Analizar tiempo y espacio.
6. **Comparar dos vectores:** determinar igualdad y terminar apenas se encuentre una diferencia. Considerar longitudes distintas, vectores iguales y diferencias en distintas posiciones; analizar mejor, peor y caso promedio, indicando las condiciones del análisis.
7. **Invertir un vector:** implementar una versión con vector auxiliar y otra in-place sin memoria adicional significativa. Comparar ventajas, desventajas y complejidad temporal y espacial; probar también longitudes cero, uno y par/impar.
8. **Sumar una matriz:** recorrer filas y elementos para sumar todo el contenido y contabilizar únicamente las sumas realizadas por el acumulador. Analizar complejidad e incluir matriz vacía, rectangular e irregular.
9. **Encontrar el máximo de una matriz:** recorrer sus elementos, justificar por qué hace falta inspeccionarlos todos y analizar complejidad temporal y espacial. Incluir matrices rectangulares e irregulares y el caso sin elementos, que no tiene máximo.
10. **Ordenamiento burbuja:** solicitar Bubble Sort, explicar que su uso se justifica principalmente con fines didácticos o conjuntos pequeños y contabilizar comparaciones e intercambios. Probar entradas vacías, unitarias, ordenadas, inversas y con valores repetidos.

## Requisitos de implementación

- **Ejercicio 1:** `OptionalInt` representa que un vector vacío no tiene mínimo; no se usan centinelas.
- **Ejercicio 2:** el resultado incluye `OptionalInt` para el índice y la cantidad de posiciones realmente inspeccionadas; ante duplicados informa la primera posición.
- **Ejercicio 3:** búsqueda binaria iterativa con límites inclusivos y punto medio calculado sin sumar directamente ambos índices. Imprime una traza por iteración y la conclusión; el vector ordenado ascendentemente es precondición.
- **Ejercicio 4:** archivos/clases separadas para ciclos anidados y `HashSet`; ambos permiten terminar al encontrar el primer duplicado.
- **Ejercicio 5:** recorre todo el vector y devuelve el total de ocurrencias.
- **Ejercicio 6:** primero compara longitudes; de ser iguales, termina ante la primera diferencia.
- **Ejercicio 7:** método con auxiliar no modifica el original; método in-place modifica el recibido.
- **Ejercicio 8:** recorre todas las filas y elementos. El resultado contiene suma `long` y cantidad de operaciones `acumulador += elemento`; esta cantidad es el total de elementos. Filas de distintas longitudes son válidas; matriz sin elementos suma cero.
- **Ejercicio 9:** recorre cada elemento para calcular el máximo; `OptionalInt.empty()` representa una matriz sin elementos.
- **Ejercicio 10:** Bubble Sort modifica el vector recibido y devuelve métricas separadas. No usa optimización de salida anticipada: compara adyacentes en cada pasada necesaria y cuenta solo intercambios realizados.

## Requisitos técnicos y restricciones

- Usar Java 21, sin bibliotecas de terceros.
- Cada prompt debe pedir código comentado y documentación Java apropiada (por ejemplo, Javadoc) que describa propósito, estrategia, entradas, resultados, errores o límites relevantes y complejidades cuando correspondan.
- Mantener las soluciones algorítmicas separadas de los ejemplos de ejecución y pruebas.
- No introducir funcionalidades que no sean necesarias para el enunciado.
- Explicar en el código o en la salida de demostración los contadores requeridos, sin alterar el algoritmo que se analiza.
- Cuando el enunciado no define el comportamiento ante entradas para las que el resultado matemático no existe (por ejemplo, un vector vacío al buscar un mínimo), el prompt debe exigir que la implementación documente explícitamente esa situación y no invente un resultado numérico.

## Casos límite transversales

- Vectores vacíos o de un solo elemento cuando el ejercicio los admite.
- Elemento buscado al inicio, al final o ausente.
- Valores repetidos, incluyendo duplicados adyacentes y no adyacentes.
- Longitudes distintas y diferencias tempranas o tardías al comparar.
- Matrices sin filas, con filas vacías, de una fila/columna, rectangulares e irregulares; las filas null se rechazan.
- Entradas ya ordenadas, en orden inverso y con repetidos para Bubble Sort.
- Para cada caso, mostrar entradas y resultado esperado, separando esos ejemplos del código del algoritmo.

## Criterios de aceptación

- La carpeta de esta unidad contiene README, especificación y un documento separado de prompts, sin modificar las guías existentes.
- La carpeta contiene soluciones en `reso/`, ejemplos separados y pruebas independientes.
- `PROMPTS.md` contiene exactamente diez prompts, uno por ejercicio, utilizables independientemente y alineados con todos los requisitos enumerados arriba.
- Los análisis de complejidad corresponden a las estrategias solicitadas y hacen explícitas las condiciones necesarias para hablar del caso promedio.
- Los contadores solicitados miden exactamente las operaciones indicadas por la consigna; en el ejercicio 8 se cuentan solo las sumas de acumulación.
- README explica cómo usar los prompts y cómo compilar, ejecutar y probar las soluciones locales con Java 21.
