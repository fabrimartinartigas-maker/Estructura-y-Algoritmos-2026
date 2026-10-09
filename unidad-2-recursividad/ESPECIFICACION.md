# Especificación — Unidad 2: Recursividad

## Objetivo

Desarrollar diez ejercicios introductorios de recursividad en Java usando OpenCode. Cada ejercicio incluye un prompt razonado y una implementación recursiva independiente. La solución debe identificar caso base, caso recursivo y reducción del problema, y probar el comportamiento solicitado.

## Alcance y decisiones

- La carpeta de esta guía es independiente de la Unidad 1.
- El lenguaje objetivo es Java 21. No se requieren bibliotecas externas.
- Cada solución se entrega en su propio archivo fuente bajo `reso/`; las pruebas y ejemplos se mantienen separados de las soluciones.
- Cada archivo de solución comienza con el prompt inicial utilizado para generar la solución. Si ese prompt cambia durante el desarrollo, se documentan al final del archivo los cambios y su motivo.
- Los ejercicios numéricos usan `int`. Se mantienen los dominios indicados en la consigna; las entradas negativas no admitidas por esos dominios se rechazan de forma explícita. Para multiplicación mediante sumas, ambos factores son no negativos (decisión confirmada por el usuario). El exponente de potencia debe ser no negativo.
- Las operaciones aritméticas que pueden desbordar `int` informan el desbordamiento en vez de presentar un resultado incorrecto como válido.
- En inversión de palabra y palíndromo, la comparación es literal y sensible a mayúsculas; espacios y signos son caracteres ordinarios.
- No se agregan validaciones para entradas no mencionadas que cambien el propósito de los algoritmos. Los parámetros de referencia (arreglos y cadenas) deben ser no nulos, salvo que una solución documente explícitamente otro contrato.
- No se fijan límites artificiales a la profundidad recursiva. Los ejemplos y pruebas usan entradas pequeñas que permiten ejecutar la recursión en una JVM normal.

## Requisitos funcionales por ejercicio

1. **Factorial:** función recursiva para `n >= 0`; casos base `0! = 1` y `1! = 1`; reducción mediante `n * factorial(n - 1)`. Rechazar negativos y comunicar desbordamiento de `int`. Probar 0, 1, valores pequeños y el límite que desborda.
2. **Suma de los primeros N números:** sumar de `n` hasta 1 recursivamente, con caso base `suma(0) = 0` y paso `n + suma(n - 1)`. Rechazar negativos y comunicar desbordamiento. Probar 0, 1 y valores mayores.
3. **Multiplicación mediante sumas:** multiplicar dos enteros no negativos mediante sumas repetidas, sin usar el operador `*` en la implementación del algoritmo. Reducir recursivamente uno de los factores; cuando el factor que se reduce vale 0, devolver 0. Rechazar factores negativos y comunicar desbordamiento en las sumas. Probar cero en cualquiera de los factores, uno y casos generales.
4. **Potencia:** calcular una potencia entera recursiva sin `Math.pow`, para exponente no negativo; caso base exponente 0 que devuelve 1; reducir el exponente y reconstruir el resultado con multiplicaciones. Rechazar exponentes negativos y comunicar desbordamiento de `int`. Probar exponentes 0, 1 y varios casos de base/exponente, incluido el desbordamiento.
5. **Conteo regresivo:** procedimiento recursivo que imprime `n, n-1, ..., 0`; el caso base imprime 0 y retorna sin continuar. Rechazar valores iniciales negativos para mantener el conteo especificado. Explicar que no devuelve un valor y por qué cambiar `n - 1` por `n + 1` impediría alcanzar el caso base. Probar 0 y valores positivos.
6. **Contar dígitos:** contar recursivamente los dígitos de un entero positivo mediante división entera por 10. Un número entre 1 y 9 tiene un dígito; rechazar entradas no positivas. Probar dígitos de una y varias posiciones, incluidos números terminados en cero.
7. **Sumar dígitos:** sumar recursivamente los dígitos de un entero positivo, extrayendo el último mediante módulo 10 y reduciendo mediante división entera por 10. Rechazar entradas no positivas y devolver el dígito único en el caso base. Probar entradas de uno y varios dígitos, con ceros internos o finales.
8. **Invertir una palabra:** invertir recursivamente un `String`, con caso base cadena vacía o de un carácter; separar el primer carácter del resto y reconstruir el resultado al volver de la recursión. Probar cadena vacía, un carácter, palíndromo y palabra de varios caracteres.
9. **Palíndromo:** determinar recursivamente si un `String` es palíndromo comparando extremos y reduciendo el intervalo. Si los caracteres extremos difieren, retornar falso; cuando queda cero o un carácter por comparar, retornar verdadero. La comparación es literal, sensible a mayúsculas y considera espacios/signos. Probar cadenas vacías, de un carácter, palíndromos y no palíndromos, incluyendo diferencias de mayúsculas o caracteres interiores.
10. **Buscar un elemento en un arreglo:** búsqueda recursiva sin ciclos. Comenzar en el índice 0 y avanzar un índice por llamada. Caso base de éxito al hallar el valor y caso base de fracaso al llegar a la longitud del arreglo. Devolver el índice de la primera coincidencia o `-1` si no existe. Probar arreglo vacío, elemento al inicio y al final, ausente y valores repetidos.

## Requisitos técnicos y restricciones

- Cada algoritmo debe resolver el problema mediante recursividad; no reemplazarlo por iteración ni usar ciclos en la búsqueda del ejercicio 10.
- La multiplicación del ejercicio 3 se implementa por sumas repetidas, sin operador `*` dentro de la función algorítmica.
- La potencia del ejercicio 4 no debe usar `Math.pow`.
- Mantener una solución independiente por ejercicio, con clase y método descriptivos.
- Cada `.java` inicia con un comentario que contiene el prompt inicial de OpenCode. Si durante el trabajo se modifica el prompt, incluir al final un comentario con la modificación y su motivo.
- Documentar cada método con Javadoc: propósito, razonamiento recursivo, parámetros, resultado, entradas no válidas o errores y complejidad temporal/espacial, cuando corresponda.
- No añadir dependencias, interfaces de usuario ni funcionalidades ajenas a la consigna.
- Los ejemplos de ejecución y las comprobaciones automatizables deben estar separados del código de las soluciones.

## Casos límite transversales

- Casos base explícitos de cada función (incluidos factorial de 0/1, suma de 0 y potencia de exponente 0).
- Entradas negativas o fuera del dominio del ejercicio.
- Desbordamiento de `int` en factorial, suma, multiplicación y potencia.
- Cadenas vacías y de un carácter, diferencias por mayúsculas, espacios o signos.
- Arreglo vacío, valor no encontrado y coincidencias múltiples.
- Profundidad de recursión: las pruebas deben usar valores ejecutables sin depender de límites de pila específicos.

## Criterios de aceptación

- La carpeta de la Unidad 2 contiene `README.md`, `ESPECIFICACION.md`, `PROMPTS.md`, diez soluciones separadas bajo `reso/` y pruebas/ejemplos fuera de `reso/`.
- `PROMPTS.md` contiene un prompt completo e independiente por ejercicio y cada implementación incluye el prompt inicial correspondiente en un comentario al principio.
- Cada ejercicio implementa el caso base, la reducción recursiva y los resultados solicitados; cumple las restricciones particulares de no usar ciclos, `*` o `Math.pow` donde se especifica.
- Entradas no admitidas y desbordamientos no producen resultados válidos engañosos.
- Las pruebas incluyen casos representativos y límites descritos en esta especificación.
- README explica cómo compilar y ejecutar la suite de pruebas con Java 21, sin instalar dependencias.
