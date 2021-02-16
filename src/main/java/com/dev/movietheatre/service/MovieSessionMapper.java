package com.dev.movietheatre.service;

import com.dev.movietheatre.model.MovieSession;
import com.dev.movietheatre.model.dto.MovieSessionRequestDto;
import com.dev.movietheatre.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper {
    MovieSessionResponseDto mapMovieSessionToDto(MovieSession movieSession);

    MovieSession dtoToMovieSession(MovieSessionRequestDto movieSessionRequestDto);
}
