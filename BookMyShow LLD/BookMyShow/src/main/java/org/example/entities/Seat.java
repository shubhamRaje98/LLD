package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.SeatTypeEnum;

import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class Seat {
    int seatId;
    SeatTypeEnum seatType;
}
