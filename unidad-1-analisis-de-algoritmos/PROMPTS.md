# Prompts para OpenCode — Unidad 1

Cada sección contiene un prompt independiente. Copiá el bloque del ejercicio que quieras resolver y usalo directamente en OpenCode.

## Ejercicio 1 — Encontrar el mínimo de un vector

```text
Implementá en Java 21 un algoritmo que encuentre el valor mínimo de un vector de enteros.

Antes del código, explicá la estrategia más adecuada: inicializar el mínimo con el primer elemento y recorrer el resto del vector una sola vez, actualizando el mínimo cuando se encuentre un valor menor. Justificá por qué esta estrategia resuelve el problema y por qué no es necesario ordenar el vector.

Requisitos:
- Escribí una solución autocontenida, sin dependencias externas, con un método claramente identificado que reciba el vector.
- Comentá el código y documentá el método con Javadoc: propósito, entrada, resultado, complejidad temporal y espacial, y límites relevantes.
- Un vector vacío no tiene mínimo: no devuelvas un valor centinela como si fuera una respuesta válida. Indicá y documentá cómo se representa o informa que no hay resultado. Si contemplás null, documentá también su tratamiento.
- Separá la implementación de los ejemplos de ejecución y de las pruebas.
- Incluí ejemplos con valores positivos y negativos, un vector de un elemento y el caso vacío, indicando el resultado esperado.
- Analizá tiempo O(n) y espacio auxiliar O(1), explicando qué representa n.
```

## Ejercicio 2 — Buscar un elemento en un vector desordenado

```text
Implementá en Java 21 un algoritmo que busque un entero objetivo en un vector desordenado.

Usá búsqueda lineal: inspeccioná las posiciones en orden y detenete cuando encuentres el objetivo. Justificá por qué es apropiada para datos sin ordenar y no supongas que el vector está ordenado.

Requisitos:
- Proporcioná un método que devuelva la posición encontrada o informe que el elemento no existe.
- Informá cuántas posiciones se recorrieron realmente: hasta la primera coincidencia, o todas las posiciones si el objetivo no aparece. No cuentes posiciones que no se inspeccionaron.
- Documentá entradas, resultado, estrategia, casos límite y complejidad con Javadoc o comentarios equivalentes.
- Separá el código del algoritmo de los ejemplos y pruebas.
- Probá objetivo en la primera posición, en la última, ausente y vector vacío; indicá posiciones recorridas esperadas para cada ejemplo.
- Analizá mejor caso O(1), peor caso O(n) y caso promedio O(n), explicando el supuesto usado para el caso promedio. Indicá espacio auxiliar O(1).
```

## Ejercicio 3 — Buscar un elemento en un vector ordenado

```text
Implementá en Java 21 una búsqueda binaria iterativa para localizar un entero objetivo en un vector ordenado de menor a mayor.

Explicá que cada comparación permite descartar aproximadamente la mitad del intervalo de búsqueda, por lo que la búsqueda binaria es más eficiente que la búsqueda lineal cuando los datos están ordenados. Dejá claro que el orden ascendente es una precondición; no ordenes el vector dentro del algoritmo.

Requisitos:
- Devolvé el índice encontrado o un resultado claramente documentado cuando no exista.
- En cada iteración, mostrá paso a paso los valores de los límites inferior y superior, el punto medio y la comparación que determina el siguiente intervalo. Mostrá también la conclusión final.
- Usá un cálculo seguro del punto medio que evite sumar directamente ambos límites.
- Documentá entradas, resultado, precondición, estrategia y complejidad temporal O(log n) y espacial O(1).
- Separá implementación, demostraciones y pruebas.
- Incluí pruebas con vector vacío, unitario, objetivo al inicio/al final/en el medio, objetivo ausente y objetivo entre dos valores sin coincidencia.
```

## Ejercicio 4 — Detectar elementos duplicados

```text
Implementá en Java 21 dos soluciones distintas para determinar si un vector de enteros contiene al menos un valor duplicado.

Solución 1: compará elementos mediante dos ciclos anidados, sin usar una estructura auxiliar para detectar duplicados.
Solución 2: recorré el vector usando un HashSet; si un valor ya estaba presente, detectá el duplicado.

Requisitos:
- Ambas soluciones deben informar si existe al menos un duplicado y pueden detenerse al detectar el primero.
- Mantené las dos implementaciones separadas y con nombres descriptivos.
- Documentá cada estrategia y comparalas con respecto a complejidad temporal y espacial. Para HashSet, distingue el tiempo esperado de su peor caso si corresponde; especificá el espacio auxiliar.
- Comentá el código y documentá entradas, resultado y complejidades con Javadoc o comentarios equivalentes.
- Separá código, ejemplos de ejecución y pruebas.
- Probá vector vacío, un elemento, todos distintos, duplicados adyacentes y duplicados no adyacentes.
```

## Ejercicio 5 — Contar ocurrencias

```text
Implementá en Java 21 un algoritmo que cuente cuántas veces aparece un entero objetivo en un vector de enteros.

Recorré el vector completo y aumentá el contador cada vez que encuentres una coincidencia. Justificá por qué no alcanza con detenerse en la primera coincidencia: se solicita el total de apariciones.

Requisitos:
- Devolvé el total de ocurrencias; para un vector vacío el total es cero.
- Documentá entradas, resultado, estrategia, complejidad temporal O(n) y espacio auxiliar O(1).
- Comentá el código y documentá el método con Javadoc o formato equivalente.
- Separá la solución de los ejemplos y pruebas.
- Incluí casos con objetivo repetido, objetivo ausente, todos los elementos iguales y vector vacío, con resultados esperados.
```

## Ejercicio 6 — Comparar dos vectores

```text
Implementá en Java 21 un algoritmo que determine si dos vectores de enteros son iguales elemento por elemento y tienen la misma longitud.

El algoritmo debe finalizar apenas detecte una diferencia: primero puede comprobar longitudes y, si son iguales, comparar posiciones hasta la primera desigualdad. Justificá esta terminación temprana.

Requisitos:
- Devolvé un resultado booleano claramente documentado.
- Documentá entradas, resultado, estrategia y análisis del mejor caso, peor caso y caso promedio. Explicá cómo influye una diferencia temprana o tardía y qué supuesto adoptás para caracterizar el caso promedio; no presentes un promedio sin declarar sus condiciones.
- Indicá el espacio auxiliar utilizado.
- Comentá el código y documentá el método con Javadoc o equivalente.
- Separá implementación, ejemplos y pruebas.
- Probá longitudes distintas, vectores iguales (incluidos vacíos), diferencia en la primera posición y diferencia en la última.
```

## Ejercicio 7 — Invertir un vector

```text
Implementá en Java 21 dos versiones para invertir un vector de enteros.

Versión 1: usá un vector auxiliar para construir el resultado en orden inverso, sin cambiar el vector original.
Versión 2: invertí el mismo vector in-place mediante intercambios desde ambos extremos, sin memoria adicional significativa.

Requisitos:
- Mantené las soluciones separadas y dejá claro si cada una devuelve un nuevo vector o modifica el recibido.
- Compará ventajas y desventajas y analizá para ambas tiempo O(n) y espacio auxiliar: O(n) para el vector auxiliar y O(1) para la versión in-place.
- Documentá entradas, resultado y efectos sobre el vector; comentá el código y usá Javadoc o equivalente.
- Separá implementación, ejemplos y pruebas.
- Probá longitudes cero y uno, y longitudes par e impar, con los resultados esperados.
```

## Ejercicio 8 — Sumar todos los elementos de una matriz

```text
Implementá en Java 21 un algoritmo que calcule la suma de todos los elementos de una matriz de enteros.

Recorré la matriz fila por fila, visitando cada elemento una vez y acumulando su valor.

Requisitos:
- Mostrá la suma final y contabilizá únicamente la cantidad de operaciones de suma ejecutadas por el acumulador al procesar elementos. No incluyas comparaciones, accesos o asignaciones en ese contador.
- Explicá la convención del contador. Si el acumulador empieza en cero y se suma cada elemento, el contador debe coincidir con la cantidad de elementos procesados.
- Analizá tiempo O(filas × columnas) para una matriz rectangular y espacio auxiliar O(1), explicando los términos.
- Documentá entradas, resultado, recorrido, contador y complejidad con Javadoc o comentarios equivalentes.
- Separá implementación de ejemplos y pruebas.
- Incluí matriz vacía (si la representación elegida la admite), matriz de un elemento, rectangular y con valores positivos y negativos. Indica suma y cantidad de sumas esperadas para cada caso.
- Si contemplás filas nulas o longitudes de fila distintas, explicá explícitamente cómo se tratan; no afirmes que la matriz es rectangular si el código no lo garantiza.
```

## Ejercicio 9 — Encontrar el mayor elemento de una matriz

```text
Implementá en Java 21 un algoritmo que encuentre el mayor elemento de una matriz de enteros.

Recorré los elementos y conservá el mayor valor observado. Justificá por qué, sin información adicional sobre los datos, es necesario considerar cada elemento antes de concluir cuál es el máximo.

Requisitos:
- Un conjunto sin elementos no tiene máximo: no devuelvas un valor centinela como si fuera el resultado; documentá cómo se informa esa situación.
- Analizá complejidad temporal O(filas × columnas) y espacio auxiliar O(1), explicando los términos.
- Documentá entradas, resultado, estrategia y límites con Javadoc o comentarios equivalentes.
- Separá la implementación de los ejemplos y las pruebas.
- Probá una matriz de un elemento, rectangular con valores negativos y positivos, máximo al inicio y máximo al final; incluye el caso sin elementos e indica el resultado esperado.
- Si contemplás filas nulas o longitudes distintas, documentá el tratamiento.
```

## Ejercicio 10 — Ordenamiento burbuja

```text
Implementá en Java 21 el algoritmo Bubble Sort para ordenar un vector de enteros en orden ascendente.

Explicá que Bubble Sort es adecuado principalmente como recurso didáctico o para conjuntos pequeños: su tiempo cuadrático lo hace poco eficiente al crecer la cantidad de datos frente a algoritmos de ordenamiento más eficientes.

Requisitos:
- Mantené la solución algorítmica separada de ejemplos y pruebas.
- Contabilizá e informá por separado las comparaciones entre elementos y los intercambios realmente efectuados. Define claramente qué cuenta como comparación e intercambio.
- Documentá si el algoritmo modifica el vector recibido y explica sus complejidades temporal y espacial. Si usás una optimización que permite terminar antes en un vector ordenado, descríbela y analiza su efecto; no la ocultes.
- Comentá el código y documentá propósito, entrada, resultado, contadores y complejidades con Javadoc o equivalente.
- Probá vectores vacío, unitario, ya ordenado, en orden inverso y con valores repetidos; indica el vector ordenado esperado y los contadores resultantes para cada entrada.
```
