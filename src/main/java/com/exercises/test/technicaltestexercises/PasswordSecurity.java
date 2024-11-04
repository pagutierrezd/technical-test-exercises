package com.exercises.test.technicaltestexercises;

/**
 * Una cadena de contraseña, pwd, consiste en caracteres binarios (0s y 1s).
 * Un experto en ciberseguridad está tratando de determinar el número mínimo de cambios necesarios para hacer que la contraseña sea segura.
 * Para lograrlo, debe dividirse en subcadenas de longitud par y sin superposición. Cada subcadena solo puede contener 1s o 0s, no una mezcla.
 * Esto ayuda a garantizar que la contraseña sea fuerte y menos vulnerable a ataques de hacking.
 * Encuentra el número mínimo de caracteres que deben invertirse en la cadena de la contraseña, es decir, cambiados de 0 a 1 o de 1 a 0, para permitir que la cadena se divida como se describió.
 * <p>
 * Ejemplo
 * Dado pwd = "1110011000"
 * 1 1 1 0 0 1 1 0 0 0  ->  1 1 1 1 1 1 1 1 0 0
 * Es óptimo voltear tres ceros de la cadena pwd para obtener 1111111100, que ahora puede ser dividida en dos subcadenas válidas.
 * <p>
 * 1 1 1 1 1 1 1 1 0 0
 * ^       ^
 * Las dos subcadenas tienen longitudes de 8 y 2 respectivamente. Dado que ambas longitudes son pares, la división es válida. Por lo tanto, la respuesta es 3.
 * <p>
 * Ejemplos:
 * Entrada: 100110. En la función pwd = "100110"
 * Salida: 3
 * Explicación Una de las formas óptimas de convertir la cadena es invertir todos los 1s o todos los 0s para obtener "000000" o "111111",
 * lo que hace que ambas cadenas sean válidas sin divisiones. Esto requiere cambiar 3 caracteres para que todos sean 0s o 1s.
 * <p>
 * Entrada2: 101011. En la función pwd = "101011"
 * Salida2: 2
 */

public class PasswordSecurity {

    public static int getMinFlips(String pwd) {
        int n = pwd.length();
        int current = 0, flips = 0, i = 1;

        while (i < n) {
            if (pwd.charAt(i) == pwd.charAt(i - 1)) {
                current++;
            } else {
                if (current % 2 == 0) {
                    flips++;
                }
                current = 0;
                i++;
            }
            i++;
        }

        if (current % 2 == 0) {
            flips++;
        }

        return flips;
    }

    public static int getMinFlips2(String pwd) {
        int n = pwd.length();
        int cur = 0, ans = 0;
        int i = 1;

        while (i < n) {
            if (pwd.charAt(i) == pwd.charAt(i - 1)) {
                cur++;
            } else {
                if (cur % 2 == 0) {
                    ans++;
                }
                cur = 0;  // Reset current count
            }
            i++;  // Increment index
        }

        // Check for the last sequence
        if (cur % 2 == 0) {
            ans++;
        }

        return ans;
    }

}
