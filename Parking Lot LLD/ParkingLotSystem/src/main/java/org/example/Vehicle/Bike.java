package org.example.Vehicle;

import org.example.parkingLot.SpotType;

public class Bike extends Vehicle{
    static final double RATE = 8.0;
    public Bike(String licensePlate) {
        super(VehicleType.BIKE, licensePlate);
    }
    @Override
    public double calculateFees(double hoursStayed) {
        return hoursStayed*RATE;
    }

    @Override
    public SpotType getParkingSpotType() {
        return SpotType.BIKE_SPOT;
    }
}
