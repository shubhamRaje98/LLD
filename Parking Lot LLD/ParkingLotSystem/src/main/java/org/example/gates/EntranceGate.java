package org.example.gates;

import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleType;
import org.example.parkingLot.ParkingLot;
import org.example.parkingLot.ParkingSpot;
import org.example.Vehicle.VehicleFactory;

import java.util.Scanner;

public class EntranceGate {
    private ParkingLot parkingLot;

    // Constructor to initialize EntranceGate with the parking lot
    public EntranceGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    // Method to process the vehicle entrance
    public void processEntrance() {
        VehicleType vehicleType = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the vehicle license plate: ");
        String licensePlate = scanner.next();
        System.out.println("Enter the vehicle type\n 1: Car\n2: Bike\n3: Cycle\n4: Truck ");
        int inputType = scanner.nextInt();

        switch (inputType){
            case 1:
                vehicleType = VehicleType.CAR;
            case 2:
                vehicleType = VehicleType.BIKE;
            case 3:
                vehicleType = VehicleType.CYCLE;
            case 4:
                vehicleType = VehicleType.TRUCK;
            default:
                System.out.println("Invalid vehicle type");
        }

        Vehicle vehicle = VehicleFactory.getVehicle(vehicleType, licensePlate);

        if (vehicle == null) {
            System.out.println("Invalid vehicle type! Only Car and Bike are allowed.");
            return;
        }

        //Generate ticket
        // Try to park the vehicle
        ParkingSpot spot = parkingLot.parkVehicle(vehicle);
        if (spot != null) {
            System.out.println("Vehicle parked successfully in spot: " + spot.getSpotNumber());
        } else {
            System.out.println("No available spots for the vehicle type.");
        }
    }
}
