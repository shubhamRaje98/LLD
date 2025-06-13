package org.example.parkingLot;

import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleType;

public class CarParkingSpot extends ParkingSpot {

    VehicleType vehicleType;
     CarParkingSpot(int spotNumber) {
        super(spotNumber, SpotType.CAR_SPOT);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
         if(isOccupied()) return false;
         return vehicle.getVehicleType()==vehicleType.CAR;
    }
}
