package com.dev.movietheatre.dao.impl;

import com.dev.movietheatre.dao.ShoppingCartDao;
import com.dev.movietheatre.exception.DataProcessingException;
import com.dev.movietheatre.lib.Dao;
import com.dev.movietheatre.model.ShoppingCart;
import com.dev.movietheatre.model.User;
import com.dev.movietheatre.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    @Override
    public ShoppingCart add(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(shoppingCart);
            transaction.commit();
            return shoppingCart;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert shoppingCart entity" + shoppingCart, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "from ShoppingCart sc "
                            + "left join fetch sc.tickets "
                            + "where sc.user = :user", ShoppingCart.class)
            .setParameter("user", user)
            .getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Shopping card by user " + user, e);
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update shoppingCart entity" + shoppingCart, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
