# Unidad 1: Análisis de Algoritmos

Esta guía desarrolla diez ejercicios de análisis de algoritmos sobre vectores y matrices en Java 21. Incluye consignas, prompts para OpenCode, soluciones independientes, una demostración y pruebas automatizadas.

## Contenido

- [ESPECIFICACION.md](./ESPECIFICACION.md): objetivos, requisitos, restricciones y criterios de aceptación.
- [PROMPTS.md](./PROMPTS.md): un prompt completo, listo para usar en OpenCode, por ejercicio.
- `reso/ejercicio01/` a `reso/ejercicio10/`: implementaciones independientes. Los ejercicios 4 y 7 incluyen dos alternativas.
- `examples/GuiaAnalisisDemo.java`: demostración separada de las soluciones.
- `tests/GuiaAnalisisTests.java`: pruebas automatizadas sin dependencias externas.

## Contenido de la guía

1. Encontrar el mínimo de un vector.
2. Buscar linealmente un elemento en un vector desordenado e informar las posiciones inspeccionadas.
3. Buscar binariamente en un vector ordenado e imprimir la traza de límites y puntos medios.
4. Detectar duplicados mediante ciclos anidados y `HashSet`.
5. Contar todas las apariciones de un valor.
6. Comparar vectores con terminación temprana.
7. Invertir un vector con auxiliar y en el mismo vector.
8. Sumar una matriz e informar las sumas ejecutadas por el acumulador.
9. Encontrar el máximo de una matriz.
10. Ordenar con Bubble Sort e informar comparaciones e intercambios.

## Compilar

Se requiere un JDK 21. Desde esta carpeta:

```sh
mkdir -p build
javac --release 21 -Xlint:all -d build $(find reso examples tests -name '*.java')
```

## Ejecutar la demostración

```sh
java -cp build unidad1.examples.GuiaAnalisisDemo
```

## Ejecutar pruebas

```sh
java -ea -cp build unidad1.tests.GuiaAnalisisTests
```

La suite informa la cantidad de verificaciones aprobadas y falla con una aserción descriptiva ante un resultado inesperado. Los prompts permanecen disponibles como material de práctica independiente; las implementaciones locales se pueden comparar con ellos y con [ESPECIFICACION.md](./ESPECIFICACION.md).
