package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Address;
import de.waksh.aposoft.domain.Extern;
import de.waksh.aposoft.repository.ExternRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class ExternTest {

    @Autowired
    private ExternRepository repository;

    private Extern createExtern() {
        Extern extern = new Extern();

        extern.setName("Jenni");
        extern.setDescription("Beschreibung");

        Address address = new Address();
        extern.setAddress(address);

        return extern;
    }

    @Test
    public void testFindAll() {
        Extern extern = createExtern();

        long count = repository.count();

        long sizeIterable = 0;

        repository.save(extern);

        Iterable<Extern> iterableextern = repository.findAll();
        for (@SuppressWarnings("unused") Extern extern2 : iterableextern) {
            sizeIterable++;
        }

        Assert.assertEquals(count + 1, sizeIterable);
    }

}
