package com.dev.opera.app.service.impl;

import com.dev.opera.app.dao.StageDao;
import com.dev.opera.app.model.Stage;
import com.dev.opera.app.service.StageService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StageServiceImpl implements StageService {
    private final StageDao stageDao;

    public StageServiceImpl(StageDao stageDao) {
        this.stageDao = stageDao;
    }

    @Override
    public Stage add(Stage stage) {
        return stageDao.add(stage);
    }

    @Override
    public List<Stage> getAll() {
        return stageDao.getAll();
    }

    @Override
    public Stage getById(Long id) {
        return stageDao.getById(id).get();
    }
}
