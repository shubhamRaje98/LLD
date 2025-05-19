package org.example.payment;

public class Payment {
    PaymentStrategy paymentStrategy;
    double amt;

    public Payment(double amt, PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
        this.amt = amt;
    }

    public void processPayment(){
        if(amt>0){
            paymentStrategy.processPayment(this.amt);
        }else{
            System.out.println("Invalid amount!");
        }
    }
}
