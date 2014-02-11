package de.waksh.aposoft;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Manufacturer;
import de.waksh.aposoft.repository.ManufacturerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class SupplierTest {

    @Autowired
    private ManufacturerRepository repository;

    public Manufacturer createSupplier() {
        Manufacturer supplier = new Manufacturer();

        supplier.setContactPerson("Karl Of");
        supplier.setName("Bayer");
        supplier.setRating("A");
        supplier.setShortdescription("Großer Pharmakonzern");
        supplier.setWebsite("www.bayer.de");

        return supplier;
    }

    @Test
    public void testInsert() {
        Manufacturer supplier = createSupplier();

        repository.save(supplier);

        List<Manufacturer> listsupplier = repository.findByName(supplier.getName());
        boolean exists = false;
        for (Manufacturer supplier2 : listsupplier) {
            if (supplier.getId() == supplier2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        Manufacturer supplier = createSupplier();

        repository.save(supplier);
        supplier.setContactPerson("Alfred Bayer");
        repository.save(supplier);

        List<Manufacturer> listsupplier = repository.findByName(supplier.getName());
        for (Manufacturer supplier2 : listsupplier) {
            if (supplier.getId() == supplier2.getId()) {
                Assert.assertEquals(supplier.getContactPerson(), supplier2.getContactPerson());
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        Manufacturer supplier = createSupplier();

        repository.save(supplier);
        repository.delete(supplier);

        List<Manufacturer> listsupplier = repository.findByName(supplier.getName());
        boolean exists = false;
        for (Manufacturer supplier2 : listsupplier) {
            if (supplier.getId() == supplier2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testFindAll() {
        Manufacturer supplier = createSupplier();
        long size = repository.count();
        long length = 0;
        repository.save(supplier);
        Iterable<Manufacturer> it = repository.findAll();
        for (@SuppressWarnings("unused") Manufacturer supplier2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }

}
