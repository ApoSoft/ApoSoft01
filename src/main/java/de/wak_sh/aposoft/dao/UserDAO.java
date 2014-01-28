package de.wak_sh.aposoft.dao;

import java.util.List;

import de.wak_sh.aposoft.domain.User;

public interface UserDAO {
    List<User> findAll();

    List<User> findUserByUsername(String username);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteuser(User user);

}
