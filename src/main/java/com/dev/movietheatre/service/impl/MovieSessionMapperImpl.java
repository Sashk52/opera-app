package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.model.MovieSession;
import com.dev.movietheatre.model.dto.MovieSessionRequestDto;
import com.dev.movietheatre.model.dto.MovieSessionResponseDto;
import com.dev.movietheatre.service.CinemaHallService;
import com.dev.movietheatre.service.MovieService;
import com.dev.movietheatre.service.MovieSessionMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapperImpl implements MovieSessionMapper {

    private CinemaHallService cinemaHallService;
    private MovieService movieService;

    public MovieSessionMapperImpl(CinemaHallService cinemaHallService,
                                  MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    @Override
    public MovieSessionResponseDto mapMovieSessionToDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setMovieSessionId(movieSession.getId());
        movieSessionResponseDto.setMovieTitle(movieSession.getMovie().getTitle());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setShowTime(DateTimeFormatter.ISO_LOCAL_DATE
                .format(movieSession.getShowTime()));
        return movieSessionResponseDto;
    }

    @Override
    public MovieSession dtoToMovieSession(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.getById(movieSessionRequestDto.getMovieId()));
        LocalDateTime sessionTime = LocalDateTime.parse(movieSessionRequestDto.getShowTime(),
                DateTimeFormatter.ISO_LOCAL_DATE);
        movieSession.setShowTime(sessionTime);
        movieSession.setCinemaHall(cinemaHallService.getById(movieSessionRequestDto
                .getCinemaHallId()));
        return movieSession;
    }
}
