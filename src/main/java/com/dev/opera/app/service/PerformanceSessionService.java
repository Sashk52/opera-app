package com.dev.opera.app.service;

import com.dev.opera.app.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;

public interface PerformanceSessionService {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    PerformanceSession add(PerformanceSession session);

    PerformanceSession getById(Long id);

    PerformanceSession update(PerformanceSession session);

    void delete(Long id);
}
