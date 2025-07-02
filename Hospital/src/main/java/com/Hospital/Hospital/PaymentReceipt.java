package com.Hospital.Hospital;

public class PaymentReceipt {
    String department;
    int pay;

    public PaymentReceipt(String department, int pay) {
        this.department = department;
        this.pay = pay;
    }

    public void Receipt() {
        System.out.println("Department: " + this.department + " | Amount: " + this.pay + " rupees");
    }
}
