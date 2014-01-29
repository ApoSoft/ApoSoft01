package de.wak_sh.aposoft.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.wak_sh.aposoft.dao.ExtemporaneousProductDAO;
import de.wak_sh.aposoft.domain.ExtemporaneousProduct;

public class ExtemporaneousProductDAOImpl implements ExtemporaneousProductDAO {

    private EntityManagerFactory emf;

    public ExtemporaneousProductDAOImpl() {
        emf = Persistence.createEntityManagerFactory("de.wak_sh.aposoft.persistence");
    }

    @Override
    public boolean insertExtemporaneousProduct(ExtemporaneousProduct extemExtemporaneousProduct) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(extemExtemporaneousProduct);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateExtemporaneousProduct(ExtemporaneousProduct extemExtemporaneousProduct) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(extemExtemporaneousProduct);
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteExtemporaneousProduct(ExtemporaneousProduct extemExtemporaneousProduct) {
        EntityManager em = emf.createEntityManager();
        ExtemporaneousProduct extProductRef = em.getReference(ExtemporaneousProduct.class,
                extemExtemporaneousProduct.getId());
        em.getTransaction().begin();
        try {
            em.remove(extProductRef);
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public List<ExtemporaneousProduct> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT e FROM ExtemporaneousProduct e");
        em.getTransaction().commit();
        return q.getResultList();
    }

    @Override
    public List<ExtemporaneousProduct> findByDescription(String description) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT e FROM ExtemporaneousProduct e WHERE e.description = :description");
        q.setParameter("description", description);
        em.getTransaction().commit();
        return q.getResultList();
    }

}
