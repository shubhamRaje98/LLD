package org.example.parkingLot;

import org.example.Vehicle.Vehicle;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(List<ParkingFloor> floors){
        this.parkingFloors = floors;
    }

    public List<ParkingFloor> getParkingFloors(){
        return parkingFloors;
    }
    public ParkingSpot findAvailableSpot(SpotType spotType){
        for(ParkingFloor parkingFloor: parkingFloors){
            ParkingSpot parkingSpot = parkingFloor.findParkingSpot(spotType);
            if(parkingSpot!=null){
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        SpotType spotType = vehicle.getParkingSpotType();
        ParkingSpot spot = findAvailableSpot(spotType);
        if(spot!=null){
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successfully in spot: " + spot.getSpotNumber());
            return spot;
        }
        System.out.println("No parking spots available for " + vehicle.getParkingSpotType() + "!");
        return null;
    }
    public void vacateSpot(ParkingSpot spot, Vehicle vehicle) {
        if (spot != null && spot.isOccupied() && spot.getVehicle().equals(vehicle)) {
            spot.vacate(); // Free the spot
            System.out.println(vehicle.getVehicleType() + " vacated the spot: " + spot.getSpotNumber());
        } else {
            System.out.println("Invalid operation! Either the spot is already vacant or the vehicle does not match.");
        }
    }

    // Method to find a spot by its number
    public ParkingSpot getSpotByNumber(int spotNumber) {
        for (ParkingFloor floor : parkingFloors) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (spot.getSpotNumber() == spotNumber) {
                    return spot;
                }
            }
        }
        return null; // Spot not found
    }
}
