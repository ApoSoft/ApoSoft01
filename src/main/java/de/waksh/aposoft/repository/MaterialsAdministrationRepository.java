package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.MaterialsAdministration;

/**
 * JPA Repository for materials administration
 * 
 * @author Jannik Kuptz
 * 
 */
public interface MaterialsAdministrationRepository extends CrudRepository<MaterialsAdministration, Integer> {

}
