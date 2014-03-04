package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.CustomerGroup;

/**
 * JPA repository for CustomerGroup objects
 * 
 * @author Jennifer Geist
 * 
 */
public interface CustomerGroupRepository extends CrudRepository<CustomerGroup, Integer> {
}
