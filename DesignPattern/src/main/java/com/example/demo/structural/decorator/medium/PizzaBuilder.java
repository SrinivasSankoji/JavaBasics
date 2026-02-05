package com.example.demo.structural.decorator.medium;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PizzaBuilder {

    public Pizza build(List<String> toppings) {
        Pizza pizza = new PlainPizza();
        for (String topping : toppings) {
            if (topping.equalsIgnoreCase("CHEESE")) {
                pizza = new CheeseDecorator(pizza);
            } else {
                throw new IllegalArgumentException("Unknown topping: " + topping);
            }
        }
        return pizza;
    }
}
