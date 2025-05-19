package org.example.payment;

public class UPIPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amt) {
        System.out.println("UPI Payment call of" + amt);
    }
}
