package com.dev.opera.app.service;

import com.dev.opera.app.model.Performance;
import com.dev.opera.app.model.dto.PerformanceRequestDto;
import com.dev.opera.app.model.dto.PerformanceResponseDto;

public interface PerformanceMapper {
    PerformanceResponseDto mapMovieToDto(Performance performance);

    Performance dtoToMovie(PerformanceRequestDto performanceRequestDto);
}
