package com.dev.movietheatre.controllers;

import com.dev.movietheatre.model.MovieSession;
import com.dev.movietheatre.model.dto.MovieSessionRequestDto;
import com.dev.movietheatre.model.dto.MovieSessionResponseDto;
import com.dev.movietheatre.service.MovieSessionMapper;
import com.dev.movietheatre.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie_sessions")
public class MovieSessionController {

    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public void addMovieSession(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionMapper.dtoToMovieSession(movieSessionRequestDto);
        movieSessionService.add(movieSession);
    }

    @GetMapping("/accessible")
    public List<MovieSessionResponseDto> findAvailableSessions(
            @RequestParam(value = "movieId") Long movieId,
            @RequestParam (value = "date")
            @DateTimeFormat (pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionMapper::mapMovieSessionToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updateMovieSession(@RequestBody MovieSessionRequestDto movieSessionRequestDto,
                                   @PathVariable Long id) {
        MovieSession movieSession = movieSessionMapper.dtoToMovieSession(movieSessionRequestDto);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
    }

    @DeleteMapping("/{id}")
    public void removeMovieSession(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
