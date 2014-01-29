package de.wak_sh.aposoft;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.wak_sh.aposoft.dao.ActiveIngredientDAO;
import de.wak_sh.aposoft.dao.impl.ActiveIngredientDAOImpl;
import de.wak_sh.aposoft.domain.ActiveIngredient;

public class TestActiveIngredient {

    public ActiveIngredient createActiveIngredient() {
        ActiveIngredient activeIngredient = new ActiveIngredient();
        activeIngredient.setName("abc");
        return activeIngredient;
    }

    @Test
    public void testInsert() {
        ActiveIngredientDAO dao = new ActiveIngredientDAOImpl();
        ActiveIngredient activeIngredient = createActiveIngredient();

        dao.insertActiveIngredient(activeIngredient);

        List<ActiveIngredient> listactiveingredient = dao.findByName(activeIngredient.getName());
        boolean exists = false;
        for (ActiveIngredient activeIngredient2 : listactiveingredient) {
            if (activeIngredient.getId() == activeIngredient2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        ActiveIngredientDAO dao = new ActiveIngredientDAOImpl();
        ActiveIngredient activeIngredient = createActiveIngredient();

        dao.insertActiveIngredient(activeIngredient);
        activeIngredient.setName("def");
        dao.updateActiveIngredient(activeIngredient);

        List<ActiveIngredient> listactiveingredient = dao.findByName(activeIngredient.getName());
        for (ActiveIngredient activeIngredient2 : listactiveingredient) {
            if (activeIngredient.getId() == activeIngredient2.getId()) {
                Assert.assertEquals(activeIngredient.getName(), activeIngredient2.getName());
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        ActiveIngredientDAO dao = new ActiveIngredientDAOImpl();
        ActiveIngredient activeIngredient = createActiveIngredient();

        dao.insertActiveIngredient(activeIngredient);
        dao.deleteActiveIngredient(activeIngredient);

        List<ActiveIngredient> listactiveingredient = dao.findByName(activeIngredient.getName());
        boolean exists = false;
        for (ActiveIngredient activeIngredient2 : listactiveingredient) {
            if (activeIngredient.getId() == activeIngredient2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testFindAll() {
        ActiveIngredientDAO dao = new ActiveIngredientDAOImpl();
        ActiveIngredient activeIngredient = createActiveIngredient();
        int size = dao.findAll().size();
        dao.insertActiveIngredient(activeIngredient);
        Assert.assertEquals(size + 1, dao.findAll().size());
    }
}
