package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    List<Address> findByCity(String city);

    List<Address> findByPostalCode(String string);

}
