package com.dev.movietheatre.service;

import com.dev.movietheatre.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
