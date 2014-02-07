package de.wak_sh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Role;

/**
 * JPA Repository for role objects
 * 
 * @author Christoph Mende
 * 
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
