package com.example.demo.structural.decorator.java67;

import java.math.BigDecimal;

public class CheeseSandwich extends SandwichDecorator {
    Sandwich sandwich;
    public CheeseSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }
    @Override
    public String getDescription() {
        return sandwich.getDescription()+ " along with Cheese";
    }
    @Override
    public BigDecimal price() {
        return sandwich.price().add(new BigDecimal("0.50"));
    }
}
