package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.AppointmentCustomer;
import de.waksh.aposoft.domain.Customer;

/**
 * 
 * @author lhuebsch
 * 
 */
public interface AppointmentCustomerRepository extends CrudRepository<AppointmentCustomer, Integer> {

    List<AppointmentCustomer> findByCustomer(Customer customer);

}
