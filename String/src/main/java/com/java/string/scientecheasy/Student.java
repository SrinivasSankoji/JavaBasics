package com.java.string.scientecheasy;

import lombok.Getter;

@Getter
public final class Student {

    private final String name;
    private final int rollNo;

    private final School school; // Added to break the Immutable Class

    public Student(String name, int rollNo, School school) {
        this.name = name;
        this.rollNo = rollNo;
        this.school = new School();
        this.school.setSchoolName(school.getSchoolName());
    }
    public static void main(String[] args) {
        School school = new School();
        school.setSchoolName("Suprabhat Model High School");
        Student st = new Student("Bhaumik", 7, school);
        String name = st.getName();
        int rollNo = st.getRollNo();
        System.out.println("Name: " +name);
        System.out.println("Roll no: " +rollNo);
        System.out.println("School name before modification: " +st.getSchool().getSchoolName());

        // Now, we will attempt to change school name.
        school.setSchoolName("DPS");
        System.out.println("School name after modification: " +st.getSchool().getSchoolName());
    }
}
