package org.example.parkingLot;

import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleType;

public class BikeParkingSpot extends ParkingSpot{
    VehicleType vehicleType;
    BikeParkingSpot(int spotNumber) {
        super(spotNumber, SpotType.BIKE_SPOT);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        if(isOccupied()) return false;
        return vehicle.getVehicleType()==vehicleType.BIKE;
    }
}
