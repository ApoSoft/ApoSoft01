package de.wak_sh.aposoft;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.wak_sh.aposoft.dao.CountryDAO;
import de.wak_sh.aposoft.dao.impl.CountryDAOImpl;
import de.wak_sh.aposoft.domain.Country;

public class TestCountry {

    public Country createCountry() {
        Country country = new Country();

        country.setCountryCode("Ger");
        country.setName("Germany");
        return country;
    }

    @Test
    public void testInsertWithCountryCode() {
        CountryDAO dao = new CountryDAOImpl();
        Country country = createCountry();

        dao.insertCountry(country);

        Country listcountry = dao.findByCountryCode(country.getCountryCode());

        boolean exists = false;
        if (country.getId() == listcountry.getId()) {
            exists = true;
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testInsertWithCountryName() {
        CountryDAO dao = new CountryDAOImpl();
        Country country = createCountry();

        dao.insertCountry(country);

        Country listcountry = dao.findByName(country.getName());

        boolean exists = false;
        if (country.getId() == listcountry.getId()) {
            exists = true;
        }
        Assert.assertTrue(exists);
    }

    @Test
    public void testUpdate() {
        CountryDAO dao = new CountryDAOImpl();
        Country country = createCountry();

        dao.insertCountry(country);
        country.setName("Deutschland");
        dao.updateCountry(country);

        List<Country> listcountry = dao.findAll();

        for (Country country2 : listcountry) {
            if (country.getId() == country2.getId()) {
                Assert.assertEquals(country2.getName(), country.getName());
            }
        }
    }

    @Test
    public void testDelete() {
        CountryDAO dao = new CountryDAOImpl();
        Country country = createCountry();

        dao.insertCountry(country);
        dao.deleteCoutnry(country);

        Country listcountry = dao.findByName(country.getName());

        boolean exists = false;
        if (country.getId() == listcountry.getId()) {
            exists = true;
        }
        Assert.assertFalse(exists);
    }

    @Test
    public void testFindAll() {
        CountryDAO dao = new CountryDAOImpl();
        Country country = createCountry();

        int size = dao.findAll().size();
        dao.insertCountry(country);
        Assert.assertEquals(size + 1, dao.findAll().size());
    }
}
