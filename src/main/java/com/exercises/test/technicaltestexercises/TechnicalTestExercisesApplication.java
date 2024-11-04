package com.exercises.test.technicaltestexercises;

import java.util.*;
import java.util.ArrayList;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechnicalTestExercisesApplication {

    private static String inputStr;

    public static void main(String[] args) {

        //test ExtraordinarySubstrings
        String inputStr = "abcabc";
        int count = ExtraordinarySubstrings.countSubstrings(inputStr);
        System.out.println(count);

        //test MaximumIndex
        int steps = 4;
        int badIndex = 6;
        int maxIndex = MaximumIndex.maxIndex(steps, badIndex);
        System.out.println(maxIndex); // Output: 9

        //test SimiliarPassword
        String password = "aabbbc";
        int minOperations = SimilarPassword.countMinimumOperations(password);
        System.out.println(minOperations); // Output: 1

        //test Stringconversion
        String binaryStr = "1111";
        int minOperations2 = StringConversion.getMinimumOperations(binaryStr);
        System.out.println(minOperations2); // Output: 2

        //test PasswordSecurity
        String password2 = "100110";
        int minFlips = PasswordSecurity.getMinFlips2(password2);
        System.out.println(minFlips);

        List<String> dates = new ArrayList<>();
        dates.add("20th Oct 2052");
        dates.add("6th Jun 1933");
        dates.add("26th May 1960");

        List<String> formattedDates = ConvertDate.preprocessDate(dates);

        for (String date : formattedDates) {
            System.out.println(date);
        }

    }

}
