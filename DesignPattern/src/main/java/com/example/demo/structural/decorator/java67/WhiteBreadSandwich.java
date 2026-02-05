package com.example.demo.structural.decorator.java67;

import java.math.BigDecimal;

/* Plain Sandwich */
public class WhiteBreadSandwich extends Sandwich {
    public WhiteBreadSandwich(String description) {
        description = description;
    }
    @Override
    public BigDecimal price() {
        return new BigDecimal("3.0");
    }
}
