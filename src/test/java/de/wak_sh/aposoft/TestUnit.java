package de.wak_sh.aposoft;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.wak_sh.aposoft.dao.UnitDAO;
import de.wak_sh.aposoft.dao.impl.UnitDAOImpl;
import de.wak_sh.aposoft.domain.Unit;

public class TestUnit {

    public Unit createUnit() {
        Unit unit = new Unit();
        unit.setName("test");
        return unit;
    }

    @Test
    public void testInsert() {
        UnitDAO dao = new UnitDAOImpl();
        Unit unit = createUnit();

        dao.insertUnit(unit);

        List<Unit> listunit = dao.findByName(unit.getName());
        boolean exists = false;
        for (Unit unit2 : listunit) {
            if (unit.getId() == unit2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        UnitDAO dao = new UnitDAOImpl();
        Unit unit = createUnit();

        dao.insertUnit(unit);
        unit.setName("abc");
        dao.updateUnit(unit);

        List<Unit> listunit = dao.findByName(unit.getName());
        for (Unit unit2 : listunit) {
            if (unit.getId() == unit2.getId()) {
                Assert.assertEquals(unit.getName(), unit2.getName());
            }
        }
    }

    @Test
    public void testDelete() {
        UnitDAO dao = new UnitDAOImpl();
        Unit unit = createUnit();

        dao.insertUnit(unit);
        dao.deleteUnit(unit);

        List<Unit> listunit = dao.findByName(unit.getName());
        boolean exists = false;
        for (Unit unit2 : listunit) {
            if (unit.getId() == unit2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testFindAll() {
        UnitDAO dao = new UnitDAOImpl();
        Unit unit = createUnit();
        int size = dao.findAll().size();
        dao.insertUnit(unit);
        Assert.assertEquals(size + 1, dao.findAll().size());
    }
}
