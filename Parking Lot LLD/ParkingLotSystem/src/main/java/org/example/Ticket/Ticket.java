package org.example.Ticket;

import org.example.Vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    final Vehicle vehicle;
    final LocalDateTime startTime;

    public Ticket(Vehicle vehicle){
        this.vehicle = vehicle;
        this.startTime = LocalDateTime.now();
    }
}
