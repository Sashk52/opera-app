package com.dev.opera.app.service.impl;

import com.dev.opera.app.model.Performance;
import com.dev.opera.app.model.dto.PerformanceRequestDto;
import com.dev.opera.app.model.dto.PerformanceResponseDto;
import com.dev.opera.app.service.PerformanceMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceMapperImpl implements PerformanceMapper {
    @Override
    public PerformanceResponseDto mapMovieToDto(Performance performance) {
        PerformanceResponseDto performanceResponseDto = new PerformanceResponseDto();
        performanceResponseDto.setPerformanceId(performance.getId());
        performanceResponseDto.setPerformanceTitle(performance.getTitle());
        performanceResponseDto.setPerformanceDescription(performance.getDescription());
        return performanceResponseDto;
    }

    @Override
    public Performance dtoToMovie(PerformanceRequestDto performanceRequestDto) {
        Performance performance = new Performance();
        performance.setTitle(performanceRequestDto.getPerformanceTitle());
        performance.setDescription(performanceRequestDto.getPerformanceDescription());
        return performance;
    }
}
