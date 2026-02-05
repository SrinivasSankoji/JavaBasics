package com.example.demo.structural.decorator.medium;

import java.util.ArrayList;
import java.util.List;

public abstract class PizzaDecorator implements Pizza {

    protected final Pizza pizza;

    protected PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public List<PriceLine> breakdown() {
        return new ArrayList<>(pizza.breakdown());
    }
}
