package com.dev.movietheatre.service;

import com.dev.movietheatre.model.Movie;
import com.dev.movietheatre.model.dto.MovieRequestDto;
import com.dev.movietheatre.model.dto.MovieResponseDto;

public interface MovieMapper {
    MovieResponseDto mapMovieToDto(Movie movie);

    Movie dtoToMovie(MovieRequestDto movieRequestDto);
}
