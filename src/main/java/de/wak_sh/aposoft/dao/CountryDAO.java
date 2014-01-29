package de.wak_sh.aposoft.dao;

import java.util.List;

import de.wak_sh.aposoft.domain.Country;

public interface CountryDAO {
    boolean insertCountry(Country country);

    boolean updateCountry(Country country);

    boolean deleteCoutnry(Country country);

    List<Country> findAll();

    Country findByCountryCode(String countryCode);

    Country findByName(String name);

}
