package de.waksh.aposoft;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Customer;
import de.waksh.aposoft.domain.CustomerGroup;
import de.waksh.aposoft.repository.CustomerGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class CustomerGroupTest {

    @Autowired
    private CustomerGroupRepository repository;

    public CustomerGroup createCustomerGroup() {
        CustomerGroup customergroup = new CustomerGroup();

        customergroup.setName("Jenni");
        customergroup.setDescription("desc");

        return customergroup;
    }

    public Customer createCustomer() {
        Customer customer = new Customer();

        customer.setName("Geist");
        customer.setTitle("Dr");
        customer.setFirstName("Jenni");
        customer.setGender("weiblich");
        customer.setBirthdate(new DateTime(2000, 1, 1, 2, 1));

        return customer;
    }

    @Test
    public void testFindAllCG() {
        Customer customer = createCustomer();
        CustomerGroup customergroup = createCustomerGroup();

        List<Customer> custom = new ArrayList<Customer>();
        custom.add(customer);
        customergroup.setCustomers(custom);

        repository.save(customergroup);
        Iterable<CustomerGroup> it = repository.findAll();
        boolean exist = false;
        for (CustomerGroup customergroup2 : it) {

            List<Customer> liste = customergroup2.getCustomers();

            for (Customer customer2 : liste) {
                if (customer2.getId() == customer.getId()) {
                    exist = true;
                    break;
                }
            }
        }
        Assert.assertTrue(exist);
    }

    @Test
    public void testFindAll() {
        CustomerGroup customergroup = createCustomerGroup();

        long size = repository.count();
        long length = 0;
        repository.save(customergroup);
        Iterable<CustomerGroup> it = repository.findAll();
        for (@SuppressWarnings("unused") CustomerGroup customergroup2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }

}
