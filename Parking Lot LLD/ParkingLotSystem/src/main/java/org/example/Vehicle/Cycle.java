package org.example.Vehicle;

public class Cycle extends Vehicle{
    static final double RATE = 5.0;
    public Cycle(String licensePlate) {
        super(VehicleType.CYCLE, licensePlate);
    }
    @Override
    public double calculateFees(double hoursStayed) {
        return hoursStayed*RATE;
    }
}