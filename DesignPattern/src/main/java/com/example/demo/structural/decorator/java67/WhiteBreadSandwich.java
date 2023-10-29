package com.example.demo.structural.decorator.java67;

import java.math.BigDecimal;

public class WhiteBreadSandwich extends Sandwich {
    public WhiteBreadSandwich(String desc) {
        description = desc;
    }
    @Override
    public BigDecimal price() {
        return new BigDecimal("3.0");
    }
}
