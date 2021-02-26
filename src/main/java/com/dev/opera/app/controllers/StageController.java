package com.dev.opera.app.controllers;

import com.dev.opera.app.model.Stage;
import com.dev.opera.app.model.dto.StageRequestDto;
import com.dev.opera.app.model.dto.StageResponseDto;
import com.dev.opera.app.service.StageMapper;
import com.dev.opera.app.service.StageService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stages")
public class StageController {

    private final StageService stageService;
    private final StageMapper stageMapper;

    public StageController(StageService stageService,
                           StageMapper stageMapper) {
        this.stageService = stageService;
        this.stageMapper = stageMapper;
    }

    @PostMapping
    public void addStage(@RequestBody StageRequestDto stageRequestDto) {
        Stage stage = stageMapper.dtoToCinemaHall(stageRequestDto);
        stageService.add(stage);
    }

    @GetMapping
    public List<StageResponseDto> getAll() {
        return stageService.getAll()
                .stream()
                .map(stageMapper::mapCinemaHallToDto)
                .collect(Collectors.toList());
    }
}
