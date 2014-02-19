package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Protocol;

/**
 * JPA repository for Protocol objects
 * 
 * @author Christoph Mende
 * 
 */
public interface ProtocolRepository extends CrudRepository<Protocol, Integer> {
}
