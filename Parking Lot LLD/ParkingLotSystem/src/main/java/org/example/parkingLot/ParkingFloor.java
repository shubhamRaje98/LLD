package org.example.parkingLot;

import org.example.Vehicle.Vehicle;

import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private List<ParkingSpot> spots;
    private ParkingSpotFactory parkingSpotFactory;
    private int floorNumber;

    public ParkingFloor(int floorNumber, Map<SpotType, Integer> numberOfEachSpotTypes){
        this.floorNumber = floorNumber;
        int spotNo = 1;
        for(Map.Entry<SpotType, Integer> en: numberOfEachSpotTypes.entrySet()){
            for(; spotNo<=en.getValue(); spotNo++){
                this.spots.add(parkingSpotFactory.getParkingSpot(en.getKey(), spotNo));
            }
        }
    }

    public ParkingSpot findParkingSpot(SpotType spotType){
        for(ParkingSpot parkingSpot: spots){
            if(parkingSpot.getSpotType() == spotType && !parkingSpot.isOccupied()){
                return parkingSpot;
            }
        }
        return null;
    }
    public List<ParkingSpot> getParkingSpots(){
        return spots;
    }
    public int getFloorNumber(){
        return this.floorNumber;
    }

}
