package de.waksh.aposoft;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Address;
import de.waksh.aposoft.domain.AppointmentCustomer;
import de.waksh.aposoft.domain.Customer;
import de.waksh.aposoft.domain.PaymentCondition;
import de.waksh.aposoft.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
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

        Address address = new Address();
        address.setCity("city");
        address.setEmail("email");
        customer.setAddress(address);

        AppointmentCustomer apoCustomer = new AppointmentCustomer();
        apoCustomer.setDate(new LocalDate(2002, 2, 2));
        AppointmentCustomer apoCustomer2 = new AppointmentCustomer();
        apoCustomer2.setDate(new LocalDate(2002, 2, 2));
        List<AppointmentCustomer> appointments = new ArrayList<AppointmentCustomer>();
        appointments.add(apoCustomer2);
        appointments.add(apoCustomer);
        customer.setAppointments(appointments);

        customer.setBirthdate(new DateTime(2222, 2, 22, 2, 2));

        // CustomerGroup customergruop = new CustomerGroup();
        // customergruop.setDescription("Gruppe");
        // customergruop.setName("Name");
        // CustomerGroup customergruop2 = new CustomerGroup();
        // customergruop2.setDescription("Gruppe1");
        // customergruop2.setName("Name1");
        // List<CustomerGroup> customerGroups = new ArrayList<CustomerGroup>();
        // customerGroups.add(customergruop2);
        // customerGroups.add(customergruop);
        // customer.setCustomerGroups(customerGroups);

        // Insurance insurance = new Insurance();
        // insurance.setName("bac");
        // insurance.setInsuranceIdNumber("12344");
        // insurance.setPhone("+49 111 1112");
        // insurance.setPrivateInsurance(false);
        // customer.setInsurance(insurance);

        PaymentCondition paymentCondition = new PaymentCondition();
        paymentCondition.setDiscountValue(11f);
        customer.setPaymentCondition(paymentCondition);

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
        for (@SuppressWarnings("unused") Object object : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }

}
