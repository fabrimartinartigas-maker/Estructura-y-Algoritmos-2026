# Especificación — Unidad 3: Algoritmos de Ordenamiento

## Objetivo

Desarrollar diez ejercicios didácticos de algoritmos de ordenamiento en Java 21 usando OpenCode. Cada ejercicio debe contar con un prompt razonado, una implementación independiente y ejemplos/pruebas que comprueben tanto el resultado como los pasos o contadores que pide la consigna.

## Alcance y decisiones acordadas

- La carpeta de la guía es independiente de las unidades anteriores.
- Lenguaje: Java 21, sin dependencias de terceros.
- Cada ejercicio tendrá una solución Java independiente bajo `reso/ejercicioNN/`; ejemplos y pruebas automatizables estarán fuera de `reso/`.
- Los arreglos de números usan `int`. Los algoritmos que ordenan arreglos los modifican in-place, salvo que la descripción indique expresamente otra cosa.
- Para ordenar nombres en el ejercicio 4, el orden requerido es el de `String.compareTo`: lexicográfico, sensible a mayúsculas y determinado por unidades de código UTF-16. No se aplica normalización lingüística.
- ShellSort usa gaps `n/2, n/4, ..., 1`, calculados con división entera; cada gap debe aparecer en la traza.
- En el ejercicio 7, el contador de llamadas recursivas cuenta cada invocación posterior a la llamada inicial, incluidas las que reciben subarreglos vacíos o unitarios.
- En el ranking, los puntajes se ordenan de mayor a menor y los empates conservan el orden original de entrada.
- Para contadores, una comparación es una comparación entre claves/valores del arreglo, no la condición de control de un ciclo. Un intercambio cuenta solo si se intercambian dos posiciones distintas. Un desplazamiento de Insertion Sort cuenta cada movimiento de una clave anterior hacia la derecha; colocar la clave guardada en su posición no se cuenta como desplazamiento.
- Los ejemplos usan tamaños acotados para que las trazas se puedan leer. No se agregan optimizaciones ni estructuras no requeridas salvo que se expliquen en el prompt y no impidan ver el comportamiento estudiado.

## Requisitos funcionales por ejercicio

1. **Bubble Sort paso a paso:** ordenar un arreglo de enteros; imprimir el original y el estado posterior a cada pasada. La explicación debe vincular las comparaciones/intercambios adyacentes con el desplazamiento del mayor valor hacia el final. Probar vacío, unitario, ordenado, inverso y con repetidos.
2. **Burbuja vs. selección:** implementar `bubbleSort(int[] array)` y `selectionSort(int[] array)`, comparar copias del mismo arreglo y reportar comparaciones e intercambios para ambos. Explicar la diferencia entre comparar vecinos y buscar el mínimo del sufijo. Mantener definiciones de contadores consistentes.
3. **Insertion Sort casi ordenado:** implementar Insertion Sort en el arreglo ejemplo `{1, 2, 3, 5, 4, 6, 7}` y reportar desplazamientos. Explicar que pocas inversiones implican pocos movimientos internos, además del recorrido de claves. Probar caso ordenado, casi ordenado, inverso y límites pequeños.
4. **Selection Sort de nombres:** ordenar nombres usando Selection Sort y `String.compareTo`; mostrar el arreglo recibido y el resultado. Probar el ejemplo dado, entrada vacía/unitaria y nombres cuya capitalización muestre la regla de orden lexicográfico Java.
5. **ShellSort y gaps:** implementar ShellSort con secuencia de gaps por mitades hasta 1; mostrar gap y arreglo luego de procesar cada etapa (una pasada completa para ese gap). Explicar cómo los saltos ordenan subsecuencias y acercan valores a sus posiciones, dejando Insertion Sort con gap 1 al final. Probar tamaños límite, ordenado, inverso y repetidos.
6. **Quicksort con primer elemento como pivote:** usar siempre el primer elemento del subarreglo como pivote; mostrar pivote, subarreglo izquierdo y derecho en cada partición, y arreglo final ordenado. Explicar recursividad y divide y vencerás. Probar arreglos pequeños, ordenado/inverso y repetidos.
7. **Peor caso de Quicksort:** ejecutar Quicksort con primer elemento como pivote sobre `{1, 2, 3, 4, 5, 6, 7}`; contar llamadas recursivas posteriores a la inicial, incluidas llamadas base con subarreglo vacío o unitario. Explicar por qué el pivote extremo produce particiones desequilibradas y peor tiempo cuadrático. Validar contador y orden final.
8. **MergeSort paso a paso:** mostrar las divisiones, la condición de corte y cada fusión de subarreglos ordenados. Explicar el propósito distinto de dividir y fusionar. Probar arreglos vacío, unitario, par/impar, desordenado y con duplicados.
9. **Comparación de algoritmos simples:** ejecutar Bubble, Selection e Insertion Sort sobre copias iguales del mismo arreglo; mostrar resultado, comparaciones e intercambios o desplazamientos. Definir claramente contadores y explicar por qué cada método realiza sus movimientos. Probar arreglos pequeños, ordenados, inversos y con repetidos.
10. **Ranking de puntajes:** recibir un arreglo de jugadores (nombre y puntaje); ordenar de mayor a menor puntaje usando uno de los algoritmos vistos, con justificación de la elección. En puntajes empatados, conservar orden de entrada. Mostrar jugadores antes/después. Probar arreglo vacío, unitario, puntajes en orden, fuera de orden y empates.

## Requisitos técnicos y restricciones

- Un paquete/clase por ejercicio y métodos públicos descriptivos para poder probar las soluciones de forma aislada.
- No usar APIs de ordenamiento predefinidas para sustituir los algoritmos que se enseñan.
- Implementar los algoritmos asignados, no uno equivalente diferente: Bubble Sort, Selection Sort, Insertion Sort, ShellSort, Quicksort con primer pivote y MergeSort.
- Los ejercicios comparativos ejecutan cada método sobre su propia copia del arreglo original para que el primero no afecte la entrada del siguiente.
- Documentar cada implementación con Javadoc: consigna, propósito, estrategia/razonamiento, parámetros, resultados, efectos sobre los datos, complejidad y comportamiento de entradas límite cuando corresponda.
- `PROMPTS.md` contendrá un prompt completo e independiente por ejercicio para OpenCode.
- No modificar guías existentes ni añadir dependencias, funcionalidades ajenas o infraestructura de build externa.

## Casos límite transversales

- Arreglos vacíos y de un elemento.
- Arreglos ya ordenados, en orden inverso, con repetidos y con valores negativos.
- Quicksort con pivote mínimo/máximo y segmentos vacíos; asegurar que la partición siempre progresa incluso con repetidos.
- Gaps de ShellSort para tamaños 0, 1, 2 y potencias/no potencias de dos.
- MergeSort con longitudes pares e impares, para que ambas mitades y el corte se muestren correctamente.
- Strings con mayúsculas y minúsculas, probados según el orden explícito de `String.compareTo`.
- Ranking con puntajes empatados, verificando que el orden relativo se conserve.
- Contadores verificados sobre casos pequeños calculables manualmente.

## Criterios de aceptación

- La guía contiene `README.md`, `ESPECIFICACION.md`, `PROMPTS.md`, diez soluciones independientes en `reso/` y pruebas separadas.
- Los diez prompts cubren las salidas, razonamientos, algoritmos y contadores exigidos por la consigna y documentan los acuerdos resueltos.
- Cada solución implementa el algoritmo requerido y produce el orden ascendente, excepto el ranking descendente.
- Trazas y contadores representan operaciones reales según las definiciones acordadas.
- Pruebas automatizadas ejercitan resultados, casos límite y métricas; todos los códigos compilan con `javac --release 21` y las pruebas se ejecutan sin dependencias externas.
- README explica cómo compilar, ejecutar y probar las soluciones.
