package org.example.payment;

public class CreditPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amt) {
        System.out.println("Credit payment call");
    }
}
