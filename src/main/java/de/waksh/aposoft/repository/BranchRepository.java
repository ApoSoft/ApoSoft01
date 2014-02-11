package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Branch;

/**
 * JPA repository for branch objects
 * 
 * @author Christoph Mende
 * 
 */
public interface BranchRepository extends CrudRepository<Branch, Integer> {
}
