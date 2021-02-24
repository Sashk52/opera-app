package com.dev.opera.app.service.impl;

import com.dev.opera.app.model.PerformanceSession;
import com.dev.opera.app.model.dto.PerformanceSessionRequestDto;
import com.dev.opera.app.model.dto.PerformanceSessionResponseDto;
import com.dev.opera.app.service.PerformanceService;
import com.dev.opera.app.service.PerformanceSessionMapper;
import com.dev.opera.app.service.StageService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionMapperImpl implements PerformanceSessionMapper {

    private StageService stageService;
    private PerformanceService performanceService;

    public PerformanceSessionMapperImpl(StageService stageService,
                                        PerformanceService performanceService) {
        this.stageService = stageService;
        this.performanceService = performanceService;
    }

    @Override
    public PerformanceSessionResponseDto mapMovieSessionToDto(
            PerformanceSession performanceSession) {
        PerformanceSessionResponseDto performanceSessionResponseDto =
                new PerformanceSessionResponseDto();
        performanceSessionResponseDto.setMovieSessionId(performanceSession.getId());
        performanceSessionResponseDto.setPerformanceTitle(performanceSession.getMovie().getTitle());
        performanceSessionResponseDto.setStageId(performanceSession.getCinemaHall().getId());
        performanceSessionResponseDto.setShowTime(DateTimeFormatter.ISO_LOCAL_DATE
                .format(performanceSession.getShowTime()));
        return performanceSessionResponseDto;
    }

    @Override
    public PerformanceSession dtoToMovieSession(
            PerformanceSessionRequestDto performanceSessionRequestDto) {
        PerformanceSession performanceSession = new PerformanceSession();
        performanceSession.setMovie(performanceService.getById(performanceSessionRequestDto
                .getPerformanceId()));
        LocalDateTime sessionTime = LocalDateTime.parse(performanceSessionRequestDto.getShowTime(),
                DateTimeFormatter.ISO_LOCAL_DATE);
        performanceSession.setShowTime(sessionTime);
        performanceSession.setCinemaHall(stageService.getById(performanceSessionRequestDto
                .getStageId()));
        return performanceSession;
    }
}
