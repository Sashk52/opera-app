package com.dev.movietheatre.dao;

import com.dev.movietheatre.model.Movie;
import java.util.List;

public interface MovieDao {

    Movie add(Movie movie);

    List<Movie> getAll();
}
