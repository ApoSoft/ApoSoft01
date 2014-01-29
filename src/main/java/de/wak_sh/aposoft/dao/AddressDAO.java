package de.wak_sh.aposoft.dao;

import java.util.List;

import de.wak_sh.aposoft.domain.Address;

public interface AddressDAO {

    boolean insertAddress(Address address);

    boolean updateAddress(Address address);

    boolean deleteAddress(Address address);

    List<Address> findAll();

    List<Address> findByCity(String city);

    List<Address> findByPostalCode(int postalCode);

}
