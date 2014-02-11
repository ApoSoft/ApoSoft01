package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Permission;

/**
 * JPA Repository for permission objects
 * 
 * @author Christoph Mende
 * 
 */
public interface PermissionRepository extends CrudRepository<Permission, Integer> {
}
