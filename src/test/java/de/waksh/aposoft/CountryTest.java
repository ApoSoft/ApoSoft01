package de.waksh.aposoft;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Address;
import de.waksh.aposoft.domain.Country;
import de.waksh.aposoft.repository.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class CountryTest {

    @Autowired
    private CountryRepository repository;

    public Country createCountry() {
        Country country = new Country();

        Address address = new Address();
        address.setCity("city");
        Address addr = new Address();
        addr.setCity("bigcity");
        addr.setEmail("email");
        List<Address> addresses = new ArrayList<Address>();
        country.setAddresses(addresses);

        country.setCountryCode("Ger");
        country.setName("Germany");
        return country;
    }

    @Test
    public void testInsertWithCountryCode() {
        Country country = createCountry();

        repository.save(country);

        Country listcountry = repository.findByCountryCode(country.getCountryCode());

        boolean exists = false;
        if (country.getId() == listcountry.getId()) {
            exists = true;
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testInsertWithCountryName() {
        Country country = createCountry();

        repository.save(country);

        Country listcountry = repository.findByName(country.getName());

        boolean exists = false;
        if (country.getId() == listcountry.getId()) {
            exists = true;
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        Country country = createCountry();

        repository.save(country);
        country.setName("Deutschland");
        repository.save(country);

        Iterable<Country> listcountry = repository.findAll();

        for (Country country2 : listcountry) {
            if (country.getId() == country2.getId()) {
                Assert.assertEquals(country2.getName(), country.getName());
            }
        }
    }

    @Test
    public void testDelete() {
        Country country = createCountry();

        repository.save(country);
        repository.delete(country);

        Country country2 = repository.findByName(country.getName());

        Assert.assertNull(country2);
    }

    @Test
    public void testFindAll() {
        Country country = createCountry();

        long size = repository.count();
        long length = 0;
        repository.save(country);
        Iterable<Country> it = repository.findAll();
        for (@SuppressWarnings("unused") Country country2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }
}
