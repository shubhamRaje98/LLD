package org.example.Vehicle;

import org.example.parkingLot.SpotType;

public class Truck extends Vehicle{

    static final double RATE = 15.0;
    public Truck(String licensePlate) {
        super(VehicleType.TRUCK, licensePlate);
    }

    @Override
    public double calculateFees(double hoursStayed) {
        return hoursStayed*RATE;
    }

    @Override
    public SpotType getParkingSpotType() {
        return SpotType.TRUCK_SPOT;
    }
}
