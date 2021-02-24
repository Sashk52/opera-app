package com.dev.opera.app.service;

import com.dev.opera.app.model.Stage;
import com.dev.opera.app.model.dto.StageRequestDto;
import com.dev.opera.app.model.dto.StageResponseDto;

public interface StageMapper {
    StageResponseDto mapCinemaHallToDto(Stage stage);

    Stage dtoToCinemaHall(StageRequestDto stageRequestDto);
}
