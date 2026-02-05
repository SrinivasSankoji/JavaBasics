package com.example.demo.structural.decorator.medium;

import java.util.List;

public class PlainPizza implements Pizza {
    @Override
    public String description() {
        return "Plain Pizza";
    }

    /* Base price */
    @Override
    public double price() {
        return 200.0;
    }

    @Override
    public List<PriceLine> breakdown() {
        return List.of(new PriceLine("Plain Pizza (base)", 200.0));
    }
}
