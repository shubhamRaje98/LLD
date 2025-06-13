package org.example.parkingLot;

public class ParkingSpotFactory {
    public static ParkingSpot getParkingSpot(SpotType spotType, int spotNumber){
        switch (spotType){
            case CAR_SPOT:
                return new CarParkingSpot(spotNumber);
            case BIKE_SPOT:
                return new BikeParkingSpot(spotNumber);
            case TRUCK_SPOT:
                return new TruckParkingSpot(spotNumber);
            case CYCLE_SPOT:
                return new CycleParkingSpot(spotNumber);
            default:
                throw  new IllegalArgumentException("Invalid spot");
        }
    }
}
