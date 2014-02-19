package de.waksh.aposoft;

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
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class ManufacturerTest {

    @Autowired
    private ManufacturerRepository repository;

    private Manufacturer createManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setContactPerson("Max");
        manufacturer.setName("Bayer");
        manufacturer.setRating("A");
        manufacturer.setShortdescription("Hersteller für Medikamente");
        manufacturer.setTelephoneNumber("+49-0431-92034");
        manufacturer.setTelephoneNumber("www.Bayer.de");
        return manufacturer;
    }

    @Test
    public void testFindAll() {
        Manufacturer manu = createManufacturer();
        long length = repository.count();
        long size = 0;
        repository.save(manu);
        Iterable<Manufacturer> it = repository.findAll();
        for (@SuppressWarnings("unused") Manufacturer manufacturer : it) {
            size++;
        }
        Assert.assertEquals(length + 1, size);
    }

    @Test
    public void testFindByName() {
        Manufacturer manu = createManufacturer();
        repository.save(manu);
        Iterable<Manufacturer> it = repository.findByName("Bayer");
        boolean exists = false;
        for (Manufacturer manufacturer : it) {
            if (manufacturer.getName().equals(manu.getName())) {
                exists = true;
            }
        }
        Assert.assertTrue(exists);
    }
}
