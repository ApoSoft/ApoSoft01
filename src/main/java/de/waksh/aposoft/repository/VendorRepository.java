package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Vendor;

/**
 * JPA repository for Vendor objects
 * 
 * @author Artem Hofmann
 * 
 */
public interface VendorRepository extends CrudRepository<Vendor, Integer> {
}
