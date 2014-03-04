package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.AppointmentSupplier;

/**
 * JPA repository for AppointmentSupplier objects
 * 
 * @author Sebastian Bruett
 * 
 */
public interface AppointmentSupplierRepository extends CrudRepository<AppointmentSupplier, Integer> {
}
