package com.dev.opera.app.service.impl;

import com.dev.opera.app.dao.PerformanceSessionDao;
import com.dev.opera.app.model.PerformanceSession;
import com.dev.opera.app.service.PerformanceSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerformanceSessionServiceImpl implements PerformanceSessionService {
    private final PerformanceSessionDao performanceSessionDao;

    public PerformanceSessionServiceImpl(PerformanceSessionDao performanceSessionDao) {
        this.performanceSessionDao = performanceSessionDao;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date) {
        return performanceSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public PerformanceSession add(PerformanceSession session) {
        return performanceSessionDao.add(session);
    }

    @Override
    public PerformanceSession getById(Long id) {
        return performanceSessionDao.getById(id).get();
    }

    @Override
    public PerformanceSession update(PerformanceSession moviesession) {
        return performanceSessionDao.update(moviesession);
    }

    @Override
    public void delete(Long id) {
        performanceSessionDao.delete(id);
    }
}
