package de.waksh.aposoft;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.ActiveIngredient;
import de.waksh.aposoft.domain.ExtemporaneousProduct;
import de.waksh.aposoft.repository.ActiveIngredientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class ActiveIngredientTest {

    @Autowired
    private ActiveIngredientRepository repository;

    public ActiveIngredient createActiveIngredient() {
        ActiveIngredient activeIngredient = new ActiveIngredient();
        activeIngredient.setName("abc");

        ExtemporaneousProduct extemporaneousProduct = new ExtemporaneousProduct();
        extemporaneousProduct.setDescription("Bayer");
        extemporaneousProduct.setType("Drop");
        activeIngredient.setExtemporaneousProduct(extemporaneousProduct);

        return activeIngredient;
    }

    @Test
    public void testInsert() {
        ActiveIngredient activeIngredient = createActiveIngredient();

        repository.save(activeIngredient);

        List<ActiveIngredient> listactiveingredient = repository.findByName(activeIngredient.getName());
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
        ActiveIngredient activeIngredient = createActiveIngredient();

        repository.save(activeIngredient);
        activeIngredient.setName("def");
        repository.save(activeIngredient);

        List<ActiveIngredient> listactiveingredient = repository.findByName(activeIngredient.getName());
        for (ActiveIngredient activeIngredient2 : listactiveingredient) {
            if (activeIngredient.getId() == activeIngredient2.getId()) {
                Assert.assertEquals(activeIngredient.getName(), activeIngredient2.getName());
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        ActiveIngredient activeIngredient = createActiveIngredient();

        repository.save(activeIngredient);
        repository.delete(activeIngredient);

        List<ActiveIngredient> listactiveingredient = repository.findByName(activeIngredient.getName());
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
        ActiveIngredient activeIngredient = createActiveIngredient();
        long size = repository.count();
        long lenghts = 0;
        repository.save(activeIngredient);
        Iterable<ActiveIngredient> it = repository.findAll();
        for (@SuppressWarnings("unused") ActiveIngredient activeIngredient2 : it) {
            lenghts++;
        }
        Assert.assertEquals(size + 1, lenghts);
    }
}
