package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.ProductShape;

/**
 * JPA repository for ProductShape objects
 * 
 * @author Artem Hofmann
 * 
 */
public interface ProductShapeRepository extends CrudRepository<ProductShape, Integer> {
}
