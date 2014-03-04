package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.ProductGroup;

/**
 * JPA repository for ProductGroup objects
 * 
 * @author Artem Hofmann
 * 
 */
public interface ProductGroupRepository extends CrudRepository<ProductGroup, Integer> {
}
