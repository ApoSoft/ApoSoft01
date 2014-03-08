package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Vendor;
import de.waksh.aposoft.repository.VendorRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class VendorTest {

    @Autowired
    private VendorRepository repository;

    private Vendor createVendor() {
        Vendor vendor = new Vendor();

        vendor.setName("test");
        vendor.setVendorCode("123");
        vendor.setWebsite("www.abc.de");

        return vendor;
    }

    @Test
    public void testFindAll() {
        Vendor vendor = createVendor();
        long length = 0;
        long size = repository.count();
        repository.save(vendor);
        Iterable<Vendor> it = repository.findAll();
        for (@SuppressWarnings("unused") Vendor vendor2 : it) {
            length++;
        }
        Assert.assertEquals(length, size + 1);
    }

}
