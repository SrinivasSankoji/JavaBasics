package com.example.demo.structural.decorator.java67;

import java.math.BigDecimal;

public class CheeseDecorator extends SandwichDecorator {
    Sandwich sandwich;
    public CheeseDecorator(Sandwich sandwich) {
        this.sandwich = sandwich;
    }
    @Override
    public String getDescription() {
        return sandwich.getDescription()+ ", Cheese";
    }
    @Override
    public BigDecimal price() {
        return sandwich.price().add(new BigDecimal("0.50"));
    }
}
