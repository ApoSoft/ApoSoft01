package de.wak_sh.aposoft.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.wak_sh.aposoft.dao.EmployeeDAO;
import de.wak_sh.aposoft.domain.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManagerFactory emf;

    public EmployeeDAOImpl() {
        emf = Persistence.createEntityManagerFactory("de.wak_sh.aposoft.persistence");
    }

    @Override
    public List<Employee> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT e FROM Employee e");
        em.getTransaction().commit();
        return q.getResultList();
    }

    @Override
    public List<Employee> findByFirstNameAndName(String firstname, String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT e FROM Employee e WHERE e.name = :name AND e.firstName = :firstName");
        q.setParameter("firstName", firstname);
        q.setParameter("name", name);
        em.getTransaction().commit();
        return q.getResultList();
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(employee);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(employee);
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        EntityManager em = emf.createEntityManager();
        Employee employeeRef = em.getReference(Employee.class, employee.getId());
        em.getTransaction().begin();
        try {
            em.remove(employeeRef);
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }
}
