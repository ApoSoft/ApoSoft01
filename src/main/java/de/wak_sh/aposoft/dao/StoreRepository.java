package de.wak_sh.aposoft.dao;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Store;

/**
 * JPA Repository for stores
 * 
 * @author Jannik Kuptz
 * 
 */
public interface StoreRepository extends CrudRepository<Store, Integer> {

}
