package de.waksh.aposoft.repository;

import org.springframework.data.repository.CrudRepository;

import de.waksh.aposoft.domain.Country;

/**
 * JPA repository for Country objects
 * 
 * @author Christoph Mende
 * 
 */
public interface CountryRepository extends CrudRepository<Country, Integer> {

    /**
     * Find countries by country code
     * 
     * @param countryCode
     *            code to search for
     * @return list of matching countries
     */
    Country findByCountryCode(String countryCode);

    /**
     * Find countries by name
     * 
     * @param name
     *            name to search for
     * @return list of matching countries
     */
    Country findByName(String name);

}
