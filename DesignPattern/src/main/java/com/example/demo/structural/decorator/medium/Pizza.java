package com.example.demo.structural.decorator.medium;

import java.util.List;

public interface Pizza {
    String description();

    double price();

    List<PriceLine> breakdown();
}


