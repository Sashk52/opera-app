package com.dev.opera.app.controllers;

import com.dev.opera.app.model.Performance;
import com.dev.opera.app.model.dto.PerformanceRequestDto;
import com.dev.opera.app.model.dto.PerformanceResponseDto;
import com.dev.opera.app.service.PerformanceMapper;
import com.dev.opera.app.service.PerformanceService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performances")
public class PerformanceController {

    private final PerformanceService performanceService;
    private final PerformanceMapper performanceMapper;

    public PerformanceController(PerformanceService performanceService,
                                 PerformanceMapper performanceMapper) {
        this.performanceService = performanceService;
        this.performanceMapper = performanceMapper;
    }

    @PostMapping
    public void addPerformance(@RequestBody PerformanceRequestDto performanceRequestDto) {
        Performance performance = performanceMapper.dtoToMovie(performanceRequestDto);
        performanceService.add(performance);
    }

    @GetMapping
    public List<PerformanceResponseDto> getAll() {
        return performanceService.getAll()
                .stream()
                .map(performanceMapper::mapMovieToDto)
                .collect(Collectors.toList());
    }
}
