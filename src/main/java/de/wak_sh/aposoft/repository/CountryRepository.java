package de.wak_sh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.wak_sh.aposoft.domain.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    Country findByCountryCode(String countryCode);

    Country findByName(String name);

}
