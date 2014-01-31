package de.wak_sh.aposoft.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    List<Address> findByCity(String city);

    List<Address> findByPostalCode(String string);

}
