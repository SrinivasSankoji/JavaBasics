package com.example.demo.structural.decorator.salitha.medium;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class CarDecorator implements Car {
    Car car;

    @Override
    public void assemble() {
        this.car.assemble();
    }
}
