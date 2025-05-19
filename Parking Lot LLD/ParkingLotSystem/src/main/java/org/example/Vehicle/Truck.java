package org.example.Vehicle;

public class Truck extends Vehicle{

    static final double RATE = 15.0;
    public Truck(String licensePlate) {
        super(VehicleType.TRUCK, licensePlate);
    }

    @Override
    public double calculateFees(double hoursStayed) {
        return hoursStayed*RATE;
    }
}
