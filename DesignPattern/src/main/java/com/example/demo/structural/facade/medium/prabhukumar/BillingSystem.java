package com.example.demo.structural.facade.medium.prabhukumar;

public class BillingSystem {

    public Bill generateBill(Integer amount) {
        return new Bill(amount);
    }
}
