package com.example.demo.structural.decorator.medium;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponse create(@RequestBody OrderRequest request) {
        return orderService.create(request);
    }

    @PutMapping ("/{orderId}")
    public OrderResponse update(@PathVariable String orderId,
                                @RequestBody OrderRequest request) {
        return orderService.update(orderId, request);
    }

    @GetMapping ("/{orderId}")
    public OrderResponse get(@PathVariable String orderId) {
        return orderService.get(orderId);
    }
}
