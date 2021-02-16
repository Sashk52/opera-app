package com.dev.movietheatre.service.impl;

import com.dev.movietheatre.model.Movie;
import com.dev.movietheatre.model.dto.MovieRequestDto;
import com.dev.movietheatre.model.dto.MovieResponseDto;
import com.dev.movietheatre.service.MovieMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl implements MovieMapper {
    @Override
    public MovieResponseDto mapMovieToDto(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setMovieId(movie.getId());
        movieResponseDto.setMovieTitle(movie.getTitle());
        movieResponseDto.setMovieDescription(movie.getDescription());
        return movieResponseDto;
    }

    @Override
    public Movie dtoToMovie(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getMovieTitle());
        movie.setDescription(movieRequestDto.getMovieDescription());
        return movie;
    }
}
