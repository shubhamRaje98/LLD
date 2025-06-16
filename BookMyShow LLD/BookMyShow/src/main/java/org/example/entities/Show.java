package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class Show {
    int showId;
    Movie movie;
    Screen screen;
    LocalDateTime showStartTime;
    LocalDateTime showEndTime;
    List<Seat> bookedSeats;

    public Show(int showId, Movie movie, Screen screen, LocalDateTime showStartTime, LocalDateTime showEndTime, List<Seat> bookedSeats){
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.showStartTime = showStartTime;
        this.showEndTime = showEndTime;
        this.bookedSeats = bookedSeats;

       // watchShowTiming();
    }

//    public void watchShowTiming(){
//        while(true){
//            LocalDateTime now = LocalDateTime.now();
//            if(now.isBefore(getShowEndTime())){
//                setShowStatus(Status.SCHEDULED);
//            }else if(now.isAfter(getShowStartTime()) && now.isBefore(getShowEndTime())){
//                setShowStatus(Status.LIVE);
//            }else{
//                setShowStatus(Status.OVER);
//            }
//        }
//    }
//    public void unBookSeatsAfterTheShow(){
//        for(Seat seat: bookedSeats){
//            seat.unbook();
//        }
//    }
}
