# Unidad 2: Recursividad

Diez ejercicios introductorios de recursividad implementados en Java 21. Cada solución es independiente y comienza con el prompt inicial usado para generarla. Los prompts completos también están reunidos en [PROMPTS.md](./PROMPTS.md); los requisitos y decisiones de alcance están en [ESPECIFICACION.md](./ESPECIFICACION.md).

## Estructura

- `reso/ejercicio01/` a `reso/ejercicio10/`: implementaciones recursivas independientes.
- `tests/GuiaRecursividadTests.java`: pruebas y ejemplos, separados de las soluciones.

## Compilar, ejecutar y probar

Se requiere un JDK 21. Desde esta carpeta, compilá las soluciones y pruebas:

```sh
mkdir -p build
javac --release 21 -d build $(find reso tests -name '*.java')
```

Ejecutá los ejemplos y pruebas automatizadas:

```sh
java -ea -cp build unidad2.tests.GuiaRecursividadTests
```

La suite informa `OK` si pasan todas las verificaciones; ante un resultado inesperado termina con una excepción indicando la prueba que falló.

Para usar una solución desde otro programa Java, importá la clase del paquete correspondiente (por ejemplo, `unidad2.ejercicio01.Factorial`) y llamá su método público. La suite de pruebas muestra ejemplos de invocación y los resultados esperados.

Los parámetros numéricos usan `int`; las operaciones que pueden desbordar lo notifican con `ArithmeticException`. Las entradas fuera del dominio documentado se rechazan con `IllegalArgumentException`. Los métodos que reciben arreglos o cadenas requieren una referencia no nula.
