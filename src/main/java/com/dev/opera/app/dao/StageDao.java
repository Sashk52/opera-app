package com.dev.opera.app.dao;

import com.dev.opera.app.model.Stage;
import java.util.List;
import java.util.Optional;

public interface StageDao {
    Stage add(Stage stage);

    List<Stage> getAll();

    Optional<Stage> getById(Long id);
}
