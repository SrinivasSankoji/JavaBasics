package com.java.string.scientecheasy;

import lombok.Getter;

@Getter
public final class ImmutableStudent {

    private final String name;
    private final int rollNo;

    private final MutableSchool school; // Added to break the Immutable Class

    public ImmutableStudent(String name, int rollNo, MutableSchool school) {
        this.name = name;
        this.rollNo = rollNo;
        this.school = new MutableSchool();
        this.school.setSchoolName(school.getSchoolName());
    }
    public static void main(String[] args) {
        MutableSchool school = new MutableSchool();
        school.setSchoolName("Suprabhat Model High School");
        ImmutableStudent st = new ImmutableStudent("Bhaumik", 7, school);
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
