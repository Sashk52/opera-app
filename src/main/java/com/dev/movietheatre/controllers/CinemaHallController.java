package com.dev.movietheatre.controllers;

import com.dev.movietheatre.model.CinemaHall;
import com.dev.movietheatre.model.dto.CinemaHallRequestDto;
import com.dev.movietheatre.model.dto.CinemaHallResponseDto;
import com.dev.movietheatre.service.CinemaHallMapper;
import com.dev.movietheatre.service.CinemaHallService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cineme-halls")
public class CinemaHallController {

    private final CinemaHallService cinemaHallService;
    private final CinemaHallMapper cinemaHallMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @PostMapping
    public void addCinemaHall(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = cinemaHallMapper.dtoToCinemaHall(cinemaHallRequestDto);
        cinemaHallService.add(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHallMapper::mapCinemaHallToDto)
                .collect(Collectors.toList());
    }
}
