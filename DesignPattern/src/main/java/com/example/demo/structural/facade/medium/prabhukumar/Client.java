package com.example.demo.structural.facade.medium.prabhukumar;

public class Client {
    public static void main(String[] args) {
        /* Without Facade Client should have knowledge about */
        /* Billing System and Invoice System */
       /* BillingSystem billingSystem=new BillingSystem();
        Bill bill=billingSystem.generateBill(5400);
        InvoiceSystem invoiceSystem=new InvoiceSystem();
        invoiceSystem.generateInvoice(bill);*/

        /* With Facade Implementation */
        FinancialSystem financialSystem=new FinancialSystem();
        financialSystem.createBillAndInvoice(6000);

    }
}
