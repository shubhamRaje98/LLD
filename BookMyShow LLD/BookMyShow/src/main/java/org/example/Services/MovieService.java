package org.example.Services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.entities.Movie;
import org.example.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class MovieService {
    Map<City, List<Movie>> cityVsMovies;
    List<Movie> movies;

    public MovieService(){
        this.cityVsMovies = new HashMap<>();
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city){
        movies.add(movie);

        if(cityVsMovies.containsKey(city)){
            cityVsMovies.get(city).add(movie);
        }else{
            List<Movie> movies1 = new ArrayList<>();
            movies1.add(movie);
            cityVsMovies.put(city, movies1);
        }
    }

    public List<Movie> getMoviesByCity(City city){
        List<Movie> movies = cityVsMovies.get(city);
        return movies==null ? new ArrayList<>() : movies;
    }

    public List<Movie> getAllMovies(){
        return movies;
    }
    public Movie getMovieByName(String movieName){
        List<Movie> movies = getAllMovies();

        for(Movie movie: movies){
            if(movie.getMovieName().contains(movieName)){
                return movie;
            }
        }

        return null;
    }
}
