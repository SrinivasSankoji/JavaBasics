package com.jio.ngo.leetcode;

public class SlidingWindowFixedDemo {

    public static void main(String[] args) {
        System.out.println(maxVowels());
    }

    public static int maximumSubArray() {
        int[] numbers = {2, 1, 5, 1, 3, 2};
        int target = 3;
        int windowSum = 0;
        int maxSum = 0;
        /* initialize the first window */
        for (int i = 0; i < target; i++) {
            windowSum += numbers[i];
        }
        maxSum = windowSum;
        /* Slide the window by removing the old value and adding the new value */
        for (int i = target; i < numbers.length; i++) {
            windowSum = windowSum - numbers[i - target] + numbers[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static double[] averageSubArray() {
        int[] numbers = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int target = 5;
        int windowSum = 0;
        /* total number of windows in the result */
        double[] result = new double[numbers.length - target + 1];

        /* initialize the first window */
        for (int i = 0; i < target; i++) {
            windowSum += numbers[i];
        }
        result[0] = (double) windowSum / target;
        /* slide the window by removing the old element and adding the new element */
        for (int i = target; i < numbers.length; i++) {
            windowSum = windowSum - numbers[i - target] + numbers[i];
            result[i - target + 1] = (double) windowSum / target;

        }
        return result;
    }

    public static int maxVowels() {
        String alphabets = "abciiidef";
        int target = 3;
        int windowCount = 0;
        int maxCount = 0;

        /* initialize te window */
        for (int i = 0; i < target; i++) {
            if (isVowel(alphabets.charAt(i))) {
                windowCount++;
            }
        }
        maxCount = windowCount;
        /* slide the window */
        for (int i = target; i < alphabets.length(); i++) {
            if (isVowel(alphabets.charAt(i - target))) {
                windowCount--;
            }
            if (isVowel(alphabets.charAt(i))) {
                windowCount++;
            }
            maxCount = Math.max(maxCount, windowCount);
        }
        return maxCount;
    }

    private static boolean isVowel(Character character) {
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
    }
}
