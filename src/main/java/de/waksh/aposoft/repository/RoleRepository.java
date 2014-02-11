package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Role;

/**
 * JPA Repository for role objects
 * 
 * @author Christoph Mende
 * 
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
