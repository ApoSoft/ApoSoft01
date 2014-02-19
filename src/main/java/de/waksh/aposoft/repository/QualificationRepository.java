package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Qualification;

/**
 * JPA repository for qualification objects
 * 
 * @author Christoph Mende
 * 
 */
public interface QualificationRepository extends CrudRepository<Qualification, Integer> {
}
