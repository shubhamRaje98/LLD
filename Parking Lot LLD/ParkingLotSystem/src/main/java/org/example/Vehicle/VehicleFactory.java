package org.example.Vehicle;

public class VehicleFactory {

    public static Vehicle getVehicle(VehicleType vehicleType, String licensePlate){
        switch (vehicleType){
            case CAR:
                return new Car(licensePlate);
            case BIKE:
                return new Bike(licensePlate);
            case TRUCK:
                return new Truck(licensePlate);
            case CYCLE:
                return new Cycle(licensePlate);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: "+vehicleType);
        }
    }
}
