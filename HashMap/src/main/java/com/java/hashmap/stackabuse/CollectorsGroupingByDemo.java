package com.java.hashmap.stackabuse;

import com.java.hashmap.stackabuse.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorsGroupingByDemo {

    static List<Student> students = Arrays.asList(
            new Student("John", "Smith", "Miami", 7.38, 19),
            new Student("Mike", "Miles", "New York", 8.4, 21),
            new Student("Michael", "Peterson", "New York", 7.5, 20),
            new Student("James", "Robertson", "Miami", 9.1, 20),
            new Student("Kyle", "Miller", "Miami", 9.83, 20),
            new Student("John", "Smith", "Miami", 8.93, 19)
    );

    public static void main(String[] args) {
        /* Collectors.groupingBy() by using Classifier function */
       /* Map<String, List<Student>> result1=students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(result1);*/

        /* Collectors.groupingBy() by using Classifier function and Downstream Collector*/
        /*Map<String, List<String>> result2=students.stream()
                .collect(Collectors.groupingBy(Student::getCity,Collectors.mapping(Student::getName,Collectors.toList())));
        System.out.println(result2);*/

        /* Collectors.groupingBy() by using Classifier function and Counting */
        /*Map<String, Long> result3=students.stream()
                .collect(Collectors.groupingBy(Student::getCity,Collectors.counting()));
        System.out.println(result3);*/

        /* Collectors.groupingBy() by using Classifier function,Supplier and Downstream function */
        Map<String, List<String>> result4=students.stream()
                .collect(Collectors.groupingBy(Student::getCity, TreeMap::new,Collectors.mapping(Student::getName,Collectors.toList())));
        System.out.println(result4);


    }
}
