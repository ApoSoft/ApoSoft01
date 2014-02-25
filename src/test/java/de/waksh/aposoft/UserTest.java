package de.waksh.aposoft;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Branch;
import de.waksh.aposoft.domain.Employee;
import de.waksh.aposoft.domain.Permission;
import de.waksh.aposoft.domain.Recipe;
import de.waksh.aposoft.domain.Role;
import de.waksh.aposoft.domain.User;
import de.waksh.aposoft.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class UserTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testInsert() {
        User user = createUser();

        repository.save(user);

        List<User> listuser = repository.findUserByUsername("abc");
        boolean exists = false;
        for (User user2 : listuser) {
            if (user.getId() == user2.getId()) {
                exists = true;
                break;
            }
        }

        Assert.assertTrue(exists);

    }

    private User createUser() {
        User user = new User();

        user.setBirthdate(new LocalDate(2000, 1, 1));
        user.setFirstName("Sebastian");
        user.setGender("maennlich");
        user.setName("Bruett");
        user.setPassword("abc");
        user.setTitle("Dr.");
        user.setUsername("abc");

        Branch branch = new Branch();
        branch.setDescription("Beschreibung");
        branch.setAddress("Straße");
        branch.setLocation("Hier");
        branch.setManager("Manager");
        branch.setLogo("Logo");
        user.setBranch(branch);

        Employee employee = new Employee();
        employee.setBirthdate(new LocalDate(2000, 1, 1));
        employee.setFirstName("Sebastian");
        employee.setGender("männlich");
        employee.setName("Brütt");
        employee.setPartTimePart(1.0f);
        employee.setTitle("Dr.");
        user.setEmployee(employee);

        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setDescription("test");
        Role role2 = new Role();
        role2.setDescription("test2");
        roles.add(role2);
        roles.add(role);
        user.setRoles(roles);

        List<Recipe> recipe = new ArrayList<>();
        Recipe recipes = new Recipe();
        recipes.setDescription("test");
        Recipe recipes2 = new Recipe();
        recipes2.setDescription("test2");
        recipe.add(recipes2);
        recipe.add(recipes);
        user.setRecipe(recipe);

        return user;
    }

    @Test
    public void testUpdate() {
        User user = createUser();

        repository.save(user);
        user.setTitle("Prof.");
        repository.save(user);

        List<User> listuser = repository.findUserByUsername("abc");
        for (User user2 : listuser) {
            if (user.getId() == user2.getId()) {
                Assert.assertEquals(user.getTitle(), "Prof.");
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        User user = createUser();

        repository.save(user);

        repository.delete(user);

        List<User> listuser = repository.findUserByUsername("abc");
        boolean exists = false;
        for (User user2 : listuser) {
            if (user.getId() == user2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testFindAll() {
        User user = createUser();

        long size = repository.count();
        long length = 0;
        repository.save(user);
        Iterable<User> it = repository.findAll();
        for (@SuppressWarnings("unused") User user2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }

    private Role createRole() {
        Role role = new Role();

        role.setDescription("abc");

        return role;
    }

    @Test
    public void testFindAllR() {
        Role role = createRole();
        User user = createUser();

        List<Role> rolle = new ArrayList<Role>();
        rolle.add(role);
        user.setRoles(rolle);

        repository.save(user);
        Iterable<User> it = repository.findAll();
        boolean exist = false;
        for (User user2 : it) {

            List<Role> liste = user2.getRoles();

            for (Role role2 : liste) {
                if (role2.getId() == role.getId()) {
                    exist = true;
                    break;
                }
            }
        }
        Assert.assertTrue(exist);
    }

    private Permission createPermission() {
        Permission permission = new Permission();

        permission.setDescription("desc");

        return permission;
    }

    @Test
    public void testFindAllP() {
        Role role = createRole();
        User user = createUser();
        Permission permission = createPermission();

        List<Permission> permi = new ArrayList<Permission>();
        permi.add(permission);
        role.setPermissions(permi);

        List<Role> rolle = new ArrayList<Role>();
        rolle.add(role);
        user.setRoles(rolle);

        repository.save(user);
        Iterable<User> it = repository.findAll();
        boolean exist = false;
        for (User user2 : it) {

            List<Role> liste = user2.getRoles();

            for (Role role2 : liste) {
                List<Permission> list = role2.getPermissions();
                for (Permission permission2 : list) {
                    if (permission2.getId() == permission.getId()) {
                        exist = true;
                        break;
                    }
                }
            }
        }
        Assert.assertTrue(exist);
    }
}
