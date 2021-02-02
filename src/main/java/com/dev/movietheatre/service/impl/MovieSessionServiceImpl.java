package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.dao.MovieSessionDao;
import com.dev.movietheatre.lib.Inject;
import com.dev.movietheatre.lib.Service;
import com.dev.movietheatre.model.MovieSession;
import com.dev.movietheatre.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    @Inject
    private MovieSessionDao movieSessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }
}
