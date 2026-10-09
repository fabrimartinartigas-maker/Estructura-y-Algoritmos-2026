# Unidad 3: Algoritmos de Ordenamiento

Diez ejercicios de ordenamiento implementados en Java 21, con prompts para OpenCode, trazas didácticas y pruebas automatizadas. Los requisitos y convenciones de métricas están en [ESPECIFICACION.md](./ESPECIFICACION.md); los prompts independientes están en [PROMPTS.md](./PROMPTS.md).

## Estructura

- `reso/ejercicio01/` a `reso/ejercicio10/`: soluciones Java independientes.
- `examples/GuiaOrdenamientoDemo.java`: salida demostrativa de los diez ejercicios, separada de las soluciones.
- `tests/GuiaOrdenamientoTests.java`: ejemplos y verificaciones, separados de las soluciones.

## Compilar, ejecutar y probar

Se requiere un JDK 21. Desde esta carpeta, compilá las soluciones y pruebas:

```sh
mkdir -p build
javac --release 21 -d build $(find reso examples tests -name '*.java')
```

Para ejecutar las demostraciones de salida:

```sh
java -cp build unidad3.examples.GuiaOrdenamientoDemo
```

Ejecutá las pruebas automatizadas:

```sh
java -ea -cp build unidad3.tests.GuiaOrdenamientoTests
```

La suite informa `OK` si pasan las verificaciones; ante un resultado inesperado termina con un error que identifica la aserción fallida. Las clases de `reso/` pueden invocarse por separado; la suite incluye ejemplos de uso.

Las métricas cuentan comparaciones entre claves y movimientos según se define en la especificación: solo intercambios entre posiciones distintas y desplazamientos de claves hacia la derecha en Insertion Sort. Quicksort cuenta las llamadas posteriores a la inicial, incluidas las llamadas base.
