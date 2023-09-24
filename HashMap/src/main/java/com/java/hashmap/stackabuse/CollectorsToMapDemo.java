package com.java.hashmap.stackabuse;

import com.java.hashmap.stackabuse.model.Student;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsToMapDemo {

    static List<Student> students = Arrays.asList(
            new Student("John", "Smith", "Miami", 7.38, 19),
            new Student("Mike", "Miles", "New York", 8.4, 21),
            new Student("Michael", "Peterson", "New York", 7.5, 20),
            new Student("James", "Robertson", "Miami", 9.1, 20),
            new Student("Kyle", "Miller", "Miami", 9.83, 20),
            new Student("John", "Smith", "Miami", 8.93, 19)
    );

    public static void main(String[] args) {
        /* Collectors toMap()  with KeyMapper and Value Mapper */
        /*Map<String, Double> result1 = students.stream().collect(Collectors.toMap(Student::getName, Student::getAvgGrade));
        System.out.println(result1);*/

        /* Collectors toMap()  with KeyMapper,Value Mapper and merge Function */
        /*Map<String, Double> result2 = students.stream()
                .collect(Collectors.toMap(Student::getName, Student::getAvgGrade,(a, b) -> (a+b)/2));
        System.out.println(result2);*/ // {Mike=8.4, Kyle=9.83, James=9.1, Michael=7.5, John=8.155}

        /* Collectors toMap()  with KeyMapper,Value Mapper,merge Function and Supplier Function */
        Map<String, Double> result3 = students.stream()
                .collect(Collectors.toMap(Student::getName, Student::getAvgGrade,(a, b) -> (a+b)/2, LinkedHashMap::new));
        System.out.println(result3); // {John=8.155, Mike=8.4, Michael=7.5, James=9.1, Kyle=9.83}
    }
}
