package com.example.demo.structural.composite;

public class Company extends CompanyDirectory {

    private final String name;

    public Company(String name) {
        super();
        this.name = name;
    }

    public void showCompanyName() {
        System.out.println("Company: " + name);
    }
}
