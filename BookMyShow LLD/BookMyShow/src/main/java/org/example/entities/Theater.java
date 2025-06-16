package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.City;

import java.util.List;
@Setter
@Getter
public class Theater {
    int theaterId;
    String theaterName;
    String theaterAddress;
    City theaterCity;
    List<Screen> screens;

    public Theater(int theaterId, String theaterName, String theaterAddress, City theaterCity, List<Screen> screens){
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.theaterAddress = theaterAddress;
        this.theaterCity = theaterCity;
        this.screens = screens;
    }
}
