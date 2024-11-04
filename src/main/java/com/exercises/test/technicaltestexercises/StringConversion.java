package com.exercises.test.technicaltestexercises;

/**
 * Los siguientes son los casos posibles:
 * <p>
 * Si los caracteres adyacentes son "11", se pueden convertir en "00" con 1 operación.
 * Si los caracteres adyacentes son "01", se pueden convertir de la siguiente manera: "01" → "11" → "00". Por lo tanto, se necesitan 2 operaciones.
 * Una lógica similar se aplica para "10".
 * Por lo tanto, si hay x unos consecutivos en la cadena, entonces:
 * <p>
 * Si x es par, todos ellos se pueden convertir en 0s en (x/2) operaciones.
 * Si x es impar, entonces (x - 1) se pueden convertir en (x - 1)/2 operaciones, y el carácter restante tomará 2 operaciones, por lo que el total será (x - 1)/2 + 2.
 * Sumar esto para todas las secciones consecutivas de unos da el número total mínimo de operaciones.
 */

public class StringConversion {

    public static int getMinimumOperations(String binaryStr) {
        int cnt = 0, ans = 0;

        for (char elem : binaryStr.toCharArray()) {
            if (elem == '1') {
                cnt++;
            } else {
                ans += getOperations(cnt);
                cnt = 0;
            }
        }

        // Asegurarse de agregar las operaciones de la última secuencia de 1s si las hay
        ans += getOperations(cnt);

        return ans;
    }

    private static int getOperations(int x) {
        if (x % 2 == 0) {
            return x / 2;
        } else {
            return ((x - 1) / 2) + 2;
        }
    }

    public static int getMinimumOperations2(String binaryStr) {
        int count = 0, operations = 0;

        for (char ch : binaryStr.toCharArray()) {
            if (ch == '1') {
                count++;
            } else {
                operations += getOperations2(count);
                count = 0;
            }
        }

        operations += getOperations(count);
        return operations;
    }

    private static int getOperations2(int x) {
        if (x % 2 == 0) {
            return x / 2;
        } else {
            return (x - 1) / 2 + 2;
        }
    }
}
