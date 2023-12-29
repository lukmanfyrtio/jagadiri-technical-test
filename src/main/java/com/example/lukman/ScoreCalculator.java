package com.example.lukman;

public class ScoreCalculator {

    public static int calculateScore(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int totalScore = 0;

        for (int num : arr) {
        	if (num == 5) {
                totalScore += 5;  // Add 5 points for every occurrence of 5
            }else if (num % 2 == 0) {
                totalScore += 1;  // Add 1 point for every even number
            }else if (num % 2 != 0) {
                totalScore += 3;  // Add 3 points for every odd number
            }
        }

        return totalScore;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5};
        int output1 = calculateScore(input1);
        System.out.println("Input: " + java.util.Arrays.toString(input1) + "\nOutput: " + output1);

        int[] input2 = {17, 19, 21};
        int output2 = calculateScore(input2);
        System.out.println("Input: " + java.util.Arrays.toString(input2) + "\nOutput: " + output2);

        int[] input3 = {5, 5, 5};
        int output3 = calculateScore(input3);
        System.out.println("Input: " + java.util.Arrays.toString(input3) + "\nOutput: " + output3);
    }
}

