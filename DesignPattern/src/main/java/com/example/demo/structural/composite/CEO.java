package com.example.demo.structural.composite;

public class CEO implements  Employee{
    private final String name;
    private final String dept;
    private final String job;

    public CEO(String name, String dept, String job) {
        this.name = name;
        this.dept = dept;
        this.job = job;
    }

    @Override
    public void showDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "CEO{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
