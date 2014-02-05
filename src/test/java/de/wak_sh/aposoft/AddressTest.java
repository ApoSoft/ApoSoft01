package de.wak_sh.aposoft;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.wak_sh.aposoft.domain.Address;
import de.wak_sh.aposoft.repository.AddressRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
@Transactional
public class AddressTest {

    @Autowired
    private AddressRepository repository;

    private Address createAddress() {

        Address address = new Address();

        address.setCity("Kiel");

        address.setEmail("abc@mail.de");
        address.setExtra01("abc");
        address.setNumber("49");
        address.setPhone("99821");
        address.setPostalCode("0431");
        address.setStreet("abcStraße 9");

        return address;
    }

    @Test
    public void testInsert() {
        Address address = createAddress();

        repository.save(address);

        List<Address> listaddress = repository.findByCity(address.getCity());
        boolean exists = false;
        for (Address address2 : listaddress) {
            if (address.getId() == address2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        Address address = createAddress();

        repository.save(address);
        address.setCity("Hamburg");
        repository.save(address);

        List<Address> listaddress = repository.findByCity(address.getCity());
        for (Address address2 : listaddress) {
            if (address.getId() == address2.getId()) {
                Assert.assertEquals(address.getCity(), address2.getCity());
                break;
            }
        }
    }

    @Test
    public void testDelete() {
        Address address = createAddress();

        repository.save(address);
        repository.delete(address);

        List<Address> listaddress = repository.findByCity(address.getCity());
        boolean exists = false;
        for (Address address2 : listaddress) {
            if (address.getId() == address2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testfindAll() {
        Address address = createAddress();

        long size = repository.count();
        long length = 0;
        repository.save(address);
        Iterable<Address> it = repository.findAll();
        for (Address address2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }

    @Test
    public void testUpdateWithPostaleCode() {
        Address address = createAddress();

        repository.save(address);

        List<Address> listaddress = repository.findByPostalCode("0431");
        boolean exists = false;
        for (Address address2 : listaddress) {
            if (address.getId() == address2.getId()) {
                exists = true;
                break;
            }
        }
        Assert.assertTrue(exists);
    }
}
