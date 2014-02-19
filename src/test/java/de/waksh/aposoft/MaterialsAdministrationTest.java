package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.MaterialsAdministration;
import de.waksh.aposoft.repository.MaterialsAdministrationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class MaterialsAdministrationTest {

    @Autowired
    private MaterialsAdministrationRepository repository;

    private MaterialsAdministration createMaterialsAdministration() {
        MaterialsAdministration matadmin = new MaterialsAdministration();
        matadmin.setAmount(10);
        return matadmin;
    }

    @Test
    public void testFindAll() {
        MaterialsAdministration maadmin = createMaterialsAdministration();
        long length = repository.count();
        long size = 0;
        repository.save(maadmin);
        Iterable<MaterialsAdministration> it = repository.findAll();
        for (@SuppressWarnings("unused") MaterialsAdministration materialsAdministration : it) {
            size++;
        }
        Assert.assertEquals(length + 1, size);
    }
}
