package com.example.demo.structural.decorator.medium;

import java.util.List;

public record OrderResponse(
        String orderId,
        String description,
        double totalPrice,
        List<LineItem> breakdown
) {
}
