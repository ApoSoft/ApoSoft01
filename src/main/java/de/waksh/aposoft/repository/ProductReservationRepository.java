package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Customer;
import de.waksh.aposoft.domain.ProductReservation;

/**
 * JPA repository for ProductReservation objects
 * 
 * @author Artem Hofmann
 * 
 */
public interface ProductReservationRepository extends CrudRepository<ProductReservation, Integer> {

    /**
     * Find product reservations by customer
     * 
     * @param customer
     *            customer to search for
     * @return list of matching product reservations
     */
    List<ProductReservation> findByCustomer(Customer customer);

}
