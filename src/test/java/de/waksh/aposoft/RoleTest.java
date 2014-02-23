package de.waksh.aposoft;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Permission;
import de.waksh.aposoft.domain.Role;
import de.waksh.aposoft.domain.User;
import de.waksh.aposoft.repository.RoleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class RoleTest {

    @Autowired
    private RoleRepository repository;

    private Role createRole() {
        Role role = new Role();

        role.setDescription("abc");

        User user = new User();
        user.setFirstName("first");
        user.setName("name");
        User user2 = new User();
        user2.setFirstName("f");
        user2.setName("n");
        List<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user);
        role.setUsers(users);

        Permission permission = new Permission();
        permission.setDescription("test1");
        Permission permission2 = new Permission();
        permission2.setDescription("test2");
        List<Permission> permissions = new ArrayList<>();
        permissions.add(permission2);
        permissions.add(permission);
        role.setPermissions(permissions);

        return role;
    }

    @Test
    public void testFindAll() {
        Role role = createRole();

        long size = repository.count();
        long length = 0;
        repository.save(role);
        Iterable<Role> it = repository.findAll();
        for (@SuppressWarnings("unused") Role role2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }
}
