package org.example.parkingLot;

import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleType;

public class CycleParkingSpot extends ParkingSpot{
    VehicleType vehicleType;
    CycleParkingSpot(int spotNumber) {
        super(spotNumber, SpotType.CYCLE_SPOT);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        if(isOccupied()) return false;
        return vehicle.getVehicleType()==vehicleType.CYCLE;
    }
}
