package org.example.parkingLot;

import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleType;

public class TruckParkingSpot extends ParkingSpot{

    TruckParkingSpot(int spotNumber) {
        super(spotNumber, SpotType.TRUCK_SPOT);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        if(isOccupied()) return false;
        return vehicle.getVehicleType()==VehicleType.TRUCK;
    }
}
