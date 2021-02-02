package com.dev.movietheatre;

import com.dev.movietheatre.lib.Injector;
import com.dev.movietheatre.model.CinemaHall;
import com.dev.movietheatre.model.Movie;
import com.dev.movietheatre.model.MovieSession;
import com.dev.movietheatre.service.CinemaHallService;
import com.dev.movietheatre.service.MovieService;
import com.dev.movietheatre.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    private static Injector injector = Injector.getInstance("com.dev.movietheatre");


    public static void main(String[] args) {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        Movie movie = new Movie();
        movie.setTitle("Call");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);

        CinemaHallService cinemaHallService = (CinemaHallService) injector
                .getInstance(CinemaHallService.class);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription("Green");
        cinemaHallService.add(cinemaHall);
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSessionService movieSessionService = (MovieSessionService) injector
                .getInstance(MovieSessionService.class);
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        LocalDateTime localDateTime = LocalDateTime.of(2021, 02, 01, 15, 00);
        movieSession.setShowTime(localDateTime);
        movieSessionService.add(movieSession);
        LocalDate movieDate = LocalDate.of(2021,02,01);
        List<MovieSession> availableSessions = movieSessionService.findAvailableSessions(movie.getId(),
                movieDate);
        System.out.println(availableSessions.toString());
    }
}
