package com.dev.movietheatre.dao.impl;

import com.dev.movietheatre.dao.RoleDao;
import com.dev.movietheatre.exception.DataProcessingException;
import com.dev.movietheatre.model.Role;
import com.dev.movietheatre.model.Roles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory sessionFactory;

    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Role role) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert role entity " + role, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Role getRoleByName(String role) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                    "from Role where roleName = :roleName", Role.class)
                    .setParameter("roleName", Roles.valueOf(role))
                    .getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get role " + role, e);
        }
    }
}
