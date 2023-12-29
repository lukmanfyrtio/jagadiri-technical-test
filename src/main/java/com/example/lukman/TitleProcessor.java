package com.example.lukman;
import java.util.List;
import java.util.Arrays;

public class TitleProcessor {

    public static String processTitles(List<String> titles) {
        if (titles == null || titles.isEmpty()) {
            return ""; // Return an empty string for empty or null input
        }

        StringBuilder concatenatedTitles = new StringBuilder();
        for (String title : titles) {
            concatenatedTitles.append(title).append(" ");
        }

        // Remove numeric symbols
        String withoutNumericSymbols = concatenatedTitles.toString().replaceAll("[0-9]", "");

        // Capitalize the first character of each word
        String[] words = withoutNumericSymbols.split("\\s+");
        StringBuilder finalTitle = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                finalTitle.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
            }
        }

        return finalTitle.toString().trim(); // Remove trailing space and return the result
    }

    public static void main(String[] args) {
        List<String> input1 = Arrays.asList("breaking news5:", "1A 1circle is round!");
        System.out.println("Input: " + input1);
        System.out.println("Output: " + processTitles(input1));

        List<String> input2 = Arrays.asList("", "Fresh fried fish - fish fresh fried");
        System.out.println("\nInput: " + input2);
        System.out.println("Output: " + processTitles(input2));

        List<String> input3 = Arrays.asList("2Here2", "is", " our STRING");
        System.out.println("\nInput: " + input3);
        System.out.println("Output: " + processTitles(input3));

        List<String> input4 = Arrays.asList("123", "eat; sleep; repeat", "321");
        System.out.println("\nInput: " + input4);
        System.out.println("Output: " + processTitles(input4));
    }
}
