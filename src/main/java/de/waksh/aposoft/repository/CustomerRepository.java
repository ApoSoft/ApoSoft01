package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Customer;

/**
 * JPA repository for Customer objects
 * 
 * @author christoph
 * 
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    /**
     * Find customers by last name
     * 
     * @param name
     *            name to search for
     * @return list of matching customers
     */
    List<Customer> findByName(String name);

}
