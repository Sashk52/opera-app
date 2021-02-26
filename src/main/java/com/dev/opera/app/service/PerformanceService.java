package com.dev.opera.app.service;

import com.dev.opera.app.model.Performance;
import java.util.List;

public interface PerformanceService {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance getById(Long id);
}
