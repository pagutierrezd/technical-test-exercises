package com.exercises.test.technicaltestexercises;

/**
 * Cada carácter del alfabeto inglés en minúsculas ha sido asignado a dígitos como se muestra.
 * 1(ab) 2(cde) 3(fgh) 4(ijk) 5(lmn) 6(opq) 7(rst) ((uvw) 9(xyz)
 * El valor numérico correspondiente a cada letra es su valor asignado.
 * <p>
 * Una subcadena extraordinaria es aquella cuya suma de los valores asignados de cada letra es divisible por su longitud.
 * Dado un string de entrada input_str, cuenta su número total de subcadenas extraordinarias no vacías.
 * <p>
 * Ejemplo:
 * input_str = 'asdf'
 * bdh   →  input_str = "bdh" --- out: 4
 * abcd  →  input_str = "abcd" --- out: 6
 * <p>
 * Todas las subcadenas no vacías de input_str son probadas en la tabla.
 * String  Mapped  Sum   Length    Is divisible
 * a       1         1     1           Yes
 * s       7         7     1           Yes
 * d       2         2     1           Yes
 * f       3         3     1           Yes
 * as      1,7       8     2           Yes
 * sd      7,2       9     2            No
 * df      2,3       5     2            No
 * asd     1,7,2    10     3            No
 * sdf     7,2,3    12     3           Yes
 * asdf    1,7,2,3  13     4            No
 */

public class ExtraordinarySubstrings {
    public static int countSubstrings(String inputStr) {

        int n = inputStr.length();
        // Almacenar los valores mapeados para todas las letras minúsculas en un array
        int[] val = new int[26];
        int x = 1;

        for (int i = 0; i < 26; i++) {
            // El valor mapeado sigue siendo el mismo para cada 3 caracteres, excepto por 1
            if ((i + 1) % 3 == 0) {
                x++;
            }
            val[i] = x;
        }

        // Precomputar y almacenar los valores mapeados como suma prefijo
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = val[inputStr.charAt(i - 1) - 'a'];
            arr[i] += arr[i - 1];
        }

        // Contar el número de subcadenas extraordinarias
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if ((arr[j] - arr[i]) % (j - i) == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int countSubstrings2(String inputStr) {

        int n = inputStr.length();
        int[] val = new int[26];
        int x = 1;
        for (int i = 0; i < 26; i++) {
            if ((i + 1) % 3 == 0) {
                x++;
            }
            val[i] += x;
        }

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = val[inputStr.charAt(i - 1) - 'a'];
            arr[i] += arr[i - 1];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if ((arr[j] - arr[i]) % (j - i) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
