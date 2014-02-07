package de.wak_sh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Permission;

/**
 * JPA Repository for permission objects
 * 
 * @author Christoph Mende
 * 
 */
public interface PermissionRepository extends CrudRepository<Permission, Integer> {
}
