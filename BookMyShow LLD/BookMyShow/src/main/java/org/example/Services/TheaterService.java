package org.example.Services;

import lombok.Getter;
import lombok.Setter;
import org.example.entities.Movie;
import org.example.entities.Screen;
import org.example.entities.Show;
import org.example.entities.Theater;
import org.example.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class TheaterService {
   Map<City, List<Theater>> cityVsTheaters;
   List<Theater> allTheaters;

   public TheaterService(){
       this.cityVsTheaters = new HashMap<>();
       this.allTheaters = new ArrayList<>();
   }
   public List<Theater> getTheaterByCity(City city){
       return cityVsTheaters.get(city);
   }

   public List<Show> getAllShowByCityAndMovie(City city, Movie movie){
       List<Show> result = new ArrayList<>();

       for(Theater theater: allTheaters){
           List<Show> shows = getAllShowFromTheater(theater);
           for(Show show: shows){
               if(show.getMovie().getMovieName().equalsIgnoreCase(movie.getMovieName()) && theater.getTheaterCity().equals(city)){
                   result.add(show);
               }
           }
       }

       return result;
   }

   public List<Show> getShowsByMovie(Movie movie){
       List<Show> allShows = new ArrayList<>();
       for(Theater theater: allTheaters){
           List<Show> shows = getAllShowFromTheater(theater);
           for(Show show: shows){
               if(show.getMovie().getMovieName().equalsIgnoreCase(movie.getMovieName())){
                   allShows.add(show);
               }
           }
       }
       return allShows;
   }

   public void addTheater(City city, Theater theater){
       allTheaters.add(theater);
       if(cityVsTheaters.containsKey(city)){
           cityVsTheaters.get(city).add(theater);
       }else{
           List<Theater> theaters = new ArrayList<>();
           theaters.add(theater);
           cityVsTheaters.put(city, theaters);
       }
   }

   public List<Show> getAllShowFromTheater(Theater theater){
       List<Show> shows = new ArrayList<>();

       List<Screen> screens = theater.getScreens();
       for(Screen screen: screens){
           shows.addAll(screen.getShows());
       }
       return shows;
   }

   public List<Screen> getAllScreens(Theater theater){
       return theater.getScreens();
   }
}
