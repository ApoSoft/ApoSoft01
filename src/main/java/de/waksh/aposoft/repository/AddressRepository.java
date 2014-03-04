package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Address;

/**
 * JPA repository for Address objects
 * 
 * @author Christoph Mende
 * 
 */
public interface AddressRepository extends CrudRepository<Address, Integer> {

    /**
     * Find addresses by city names
     * 
     * @param city
     *            name of the city
     * @return a list of matching addresses
     */
    List<Address> findByCity(String city);

    /**
     * Find addresses by postal codes
     * 
     * @param string
     *            postal code
     * @return a list of matching addresses
     */
    List<Address> findByPostalCode(String string);

}
