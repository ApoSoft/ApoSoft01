package de.wak_sh.aposoft;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.wak_sh.aposoft.dao.CustomerRepository;
import de.wak_sh.aposoft.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class CustomerTest {

    @Autowired
    private CustomerRepository repository;

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
        Customer customer = createCustomer();

        repository.save(customer);

        List<Customer> listCustomer = repository.findByName(customer.getName());
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
        Customer customer = createCustomer();

        repository.save(customer);
        customer.setFirstName("Karl");
        repository.save(customer);

        List<Customer> listCustomer = repository.findByName(customer.getName());
        for (Customer customer2 : listCustomer) {
            if (customer.getId() == customer2.getId()) {
                Assert.assertEquals(customer.getFirstName(), customer2.getFirstName());
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        Customer customer = createCustomer();

        repository.save(customer);
        repository.delete(customer);

        List<Customer> listCustomer = repository.findByName(customer.getName());
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
        Customer customer = createCustomer();

        long size = repository.count();
        long length = 0;
        repository.save(customer);
        Iterable<Customer> it = repository.findAll();
        for (Object object : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }
}
