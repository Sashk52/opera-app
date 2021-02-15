package com.dev.movietheatre.dao;

import com.dev.movietheatre.model.CinemaHall;
import java.util.List;
import java.util.Optional;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();

    Optional<CinemaHall> getById(Long id);
}
