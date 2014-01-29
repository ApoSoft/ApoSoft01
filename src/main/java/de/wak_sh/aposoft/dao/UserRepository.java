package de.wak_sh.aposoft.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findUserByUsername(String username);
}
