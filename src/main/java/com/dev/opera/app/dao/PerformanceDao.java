package com.dev.opera.app.dao;

import com.dev.opera.app.model.Performance;
import java.util.List;
import java.util.Optional;

public interface PerformanceDao {

    Performance add(Performance performance);

    List<Performance> getAll();

    Optional<Performance> getById(Long id);
}
