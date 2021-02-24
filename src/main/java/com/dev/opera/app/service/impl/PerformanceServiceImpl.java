package com.dev.opera.app.service.impl;

import com.dev.opera.app.dao.PerformanceDao;
import com.dev.opera.app.model.Performance;
import com.dev.opera.app.service.PerformanceService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    private final PerformanceDao performanceDao;

    public PerformanceServiceImpl(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }

    @Override
    public Performance add(Performance performance) {
        return performanceDao.add(performance);
    }

    @Override
    public List<Performance> getAll() {
        return performanceDao.getAll();
    }

    @Override
    public Performance getById(Long id) {
        return performanceDao.getById(id).get();
    }
}
