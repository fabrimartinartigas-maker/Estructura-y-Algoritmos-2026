# Unidad 6: Pilas y Colas con Listas Enlazadas

Guía práctica con diez ejercicios independientes de pilas, colas y listas enlazadas en Java 21. Cada solución mantiene nodos propios; las demostraciones y pruebas están separadas.

## Contenido

- [ESPECIFICACION.md](./ESPECIFICACION.md): objetivos, contratos, restricciones y criterios de aceptación.
- [PROMPTS.md](./PROMPTS.md): prompts listos para utilizar con OpenCode, uno por ejercicio.
- `reso/ejercicio01/` a `reso/ejercicio10/`: soluciones independientes; cada fuente incluye el prompt inicial utilizado.
- `examples/GuiaPilasColasEnlazadasDemo.java`: demostraciones separadas.
- `tests/GuiaPilasColasEnlazadasTests.java`: pruebas automatizadas sin dependencias externas.

## Consignas

1. Implementar una pila enlazada de enteros con apilar, desapilar, consultar tope, comprobar vacío, buscar e imprimir; `head` representa el tope y las operaciones de apilar/desapilar son O(1).
2. Implementar una cola enlazada de enteros con encolar, desencolar, consultar frente, comprobar vacío, buscar e imprimir; mantener `head` y `tail` permite agregar al final en O(1).
3. Generalizar la pila enlazada para almacenar `Integer`, `String` y objetos propios mediante genéricos.
4. Generalizar la cola enlazada para almacenar nombres y objetos `Cliente`, preservando el comportamiento FIFO.
5. Simular el historial de navegación con una pila: visitar, volver, consultar la página actual e imprimir las visitas.
6. Atender clientes bancarios en orden FIFO; cada cliente contiene nombre, número de turno y motivo de consulta.
7. Validar paréntesis balanceados usando una pila para guardar las aperturas; otros caracteres se ignoran.
8. Invertir una palabra con una pila enlazada, como `algoritmo` → `omtirogla`.
9. Administrar trabajos de impresión en FIFO; cada trabajo contiene archivo, páginas y usuario.
10. Implementar una lista doblemente enlazada genérica que inserte por ambos extremos, elimine por valor y permita imprimir en ambos sentidos.

Las decisiones de índices/extremos, excepciones, casos límite y criterios de aceptación están detallados en [ESPECIFICACION.md](./ESPECIFICACION.md).

## Compilar

Se requiere un JDK 21. Desde esta carpeta:

```sh
mkdir -p build
javac --release 21 -Xlint:all -d build $(find reso examples tests -name '*.java')
```

## Ejecutar demostraciones

```sh
java -cp build unidad6.examples.GuiaPilasColasEnlazadasDemo
```

## Ejecutar pruebas

```sh
java -ea -cp build unidad6.tests.GuiaPilasColasEnlazadasTests
```

Las operaciones de consulta o extracción sobre una pila o cola vacía lanzan `IllegalStateException`. Las comparaciones por valor usan `Objects.equals`; la lista doble elimina solo la primera coincidencia.
