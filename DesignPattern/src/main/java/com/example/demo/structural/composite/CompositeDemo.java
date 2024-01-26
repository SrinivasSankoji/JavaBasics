package com.example.demo.structural.composite;

public class CompositeDemo {
    public static void main(String[] args) {
        CEO ceo = new CEO("Nandini", "COM", "Chief Executive Officer");

        Developer developer1 = new Developer("Srinivas", "ENG", "Project manager");
        Developer developer2 = new Developer("XYZ", "ENG", "Associate Software Engineer");

        CompanyDirectory softwareCompany=new CompanyDirectory();
        softwareCompany.addEmployee(ceo);
        softwareCompany.addEmployee(developer1);
        softwareCompany.addEmployee(developer2);

        Company company = new Company("N Technologies");
        company.addEmployee(softwareCompany);
        company.showCompanyName();
        company.showDetails();
    }
}
