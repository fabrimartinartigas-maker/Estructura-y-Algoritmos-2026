# Prompts para OpenCode — Unidad 2: Recursividad

Cada prompt es independiente y corresponde al comentario inicial de la solución del ejercicio respectivo.

## Ejercicio 1 — Factorial

```text
Implementá en Java 21 una función recursiva que calcule el factorial de un entero n.
Antes del código, explicá por qué el problema puede resolverse recursivamente:
- Caso base: factorial(0) = 1 y factorial(1) = 1.
- Caso recursivo: factorial(n) = n * factorial(n - 1); cada llamada reduce n hasta alcanzar el caso base.
- La entrada debe ser n >= 0; rechazá n negativo.
Usá int y detectá explícitamente el desbordamiento en vez de devolver un resultado incorrecto.
Documentá propósito, razonamiento, parámetro, resultado, error y complejidad temporal y espacial con Javadoc. Comentá el caso base y recursivo.
Separá la función de los ejemplos y las pruebas. Probá 0, 1, 5, 12 y 13; explica cuáles son sus resultados y que 13! excede int.
```

## Ejercicio 2 — Suma de los primeros N números

```text
Implementá en Java 21 una función recursiva que sume los enteros desde n hasta 1.
Explicá que el caso más simple es suma(0) = 0 y que suma(n) = n + suma(n - 1), porque cada llamada agrega n y reduce el problema a n - 1.
La entrada debe ser n >= 0; rechazá n negativo. Usá int y detectá explícitamente el desbordamiento.
Documentá propósito, razonamiento recursivo, parámetro, resultado, errores y complejidad temporal y espacial con Javadoc. Comentá caso base y paso recursivo.
Mantené la función separada de los ejemplos y pruebas. Validá 0, 1 y varios valores positivos, indicando resultados esperados.
```

## Ejercicio 3 — Multiplicación mediante sumas

```text
Implementá en Java 21 una función recursiva que multiplique dos enteros no negativos sin usar el operador * en la función algorítmica.
Representá a * b como la suma de a repetida b veces. Reducí el segundo parámetro en cada llamada: multiplicar(a, b) = a + multiplicar(a, b - 1). El caso base es b = 0 y devuelve 0.
Rechazá factores negativos. Usá int y detectá explícitamente el desbordamiento de las sumas.
Documentá propósito, razonamiento, parámetros, resultado, errores y complejidad temporal y espacial con Javadoc. Comentá el caso base y cómo se reduce b.
Separá implementación, ejemplos y pruebas. Probá cero en cada factor, 1 por un valor y varios productos no negativos; indicá los resultados esperados.
```

## Ejercicio 4 — Potencia

```text
Implementá en Java 21 una función recursiva que calcule base elevado a exponente sin usar Math.pow.
Explicá que una potencia representa multiplicaciones sucesivas. El caso base es exponente 0 y devuelve 1. En el caso recursivo, reducí el exponente: potencia(base, exponente) = base * potencia(base, exponente - 1).
Admití exponentes no negativos y rechazá exponentes negativos. En particular, potencia(0, 0) devuelve 1 según el caso base indicado. Usá int y detectá explícitamente el desbordamiento.
Documentá propósito, razonamiento, parámetros, resultado, error y complejidad temporal y espacial con Javadoc. Comentá el caso base y la reducción.
Separá la función de ejemplos y pruebas. Probá exponentes 0 y 1, bases 0, 1, negativas y positivas, y un caso cuyo resultado desborde int.
```

## Ejercicio 5 — Conteo regresivo

```text
Implementá en Java 21 un procedimiento recursivo que imprima el conteo desde n hasta 0, inclusive.
Explicá que no necesariamente devuelve un valor: su propósito es producir salida. Usá como caso base n = 0, imprimiendo 0 y retornando. En otro caso, imprimí n y llamá recursivamente con n - 1, acercándote al caso base.
Rechazá n negativo. Explicá que usar n + 1 en vez de n - 1 alejaría la llamada del caso base y causaría recursión sin fin hasta agotar la pila.
Documentá propósito, parámetro, salida, error y complejidad temporal y espacial con Javadoc. Mantené el procedimiento separado de ejemplos y pruebas.
Probá n = 0 y valores positivos; verifica la secuencia completa descendente hasta 0.
```

## Ejercicio 6 — Contar dígitos

```text
Implementá en Java 21 una función recursiva que cuente los dígitos de un entero positivo.
Reducí el número mediante división entera por 10. El caso base es un valor entre 1 y 9, que tiene un dígito; para los demás, devuelve 1 + contarDigitos(n / 10).
La entrada debe ser positiva; rechazá cero y negativos porque el ejercicio especifica enteros positivos.
Documentá propósito, razonamiento recursivo, parámetro, resultado, error y complejidad temporal y espacial con Javadoc. Comentá caso base y reducción.
Separá función, ejemplos y pruebas. Probá números de uno y varios dígitos, incluidos valores terminados en cero.
```

## Ejercicio 7 — Sumar dígitos

```text
Implementá en Java 21 una función recursiva que sume los dígitos de un entero positivo.
Obtené el último dígito con n % 10 y reducí el número mediante división entera n / 10. El caso base es un número entre 1 y 9 y devuelve ese mismo dígito. En el caso recursivo, devuelve n % 10 + sumarDigitos(n / 10).
La entrada debe ser positiva; rechazá cero y negativos según el dominio del ejercicio.
Documentá propósito, razonamiento, parámetro, resultado, error y complejidad temporal y espacial con Javadoc. Comentá el caso base y cómo se combinan los resultados.
Separá la función de los ejemplos y pruebas. Probá números de uno y varios dígitos con ceros internos o finales e indica las sumas esperadas.
```

## Ejercicio 8 — Invertir una palabra

```text
Implementá en Java 21 una función recursiva que invierta un String.
El caso base es una cadena vacía o de un carácter, que se devuelve sin cambios. Para reducir el problema, separá el primer carácter del resto. Reconstruí el resultado al volver de la recursión: invertir(resto) + primer carácter.
La inversión es literal: conserva mayúsculas, espacios y signos tal como son, pero invierte su orden.
Documentá propósito, razonamiento, parámetro, resultado y complejidad temporal y espacial con Javadoc. Comentá el caso base, la reducción y la reconstrucción.
Separá la función de ejemplos y pruebas. Probá cadena vacía, un carácter y palabras de varios caracteres, incluyendo una palabra palíndroma.
```

## Ejercicio 9 — Palíndromo

```text
Implementá en Java 21 una función recursiva que determine si un String es palíndromo.
Compará el primer y último carácter. Si son distintos, devuelve false; si coinciden, reduce el problema eliminando ambos extremos y continúa recursivamente. El caso base devuelve true cuando queda una cadena vacía o un solo carácter.
La comparación debe ser literal y sensible a mayúsculas; espacios y signos se consideran caracteres y no se normalizan.
Documentá propósito, razonamiento, parámetro, resultado y complejidad temporal y espacial con Javadoc. Comentá la comparación, la reducción y los casos base.
Separá la función de los ejemplos y pruebas. Probá cadena vacía, un carácter, palíndromos y no palíndromos, incluidas diferencias de mayúsculas, espacios o caracteres interiores.
```

## Ejercicio 10 — Buscar un elemento en un arreglo

```text
Implementá en Java 21 una función recursiva que busque un entero objetivo en un arreglo de enteros, sin usar ciclos.
La búsqueda comienza en la posición 0 y avanza una posición por llamada recursiva. Caso base de éxito: el elemento en la posición actual coincide con el objetivo. Caso base de fracaso: el índice alcanza la longitud del arreglo. Devuelve el índice de la primera coincidencia o -1 si el valor no existe.
No uses for, while, streams ni otra técnica iterativa para recorrer el arreglo.
Documentá propósito, razonamiento, parámetros, resultado y complejidad temporal y espacial con Javadoc. Comentá los dos casos base y el avance del índice.
Separá implementación, ejemplos y pruebas. Probá arreglo vacío, objetivo al inicio y al final, valor ausente y valor repetido.
```
