package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Screen {
    int screenId;
    List<Show> shows;
    List<Seat> seats;

    public Screen() {
        this.shows = new ArrayList<>();
        this.seats = new ArrayList<>();
    }
}
