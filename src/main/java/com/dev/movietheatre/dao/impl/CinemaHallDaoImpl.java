package com.dev.movietheatre.dao.impl;

import com.dev.movietheatre.dao.CinemaHallDao;
import com.dev.movietheatre.exception.DataProcessingException;
import com.dev.movietheatre.model.CinemaHall;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallDaoImpl implements CinemaHallDao {
    private final SessionFactory sessionFactory;

    public CinemaHallDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(cinemaHall);
            transaction.commit();
            return cinemaHall;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert cinemaHall entity" + cinemaHall, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CinemaHall> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<CinemaHall> getAllCinemaHallsQuery = session.createQuery("from CinemaHall",
                    CinemaHall.class);
            return getAllCinemaHallsQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get list of all cinemaHall ", e);
        }
    }
}
