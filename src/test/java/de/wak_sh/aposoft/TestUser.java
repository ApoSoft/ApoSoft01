package de.wak_sh.aposoft;

import java.util.List;

import org.joda.time.DateTime;
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

        user.equals(dao.findUserByUsername("abc"));

        List<User> listuser = dao.findUserByUsername("abc");
        boolean exists = false;
        for (User user2 : listuser) {
            if (user.equals(user2)) {
                exists = true;
                break;
            }
        }

        Assert.assertTrue(exists);

    }

    private User createUser() {
        User user = new User();

        user.setBirthdate(new DateTime(2000, 1, 1, 1, 1));
        user.setFirstName("Sebastian");
        user.setGender("maennlich");
        user.setName("Bruett");
        user.setPassword("abc");
        user.setTitle("Dr.");
        user.setUsername("abc");

        return null;
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
            if (user.equals(user2)) {
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
            if (user.equals(user2)) {
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
