package com.dev.movietheatre.service;

import com.dev.movietheatre.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession session);

    MovieSession getById(Long id);

    MovieSession update(MovieSession session);

    void delete(Long id);
}
