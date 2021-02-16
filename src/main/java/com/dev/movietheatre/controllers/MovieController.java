package com.dev.movietheatre.controllers;

import com.dev.movietheatre.model.Movie;
import com.dev.movietheatre.model.dto.MovieRequestDto;
import com.dev.movietheatre.model.dto.MovieResponseDto;
import com.dev.movietheatre.service.MovieMapper;
import com.dev.movietheatre.service.MovieService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public void addMovie(@RequestBody MovieRequestDto movieRequestDto) {
        Movie movie = movieMapper.dtoToMovie(movieRequestDto);
        movieService.add(movie);
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(movieMapper::mapMovieToDto)
                .collect(Collectors.toList());
    }
}
