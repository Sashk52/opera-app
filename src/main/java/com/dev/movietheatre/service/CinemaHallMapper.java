package com.dev.movietheatre.service;

import com.dev.movietheatre.model.CinemaHall;
import com.dev.movietheatre.model.dto.CinemaHallRequestDto;
import com.dev.movietheatre.model.dto.CinemaHallResponseDto;

public interface CinemaHallMapper {
    CinemaHallResponseDto mapCinemaHallToDto(CinemaHall cinemaHall);

    CinemaHall dtoToCinemaHall(CinemaHallRequestDto cinemaHallRequestDto);
}
