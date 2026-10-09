# Unidad 5: Listas Enlazadas Simples

Diez ejercicios de listas enlazadas simples en Java 21: construcción, búsqueda, acceso e inserción por posición, eliminación, modificación, conteo, inversión y tipos genéricos.

## Contenido

- [ESPECIFICACION.md](./ESPECIFICACION.md): alcance, contratos, casos límite y criterios de aceptación.
- [PROMPTS.md](./PROMPTS.md): diez prompts independientes para OpenCode.
- `reso/ejercicio01/` a `reso/ejercicio10/`: soluciones aisladas, cada una con el prompt inicial comentado en el archivo.
- `examples/GuiaListasEnlazadasDemo.java`: demostraciones de uso.
- `tests/GuiaListasEnlazadasTests.java`: pruebas automatizadas sin dependencias externas.

## Compilar

Se requiere un JDK 21. Desde esta carpeta:

```sh
mkdir -p build
javac --release 21 -Xlint:all -d build $(find reso examples tests -name '*.java')
```

## Ejecutar demostraciones

```sh
java -cp build unidad5.examples.GuiaListasEnlazadasDemo
```

## Ejecutar pruebas

```sh
java -ea -cp build unidad5.tests.GuiaListasEnlazadasTests
```

La suite imprime `OK` y la cantidad de verificaciones aprobadas. Si falla una expectativa, informa el nombre de la verificación. Las soluciones son independientes; la demo muestra cómo invocar cada una. Los índices inválidos lanzan `IndexOutOfBoundsException`.
