package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Unit;

/**
 * JPA repository for Unit objects
 * 
 * @author Christoph Mende
 * 
 */
public interface UnitRepository extends CrudRepository<Unit, Integer> {
    /**
     * Find units by name
     * 
     * @param name
     *            name to search for
     * @return list of matching units
     */
    List<Unit> findByName(String name);
}
