package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.AppointmentCustomer;
import de.waksh.aposoft.domain.Customer;

/**
 * JPA repository for AppointmentCustomer objects
 * 
 * @author Lennart Huebsch
 * 
 */
public interface AppointmentCustomerRepository extends CrudRepository<AppointmentCustomer, Integer> {

    /**
     * Find appointment customers by Customer objects
     * 
     * @param customer
     *            customer to search for
     * @return a list of matching appointment customers
     */
    List<AppointmentCustomer> findByCustomer(Customer customer);

}
