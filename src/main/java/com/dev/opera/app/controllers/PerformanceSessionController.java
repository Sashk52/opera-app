package com.dev.opera.app.controllers;

import com.dev.opera.app.model.PerformanceSession;
import com.dev.opera.app.model.dto.PerformanceSessionRequestDto;
import com.dev.opera.app.model.dto.PerformanceSessionResponseDto;
import com.dev.opera.app.service.PerformanceSessionMapper;
import com.dev.opera.app.service.PerformanceSessionService;
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
@RequestMapping("/performances-sessions")
public class PerformanceSessionController {

    private final PerformanceSessionService performanceSessionService;
    private final PerformanceSessionMapper performanceSessionMapper;

    public PerformanceSessionController(PerformanceSessionService performanceSessionService,
                                        PerformanceSessionMapper performanceSessionMapper) {
        this.performanceSessionService = performanceSessionService;
        this.performanceSessionMapper = performanceSessionMapper;
    }

    @PostMapping
    public void addPerformanceSession(
            @RequestBody PerformanceSessionRequestDto performanceSessionRequestDto) {
        PerformanceSession performanceSession = performanceSessionMapper
                .dtoToMovieSession(performanceSessionRequestDto);
        performanceSessionService.add(performanceSession);
    }

    @GetMapping("/available")
    public List<PerformanceSessionResponseDto> findAvailableSessions(
            @RequestParam(value = "movieId") Long movieId,
            @RequestParam (value = "date")
            @DateTimeFormat (pattern = "dd.MM.yyyy") LocalDate date) {
        return performanceSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(performanceSessionMapper::mapMovieSessionToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updatePerformanceSession(
            @RequestBody PerformanceSessionRequestDto performanceSessionRequestDto,
                                   @PathVariable Long id) {
        PerformanceSession performanceSession = performanceSessionMapper
                .dtoToMovieSession(performanceSessionRequestDto);
        performanceSession.setId(id);
        performanceSessionService.update(performanceSession);
    }

    @DeleteMapping("/{id}")
    public void removeMovieSession(@PathVariable Long id) {
        performanceSessionService.delete(id);
    }
}
