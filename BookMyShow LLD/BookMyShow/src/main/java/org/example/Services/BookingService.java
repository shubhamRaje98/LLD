package org.example.Services;

import org.example.utilities.BookingDataFactory;
import org.example.entities.Movie;
import org.example.entities.Seat;
import org.example.entities.Show;
import org.example.enums.City;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class BookingService {
    private static BookingService instance; //Singleton instance

    private final MovieService movieService;
    private final TheaterService theaterService;
    private final Scanner scanner;


    private BookingService(){
        movieService = new MovieService();
        theaterService = new TheaterService();
        scanner = new Scanner(System.in);
    }

    public static BookingService getInstance(){
        if(instance==null){
            synchronized(BookingService.class){
                if(instance==null){
                    instance = new BookingService();
                }
            }
        }
        return instance;
    }

    public void startBookingSession(){
        System.out.println("\uD83D\uDE00 Welcome to BookMyShow");
        City city = selectCity();
        Movie movie = selectMovie(city);
        Show show = selectShow(movie);
        bookASeat(show);
    }

    private void bookASeat(Show show) {
        System.out.println("Select a seat for "+show.getMovie().getMovieName());
        List<Seat> bookedSeats = show.getBookedSeats();
        System.out.println("Screens: "+show.getScreen());
        List<Seat> allSeats = show.getScreen().getSeats();

        int userChoice = scanner.nextInt();
        Seat seat = allSeats.get(userChoice-1);

        if(bookedSeats.contains(seat)){
            System.out.println("Seat is already booked");
            bookASeat(show);
        }

        show.getBookedSeats().add(seat);
        PaymentService paymentService = new PaymentService();
        boolean paymentSuccess = paymentService.processPayment(250); // Example amount

        if (paymentSuccess) {
            System.out.println("✅ Booking Successful! Enjoy your movie! 🍿");
            generateTicket(show, seat);
        } else {
            System.out.println("❌ Payment failed! Please try again.");
            show.getBookedSeats().remove(seat); // Revert seat booking
        }

    }

    private void generateTicket(Show show, Seat seat) {
        System.out.println("\n========================================");
        System.out.println("🎟️       MOVIE TICKET CONFIRMATION       🎟️");
        System.out.println("========================================");
        System.out.println("🎬 Movie: " + show.getMovie().getMovieName());
        System.out.println("⏰ Show Time: " + show.getShowStartTime() + ":00");
        System.out.println("💺 Seat Number: " + seat.getSeatId());
        System.out.println("----------------------------------------");
        System.out.println("📅 Date: " + java.time.LocalDate.now());
        System.out.println("🆔 Booking ID: " + UUID.randomUUID());
        System.out.println("========================================");
        System.out.println("🎉 Enjoy your movie! 🍿 Have a great time!");
        System.out.println("========================================\n");
    }

    private void showSeats(Show show){
        System.out.println("Bellow are the seats: ");
        List<Seat> bookedSeats = show.getBookedSeats();
        List<Seat> allSeats = show.getScreen().getSeats();

        int cnt = 1;
        for(Seat seat: allSeats){
            if(bookedSeats.contains(seat)){
                System.out.print((cnt++) + ": " + seat.getSeatId() + " booked "+ seat.getSeatType());
            }else{
                System.out.print((cnt++) + ": " + seat.getSeatId() + "available " + seat.getSeatType());
            }
        }
    }

    private Show selectShow(Movie movie) {
        System.out.println("Enter the show for movie: "+movie.getMovieName());
        List<Show> shows = theaterService.getShowsByMovie(movie);
        int cnt = 1;

        for(Show show: shows){
            System.out.println((cnt++)+": "+show.getShowStartTime() + " - " + show.getShowEndTime());
        }

        int userChoice = scanner.nextInt();
        return shows.get(userChoice-1);
    }

    public City selectCity(){
        System.out.println("Select a city: ");
        int cnt = 1;
        for(City city: City.values()){
            System.out.println((cnt++)+": "+city);
        }

        int userChoice = scanner.nextInt();
        City[] cities = City.values();

        return cities[userChoice-1];
    }

    public Movie selectMovie(City city){
        System.out.println("Select a movie in "+city);
        List<Movie> movies = movieService.getMoviesByCity(city);
        int cnt = 1;
        for(Movie movie: movies){
            System.out.println((cnt++)+": "+movie.getMovieName());
        }
        int userChoice = scanner.nextInt();
        return movies.get(userChoice - 1);
    }

    public void initialize(){
        BookingDataFactory bookingDataFactory = new BookingDataFactory();
        bookingDataFactory.createMovies(movieService);
        bookingDataFactory.createTheaters(movieService, theaterService);
    }
}
