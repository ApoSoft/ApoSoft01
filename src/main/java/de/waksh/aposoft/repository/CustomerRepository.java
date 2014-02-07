package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByName(String name);

}
