package org.example.Vehicle;

import org.example.parkingLot.SpotType;

public class Car extends Vehicle{

    static final double RATE = 10.0;
    public Car(String licensePlate) {
        super(VehicleType.CAR, licensePlate);
    }

    @Override
    public double calculateFees(double hoursStayed) {
        return hoursStayed*RATE;
    }

    @Override
    public SpotType getParkingSpotType() {
        return SpotType.CAR_SPOT;
    }
}
