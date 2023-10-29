package com.example.demo.structural.facade.medium.abdulazizpulatjonov;

public class OrderFood {
    public static void main(String[] args) {
        Cook cook = new Cook();
        System.out.println(cook.prepareBreakfast());
    }
}
