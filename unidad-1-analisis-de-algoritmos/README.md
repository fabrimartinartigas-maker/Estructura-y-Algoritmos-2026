# Unidad 1: Análisis de Algoritmos

Esta guía reúne diez ejercicios para redactar prompts de OpenCode. Cada prompt solicita una implementación Java y un análisis de algoritmos; la guía no incluye esas implementaciones, porque el entregable de la consigna es construir los prompts.

## Contenido

- [ESPECIFICACION.md](./ESPECIFICACION.md): objetivos, requisitos, restricciones y criterios de aceptación.
- [PROMPTS.md](./PROMPTS.md): un prompt completo, listo para usar en OpenCode, por ejercicio.

## Uso, compilación, ejecución y pruebas

1. Abrí [PROMPTS.md](./PROMPTS.md), copiá el prompt del ejercicio elegido y pegalo en OpenCode.
2. El prompt solicita código Java 21 independiente, sin dependencias externas, con la implementación separada de los ejemplos y pruebas.
3. Guardá el código generado en un archivo cuyo nombre coincida con la clase pública. Para compilarlo, desde la carpeta del archivo ejecutá:

   ```sh
   javac --release 21 NombreDeLaClase.java
   ```

4. Ejecutalo con:

   ```sh
   java NombreDeLaClase
   ```

5. Ejecutá los casos representativos y límite solicitados por el prompt y compará el resultado con el esperado. Revisá también que el análisis de complejidad y, cuando corresponda, los contadores coincidan con las operaciones efectivamente realizadas.

La compilación y las pruebas corresponden al código que genere OpenCode; esta guía no contiene código fuente compilable ni una suite de pruebas propia.
