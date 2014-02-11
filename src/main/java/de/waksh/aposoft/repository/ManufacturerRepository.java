package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Manufacturer;

/**
 * Repository for Manufacturer
 * 
 * @author Jannik Kuptz
 * 
 */
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {

    List<Manufacturer> findByName(String name);

}
