package com.exercises.test.technicaltestexercises;

/**
 * Tienes un arreglo infinito de enteros numerados consecutivamente desde 0. En cada paso, un puntero puede moverse desde el índice
 * 𝑖 al índice i+j, o quedarse en el mismo lugar. El valor de i comienza en 0. El valor de j comienza en 1 y se incrementa en 1 con cada paso.
 * Hay un índice específico que se debe evitar, llamado badIndex. Debes determinar el índice más alto que se puede alcanzar en un número dado de pasos, evitando el badIndex.
 * <p>
 * Parámetros de la función
 * La función maxIndex debe recibir los siguientes parámetros:
 * <p>
 * int steps: el número de pasos que puede dar el puntero.
 * int badIndex: el índice que debe evitarse.
 * La función debe devolver un int que represente el índice más alto que se puede alcanzar desde el índice 0 sin pasar por badIndex.
 * <p>
 * Ejemplo de Formato de Entrada
 * Entrada:
 * 2   → steps = 2
 * 2   → badIndex = 2
 * Salida esperada: 3
 * <p>
 * Explicación del Caso de Ejemplo 1
 * El puntero puede moverse un máximo de 2 pasos y debe evitar el índice 2.
 * <p>
 * Paso 1: Mover 1 unidad al índice
 * 0+1=1. 𝑗 se incrementa a 2.
 * Paso 2: Mover 2 unidades al índice
 * 1+2=3. 𝑗 se incrementa a 3.
 * El índice máximo alcanzable evitando el badIndex 2 es 3.
 * <p>
 * Explicación del Caso de Ejemplo 2
 * Entrada:
 * <p>
 * 3   → steps = 3
 * 3   → badIndex = 3
 * Salida esperada:
 * 5
 * Explicación:
 * Escenario 1:
 * <p>
 * Paso 1: Mover 1 unidad al índice
 * 0+1=1. 𝑗 se incrementa a 2.
 * Paso 2: Permanecer en el índice 1 (evitar el badIndex). 𝑗 se incrementa a 3.
 * Paso 3: Mover 3 unidades al índice 1+3=4.
 * <p>
 * Escenario 2:
 * <p>
 * Paso 1: Permanecer en el índice 0.
 * 𝑗 se incrementa a 2.
 * Paso 2: Mover 2 unidades al índice
 * 0+2=2. 𝑗 se incrementa a 3.
 * Paso 3: Mover 3 unidades al índice 2+3=5.
 */

public class MaximumIndex {

    public static int maxIndex(int steps, int badIndex) {
        int i = 0, j = 1;

        for (int step = 0; step < steps; step++) {
            // Si i + j es igual a badIndex, omitir ese paso
            if (i + j == badIndex) {
                i -= 1; // Retroceder para evitar el índice malo
            }
            i += j;
            j++;
        }

        return i;
    }

    public static int maxIndex2(int steps, int badIndex) {
        int i = 0, j = 1;
        for (int k = 0; k < steps; k++) {
            if (i + j == badIndex) {
                i--;
            }
            i += j;
            j++;
        }
        return i;
    }
}
