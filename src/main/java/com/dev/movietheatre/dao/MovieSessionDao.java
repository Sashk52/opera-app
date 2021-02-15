package com.dev.movietheatre.dao;

import com.dev.movietheatre.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession session);

    Optional<MovieSession> getById(Long id);

    MovieSession update(MovieSession movieSession);

    void delete(Long id);
}
