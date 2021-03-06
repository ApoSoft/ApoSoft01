package de.waksh.aposoft;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Unit;
import de.waksh.aposoft.repository.UnitRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class UnitTest {

    @Autowired
    private UnitRepository repository;

    public Unit createUnit() {
        Unit unit = new Unit();
        unit.setName("test");
        return unit;
    }

    @Test
    public void testInsert() {
        Unit unit = createUnit();

        repository.save(unit);

        List<Unit> listunit = repository.findByName(unit.getName());
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
        Unit unit = createUnit();

        repository.save(unit);
        unit.setName("abc");
        repository.save(unit);

        List<Unit> listunit = repository.findByName(unit.getName());
        for (Unit unit2 : listunit) {
            if (unit.getId() == unit2.getId()) {
                Assert.assertEquals(unit.getName(), unit2.getName());
            }
        }
    }

    @Test
    public void testDelete() {
        Unit unit = createUnit();

        repository.save(unit);
        repository.delete(unit);

        List<Unit> listunit = repository.findByName(unit.getName());
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
        Unit unit = createUnit();
        long size = repository.count();
        long length = 0;
        repository.save(unit);
        Iterable<Unit> it = repository.findAll();
        for (@SuppressWarnings("unused") Unit unit2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }
}
