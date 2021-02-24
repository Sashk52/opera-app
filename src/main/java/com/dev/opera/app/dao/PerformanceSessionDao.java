package com.dev.opera.app.dao;

import com.dev.opera.app.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PerformanceSessionDao {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    PerformanceSession add(PerformanceSession session);

    Optional<PerformanceSession> getById(Long id);

    PerformanceSession update(PerformanceSession performanceSession);

    void delete(Long id);
}
