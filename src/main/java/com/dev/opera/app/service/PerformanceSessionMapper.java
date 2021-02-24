package com.dev.opera.app.service;

import com.dev.opera.app.model.PerformanceSession;
import com.dev.opera.app.model.dto.PerformanceSessionRequestDto;
import com.dev.opera.app.model.dto.PerformanceSessionResponseDto;

public interface PerformanceSessionMapper {
    PerformanceSessionResponseDto mapMovieSessionToDto(PerformanceSession performanceSession);

    PerformanceSession dtoToMovieSession(PerformanceSessionRequestDto performanceSessionRequestDto);
}
