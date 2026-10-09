# Prompts para OpenCode — Unidad 3: Algoritmos de Ordenamiento

Copiá el prompt del ejercicio que quieras implementar. Cada bloque es independiente y debe generar una solución Java 21 comentada, con ejemplos/pruebas separados y sin dependencias externas.

## Ejercicio 1 — Bubble Sort paso a paso

```text
Implementá en Java 21 Bubble Sort para ordenar un arreglo de enteros de menor a mayor.
Explicá que se comparan elementos vecinos y se intercambian si están fuera de orden; en cada pasada el mayor valor aún no ubicado se desplaza hacia el final.
El programa debe mostrar el arreglo original y el estado después de cada pasada. Incluí una pasada completa por cada una de las n-1 iteraciones (si n < 2 no hay pasadas) para que la traza sea clara; no agregues salida dentro del método de ordenamiento, devolvé o almacená los estados y mostrálos desde el ejemplo.
Documentá el algoritmo, entradas, mutación del arreglo y complejidades con Javadoc. Separá implementación, ejemplo y pruebas.
Probá arreglo vacío, unitario, ya ordenado, inverso y con repetidos. Verificá orden ascendente y cada estado de pasada.
```

## Ejercicio 2 — Comparación entre Burbuja y Selección

```text
Implementá en Java 21 los métodos bubbleSort(int[] array) y selectionSort(int[] array), que ordenen ascendentemente.
Bubble Sort debe comparar vecinos e intercambiarlos cuando sea necesario. Selection Sort debe buscar el índice del menor elemento del sufijo y colocarlo al inicio del sufijo.
Ambos métodos deben reportar comparaciones entre valores e intercambios reales. Una comparación de ciclo/índice no cuenta; un intercambio cuenta solo si se cambian dos posiciones distintas. Usá un resultado de métricas claro y documentá las convenciones.
Ejecutá los dos métodos sobre copias independientes del mismo arreglo. Mostrá resultado, comparaciones e intercambios y explicá qué diferencia entre estrategias reflejan las métricas.
Separá código, demostración y pruebas; usá Javadoc y no uses ordenamiento de biblioteca.
Probá vacío, unitario, ordenado, inverso y repetidos, comprobando tanto arreglos ordenados como conteos.
```

## Ejercicio 3 — Insertion Sort con arreglo casi ordenado

```text
Implementá Insertion Sort en Java 21 para ordenar ascendentemente el arreglo de ejemplo {1, 2, 3, 5, 4, 6, 7}.
Explicá que cada clave se inserta en su posición dentro del prefijo ordenado y que si el arreglo está casi ordenado suelen necesitarse pocos desplazamientos.
Contabilizá desplazamientos: cada vez que un elemento previo se mueve una posición a la derecha cuenta uno; colocar la clave temporal en su posición final no cuenta. Mostrá el total.
Documentá entradas, mutación, razonamiento y complejidad con Javadoc. Mantené solución separada de los ejemplos y pruebas.
Probá vacío, unitario, ordenado, casi ordenado (incluido el ejemplo) e inverso; verificá resultado y desplazamientos esperados.
```

## Ejercicio 4 — Selection Sort de nombres

```text
Implementá en Java 21 Selection Sort para ordenar un arreglo de nombres de forma ascendente.
En cada posición, buscá el menor String entre esa posición y el final y luego intercambiá si hace falta. Compará mediante String.compareTo: orden lexicográfico de Java, sensible a mayúsculas y basado en unidades de código UTF-16; no normalices ni apliques reglas regionales.
Usá el ejemplo {"Lucia", "Ana", "Pedro", "Juan"} y mostrá el resultado. Documentá propósito, estrategia, entradas, resultado y complejidad con Javadoc.
Separá implementación de ejemplos y pruebas. No uses Arrays.sort ni otra API de ordenamiento.
Probá arreglo vacío, unitario, el ejemplo y nombres con distintas mayúsculas para demostrar el criterio de compareTo.
```

## Ejercicio 5 — ShellSort explicando los gaps

```text
Implementá ShellSort en Java 21 con la secuencia de gaps n/2, n/4, ..., 1 usando división entera. Para cada gap, ejecutá una pasada completa de inserción por saltos antes de continuar con el gap siguiente.
Mostrá cada gap y el estado del arreglo al finalizar esa etapa. Explicá que los saltos permiten mover elementos a mayor distancia que Insertion Sort y que el gap 1 termina de ordenar el arreglo.
Documentá el algoritmo, la secuencia de gaps, parámetros, resultado, mutación y complejidad sin atribuirle una cota que no corresponda a esta secuencia. Separá el ordenamiento de la presentación de trazas.
Probá tamaños 0, 1, 2, potencia de dos y no potencia de dos; además, ordenado, inverso y con repetidos. Verificá cada gap/estado y el resultado final.
```

## Ejercicio 6 — Quicksort con primer elemento como pivote

```text
Implementá en Java 21 Quicksort recursivo usando siempre el primer elemento de cada subarreglo como pivote.
Explicá el enfoque de divide y vencerás: particionar alrededor del pivote y ordenar recursivamente las partes. En cada partición registrá y mostrá el pivote elegido, el subarreglo izquierdo y el subarreglo derecho; al final mostrá el arreglo completo ordenado.
La partición debe progresar incluso si hay valores repetidos. Documentá rangos, casos base y complejidad, incluido el peor caso O(n^2) y la pila recursiva.
No uses Arrays.sort ni escribas la traza desde el algoritmo; devolvé eventos para que el ejemplo los presente. Separá código, ejemplo y pruebas.
Probá vacío, unitario, ordenado, inverso y repetidos; verificá resultado y que los eventos reflejen particiones válidas.
```

## Ejercicio 7 — Peor caso de Quicksort

```text
Implementá en Java 21 Quicksort con el primer elemento de cada subarreglo como pivote y ejecútalo sobre {1, 2, 3, 4, 5, 6, 7}.
Explicá que en una entrada ordenada el primer elemento es el mínimo, por lo que las particiones quedan muy desequilibradas (una parte vacía y otra con un elemento menos), llevando al peor caso cuadrático.
Contabilizá las llamadas recursivas posteriores a la llamada inicial. Cuenta cada invocación de la función recursiva, incluso cuando recibe un subarreglo vacío o unitario; no cuentes la invocación inicial. Mostrá el arreglo final y el total de llamadas según esa definición.
Documentá método, caso base, partición, métrica y complejidad. Separá solución de ejemplos y pruebas.
Valida manualmente el contador para el arreglo de siete valores y prueba también tamaños 0, 1 y 2.
```

## Ejercicio 8 — MergeSort paso a paso

```text
Implementá MergeSort recursivo en Java 21.
Durante la ejecución, registrá y mostrá cuándo se divide cada subarreglo, cuándo una llamada alcanza la condición de corte (longitud menor que 2) y cada fusión de subarreglos ya ordenados. Explicá que dividir reduce el problema y fusionar produce el orden local.
La traza debe estar separada de la lógica: el algoritmo registra eventos y el ejemplo los imprime. Documentá casos base, índices, entradas, resultado y complejidades O(n log n) de tiempo y O(n) de espacio auxiliar.
No uses una API de ordenamiento de biblioteca. Separá código, demostraciones y pruebas.
Probá vacío, unitario, longitudes pares e impares, desordenados y con duplicados; verifica traza y resultado.
```

## Ejercicio 9 — Comparación de algoritmos simples

```text
Implementá en Java 21 Bubble Sort, Selection Sort e Insertion Sort y aplicá cada uno a su propia copia del mismo arreglo inicial.
Mostrá para cada algoritmo el arreglo ordenado, cantidad de comparaciones entre claves y cantidad de intercambios o desplazamientos.
Usá definiciones consistentes: las comparaciones son solo comparaciones de valores; un intercambio cuenta si dos posiciones distintas se intercambian; en Insertion Sort, cada movimiento de una clave previa hacia la derecha cuenta como desplazamiento, pero la escritura final de la clave no. Explicá estas convenciones.
Documentá las tres estrategias y sus complejidades con Javadoc. No uses APIs de ordenamiento, y separá implementación, salida de ejemplo y pruebas.
Probá un mismo arreglo vacío, unitario, ordenado, inverso y con repetidos para los tres métodos; comprueba que los resultados coincidan y valida las métricas en casos pequeños.
```

## Ejercicio 10 — Sistema de ranking de puntajes

```text
Implementá en Java 21 un ranking que reciba un arreglo de jugadores, cada uno con nombre y puntaje entero, y lo ordene de mayor a menor puntaje.
Elegí un algoritmo visto en la guía y justificá por qué es adecuado para el tamaño/propósito didáctico del ejemplo. Conservá el orden original de entrada entre jugadores con puntajes iguales. No uses APIs de ordenamiento de biblioteca.
Usá como ejemplo Ana (1200), Pedro (900), Lucia (1500). Mostrá el ranking antes y después del ordenamiento.
Documentá la estructura Jugador, entradas, resultado, estabilidad y complejidad con Javadoc. Mantené algoritmo, demostración y pruebas separados.
Probá arreglo vacío, unitario, ordenado, desordenado y dos o más empates; verifica orden descendente y estabilidad de los empatados.
```
