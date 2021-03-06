package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Occupation;

/**
 * JPA repository for Occupation objects
 * 
 * @author Christoph Mende
 * 
 */
public interface OccupationRepository extends CrudRepository<Occupation, Integer> {
}
