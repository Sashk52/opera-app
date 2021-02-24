package com.dev.opera.app.dao.impl;

import com.dev.opera.app.dao.PerformanceSessionDao;
import com.dev.opera.app.exception.DataProcessingException;
import com.dev.opera.app.model.PerformanceSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceSessionDaoImpl implements PerformanceSessionDao {
    private final SessionFactory sessionFactory;

    public PerformanceSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<PerformanceSession> getMoviesSessionQuery = session.createQuery(
                    "select ps from PerformanceSession ps "
                            + " left join fetch ps.stage "
                            + " left join fetch ps.performance "
                            + " where ps.performance.id = :id"
                            + " and date_format(ms.showTime, '%Y-%m-%d')=:date",
                    PerformanceSession.class);
            getMoviesSessionQuery.setParameter("id", performanceId);
            getMoviesSessionQuery.setParameter("date",
                    DateTimeFormatter.ISO_LOCAL_DATE.format(date));
            return getMoviesSessionQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get list of all performanceSessions ", e);
        }
    }

    @Override
    public PerformanceSession add(PerformanceSession performanceSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(performanceSession);
            transaction.commit();
            return performanceSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert performanceSession entity"
                    + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<PerformanceSession> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(PerformanceSession.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get movieSession by id " + id, e);
        }
    }

    @Override
    public PerformanceSession update(PerformanceSession performanceSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(performanceSession);
            transaction.commit();
            return performanceSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update MovieSession " + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            PerformanceSession deletedPerformanceSession = session
                    .load(PerformanceSession.class, id);
            session.delete(deletedPerformanceSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete MovieSession by id" + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
