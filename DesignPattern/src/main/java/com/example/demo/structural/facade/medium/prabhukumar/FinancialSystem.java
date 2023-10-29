package com.example.demo.structural.facade.medium.prabhukumar;

public class FinancialSystem {
    private BillingSystem billingSystem;
    private InvoiceSystem invoiceSystem;

    public FinancialSystem() {
        this.billingSystem = new BillingSystem();
        this.invoiceSystem = new InvoiceSystem();
    }

    public void createBillAndInvoice(Integer amount) {
        Bill bill = billingSystem.generateBill(5400);
        invoiceSystem.generateInvoice(bill);
    }


}
