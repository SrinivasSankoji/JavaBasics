package com.jio.ngo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPointerExamples {

    public static void main(String[] args) {
        reverseStringUsingSwap();
    }

    public static void twoSumUsingHashMap() {
        int[] numbers = {7, 2, 11, 15};
        int target = 13;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                System.out.println("Two numbers are " + complement + " and " + numbers[i]);
                return;
            } else {
                map.put(numbers[i], i);
            }
        }
    }

    public static void twoSumUsingTwoPointer() {
        int[] numbers = {2, 7, 11, 15};
        int target = 13;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                System.out.println("Two numbers are " + numbers[left] + " and " + numbers[right]);
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void removeDuplicatesFromSortedArrayTwoPointer() {
        int[] numbers = {1, 1, 2, 2, 3};
        int slow = 0;
        for (int fast = 1; fast < numbers.length; fast++) {
            if (numbers[fast] != numbers[slow]) {
                slow++;
                numbers[slow] = numbers[fast];
            }
        }
        slow = slow + 1;
        for (int i = 0; i < slow; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static List<List<Integer>> threeSumUsingTwoPointer() {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(numbers);
        int target = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == target) {
                    result.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));
                    while (left < right && numbers[left] == numbers[left + 1]) {
                        left++;
                    }
                    while (left < right && numbers[right] == numbers[right - 1]) {
                        right--;
                    }
                }
                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void moveZerosToEndTwoPointer() {
        int[] numbers = {0, 1, 0, 3, 12};
        int slow = 0;
        /* Moe all non-zero's to the front */
        for (int fast = 0; fast < numbers.length; fast++) {
            if (numbers[fast] != 0) {
                numbers[slow] = numbers[fast];
                slow++;
            }
        } /*  Output after for-loop [1, 3, 12, 3, 12] */
        /* Fill remaining positions with zero */
        while (slow < numbers.length) {
            numbers[slow] = 0;
            slow++;
        }
        System.out.println(Arrays.toString(numbers));
    }

    public static boolean isPalindromeTwoPointer() {
        String input = "A man, a plan, a canal: Panama";
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            /* Skip non-alpha-numeric characters from left */
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) {
                left++;
            }
            /* Skip non-alpha-numeric characters from right */
            while (left < right && !Character.isLetterOrDigit(input.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void reverseStringUsingSwap() {
        char[] characterArray = {'h', 'e', 'l', 'l', 'o'};
        int left = 0;
        int right = characterArray.length - 1;
        while (left < right) {
            char temp = characterArray[left];
            characterArray[left] = characterArray[right];
            characterArray[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(characterArray));
    }
}
