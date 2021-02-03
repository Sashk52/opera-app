package com.dev.movietheatre.dao.impl;

import com.dev.movietheatre.dao.TicketDao;
import com.dev.movietheatre.exception.DataProcessingException;
import com.dev.movietheatre.lib.Dao;
import com.dev.movietheatre.model.Ticket;
import com.dev.movietheatre.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class TicketDaoImpl implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert ticket entity" + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
