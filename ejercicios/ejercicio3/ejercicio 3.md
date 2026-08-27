# Ejercicio 3: Factorial recursivo en Java

Implementá en Java una función recursiva que calcule el factorial de un
número entero no negativo, con esta definición:

- factorial(0) = 1                    (caso base)
- factorial(n) = n * factorial(n - 1) (caso recursivo, para n >= 1)

## Requisitos

1. Creá un único archivo `FactorialRecursivo.java` en `ejercicios/ejercicio3/`.
2. Método `public static long factorial(int n)`:
   - Debe ser **recursivo**; está prohibido usar bucles o funciones de
     biblioteca para el cálculo.
   - `factorial(0)` debe devolver 1.
   - Si `n < 0`, debe lanzar `IllegalArgumentException` con mensaje claro.
   - Si `n > 20`, debe lanzar `ArithmeticException` con mensaje claro
     (20! = 2432902008176640000 es el mayor factorial que cabe en `long`).
3. Javadoc en español:
   - En la clase: `Ejercicio 3: factorial de un número (recursivo).` e
     incluye el análisis de complejidad: tiempo O(n) y espacio O(n)
     (pila de recursión).
   - En el método: `@param`, `@return` y `@throws`.
4. `main(String[] args)` con dos modos, igual que el ejercicio 2:
   - **Sin argumentos** → demo interactiva con `Scanner`: pide `n`,
     valida que sea entero y no negativo (captura `InputMismatchException`
     para entrada no numérica), e imprime n! . Si `n > 20`, muestra un
     aviso de desbordamiento capturando la `ArithmeticException`.
   - **Con argumento `pruebas`** (`args[0].equalsIgnoreCase("pruebas")`) →
     autoverificación de casos predefinidos: imprime `PASÓ   <descripcion>`
     o `FALLÓ  <descripcion>` por caso, `Resumen: X/Y casos pasaron.` al
     final y `System.exit(1)` si hay algún fallo. Sin frameworks externos.
5. Casos de prueba obligatorios en la autoverificación:
   - factorial(0)  == 1                       (caso base)
   - factorial(1)  == 1
   - factorial(5)  == 120
   - factorial(12) == 479001600               (mayor valor que cabe en int)
   - factorial(20) == 2432902008176640000L    (mayor valor que cabe en long)
   - factorial(-1) lanza IllegalArgumentException
   - factorial(21) lanza ArithmeticException  (desbordamiento de long)
6. Comentarios y mensajes de consola en español, estilo de los ejercicios
   anteriores `MinimoVector.java` y `BusquedaSecuencial.java`.

## Verificación

- Compilá sin warnings: `javac FactorialRecursivo.java`
- Ejecutá la autoverificación: `java FactorialRecursivo pruebas`
- Resultado esperado: 7/7 casos pasan.
