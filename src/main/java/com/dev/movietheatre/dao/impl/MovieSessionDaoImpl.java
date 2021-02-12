package com.dev.movietheatre.dao.impl;

import com.dev.movietheatre.dao.MovieSessionDao;
import com.dev.movietheatre.exception.DataProcessingException;
import com.dev.movietheatre.model.MovieSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl implements MovieSessionDao {
    private final SessionFactory sessionFactory;

    public MovieSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<MovieSession> getMoviesSessionQuery = session.createQuery(
                    "select ms from MovieSession ms "
                           + " left join fetch ms.cinemaHall "
                           + " left join fetch ms.movie "
                           + " where ms.movie.id = :id"
                           + " and date_format(ms.showTime, '%Y-%m-%d')=:date", MovieSession.class);
            getMoviesSessionQuery.setParameter("id", movieId);
            getMoviesSessionQuery.setParameter("date",
                    DateTimeFormatter.ISO_LOCAL_DATE.format(date));
            return getMoviesSessionQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get list of all movieSessions ", e);
        }
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert MovieSession entity" + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
