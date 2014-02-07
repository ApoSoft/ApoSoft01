package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Store;

/**
 * JPA Repository for stores
 * 
 * @author Jannik Kuptz
 * 
 */
public interface StoreRepository extends CrudRepository<Store, Integer> {

}
