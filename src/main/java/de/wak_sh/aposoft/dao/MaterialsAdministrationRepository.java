package de.wak_sh.aposoft.dao;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.MaterialsAdministration;

/**
 * JPA Repository for materials administration
 * 
 * @author Jannik Kuptz
 * 
 */
public interface MaterialsAdministrationRepository extends CrudRepository<MaterialsAdministration, Integer> {

}
