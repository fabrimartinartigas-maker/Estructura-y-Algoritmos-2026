# Unidad 4: Pilas y Colas con Arreglos

Guía práctica con diez implementaciones independientes de pilas y colas en Java 21, prompts para OpenCode, demostraciones y pruebas.

## Contenido

- [ESPECIFICACION.md](./ESPECIFICACION.md): objetivos, contratos, casos límite y criterios de aceptación.
- [PROMPTS.md](./PROMPTS.md): prompts listos para usar, uno por ejercicio.
- `reso/ejercicio01/` a `reso/ejercicio10/`: implementaciones independientes con el prompt inicial en el archivo.
- `examples/GuiaPilasColasDemo.java`: demostraciones separadas de las estructuras.
- `tests/GuiaPilasColasTests.java`: pruebas automatizadas sin dependencias externas.

## Compilar

Se requiere un JDK 21. Desde esta carpeta:

```sh
mkdir -p build
javac --release 21 -Xlint:all -d build $(find reso examples tests -name '*.java')
```

## Ejecutar demostraciones

```sh
java -cp build unidad4.examples.GuiaPilasColasDemo
```

## Ejecutar pruebas

```sh
java -ea -cp build unidad4.tests.GuiaPilasColasTests
```

La suite muestra `OK` con la cantidad de verificaciones aprobadas. Si una expectativa falla, informa cuál fue mediante una aserción. Las estructuras reciben su capacidad al construirse y lanzan `IllegalStateException` en inserciones o extracciones/consultas inválidas, tal como se define en la especificación.
