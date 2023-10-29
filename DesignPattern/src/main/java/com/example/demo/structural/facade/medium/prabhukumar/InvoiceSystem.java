package com.example.demo.structural.facade.medium.prabhukumar;

public class InvoiceSystem {

    public void generateInvoice(Bill bill) {
        System.out.println("Creating invoice for bill with amount: " + bill.getAmount());
    }
}
