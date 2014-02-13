package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.ProductReservation;

public interface ProductReservationRepository extends CrudRepository<ProductReservation, Integer> {

}
