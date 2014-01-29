package de.wak_sh.aposoft.dao;

import java.util.List;

import de.wak_sh.aposoft.domain.Customer;

public interface CustomerDAO {

    boolean insertCustomer(Customer customer);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(Customer customer);

    List<Customer> findAll();

    List<Customer> findByName(String name);

}
