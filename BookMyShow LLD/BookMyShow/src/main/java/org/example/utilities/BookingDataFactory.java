package org.example.utilities;

import org.example.Factories.MovieFactory;
import org.example.Factories.TheaterFactory;
import org.example.Services.MovieService;
import org.example.Services.TheaterService;
import org.example.entities.*;
import org.example.enums.City;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BookingDataFactory {

    public static List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screens.add(screen1);
        return screens;
    }

    public static Show createShow(int showId, Movie movie, Screen screen, LocalDateTime showStartTime, LocalDateTime showEndTime) {
        Show show = new Show(showId, movie, screen, showStartTime, showEndTime, new ArrayList<>());
        return show;
    }

    public static List<Movie> createMovies(MovieService MovieService) {
        List<String> cast = new ArrayList<>();
        cast.add("Rebecca");
        cast.add("Shubham");
        Movie barbie = MovieFactory.createMovie(1, "BARBIE", 128, cast);
        Movie oppenheimer = MovieFactory.createMovie(2, "OPPENHEIMER", 180, cast);

        MovieService.addMovie(barbie, City.BANGLORE);
        MovieService.addMovie(barbie, City.DELHI);
        MovieService.addMovie(oppenheimer, City.BANGLORE);
        MovieService.addMovie(oppenheimer, City.DELHI);
        MovieService.addMovie(barbie, City.MUMBAI);
        MovieService.addMovie(oppenheimer, City.MUMBAI);
        return Arrays.asList(barbie, oppenheimer);
    }

    public static void createTheaters(MovieService MovieService, TheaterService TheaterService) {
        Movie barbie = MovieService.getMovieByName("BARBIE");
        Movie oppenheimer = MovieService.getMovieByName("OPPENHEIMER");

        Theater inox = TheaterFactory.createTheater(1, "INOX", "Ghodbandar road", City.BANGLORE);
        List<Screen> screens = inox.getScreens();

        for(Screen screen: screens){
            Show show = createShow(22, barbie, screen, LocalDateTime.of(2025, 8, 2, 13, 00, 0), LocalDateTime.of(2025, 8, 2, 15, 15, 0));
            Show show2 = createShow(23, oppenheimer, screen, LocalDateTime.of(2025, 9, 2, 14, 00, 0), LocalDateTime.of(2025, 8, 2, 16, 15, 0));
            List<Show> shows = new ArrayList<>();
            shows.add(show);
            shows.add(show2);

            screen.setShows(shows);
        }

        Theater pvr = TheaterFactory.createTheater(1, "INOX", "Ghodbandar road", City.BANGLORE);
        List<Screen> screens2 = inox.getScreens();
        for(Screen screen: screens){
            Show show = createShow(21, oppenheimer, screen, LocalDateTime.of(2025, 8, 2, 12, 00, 0), LocalDateTime.of(2025, 8, 2, 14, 15, 0));
            Show show2 = createShow(1, barbie, screen, LocalDateTime.of(2025, 9, 2, 16, 00, 0), LocalDateTime.of(2025, 8, 2, 19, 15, 0));
            List<Show> shows = new ArrayList<>();
            shows.add(show);
            shows.add(show2);

            screen.setShows(shows);
        }

        TheaterService.addTheater(City.BANGLORE, inox);
        TheaterService.addTheater(City.DELHI, pvr);
    }
}