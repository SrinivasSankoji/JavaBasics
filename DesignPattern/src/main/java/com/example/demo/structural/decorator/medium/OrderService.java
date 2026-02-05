package com.example.demo.structural.decorator.medium;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {

    private final PizzaBuilder pizzaBuilder;
    private final Map<String, OrderRequest> orders = new ConcurrentHashMap<>();

    public OrderService(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public OrderResponse create(OrderRequest req) {
        String id = UUID.randomUUID().toString();
        orders.put(id, req);
        return toResponse(id, req);
    }

    public OrderResponse update(String orderId, OrderRequest req) {
        if (!orders.containsKey(orderId)) {
            throw new NoSuchElementException("Order not found: " + orderId);
        }
        orders.put(orderId, req);
        return toResponse(orderId, req);
    }

    public OrderResponse get(String orderId) {
        OrderRequest req = orders.get(orderId);
        if (req == null) throw new NoSuchElementException("Order not found: " + orderId);
        return toResponse(orderId, req);
    }

    private OrderResponse toResponse(String id, OrderRequest req) {
        List<String> toppings = (req.toppings() == null) ? List.of() : req.toppings();
        Pizza pizza = pizzaBuilder.build(toppings);

        List<LineItem> breakdown = pizza.breakdown().stream()
                .map(pl -> new LineItem(pl.item(), pl.amount()))
                .toList();

        return new OrderResponse(
                id,
                pizza.description(),
                pizza.price(),
                breakdown
        );
    }
}
