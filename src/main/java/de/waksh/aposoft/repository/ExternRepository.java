package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Extern;

/**
 * JPA repository for Extern objects
 * 
 * @author Christoph Mende
 * 
 */
public interface ExternRepository extends CrudRepository<Extern, Integer> {
}
