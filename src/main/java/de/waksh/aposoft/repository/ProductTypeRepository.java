package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.ProductType;

/**
 * JPA repository for ProductType objects
 * 
 * @author Artem Hofmann
 * 
 */
public interface ProductTypeRepository extends CrudRepository<ProductType, Integer> {
}
