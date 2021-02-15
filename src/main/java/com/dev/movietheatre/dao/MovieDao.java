package com.dev.movietheatre.dao;

import com.dev.movietheatre.model.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieDao {

    Movie add(Movie movie);

    List<Movie> getAll();

    Optional<Movie> getById(Long id);
}
