package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Movie {
    int movieId;
    String movieName;
    int movieDuration;
    List<String> cast;
}
