package org.example.payment;

public class CashPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amt) {
        System.out.println("Cash payment call");
    }
}

