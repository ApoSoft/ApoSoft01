package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Customer;
import de.waksh.aposoft.domain.ProductReservation;

public interface ProductReservationRepository extends CrudRepository<ProductReservation, Integer> {

    List<ProductReservation> findByCustomer(Customer customer);

}
