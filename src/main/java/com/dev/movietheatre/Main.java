package com.dev.movietheatre;

import com.dev.movietheatre.lib.Injector;
import com.dev.movietheatre.model.Movie;
import com.dev.movietheatre.service.MovieService;

public class Main {
private static Injector injector = Injector.getInstance("com.dev.movietheatre");
    public static void main(String[] args) {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);

        Movie movie = new Movie();
        movie.setTitle("Call");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);
    }
}
