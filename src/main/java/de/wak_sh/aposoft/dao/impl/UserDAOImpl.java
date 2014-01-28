package de.wak_sh.aposoft.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.wak_sh.aposoft.dao.UserDAO;
import de.wak_sh.aposoft.domain.User;

public class UserDAOImpl implements UserDAO {

    private EntityManagerFactory emf;

    public UserDAOImpl() {
        emf = Persistence.createEntityManagerFactory("de.wak_sh.aposoft.persistence");
    }

    @Override
    public List<User> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM User u");
        em.getTransaction().commit();
        return q.getResultList();
    }

    @Override
    public List<User> findUserByUsername(String username) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
        q.setParameter("username", username);
        em.getTransaction().commit();
        return q.getResultList();
    }

    @Override
    public boolean insertUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(user);
        } catch (EntityExistsException e) {
            return false;
        }
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteuser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(user);
        } catch (IllegalArgumentException e) {
            return false;
        }
        em.getTransaction().commit();
        return true;
    }

}
