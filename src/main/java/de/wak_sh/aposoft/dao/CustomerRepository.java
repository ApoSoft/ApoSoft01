package de.wak_sh.aposoft.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByName(String name);

}
