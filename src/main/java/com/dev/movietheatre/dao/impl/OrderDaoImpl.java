package com.dev.movietheatre.dao.impl;

import com.dev.movietheatre.dao.OrderDao;
import com.dev.movietheatre.exception.DataProcessingException;
import com.dev.movietheatre.lib.Dao;
import com.dev.movietheatre.model.Order;
import com.dev.movietheatre.model.User;
import com.dev.movietheatre.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order add(Order someOrder) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(someOrder);
            transaction.commit();
            return someOrder;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert order entity " + someOrder, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "select distinct o from Order o "
                            + " left join fetch o.tickets "
                            + " where o.user = :user ", Order.class)
            .setParameter("user", user)
            .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get list of all movieSessions ", e);
        }
    }
}
