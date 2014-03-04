package de.waksh.aposoft;

import java.util.ArrayList;
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
import de.waksh.aposoft.domain.OrderItem;
import de.waksh.aposoft.repository.AppointmentCustomerRepository;
import de.waksh.aposoft.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class AppointmentCustomerTest {

    @Autowired
    private AppointmentCustomerRepository repository;

    @Autowired
    private CustomerRepository custRepo;

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
        custRepo.save(customer);
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

    @Test
    public void testItems() {
        AppointmentCustomer apocustomer = createAppointmentCustomer();
        OrderItem orderItem = new OrderItem();
        orderItem.setAmount(20);
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setAmount(20);

        List<OrderItem> listorder = new ArrayList<>();
        listorder.add(orderItem);
        listorder.add(orderItem1);

        apocustomer.setItems(listorder);
        repository.save(apocustomer);

        boolean isokay = false;
        Iterable<AppointmentCustomer> it = repository.findAll();
        for (@SuppressWarnings("unused") AppointmentCustomer appointmentCustomer : it) {
            List<OrderItem> list = apocustomer.getItems();
            for (OrderItem orderItem2 : list) {
                if (orderItem.getId() == orderItem2.getId() || orderItem1.getId() == orderItem2.getId()) {
                    isokay = true;
                } else {
                    isokay = false;
                    break;
                }
            }
        }
        Assert.assertTrue(isokay);
    }
}
