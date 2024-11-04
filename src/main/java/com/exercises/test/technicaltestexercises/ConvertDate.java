package com.exercises.test.technicaltestexercises;

import java.util.*;

/**
 * Dada una cadena de fecha en el formato Día Mes Año, donde:
 * El día es una cadena con el formato "1st", "2nd", "3rd", "21st", "22nd", "23rd"...
 * El mes son las primeras tres letras de los meses del idioma inglés, como "Jan" para enero y "Dic" para diciembre.
 * El año tiene 4 dígitos que van desde 1900 a 2100.
 * Convierta la cadena de fecha "Día Mes Año" a la cadena de fecha "YYYY-MM-DD" en el formato "año de 4 dígitos - mes de 2 dígitos - día de 2 dígitos"
 */

public class ConvertDate {

    public static List<String> preprocessDate(List<String> date) {
        List<String> rest = new ArrayList<>();

        // Mapa de meses
        HashMap<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        for (String value : date) {
            String[] data = value.split(" ");
            String fecha = data[2] + "-" + months.get(data[1]) + "-" + data[0].replaceAll("\\D", "").replaceAll("^(\\d)$", "0$1");
            rest.add(fecha);
        }

        return rest;
    }

}
