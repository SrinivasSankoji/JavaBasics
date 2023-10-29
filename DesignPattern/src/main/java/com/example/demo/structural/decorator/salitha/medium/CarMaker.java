package com.example.demo.structural.decorator.salitha.medium;

public class CarMaker {

    public static void main(String[] args) {
        Car car=new RealCar();
        car.assemble();
        System.out.println("\n*****");
        Car luxuryCar=new LuxuryCar(car);
        luxuryCar.assemble();
    }
}
