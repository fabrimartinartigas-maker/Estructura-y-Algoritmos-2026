# Especificación — Unidad 1: Análisis de Algoritmos

## Objetivo

Construir diez prompts completos en español, listos para usar en OpenCode, que soliciten la implementación en Java de algoritmos básicos sobre vectores y matrices, junto con la justificación de las estrategias y el análisis de complejidad exigido en cada ejercicio.

## Alcance y decisiones

- El entregable de cada ejercicio es el prompt para OpenCode. No se incluyen las soluciones Java generadas por esos prompts.
- Se establece Java 21 como versión objetivo, a elección del usuario, quien indicó que podía seleccionarse cualquier versión.
- Los prompts solicitan soluciones autocontenidas, sin dependencias externas, y que separen la implementación de los ejemplos de ejecución y los casos de prueba.
- En el ejercicio 8, el contador registra únicamente las sumas ejecutadas al acumular los elementos; esta definición fue confirmada por el usuario.
- No se agregan cambios a otras guías ni se requiere crear una carpeta `src/`, porque esta consigna pide elaborar prompts, no implementar los diez algoritmos en el repositorio.

## Requisitos funcionales por ejercicio

1. **Encontrar el mínimo de un vector:** solicitar una pasada lineal, explicar por qué no hace falta ordenar y pedir las complejidades temporal y espacial. Incluir el caso vacío, donde no existe mínimo, sin aceptar un valor centinela como resultado válido.
2. **Buscar en un vector desordenado:** solicitar búsqueda lineal e informar cuántas posiciones se inspeccionan, tanto al encontrar el elemento como al determinar que no existe. Analizar mejor, peor y caso promedio.
3. **Buscar en un vector ordenado:** solicitar búsqueda binaria, explicar su ventaja frente a la lineal para datos ordenados y documentar la complejidad. Mostrar la evolución de los límites y del punto medio en cada iteración, incluido el resultado.
4. **Detectar duplicados:** solicitar dos implementaciones: comparación con ciclos anidados y uso de `HashSet`. Comparar tiempo y espacio; incluir vectores vacío, unitario, sin duplicados y con duplicado.
5. **Contar ocurrencias:** recorrer completamente el vector para contar todas las apariciones del valor solicitado y justificar por qué no se puede detener la búsqueda al encontrar una coincidencia. Analizar tiempo y espacio.
6. **Comparar dos vectores:** determinar igualdad y terminar apenas se encuentre una diferencia. Considerar longitudes distintas, vectores iguales y diferencias en distintas posiciones; analizar mejor, peor y caso promedio, indicando las condiciones del análisis.
7. **Invertir un vector:** implementar una versión con vector auxiliar y otra in-place sin memoria adicional significativa. Comparar ventajas, desventajas y complejidad temporal y espacial; probar también longitudes cero, uno y par/impar.
8. **Sumar una matriz:** recorrer filas y columnas para sumar todos los elementos y contabilizar únicamente las sumas realizadas por el acumulador. Analizar complejidad e incluir matriz vacía y matrices con dimensiones representativas.
9. **Encontrar el máximo de una matriz:** recorrer sus elementos, justificar por qué hace falta inspeccionarlos todos y analizar complejidad temporal y espacial. Incluir el caso sin elementos, que no tiene máximo.
10. **Ordenamiento burbuja:** solicitar Bubble Sort, explicar que su uso se justifica principalmente con fines didácticos o conjuntos pequeños y contabilizar comparaciones e intercambios. Probar entradas vacías, unitarias, ordenadas, inversas y con valores repetidos.

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
- Matrices sin elementos, de una fila/columna y rectangulares.
- Entradas ya ordenadas, en orden inverso y con repetidos para Bubble Sort.
- Para cada caso, mostrar entradas y resultado esperado, separando esos ejemplos del código del algoritmo.

## Criterios de aceptación

- La carpeta de esta unidad contiene README, especificación y un documento separado de prompts, sin modificar las guías existentes.
- `PROMPTS.md` contiene exactamente diez prompts, uno por ejercicio, utilizables independientemente y alineados con todos los requisitos enumerados arriba.
- Los análisis de complejidad corresponden a las estrategias solicitadas y hacen explícitas las condiciones necesarias para hablar del caso promedio.
- Los contadores solicitados miden exactamente las operaciones indicadas por la consigna; en el ejercicio 8 se cuentan solo las sumas de acumulación.
- README explica cómo usar los prompts y cómo compilar, ejecutar y probar el código que genere OpenCode con Java 21.
