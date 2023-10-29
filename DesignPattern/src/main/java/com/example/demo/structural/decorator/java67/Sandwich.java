package com.example.demo.structural.decorator.java67;

import java.math.BigDecimal;

public abstract class Sandwich {
    protected String description = "Sandwich";
    public String getDescription() {
        return description;
    }
    public abstract BigDecimal price();
}
