package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.model.CinemaHall;
import com.dev.movietheatre.model.dto.CinemaHallRequestDto;
import com.dev.movietheatre.model.dto.CinemaHallResponseDto;
import com.dev.movietheatre.service.CinemaHallMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperImpl implements CinemaHallMapper {

    @Override
    public CinemaHallResponseDto mapCinemaHallToDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setCinemaHallId(cinemaHall.getId());
        cinemaHallResponseDto.setCinemaHallDescription(cinemaHall.getDescription());
        return cinemaHallResponseDto;
    }

    @Override
    public CinemaHall dtoToCinemaHall(CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setDescription(cinemaHallRequestDto.getCinemaHallDescription());
        return cinemaHall;
    }
}
