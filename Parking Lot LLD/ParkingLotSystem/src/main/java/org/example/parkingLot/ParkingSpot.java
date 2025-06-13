package org.example.parkingLot;

import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleType;
import org.example.parkingLot.SpotType;

public abstract class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Vehicle vehicle;
    private SpotType spotType;

    ParkingSpot(int spotNumber, SpotType spotType){
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public void vacate(){
        if(!isOccupied()){
            throw new IllegalStateException("The spot is already vacant");
        }
        this.vehicle = null;
        this.isOccupied = false;
    }

    public int getSpotNumber(){
        return this.spotNumber;
    }
    
    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public SpotType getParkingSpotOfVehicle(Vehicle vehicle){
        if(vehicle.getVehicleType() == VehicleType.CAR){
            return SpotType.CAR_SPOT;
        }else if(vehicle.getVehicleType() == VehicleType.BIKE){
            return SpotType.BIKE_SPOT;
        }else if(vehicle.getVehicleType() == VehicleType.TRUCK) {
            return SpotType.TRUCK_SPOT;
        }else if(vehicle.getVehicleType() == VehicleType.CYCLE) {
            return SpotType.CYCLE_SPOT;
        }else{
            throw new IllegalArgumentException("Invalid vehicle type!");
        }
    }
    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }
    public void occupySpot(){
        this.isOccupied = true;
    }

    public SpotType getSpotType() {
        return this.spotType;
    }

    public void parkVehicle(Vehicle vehicle) {
        if(!canParkVehicle(vehicle)){
            throw new IllegalStateException("Cannot park here");
        }
        setVehicle(vehicle);
        occupySpot();
    }
    public abstract boolean canParkVehicle(Vehicle vehicle);

    @Override
    public String toString(){
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", isOccupied=" + isOccupied +
                ", vehicle=" + (vehicle != null ? vehicle.getLicensePlate() : "None") +
                '}';
    }
}
