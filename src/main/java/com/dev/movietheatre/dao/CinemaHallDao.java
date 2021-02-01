package com.dev.movietheatre.dao;

import com.dev.movietheatre.model.CinemaHall;
import java.util.List;

public interface CinemaHallDao {

    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}
