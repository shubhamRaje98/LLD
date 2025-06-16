package org.example.Factories;

import org.example.entities.Screen;
import org.example.entities.Seat;
import org.example.entities.Show;
import org.example.entities.Theater;
import org.example.enums.City;
import org.example.enums.SeatTypeEnum;

import java.util.*;

public class TheaterFactory {
    public static Theater createTheater(int theaterId, String theaterName, String theaterAddress, City city) {
        Theater Theater = new Theater(theaterId, theaterName, theaterAddress, city, createScreens());
        return Theater;
    }

    private static List<Screen> createScreens() {
        Screen screen = new Screen();
        screen.setScreenId(1);
        List<Show> shows = new ArrayList<>();
        screen.setShows(new ArrayList<>());
        screen.setSeats(createSeats());
        return Arrays.asList(screen);
    }

    private static List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if(i<30){
                seats.add(new Seat(i, SeatTypeEnum.SILVER));
            }else if(i<60){
                seats.add(new Seat(i, SeatTypeEnum.GOLD));
            }else{
                seats.add(new Seat(i, SeatTypeEnum.PLATINUM));
            }
        }
        return seats;
    }
}