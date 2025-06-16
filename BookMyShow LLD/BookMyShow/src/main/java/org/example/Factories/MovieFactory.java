package org.example.Factories;

import org.example.entities.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieFactory {
    private static final Map<String, Movie> movieCache = new HashMap<>();

    public static Movie createMovie(int id, String name, int duration, List<String> cast) {
        return movieCache.computeIfAbsent(name, k -> new Movie(id, name, duration, cast));
    }
}