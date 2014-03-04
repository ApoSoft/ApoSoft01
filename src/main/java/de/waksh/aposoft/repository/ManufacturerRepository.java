package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Manufacturer;

/**
 * JPA repository for Manufacturer objects
 * 
 * @author Jannik Kuptz
 * 
 */
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {

    /**
     * Find manufacturers by name
     * 
     * @param name
     *            name to search for
     * @return list of matching manufacturers
     */
    List<Manufacturer> findByName(String name);

}
