package com.exercises.test.technicaltestexercises;

import java.util.*;

/**
 * Un sistema de detección de contraseñas para cuentas de HackerRank detecta que una contraseña es "similar" si el número de vocales es igual al número de consonantes en la contraseña.
 * Las contraseñas consisten únicamente en caracteres en minúsculas del alfabeto inglés, y las vocales son ('a', 'e', 'i', 'o', 'u').
 * <p>
 * Para verificar la fortaleza de una contraseña y la facilidad con la que puede ser hackeada,
 * se pueden realizar manipulaciones en la contraseña. En una operación, cualquier carácter de la cadena
 * puede ser incrementado o decrementado. Por ejemplo, 'f' se puede incrementar a 'g' o decrementar a 'e'. Nota: el carácter 'a' no se puede decrementar y 'z' no se puede incrementar.
 * <p>
 * El objetivo es encontrar el número mínimo de operaciones necesarias para que la contraseña sea "similar".
 * <p>
 * Ejemplo
 * Considere la contraseña password = "hack".
 * <p>
 * La 'h' puede cambiarse a 'i' en una operación.
 * La cadena resultante es "iack", que tiene 2 vocales ('i', 'a') y 2 consonantes ('c', 'k'), lo que la hace "similar".
 * Devuelve 1, el número mínimo de operaciones necesarias.
 */

public class SimilarPassword {

    public static int countMinimumOperations(String password) {
        int n = password.length();
        int v = 0, c = 0;
        List<Integer> ops = new ArrayList<>();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (char ch : password.toCharArray()) {
            boolean isVowel = false;
            for (char vowel : vowels) {
                if (ch == vowel) {
                    v++;
                    isVowel = true;
                    break;
                }
            }

            if (!isVowel) {
                c++;
                int minOperations = 26;
                for (char vowel : vowels) {
                    minOperations = Math.min(minOperations, Math.abs(ch - vowel));
                }
                ops.add(minOperations);
            }
        }

        if (v >= c) {
            return (v - c) / 2;
        }

        Collections.sort(ops);
        int numChars = (c - v) / 2;
        int totalOperations = 0;
        for (int i = 0; i < numChars; i++) {
            totalOperations += ops.get(i);
        }

        return totalOperations;
    }

    public static int countMinimumOperations2(String password) {
        int n = password.length();
        int vowelCount = 0;
        int consonantCount = 0;
        List<Integer> operations = new ArrayList<>();

        for (char ch : password.toCharArray()) {
            if (isVowel(ch)) {
                vowelCount++;
            } else {
                int minOperations = 26;
                for (char vowel : "aeiou".toCharArray()) {
                    minOperations = Math.min(minOperations, Math.abs(ch - vowel));
                }
                consonantCount++;
                operations.add(minOperations);
            }
        }

        if (vowelCount >= consonantCount) {
            return (vowelCount - consonantCount) / 2;
        }

        Collections.sort(operations);
        int numCharsToChange = (consonantCount - vowelCount) / 2;
        return operations.subList(0, numCharsToChange).stream().mapToInt(Integer::intValue).sum();
    }

    private static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}
