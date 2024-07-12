package com.java.oops.constructor;

import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private int age;

    /* Argument Constructor */
    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /* Copy Constructor */
    public Student(Student student) {
        this.firstName = student.firstName;
        this.lastName = student.lastName;
        this.age = student.age;
    }

    public void displayStudent () {
        System.out.println("First Name : " + this.firstName);
        System.out.println("Last Name : " + this.lastName);
        System.out.println("Age : " + this.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    public static void main(String[] args) {
        /* call to argument constructor */
        Student s1=new Student("Srinivas","Chary",37);
        /* call to copy constructor */
        Student s2=new Student(s1);
        System.out.println(s1==s2); //false
        System.out.println(s1.equals(s2)); //true

    }

}
