package com.jio.ngo.anilgoyal;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInterviewProgramming {

    public static void main(String[] args) {
        twoSumUsingTwoPointer();
    }

    public static void toMostFrequentElements() {
        List<Integer> numbers = List.of(1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 5, 5, 5, 5, 5);
        int k = 2;
        numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(k)
                .forEach(element -> System.out.println(element.getKey() + " appeared " + element.getValue() + " times"));
    }

    public static void secondMostFrequentElement() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1)
                .findFirst()
                .ifPresent(element -> System.out.println(element.getKey() + " appeared " + element.getValue() + " times"));
    }

    public static void mergeTwoLists() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);
        List<Integer> integerList = Stream.of(list1, list2).flatMap(List::stream).toList();
        System.out.println(integerList);
        Stream.of(list1, list2).flatMap(List::stream).toList().forEach(System.out::println);
    }

    public static void commonElementInTwoLists() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(3, 4, 5);
        list1.stream().filter(list2::contains).forEach(System.out::println);
    }

    public static void listOfStringToMapWithValueAsStringLength() {
        List<String> fruits = List.of("apple", "banana", "cherry", "apple");
        fruits.stream().collect(Collectors.toMap(Function.identity(), String::length, (fruit1, fruit2) -> fruit2, LinkedHashMap::new))
                .forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void reduceOperations() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        int result = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum of numbers : " + result);
        List<String> words = List.of("Java", "Streams", "are", "powerful");
        System.out.println("String join : " + words.stream().reduce("", String::concat));
    }

    public static void partitionStringByLength() {
        /*  Partition strings by length: short (<5), medium (5-10), long (>10) */
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grapefruit", "kiwi");
        words.stream().collect(
                Collectors.groupingBy(word -> {
                    if (word.length() < 5) {
                        return "Short";
                    } else if (word.length() <= 10) {
                        return "Medium";
                    } else
                        return "Long";
                })
        ).forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void repeatedCharacters() {
        String input = "programming";
        List<Character> repeatedCharacters = input.chars().mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(repeatedCharacters); // [r, g, m]
    }

    public static void repeatedCharactersCount() {
        String input = "programming";
        Map<Character, Long> repeatedCharacters = input.chars() // Returns an IntStream of ASCII values.
                .mapToObj(character -> (char) character) // Converts ASCII int → Character
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(repeatedCharacters); // {r=2, g=2, m=2}
    }

    /* For the word programming First Repeated character is r */
    public static void findFirstRepeatedCharacter() {
        String input = "programming";
        input.chars().mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(System.out::println); // r
    }

    /* For the word programming non-repeated characters are p, o, a, i, n */
    public static void findNonRepeatedCharacters() {
        String input = "programming";
    }

    /* For the word programming the highest frequency characters are r=2 g=2 m=2 */
    public static void findHighestFrequencyCharacters() {
        String input = "programming";
        /* Highest Frequency Characters means occurrence of the characters */
        input.chars().mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((key, value) -> System.out.println(key + " repeated " + value));
    }

    /* For the word programming the duplicate characters with ignoring case are r,g and m */
    public static void findDuplicateCharactersIgnoringCase() {
        String input = "programming";
    }

    /* For the sentence "java is easy and java is powerful" repeated words are [java, is] */
    public static void findRepeatedWords() {

    }

    public static void mapOfInitialsToConcatenatedNames() {
        List<String> names = List.of("Alice", "Anil", "Bob", "Charlie", "David", "Eve", "Frank");
        names.stream().collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.joining(",")))
                .forEach((key, value) -> System.out.println(key + " = " + value));
    }

    public static void longestWordInListOfStrings() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grapefruit", "kiwi");
        words.stream().reduce((word1, word2) -> word1.length() >= word2.length() ? word1 : word2)
                .ifPresent(System.out::println); // grapefruit
    }

    public static void shortestWordInListOfStrings() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grapefruit", "kiwi");
        words.stream().reduce((word1, word2) -> word1.length() <= word2.length() ? word1 : word2)
                .ifPresent(System.out::println); // grapefruit
    }

    public static void averageLengthOfString() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grapefruit", "kiwi");
        words.stream().mapToInt(String::length).average()
                .ifPresent(System.out::println); // 5.428571428571429
    }

    public static void sumOfLengthOfString() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grapefruit", "kiwi");
        int sum = words.stream().mapToInt(String::length).sum();
        System.out.println(sum); // 38
    }

    public static void countOfStringWithCharacter() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grapefruit", "kiwi");
        long count = words.stream().filter(word -> word.startsWith("a")).count();
        System.out.println(count);
    }

    public static void distinctString() {
        List<String> fruits = List.of("apple", "banana", "apple", "cherry", "banana", "date");
        System.out.println(fruits.stream().distinct().toList()); // [apple, banana, cherry, date]
    }

    public static void secondLongestWord() {
        List<String> fruits = List.of("apple", "banana", "cherry", "date", "fig", "grapefruit", "kiwi");
        fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Map.Entry::getKey)
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
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
}
