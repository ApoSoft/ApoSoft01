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
import de.waksh.aposoft.repository.PermissionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class PermissionTest {

    @Autowired
    private PermissionRepository repository;

    private Permission createPermission() {
        Permission permission = new Permission();

        permission.setDescription("abc");

        List<Role> items = new ArrayList<>();
        Role role = new Role();
        role.setDescription("test");
        Role role2 = new Role();
        role.setDescription("test2");
        items.add(role2);
        items.add(role);
        permission.setRoles(items);

        return permission;
    }

    @Test
    public void testFindAll() {
        Permission permission = createPermission();

        long size = repository.count();
        long length = 0;
        repository.save(permission);
        Iterable<Permission> it = repository.findAll();
        for (@SuppressWarnings("unused") Permission permission2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }
}
