package de.waksh.aposoft;

import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.AppointmentCustomer;
import de.waksh.aposoft.domain.Customer;
import de.waksh.aposoft.repository.AppointmentCustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class AppointmentCustomerTest {

    @Autowired
    private AppointmentCustomerRepository repository;

    private AppointmentCustomer createAppointmentCustomer() {
        AppointmentCustomer appointmentCustomer = new AppointmentCustomer();
        appointmentCustomer.setDate(new LocalDate(2002, 02, 02));
        return appointmentCustomer;
    }

    public Customer createCustomer() {

        Customer customer = new Customer();

        customer.setFirstName("Sebastian");
        customer.setGender("maennlich");
        customer.setName("Bruett");
        customer.setTitle("Herr");

        return customer;

    }

    @Test
    public void testFindAll() {
        AppointmentCustomer apocustomer = createAppointmentCustomer();
        long size = repository.count();
        long length = 0;
        repository.save(apocustomer);
        Iterable<AppointmentCustomer> it = repository.findAll();
        for (@SuppressWarnings("unused") AppointmentCustomer appointmentCustomer : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }

    @Test
    public void testFindByCustomer() {
        AppointmentCustomer apocustomer = createAppointmentCustomer();
        Customer customer = createCustomer();
        apocustomer.setCustomer(customer);
        repository.save(apocustomer);
        List<AppointmentCustomer> listcustomer = repository.findByCustomer(customer);
        boolean exists = false;
        for (AppointmentCustomer appointmentCustomer : listcustomer) {
            // Customer cust = appointmentCustomer.getCustomer();
            if (apocustomer.getId() == appointmentCustomer.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }
}
