package de.wak_sh.aposoft;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.wak_sh.aposoft.dao.CustomerDAO;
import de.wak_sh.aposoft.dao.impl.CustomerDAOImpl;
import de.wak_sh.aposoft.domain.Customer;

public class TestCustomer {

    public Customer createCustomer() {

        Customer customer = new Customer();

        customer.setFirstName("Sebastian");
        customer.setGender("maennlich");
        customer.setName("Bruett");
        customer.setTitle("Herr");

        return customer;

    }

    @Test
    public void testInsert() {
        CustomerDAO dao = new CustomerDAOImpl();
        Customer customer = createCustomer();

        dao.insertCustomer(customer);

        List<Customer> listCustomer = dao.findByName(customer.getName());
        boolean exists = false;
        for (Customer customer2 : listCustomer) {
            if (customer.getId() == customer2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        CustomerDAO dao = new CustomerDAOImpl();
        Customer customer = createCustomer();

        dao.insertCustomer(customer);
        customer.setFirstName("Karl");
        dao.updateCustomer(customer);

        List<Customer> listCustomer = dao.findByName(customer.getName());
        for (Customer customer2 : listCustomer) {
            if (customer.getId() == customer2.getId()) {
                Assert.assertEquals(customer.getFirstName(), customer2.getFirstName());
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        CustomerDAO dao = new CustomerDAOImpl();
        Customer customer = createCustomer();

        dao.insertCustomer(customer);
        dao.deleteCustomer(customer);

        List<Customer> listCustomer = dao.findByName(customer.getName());
        boolean exists = false;
        for (Customer customer2 : listCustomer) {
            if (customer.getId() == customer2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testFindAll() {
        CustomerDAO dao = new CustomerDAOImpl();
        Customer customer = createCustomer();

        int size = dao.findAll().size();
        dao.insertCustomer(customer);
        Assert.assertEquals(size + 1, dao.findAll().size());
    }
}
