package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.dao.MovieSessionDao;
import com.dev.movietheatre.model.MovieSession;
import com.dev.movietheatre.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private final MovieSessionDao movieSessionDao;

    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        return movieSessionDao.add(session);
    }

    @Override
    public MovieSession getById(Long id) {
        return movieSessionDao.getById(id);
    }

    @Override
    public MovieSession update(MovieSession moviesession) {
        return movieSessionDao.update(moviesession);
    }

    @Override
    public void delete(Long id) {
        movieSessionDao.delete(id);
    }
}
