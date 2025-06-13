package org.example.Vehicle;

import org.example.parkingLot.SpotType;

public class Cycle extends Vehicle{
    static final double RATE = 5.0;
    public Cycle(String licensePlate) {
        super(VehicleType.CYCLE, licensePlate);
    }
    @Override
    public double calculateFees(double hoursStayed) {
        return hoursStayed*RATE;
    }

    @Override
    public SpotType getParkingSpotType() {
        return SpotType.CYCLE_SPOT;
    }


}