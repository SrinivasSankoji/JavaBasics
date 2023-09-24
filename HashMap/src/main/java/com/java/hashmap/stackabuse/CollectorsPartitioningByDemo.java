package com.java.hashmap.stackabuse;

import com.java.hashmap.stackabuse.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsPartitioningByDemo {

    static List<Student> students = Arrays.asList(
            new Student("John", "Smith", "Miami", 7.38, 19),
            new Student("Mike", "Miles", "New York", 8.4, 21),
            new Student("Michael", "Peterson", "New York", 7.5, 20),
            new Student("James", "Robertson", "Miami", 9.1, 20),
            new Student("Kyle", "Miller", "Miami", 9.83, 20),
            new Student("John", "Smith", "Miami", 8.93, 19)
    );

    public static void main(String[] args) {
        /* Collectors partitioningBy with the Predicate Function */
       /* Map<Boolean, List<Student>> result1=students.stream().collect(Collectors.partitioningBy(student -> student.getName().length()>4));
        System.out.println(result1.keySet());*/

        /* Collectors partitioningBy with the Predicate Function and Downstream Function */
        Map<Boolean, List<String>> result2= students.stream().collect(Collectors.partitioningBy(student -> student.getAge()>20,Collectors.mapping(Student::getName,Collectors.toList())));
        System.out.println(result2);
    }
}
