package de.wak_sh.aposoft;

import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import de.wak_sh.aposoft.dao.UserDAO;
import de.wak_sh.aposoft.dao.impl.UserDAOImpl;
import de.wak_sh.aposoft.domain.User;

public class TestUser {

    @Test
    public void testInsert() {
        UserDAO dao = new UserDAOImpl();

        User user = createUser();

        dao.insertUser(user);

        List<User> listuser = dao.findUserByUsername("abc");
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

        return user;
    }

    @Test
    public void testUpdate() {
        User user = createUser();

        UserDAO dao = new UserDAOImpl();

        dao.insertUser(user);
        user.setTitle("Prof.");
        dao.updateUser(user);

        List<User> listuser = dao.findUserByUsername("abc");
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
        UserDAO dao = new UserDAOImpl();

        dao.insertUser(user);

        dao.deleteuser(user);

        List<User> listuser = dao.findUserByUsername("abc");
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
        UserDAO dao = new UserDAOImpl();

        int size = dao.findAll().size();

        dao.insertUser(user);

        Assert.assertEquals(size + 1, dao.findAll().size());
    }

}
