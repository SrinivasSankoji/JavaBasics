package com.example.demo.structural.decorator.medium;

import java.util.List;

public class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String description() {
        return pizza.description() + " + Cheese";
    }

    @Override
    public double price() {
        return pizza.price() + 40.0;
    }

    @Override
    public List<PriceLine> breakdown() {
        List<PriceLine> lines = super.breakdown();
        lines.add(new PriceLine("Cheese", 40.0));
        return lines;
    }
}
