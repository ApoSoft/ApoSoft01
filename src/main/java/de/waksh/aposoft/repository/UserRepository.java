package de.waksh.aposoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.User;

/**
 * JPA Repository for user objects
 * 
 * @author Christoph Mende
 * 
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * Returns a list of all user objects having the given username
     * 
     * @param username
     *            username to search for
     * @return list of matching users
     */
    List<User> findUserByUsername(String username);

}
