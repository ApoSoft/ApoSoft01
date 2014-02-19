package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Role;
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
