package com.dev.opera.app.service.impl;

import com.dev.opera.app.model.Stage;
import com.dev.opera.app.model.dto.StageRequestDto;
import com.dev.opera.app.model.dto.StageResponseDto;
import com.dev.opera.app.service.StageMapper;
import org.springframework.stereotype.Component;

@Component
public class StageMapperImpl implements StageMapper {

    @Override
    public StageResponseDto mapCinemaHallToDto(Stage stage) {
        StageResponseDto stageResponseDto = new StageResponseDto();
        stageResponseDto.setStageId(stage.getId());
        stageResponseDto.setStageDescription(stage.getDescription());
        return stageResponseDto;
    }

    @Override
    public Stage dtoToCinemaHall(StageRequestDto stageRequestDto) {
        Stage stage = new Stage();
        stage.setDescription(stageRequestDto.getStageDescription());
        return stage;
    }
}
